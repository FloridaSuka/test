package repositories;

import database.DBConnector;
import models.Notat;
import models.dto.create.CreateNotat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotatRepository {
    public boolean regjistroNota(CreateNotat nota) {
        String query = "INSERT INTO Notat (nxenesi_id, lenda_id, mesuesi_id, drejtimi_id, klasa_id, paralelja_id,periudha_id, nota_pare, nota_dyte) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, nota.nxenesiId);
            stmt.setInt(2, nota.lendaId);
            stmt.setInt(3, nota.mesuesiId);
            stmt.setInt(4, nota.drejtimiId);
            stmt.setInt(5, nota.klasaId);
            stmt.setInt(6, nota.paraleljaId);
            stmt.setInt(7,nota.periudhaId);
            stmt.setInt(8, nota.notaPare);
            stmt.setInt(9, nota.notaDyte);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int numronNotat(int nota) {
        String query = "SELECT COUNT(*) AS total FROM Notat WHERE nota_pare = ?";
        int total = 0;

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, nota);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                total = rs.getInt("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }
    public List<Notat> gjejTeGjithaNotat() {
        List<Notat> lista = new ArrayList<>();
        String query = "SELECT * FROM Notat";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Notat n = Notat.fromResultSet(rs);
                lista.add(n);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    public int numriNotavePerGjinineDheNoten(int nota, String gjinia, int mesuesiId) {
        String sql = "SELECT COUNT(*) AS total " +
                "FROM notat n " +
                "JOIN nxenesit nx ON n.nxenesi_id = nx.id " +
                "WHERE n.nota_pare = ? AND nx.gjinia = ? AND n.mesuesi_id = ?";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, nota);
            stmt.setString(2, gjinia);
            stmt.setInt(3, mesuesiId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int numriNxenesvePerMesuesin(int mesuesiId) {
        String sql = "SELECT COUNT(DISTINCT nxenesi_id) AS total " +
                "FROM notat " +
                "WHERE mesuesi_id = ?";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, mesuesiId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    // Shembull metode që merr notat nga DB sipas mesuesiId (implementimi mund ndryshojë)
    private List<Integer> getNotatByMesuesiId(int mesuesiId) {
        List<Integer> notat = new ArrayList<>();
        String sql = "SELECT nota_pare FROM notat WHERE mesuesi_id = ?";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, mesuesiId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int notaPare = rs.getInt("nota_pare");
                if (notaPare > 0) {  // opsionale, nëse do të anashkalosh nota 0 ose negative
                    notat.add(notaPare);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notat;
    }

    public double mesatarjaNotavePerMesuesin(int mesuesiId) {
        List<Integer> notat = getNotatByMesuesiId(mesuesiId);
        if (notat.isEmpty()) return 0;

        int total = 0;
        for (int n : notat) total += n;

        return (double) total / notat.size();
    }
    public int numriNotavePerNxenesin(int nota, long nxenesiId) {
        String sql = "SELECT COUNT(*) AS total FROM notat WHERE nota_pare = ? AND nxenesi_id = ?";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, nota);
            stmt.setLong(2, nxenesiId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }






}
