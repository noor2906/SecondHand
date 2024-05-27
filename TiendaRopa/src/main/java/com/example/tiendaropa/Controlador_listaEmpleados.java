package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.ConsultasBBDD;
import com.example.tiendaropa.model.Empleado;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controlador_listaEmpleados implements Initializable {

    private List<Empleado> empleados = new ArrayList<>();

    @FXML
    private VBox vBoxEmpleados;

    private Empleado empleado;

    // Obtenemos empleados
    // Hecho por: Carol
    private List<Empleado> getEmpleados() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        // Llamar a la consulta que me devuelve todos los empleados
        ConsultasBBDD consulta = new ConsultasBBDD();
        empleados = consulta.listaEmpleados();
        return empleados;
    }
    // Hecho por: Carol
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            empleados.addAll(getEmpleados());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            for (int i = 0; i < empleados.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXML_itemEmpleado_Carol.fxml"));

                Parent itemEmpleado = fxmlLoader.load();

                // Obtener el controlador del elemento de empleado
                Controlador_ItemEmpleado itemController = fxmlLoader.getController();
                // Llamar al método setData() y pasarle el objeto Empleado correspondiente
                itemController.setData(empleados.get(i));

                // Crear un nuevo HBox para el itemEmpleado y centrarlo
                HBox hbox = new HBox(itemEmpleado);
                hbox.setAlignment(Pos.CENTER); // Centrar el HBox
                hbox.setPadding(new Insets(10)); // Añadir padding si es necesario

                // Agregar el HBox al VBox
                vBoxEmpleados.getChildren().add(hbox);
            }

            // Asegurar que el VBox esté centrado
            vBoxEmpleados.setAlignment(Pos.TOP_CENTER);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // BOTONES ----------------------------------------------------------------------------------------------------------

    // Método que enlaza el botón del menú hamburguesa a la pantalla del menú
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
    public void mostrarPanelAdmin(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXML_panelAdmin_Noor.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}

