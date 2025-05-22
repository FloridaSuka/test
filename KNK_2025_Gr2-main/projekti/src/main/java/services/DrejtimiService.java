package services;

import database.DBConnector;
import models.Drejtimi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DrejtimiService {

    public List<Drejtimi> getDrejtimet() {
        List<Drejtimi> lista = new ArrayList<>();
        String query = "SELECT * FROM drejtimet";

        try (Connection conn = DBConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                lista.add(new Drejtimi(
                        rs.getInt("id"),
                        rs.getString("emri"),
                        rs.getInt("shkolla_id"),
                        rs.getInt("paralelja_id")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    public void addDrejtimi(Drejtimi drejtimi) {
        String query = "INSERT INTO drejtimet (emri, shkolla_id, paralelja_id) VALUES (?, ?, ?)";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, drejtimi.getEmri());
            stmt.setInt(2, drejtimi.getShkollaId());
            stmt.setInt(3, drejtimi.getParaleljaId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDrejtimi(Drejtimi drejtimi) {
        String query = "UPDATE drejtimet SET emri = ?, shkolla_id = ?, paralelja_id = ? WHERE id = ?";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, drejtimi.getEmri());
            stmt.setInt(2, drejtimi.getShkollaId());
            stmt.setInt(3, drejtimi.getParaleljaId());
            stmt.setInt(4, drejtimi.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDrejtimi(int id) {
        String query = "DELETE FROM drejtimet WHERE id = ?";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

