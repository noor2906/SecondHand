module com.example.tiendaropa {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.tiendaropa to javafx.fxml;
    exports com.example.tiendaropa;
}