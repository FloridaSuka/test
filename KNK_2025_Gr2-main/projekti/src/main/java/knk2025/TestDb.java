package knk2025;
import database.DBConnector;
import java.sql.*;

public class TestDb {
    public static void main(String[] args)  throws SQLException {
        Connection connection = DBConnector.getConnection();
        if (connection == null) {
            System.out.println("Lidhja me databazën ka dështuar!");
            return;
        }
        String query = " INSERT INTO nxenesit (id,emri, mbiemri, email, mosha,gjinia, adresa, tel) VALUES (10, 'Emri1', 'Mbiemri1', 'email1', 15, 'm', 'adresa1', '1234567890') ";
        Statement statement = connection.createStatement();
        statement.execute(query);
//        statement.execute("DELETE FROM users WHERE id = 1");
        query = " SELECT * FROM nxenesit ";
        ResultSet results = statement.executeQuery(query);
        while(results.next()){
            int id = results.getInt("id");
            String name = results.getString("emri");
            String surname = results.getString("mbiemri");
            int age = results.getInt("mosha");
            String email = results.getString("email");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Mbiemri: " + surname);
            System.out.println("Email: " + email);
            System.out.println("Age: " + age);
            System.out.println("------------------");
        }
        //fshirja e te gjitha rekordeve
        statement.execute("DELETE FROM users");
    }
}
