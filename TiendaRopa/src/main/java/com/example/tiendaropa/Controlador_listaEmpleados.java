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
import javafx.scene.control.Button;
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



    //Obtenemos empleados
    private List<Empleado> getEmpleados() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();

        //Llamar a la consulta que me devuelve todos los articulos
        ConsultasBBDD consulta = new ConsultasBBDD();

        empleados = consulta.listaEmpleados();

        return empleados;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            empleados.addAll(getEmpleados());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int row = 0;

        HBox hbox = new HBox(); // Crea el primer HBox

        try {
            for (int i = 0; i < empleados.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXML_itemEmpleado_Carol.fxml"));

                Parent itemEmpleado = fxmlLoader.load();

                // Obtener el controlador del elemento de empleado
                Controlador_ItemEmpleado itemController = fxmlLoader.getController();

                // Llamar al método setData() y pasarle el objeto Empleado correspondiente
                itemController.setData(empleados.get(i));

                // Agregar el contenido cargado al hbox
                hbox.getChildren().add(itemEmpleado);


                    // Agrega el HBox actual al VBox
                    vBoxEmpleados.getChildren().add(hbox);
                    vBoxEmpleados.setAlignment(Pos.CENTER);
                    // Crea un nuevo HBox para los próximos elementos
                    hbox = new HBox();
                    row++;

            }


        } catch (IOException e) {
            e.printStackTrace();
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




}
