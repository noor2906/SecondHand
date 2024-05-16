package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.ConsultasBBDD;
import com.example.tiendaropa.Conexiones.InsercionesBBDD;
import com.example.tiendaropa.model.MetodoPago;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtDni;
    @FXML
    private TextField txtDireccion;
    @FXML
    private ComboBox<String> combList;
    public void initialize(){
        HashMap<Integer,MetodoPago> mapaPagos = MetodoPago.getMapaMetodoPago();
        ObservableList<String> soList = FXCollections.observableArrayList();
        for (Integer k:mapaPagos.keySet()) {
            soList.add(mapaPagos.get(k).getDescripcion());
        }

        combList.setItems(soList);
    }
    public void registrar(MouseEvent event) throws IOException {
        int ok=0;
        String nombre = txtNombre.getText();
        String contra = txtContra.getText();
        String apellidos = txtApellidos.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        String dni = txtDni.getText();
        String direccion = txtDireccion.getText();
        if (!dni.equals("") && !nombre.equals("") && !apellidos.equals("") && !email.equals("") && !direccion.equals("") && !contra.equals("")){
            ok=InsercionesBBDD.insercionRegistro(nombre,contra,apellidos,telefono,email,dni,direccion);
        }else {
            System.out.println("\nRegistro: Te has dejado algún campo importante\n");
        }
        if (ok>0){mostrarLogin(event);}

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

    // Botones Limpiar
    public void limpiarNombre(MouseEvent actionEvent) {
        txtNombre.clear();
    }
    public void limpiarApellidos(MouseEvent actionEvent) {
        txtApellidos.clear();
    }
    public void limpiarDni(MouseEvent actionEvent) {
        txtDni.clear();
    }
    public void limpiarEmail(MouseEvent actionEvent) {
        txtEmail.clear();
    }
    public void limpiarContra(MouseEvent actionEvent) {
        txtContra.clear();
    }
    public void limpiarDireccion(MouseEvent actionEvent) {
        txtDireccion.clear();
    }
    public void limpiarTelefono(MouseEvent actionEvent) {
        txtTelefono.clear();
    }
}
