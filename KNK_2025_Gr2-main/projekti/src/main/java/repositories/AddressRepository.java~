//package repositories;
//
//import database.DBConnector;
//import models.Adresa;
//import models.dto.create.CreateAdresa;
//import models.dto.update.UpdateAdresa;
//import models.dto.delete.DeleteAdresa;
//
//import java.sql.*;
//import java.util.ArrayList;
//
//public class AddressRepository {
//
//    public static ArrayList<Adresa> getAll() {
//        ArrayList<Adresa> adresat = new ArrayList<>();
//        String query = "SELECT * FROM Adresa";
//        try (Connection conn = DBConnector.getConnection();
//             PreparedStatement pst = conn.prepareStatement(query);
//             ResultSet rs = pst.executeQuery()) {
//
//            while (rs.next()) {
//                adresat.add(Adresa.getInstance(rs));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return adresat;
//    }
//
//    public static Adresa getById(int id) {
//        String query = "SELECT * FROM Adresa WHERE id = ?";
//        try (Connection conn = DBConnector.getConnection();
//             PreparedStatement pst = conn.prepareStatement(query)) {
//
//            pst.setInt(1, id);
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                return Adresa.getInstance(rs);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static boolean create(CreateAdresa adresa) {
//        String query = "INSERT INTO Adresa (qyteti, rruga, kodi_postar) VALUES (?, ?, ?)";
//        try (Connection conn = DBConnector.getConnection();
//             PreparedStatement pst = conn.prepareStatement(query)) {
//
//            pst.setString(1, adresa.getQyteti());
//            pst.setString(2, adresa.getRruga());
//            pst.setString(3, adresa.getKodiPostar());
//
//            return pst.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public static boolean update(UpdateAdresa adresa) {
//        String query = "UPDATE Adresa SET qyteti = ?, rruga = ?, kodi_postar = ? WHERE id = ?";
//        try (Connection conn = DBConnector.getConnection();
//             PreparedStatement pst = conn.prepareStatement(query)) {
//
//            pst.setString(1, adresa.getQyteti());
//            pst.setString(2, adresa.getRruga());
//            pst.setString(3, adresa.getKodiPostar());
//            pst.setInt(4, adresa.getId());
//
//            return pst.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public static boolean delete(DeleteAdresa adresa) {
//        String query = "DELETE FROM Adresa WHERE id = ?";
//        try (Connection conn = DBConnector.getConnection();
//             PreparedStatement pst = conn.prepareStatement(query)) {
//
//            pst.setInt(1, adresa.getId());
//
//            return pst.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//}
//
