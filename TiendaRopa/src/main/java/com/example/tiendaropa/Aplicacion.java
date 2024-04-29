package com.example.tiendaropa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplicacion extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("FXML_home_Noor.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 700);
        stage.setTitle("Second Hand - Noor | Carolina | Verónica");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}