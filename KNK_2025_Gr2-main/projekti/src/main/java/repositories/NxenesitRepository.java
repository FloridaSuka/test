package repositories;

import database.DBConnector;
import models.Nxenesit;
import models.dto.create.CreateNxenesit;
import models.dto.update.UpdateNxenesit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NxenesitRepository {

    public boolean shtoNxenes(CreateNxenesit nx) {
        String query = "INSERT INTO Nxenesit (emri, mbiemri, datelindja, gjinia, email, phone, adresa_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nx.getEmri());
            stmt.setString(2, nx.getMbiemri());
            stmt.setDate(3, Date.valueOf(nx.getDatelindja()));
            stmt.setString(4, String.valueOf(nx.getGjinia()));
            stmt.setString(5, nx.getEmail());
            stmt.setString(6, nx.getPhone());
            stmt.setInt(7, nx.getAdresaId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean fshijNxenes(int id) {
        String query = "DELETE FROM Nxenesit WHERE id = ?";
        try (Connection conn = DBConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean perditesoNxenes(UpdateNxenesit nx) {
        String query = "UPDATE Nxenesit SET emri = ?, mbiemri = ?, datelindja = ?, gjinia = ?, email = ?, phone = ?, adresa_id = ? WHERE id = ?";
        try (Connection conn = DBConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nx.getEmri());
            stmt.setString(2, nx.getMbiemri());
            stmt.setDate(3, Date.valueOf(nx.getDatelindja()));
            stmt.setString(4, String.valueOf(nx.getGjinia()));
            stmt.setString(5, nx.getEmail());
            stmt.setString(6, nx.getPhone());
            stmt.setInt(7, nx.getAdresaId());
            stmt.setInt(8, nx.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int lookupAdresaId(String rruga) {
        String query = "SELECT id FROM adresa WHERE rruga = ?";
        try (Connection conn = DBConnector.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, rruga);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public Integer getNxenesiIdByName(String emri) {
        String sql = "SELECT id FROM nxenesit WHERE LOWER(emri) = LOWER(?)";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emri.trim());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int merrNumrinENxenesve() {
        int count = 0;

        try (Connection conn = DBConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM nxenesit")) {

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // ose log.error(e);
        }

        return count;
    }
    public List<Nxenesit> gjejTeGjitheNxenesit() {
        List<Nxenesit> lista = new ArrayList<>();
        String query = "SELECT * FROM Nxenesit JOIN Adresa ON Nxenesit.adresa_id = Adresa.id";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Nxenesit nx = Nxenesit.fromResultSet(rs);
                lista.add(nx);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    public int getNxenesiIdByEmail(String email) {
        String sql = "SELECT id FROM nxenesit WHERE email = ?";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }





}
