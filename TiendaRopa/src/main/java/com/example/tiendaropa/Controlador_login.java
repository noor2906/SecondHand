package com.example.tiendaropa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Controlador_login {
  private ConexionBBDD conn = new ConexionBBDD();
    @FXML
    private TextField txtContraLogin;
    @FXML
    private TextField txtDatoLogin;

    public void login(ActionEvent actionEvent) throws IOException {
        Alert a = new Alert(Alert.AlertType.NONE);
        boolean ok;
        String user = txtDatoLogin.getText();
        String pass = txtContraLogin.getText();
        conn.conectar();
        conn.crearSentencia();
        ok=conn.login(user,pass);
        conn.desconectar();
        if (ok){
            mostrarHome(actionEvent);
        }else {
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setHeaderText(null);
            a.setContentText("El usuario no existe :(");
            a.show();
        }
    }
      public void mostrarHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML_home_Noor.fxml")));

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void mostrarRegistro(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML_registroUsuario_Carol.fxml")));

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void limpiarUser(ActionEvent actionEvent) {
        txtDatoLogin.clear();
    }

    public void limpiarContra(ActionEvent actionEvent) {
        txtContraLogin.clear();
    }

    public void mostrarCarrito(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_carrito_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void mostrarPantallaPrueba(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_PantallaPrueba.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void mostrarVolverHome(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_home_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
}
