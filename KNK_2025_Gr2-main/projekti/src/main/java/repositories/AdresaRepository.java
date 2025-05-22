package repositories;

import database.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdresaRepository {

    public Integer gjejAdresaId(String emriRruges) {
        String sql = "SELECT id FROM adresa WHERE LOWER(rruga) = LOWER(?)";
        try (Connection con = DBConnector.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, emriRruges.trim());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            } else {
                return null; // nuk u gjet
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer shtoAdrese(String qyteti, String rruga, String kodiPostar) {
        String sql = "INSERT INTO adresa (qyteti, rruga, kodi_postar) VALUES (?, ?, ?) RETURNING id";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, qyteti);
            stmt.setString(2, rruga);
            stmt.setString(3, kodiPostar);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
