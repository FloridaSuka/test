package repositories;

import database.DBConnector;
import models.*;
import models.dto.create.CreateKlasa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KlasaRepository {

    public boolean shtoKlasa(CreateKlasa klasa) {
        // Kontrollo që të gjitha ID-të janë të vlefshme
        if (klasa.getShkollaId() == -1) {
            System.out.println("❌ Shkolla nuk u gjet në databazë!");
            return false;
        }
        if (klasa.getParaleljaId() == -1) {
            System.out.println("❌ Paralelja nuk u gjet në databazë!");
            return false;
        }
        if (klasa.getMesuesiId() == -1) {
            System.out.println("❌ Mesuesi nuk u gjet në databazë!");
            return false;
        }
        if (klasa.getDrejtimiId() == -1) {
            System.out.println("❌ Drejtimi nuk u gjet në databazë!");
            return false;
        }

        String query = "INSERT INTO klasa (niveli, shkolla_id, paralelja_id, mesuesi_id, drejtimi_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, klasa.getNiveli());
            stmt.setInt(2, klasa.getShkollaId());
            stmt.setInt(3, klasa.getParaleljaId());
            stmt.setInt(4, klasa.getMesuesiId());
            stmt.setInt(5, klasa.getDrejtimiId());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ Klasa u shtua me sukses!");
                return true;
            } else {
                System.out.println("❌ Nuk u shtua klasa.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Gabim gjatë shtimit të klasës: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }


    public int lookupId(String table, String column, String value) {
        String query = "SELECT id FROM " + table + " WHERE LOWER(" + column + ") = LOWER(?)";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, value);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            } else {
                System.out.println("❌ Nuk u gjet " + value + " në tabelën " + table);
            }
        } catch (SQLException e) {
            System.out.println("❌ Gabim gjatë kërkimit të ID-së: " + e.getMessage());
            e.printStackTrace();
        }
        return -1; // Nëse nuk gjendet
    }
    public List<Klasa> gjejTeGjitha() {
        List<Klasa> klasat = new ArrayList<>();
        String query = """
        SELECT k.*, 
               shk.emri AS shkolla_emri,
               p.emri AS paralelja_emri,
               m.emri AS mesuesi_emri, m.mbiemri AS mesuesi_mbiemri,
               d.emri AS drejtimi_emri
        FROM klasa k
        JOIN shkolla shk ON k.shkolla_id = shk.id
        JOIN paralelja p ON k.paralelja_id = p.id
        JOIN mesuesi m ON k.mesuesi_id = m.id
        JOIN drejtimi d ON k.drejtimi_id = d.id
        """;

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Shkolla shkolla = new Shkolla(rs.getInt("shkolla_id"), rs.getString("shkolla_emri"), null, null);
                Paralelja paralelja = new Paralelja(rs.getInt("paralelja_id"), rs.getString("paralelja_emri"));
                Mesuesi mesuesi = new Mesuesi(rs.getInt("mesuesi_id"), rs.getString("mesuesi_emri"), rs.getString("mesuesi_mbiemri"), "", "");
                Drejtimi drejtimi = new Drejtimi(rs.getInt("drejtimi_id"), rs.getString("drejtimi_emri"));

                Klasa klasa = new Klasa(rs.getInt("id"), rs.getInt("niveli"), shkolla, paralelja, mesuesi, drejtimi);
                klasat.add(klasa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return klasat;
    }

}
