package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.InsercionesBBDD;
import com.example.tiendaropa.model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class Controlador_altaEdicionEmpleado {

    private InsercionesBBDD insercionesBBDD = new InsercionesBBDD();

    @FXML
    private TextField txtfNombreEditarEmpleado;

    @FXML
    private TextField txtfApellidosEditarEmpleado;

    @FXML
    private TextField txtfDNIEditarEmpleado;

    @FXML
    private TextField txtfFechaNacEditarEmpleado;

    @FXML
    private TextField txtfContraEditarEmpleado;

    @FXML
    private TextField txtfTlfnoEditarEmpleado;

    @FXML
    private TextField txtfDireccionEditarEmpleado;

    @FXML
    private TextField txtfEmailEditarEmpleado;

    @FXML
    private CheckBox checkBPrivilegiosEditarEmpleado;

    @FXML
    private RadioButton rbtnAdminEditarEmpleado;

    @FXML
    private RadioButton rbtnVendedorEditarEmpleado;

    @FXML
    private RadioButton rbtnAlmacenEditarEmpleado;

    @FXML
    private Button btnClear1;

    @FXML
    private Button btnClear2;

    @FXML
    private Button btnClear3;

    @FXML
    private Button btnClear4;

    @FXML
    private Button btnClear5;

    @FXML
    private Button btnClear6;

    @FXML
    private Button btnClear7;

    @FXML
    private Button btnClear8;


    public void initialize(){
        btnClear1.setOnAction(e -> limpiarCampo(txtfNombreEditarEmpleado)); //Le dices al onAction que evento tiene que ejecutar cuando le hagan click
        btnClear2.setOnAction(e -> limpiarCampo(txtfApellidosEditarEmpleado));
        btnClear3.setOnAction(e -> limpiarCampo(txtfDNIEditarEmpleado));
        btnClear4.setOnAction(e -> limpiarCampo(txtfFechaNacEditarEmpleado));
        btnClear5.setOnAction(e -> limpiarCampo(txtfContraEditarEmpleado));
        btnClear6.setOnAction(e -> limpiarCampo(txtfTlfnoEditarEmpleado));
        btnClear7.setOnAction(e -> limpiarCampo(txtfDireccionEditarEmpleado));
        btnClear8.setOnAction(e -> limpiarCampo(txtfEmailEditarEmpleado));

    }

    @FXML
    private void guardarCambios() {

        String dni = txtfDNIEditarEmpleado.getText();
        String nombre = txtfNombreEditarEmpleado.getText();
        String apellidos = txtfApellidosEditarEmpleado.getText();
        String telefono = txtfTlfnoEditarEmpleado.getText();
        String fechaNacimiento = txtfFechaNacEditarEmpleado.getText();
        String email = txtfEmailEditarEmpleado.getText();
        String direccion = txtfDireccionEditarEmpleado.getText();
        boolean tienePrivilegios = checkBPrivilegiosEditarEmpleado.isSelected();
        String pass = txtfContraEditarEmpleado.getText();
        int tipoEmpleado = obtenerTipoEmpleadoSeleccionado();


        try {
            // Verificar si insercionesBBDD es nulo antes de llamar al método
            if (insercionesBBDD != null) {
                insercionesBBDD.insertarEmpleado(dni, nombre, apellidos, telefono, fechaNacimiento, email, direccion, tienePrivilegios, pass, tipoEmpleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    // Método para obtener el tipo de empleado seleccionado
    private int obtenerTipoEmpleadoSeleccionado() {
        if (rbtnAdminEditarEmpleado.isSelected()) {
            return 1;
        } else if (rbtnVendedorEditarEmpleado.isSelected()) {
            return 2;
        } else if (rbtnAlmacenEditarEmpleado.isSelected()) {
            return 3;
        } else {
            // Por defecto, devolver tipo "Vendedor"
            return 3;
        }
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

    public void mostrarPanelAdmin(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_panelAdmin_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void limpiarCampo(TextField campoTexto){
        campoTexto.clear();
    }
}

