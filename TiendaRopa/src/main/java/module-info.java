module com.example.tiendaropa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.tiendaropa to javafx.fxml;
    exports com.example.tiendaropa;
    exports com.example.tiendaropa.Conexiones;
    opens com.example.tiendaropa.Conexiones to javafx.fxml;
}
