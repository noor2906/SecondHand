package com.example.tiendaropa;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Controlador_registroUsuario {
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtContra;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtTelefono;
    public void registrar(){

    }

    //BOTONES ----------------------------------------------------------------------------------------------------------

    //Método que enlaza el botón del menú hamburguesa a la pantalla del menú
    public void mostrarMenu(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_menuHamburguesa_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void mostrarHome(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_home_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void mostrarLogin(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_login_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void mostrarCarrito(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_carrito_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
}
