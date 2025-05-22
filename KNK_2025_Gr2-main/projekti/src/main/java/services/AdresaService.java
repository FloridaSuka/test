package services;

import database.DBConnector;
import models.Adresa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdresaService {

    public List<Adresa> getAdresat() {
        List<Adresa> lista = new ArrayList<>();
        String query = "SELECT * FROM adresa";

        try (Connection conn = DBConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                lista.add(new Adresa(
                        rs.getInt("id"),
                        rs.getString("qyteti"),
                        rs.getString("rruga"),
                        rs.getString("kodi_postar")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    public void addAdresa(Adresa adresa) {
        String query = "INSERT INTO adresa (qyteti, rruga, kodi_postar) VALUES (?, ?, ?)";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, adresa.getQyteti());
            stmt.setString(2, adresa.getRruga());
            stmt.setString(3, adresa.getKodiPostar());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateAdresa(Adresa adresa) {
        String query = "UPDATE adresa SET qyteti = ?, rruga = ?, kodi_postar = ? WHERE id = ?";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, adresa.getQyteti());
            stmt.setString(2, adresa.getRruga());
            stmt.setString(3, adresa.getKodiPostar());
            stmt.setInt(4, adresa.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAdresa(int id) {
        String query = "DELETE FROM adresa WHERE id = ?";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

