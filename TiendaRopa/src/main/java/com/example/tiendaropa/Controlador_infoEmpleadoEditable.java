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
import com.example.tiendaropa.Conexiones.ModificacionesBBDD;


public class Controlador_infoEmpleadoEditable /*implements Initializable*/ {

    private ModificacionesBBDD modificacionesBBDD = new ModificacionesBBDD();

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


    @FXML
    public void actualizarEdicionHabilitada() {
        edicionHabilitada = !edicionHabilitada;
        txtDNI.setDisable(edicionHabilitada);
        txtTelefono.setDisable(edicionHabilitada);
        txtEmail.setDisable(edicionHabilitada);
        txtNumApellidos.setDisable(edicionHabilitada);
        txtDireccion.setDisable(edicionHabilitada);
        cbTarjetaFidl.setDisable(edicionHabilitada);
        dpFechaNacimiento.setDisable(edicionHabilitada);

        if (!edicionHabilitada) {
            // Si la edición está habilitada, significa que estamos guardando los cambios
            guardarCambios();
        }
    }

    private void guardarCambios() {

        // Obtener los datos del formulario
        String dni = txtDNI.getText();
        String nombre = textNombreApellidos.getText().split(" ")[0]; // Obtener el primer nombre
        String apellidos = textNombreApellidos.getText().substring(nombre.length()).trim(); // Obtener los apellidos restantes
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        String direccion = txtDireccion.getText();
        LocalDate fechaNacimiento = dpFechaNacimiento.getValue();
        boolean tienePrivilegios = cbTarjetaFidl.isSelected();

        // Formatear la fecha de LocalDate a String (si es necesario)
        String fNacimiento = (fechaNacimiento != null) ? fechaNacimiento.toString() : "";

        modificacionesBBDD.conectarBBDD();

        try {
            modificacionesBBDD.actualizarEmpleado(dni, nombre, apellidos, telefono, fNacimiento, email, direccion, tienePrivilegios);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            modificacionesBBDD.cerrarConexion();
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
