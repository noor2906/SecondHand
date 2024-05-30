package com.example.tiendaropa;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Controlador_panelAdmin {

    @FXML
    Button btnLogin;
    public void initialize(){
        btnLogin.setDisable(true);
    }

    //BOTONES ----------------------------------------------------------------------------------------------------------

    //Método que enlaza el botón del menú hamburguesa a la pantalla del menú
    // Hecho por: Noor
    public void mostrarMenu(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_menuHamburguesa_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Carol
    public void mostrarLogin(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_login_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Carol
    public void mostrarCarrito(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_carrito_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Carol
    public void mostrarHome(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_home_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Vero
    public void mostrarListaUsuarios(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_listaUsuarios_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Vero
    public void mostrarListaEmpleados(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_listaEmpleados_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Noor
    public void mostrarListaProductos(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_listaProductos_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Vero
    public void mostrarPedidos(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_home_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Noor
    public void mostrarAltaProducto(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_panelAltaProducto_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Carol
    public void mostrarAltaEmpleado(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_altaEdicionEmpleado_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void cerrarSesion(MouseEvent event) throws IOException {
        Controlador_login.setUsuario(null);
        mostrarHome(event);
    }

}
