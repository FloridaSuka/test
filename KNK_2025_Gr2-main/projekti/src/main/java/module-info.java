module com.example.demo {
    requires java.sql;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;

    opens com.example.demo to javafx.fxml;
    opens database to javafx.fxml;
    opens knk2025 to javafx.fxml;
    opens controllers to javafx.fxml;
    opens app to javafx.graphics;
    opens models to javafx.base;

    exports com.example.demo;
    exports controllers;
    exports database;
    exports knk2025;
    exports app;
}
