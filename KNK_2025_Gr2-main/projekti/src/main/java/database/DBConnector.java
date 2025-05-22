package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static Connection connection = null;
    private static final String DB_URL = "jdbc:postgresql://localhost/knk-database";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "12345678";

    public static Connection getConnection() {
        try {
            // ✅ Kontrollojmë nëse lidhja është null ose e mbyllur
            if (connection == null || connection.isClosed()) {
                System.out.println("🔄 Krijimi i një lidhje të re me databazën...");
                connection = DriverManager.getConnection(
                        DB_URL,
                        DB_USER,
                        DB_PASSWORD
                );
            } else {
                System.out.println("✅ Lidhja ekzistuese po përdoret.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Gabim gjatë krijimit të lidhjes me databazën: " + e.getMessage());
            return null;
        }
        return connection;
    }
}
