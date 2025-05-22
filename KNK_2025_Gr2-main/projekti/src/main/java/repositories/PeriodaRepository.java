package repositories;

import database.DBConnector;
import models.Perioda;
import models.dto.create.CreatePerioda;
import models.dto.update.UpdatePerioda;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeriodaRepository {
    public Integer getPeriodaIdByName(String emri) {
        String sql = "SELECT id FROM perioda WHERE LOWER(emri) = LOWER(?)";
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

}


