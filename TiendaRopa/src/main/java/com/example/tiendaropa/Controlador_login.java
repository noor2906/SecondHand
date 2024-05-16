package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.ConsultasBBDD;
import com.example.tiendaropa.model.Cliente;
import com.example.tiendaropa.model.Empleado;
import com.example.tiendaropa.model.Usuario;
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
    private ConsultasBBDD consulta = new ConsultasBBDD();
    @FXML
    private TextField txtContraLogin;
    @FXML
    private TextField txtDatoLogin;

    public void login(ActionEvent actionEvent) throws IOException {
        Alert a = new Alert(Alert.AlertType.NONE);
        Usuario usuario;
        String user = txtDatoLogin.getText();
        String pass = txtContraLogin.getText();
        usuario=consulta.login(user,pass);
        if (usuario instanceof Cliente){
            mostrarHome(actionEvent);
            System.out.println(usuario.toString()); //! Borrar más adelante --> Ver si el usuario se ha creado correctamente
        } else if (usuario instanceof Empleado) {
            mostrarPanelAdmin(actionEvent);
        } else {
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
    public void mostrarPanelAdmin(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML_panelAdmin_Noor.fxml")));

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


    //BOTONES ----------------------------------------------------------------------------------------------------------

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
