package repositories;

import database.DBConnector;
import models.Drejtor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrejtoriRepository {

    public boolean shtoDrejtor(Drejtor d) {
        String sql = "INSERT INTO drejtor (emri, mbiemri, email, tel, adresa_id, shkolla_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, d.getEmri());
            stmt.setString(2, d.getMbiemri());
            stmt.setString(3, d.getEmail());
            stmt.setString(4, d.getTel());
            stmt.setInt(5, d.getAdresaId());
            stmt.setInt(6, d.getShkollaId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean perditesoDrejtor(Drejtor d) {
        StringBuilder sql = new StringBuilder("UPDATE drejtor SET ");
        List<Object> params = new ArrayList<>();

        if (d.getEmri() != null && !d.getEmri().isBlank()) {
            sql.append("emri = ?, ");
            params.add(d.getEmri());
        }
        if (d.getMbiemri() != null && !d.getMbiemri().isBlank()) {
            sql.append("mbiemri = ?, ");
            params.add(d.getMbiemri());
        }
        if (d.getEmail() != null && !d.getEmail().isBlank()) {
            sql.append("email = ?, ");
            params.add(d.getEmail());
        }
        if (d.getTel() != null && !d.getTel().isBlank()) {
            sql.append("tel = ?, ");
            params.add(d.getTel());
        }
        if (d.getAdresaId() != 0) {
            sql.append("adresa_id = ?, ");
            params.add(d.getAdresaId());
        }
        if (d.getShkollaId() != 0) {
            sql.append("shkolla_id = ?, ");
            params.add(d.getShkollaId());
        }

        if (params.isEmpty()) return false;

        sql.setLength(sql.length() - 2);
        sql.append(" WHERE id = ?");
        params.add(d.getId());

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


    public boolean fshijDrejtor(int id) {
        String sql = "DELETE FROM drejtor WHERE id = ?";

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

