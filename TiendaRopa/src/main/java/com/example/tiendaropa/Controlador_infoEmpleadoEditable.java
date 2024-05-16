package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.ConsultasBBDD;
import com.example.tiendaropa.model.Articulo;
import com.example.tiendaropa.model.Empleado;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Controlador_infoEmpleadoEditable /*implements Initializable*/ {

    @FXML
    private Button btnVolverListaEmpleado;

    @FXML
    TextField txtDNI, txtTelefono, txtEmail, txtNumApellidos, txtDireccion;

     @FXML
    DatePicker dpFechaNacimiento;

     @FXML
     CheckBox cbTarjetaFidl;

    @FXML
    Text textNombreApellidos;

    boolean edicionHabilitada = false;



    //Obtenermos la informacion del empleado en el que hemos clicado y lo cargamos sobre las ranuras que toca.

    public void cargarEmpleado(Empleado empleado) throws FileNotFoundException {

        //Propiedades de un empleado cualquiera ------------------------------------------------------------------------

        textNombreApellidos.setText(empleado.getNombre() + " " + empleado.getApellidos());
        txtDNI.setText(empleado.getDni());
        txtTelefono.setText(String.valueOf(empleado.getTelefono()));
        txtEmail.setText(empleado.getE_mail());
        txtNumApellidos.setText(String.valueOf(empleado.contarApellidos()));
        txtDireccion.setText(empleado.getDireccion());
        cbTarjetaFidl.setSelected(empleado.isTienePrivilegios());

        String fechaNacimientoStr = empleado.getfNacimiento(); // Obtener la cadena de fecha del empleado

        // Definir un formato para convertir la cadena de fecha a LocalDate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            // Convertir la cadena de fecha a LocalDate
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);

            // Establecer la fecha en el DatePicker
            dpFechaNacimiento.setValue(fechaNacimiento);
        } catch (DateTimeParseException e) {
            // Manejar el error en caso de que la fecha no pueda ser parseada
            System.err.println("Error al parsear la fecha de nacimiento: " + e.getMessage());
        }
    }

    public void actualizarEdicionHabilitada(){

        edicionHabilitada = !edicionHabilitada;
        txtDNI.setDisable(edicionHabilitada);
        txtTelefono.setDisable(edicionHabilitada);
        txtEmail.setDisable(edicionHabilitada);
        txtNumApellidos.setDisable(edicionHabilitada);
        txtDireccion.setDisable(edicionHabilitada);
        cbTarjetaFidl.setDisable(edicionHabilitada);
        dpFechaNacimiento.setDisable(edicionHabilitada);

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

    public void mostrarPantallaPrueba(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_PantallaPrueba.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    public void mostrarListaEmpleados(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_listaEmpleados_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
}
