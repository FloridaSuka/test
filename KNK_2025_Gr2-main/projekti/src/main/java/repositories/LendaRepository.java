package repositories;

import database.DBConnector;
import models.dto.create.CreateLenda;

import java.sql.*;

public class LendaRepository {
    public int getLendaIdByName(String emri) {
        String sql = "SELECT id FROM lendet WHERE LOWER(emri) = LOWER(?)";

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

        return 0; // ose -1 nëse s’gjendet
    }

    public boolean shto(CreateLenda l) {
        BaseRepository base = new BaseRepository();

        Integer drejtimiId = base.gjejId(l.getDrejtimi(), "drejtimi");
        Integer periodaId = base.gjejId(l.getPerioda(), "perioda");
        Integer mesuesiId = base.gjejId(l.getMesuesi(), "mesuesi");

        if (drejtimiId == null || periodaId == null || mesuesiId == null) {
            System.out.println("❌ Një nga ID-të nuk u gjet.");
            return false;
        }

        String sql = "INSERT INTO lenda (emri, drejtimi_id, perioda_id, mesuesi_id) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnector.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, l.getEmri());
            ps.setInt(2, drejtimiId);
            ps.setInt(3, periodaId);
            ps.setInt(4, mesuesiId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean fshij(int id) {
        String sql = "DELETE FROM lendet WHERE id=?";
        try (Connection con = DBConnector.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}