package com.example.tiendaropa;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Controlador_listaProductos {

    //Método que enlaza el botón del menú hamburguesa a la pantalla del menú
    public void mostrarMenu(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_menuHamburguesa_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
}
