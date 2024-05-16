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
    private HBox hBoxListaEmpleado;

    private List<Empleado> empleados = new ArrayList<>();

    private Empleado empleado;

    @FXML
    TextField txtDNI, txtTelefono, txtEmail, txtNumApellidos, txtDireccion;

     @FXML
    DatePicker dpFechaNacimiento;

     @FXML
     CheckBox cbTarjetaFidl;

    @FXML
    Text textNombreApellidos;

    //Obtenemos artículos

   /* private List<Empleado> getEmpleados() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();

        //Llamar a la consulta que me devuelve todos los articulos
        ConsultasBBDD consulta = new ConsultasBBDD();

        empleados = consulta.listaEmpleados();

        return empleados;
    }*/

   /* @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            empleados.addAll(getEmpleados());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int column = 0;
        int row = 0;

        HBox hbox = new HBox(); // Crea el primer HBox

        try {
            for (int i = 0; i < empleados.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXML_infoEmpleadoEditable_Carol.fxml"));

                Parent itemEmpleado = fxmlLoader.load();

                // Obtener el controlador del elemento de empleado
                Controlador_ItemEmpleado itemController = fxmlLoader.getController();

                // Llamar al método setData() y pasarle el objeto Empleado correspondiente
                itemController.setData(empleados.get(i));

                //Propiedades Hbox
                hBoxListaEmpleado.setPrefHeight(hBoxListaEmpleado.getPrefHeight() + 80);

                //Propiedades Hbox
                hbox.setAlignment(Pos.CENTER_LEFT);
                hbox.setSpacing(25);
                hbox.setPadding(new Insets(0,0,0,80));


                // Agregar el contenido cargado al hbox
                hbox.getChildren().add(itemEmpleado);

                column++;
                // Si el HBox actual tiene tres elementos, crea un nuevo HBox
                if (column == 2) {
                    // Agrega el HBox actual al VBox
                    hBoxListaEmpleado.getChildren().add(hbox);
                    hBoxListaEmpleado.setAlignment(Pos.CENTER);
                    // Crea un nuevo HBox para los próximos elementos
                    hbox = new HBox();
                    column = 0;
                    row++;
                }
            }

            // Si hay artículos restantes que no llenan una fila completa
            if (column > 0) {
                hBoxListaEmpleado.getChildren().add(hbox);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void cargarEmpleado(Empleado empleado) throws FileNotFoundException {

        //Propiedades de un empleado cualquiera ------------------------------------------------------------------------

        textNombreApellidos.setText(empleado.getNombre() + " " + empleado.getApellidos());
        txtDNI.setText(empleado.getNombre());
        txtTelefono.setText(String.valueOf(empleado.getTelefono()));
        txtEmail.setText(empleado.getE_mail());
        txtNumApellidos.setText(String.valueOf(empleado.contarApellidos()));
        txtDireccion.setText(empleado.getDireccion());
        cbTarjetaFidl.setSelected(empleado.isTienePrivilegios());

        // Cargar la fecha de nacimiento del empleado que es un String en un DataPicker.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        try {
            // Convertir la cadena de fecha a LocalDate
            LocalDate fechaNacimiento = LocalDate.parse(empleado.getfNacimiento(), formatter);
            // Establecer la fecha en el DatePicker
            dpFechaNacimiento.setValue(fechaNacimiento);
        } catch (DateTimeParseException e) {
            // Manejar el error en caso de que la fecha no pueda ser parseada (Convertir una cadena de texto a un tipo de dato especifico, como un numero, fecha, etc)
            System.err.println("Error al parsear la fecha de nacimiento: " + e.getMessage());
            dpFechaNacimiento.setValue(null);
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
}
