package repositories;

import database.DBConnector;
import java.sql.*;

public class MungesatRepository {
    public boolean shto(int studentId, int lendaId, int periodaId, Date data, String arsyeja) {
        String sql = "INSERT INTO Mungesa(student_id, lenda_id, perioda_id, data_mungeses, arsyeja) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            stmt.setInt(2, lendaId);
            stmt.setInt(3, periodaId);
            stmt.setDate(4, data);
            stmt.setString(5, arsyeja);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean perditeso(int id, int studentId, int lendaId, int periodaId, Date data, String arsyeja) {
        String sql = "UPDATE Mungesa SET student_id=?, lenda_id=?, perioda_id=?, data_mungeses=?, arsyeja=? WHERE id=?";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            stmt.setInt(2, lendaId);
            stmt.setInt(3, periodaId);
            stmt.setDate(4, data);
            stmt.setString(5, arsyeja);
            stmt.setInt(6, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean fshij(int id) {
        String sql = "DELETE FROM Mungesa WHERE id = ?";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Integer gjejId(String emri, String tabela) {
        String sql = "SELECT id FROM " + tabela + " WHERE emri = ?";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emri);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int numriMungesavePerGjinine(String gjinia) {
        String sql = "SELECT COUNT(*) AS total FROM Mungesa m " +
                "JOIN nxenesit n ON m.student_id = n.id " +
                "WHERE n.gjinia = ?";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, gjinia);
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