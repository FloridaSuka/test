package repositories;

import database.DBConnector;
import models.Shkolla;
import models.dto.create.CreateShkolla;
import models.dto.update.UpdateShkolla;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShkollaRepository {

    public boolean shtoShkollen(CreateShkolla shkolla) {
        String sql = "INSERT INTO shkolla (emri, tel, adresa_id) VALUES (?, ?, ?)";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, shkolla.getEmri());
            stmt.setString(2, shkolla.getTel());
            stmt.setInt(3, shkolla.getAdresaId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean perditesoShkollen(UpdateShkolla shkolla) {
        StringBuilder sql = new StringBuilder("UPDATE shkolla SET ");
        List<Object> params = new ArrayList<>();

        if (shkolla.getEmri() != null && !shkolla.getEmri().isBlank()) {
            sql.append("emri = ?, ");
            params.add(shkolla.getEmri());
        }
        if (shkolla.getTel() != null && !shkolla.getTel().isBlank()) {
            sql.append("tel = ?, ");
            params.add(shkolla.getTel());
        }
        if (shkolla.getAdresaId() != 0) {
            sql.append("adresa_id = ?, ");
            params.add(shkolla.getAdresaId());
        }
        if (params.isEmpty()) return false;

        sql.setLength(sql.length() - 2);
        sql.append(" WHERE id = ?");
        params.add(shkolla.getId());

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean fshijShkollen(int id) {
        String sql = "DELETE FROM shkolla WHERE id = ?";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
