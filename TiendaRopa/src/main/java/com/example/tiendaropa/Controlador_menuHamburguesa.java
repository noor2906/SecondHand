package com.example.tiendaropa;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

// PANTALLA 3

public class Controlador_menuHamburguesa {

    // ROPA ------------------------------------------------------------------------------------------------------------

    //Método que enlaza el botón 'Ropa' del menú hamburguesa a la página de productos filtrados
    public void mostrarFiltroRopa(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_catologoRopa_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    //Método que enlaza el botón 'Camisa' del menú hamburguesa a la página de productos filtrados
    public void mostrarFiltroCamisas(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_catologoRopa_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    //Método que enlaza el botón 'Chaquetas' del menú hamburguesa a la página de productos filtrados
    public void mostrarFiltroChaquetas(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_catologoRopa_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    //Método que enlaza el botón 'Pantalones' del menú hamburguesa a la página de productos filtrados
    public void mostrarFiltroPantalones(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_catologoRopa_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    // ACCESORIOS ------------------------------------------------------------------------------------------------------

    //Método que enlaza el botón 'Accesorios' del menú hamburguesa a la página de productos filtrados
    public void mostrarFiltroAccesorios(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_catalogoAccesorios_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    //Método que enlaza el botón 'Bolsos' del menú hamburguesa a la página de productos filtrados
    public void mostrarFiltroBolsos(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_catalogoAccesorios_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    //Método que enlaza el botón 'Zapatos' del menú hamburguesa a la página de productos filtrados
    public void mostrarFiltroZapatos(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_catalogoAccesorios_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

}
