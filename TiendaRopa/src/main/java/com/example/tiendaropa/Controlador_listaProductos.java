package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.ConsultasBBDD;
import com.example.tiendaropa.model.Articulo;
import com.example.tiendaropa.model.Cliente;
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
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controlador_listaProductos {

    private List<Articulo> productos = new ArrayList<>();
    @FXML
    private VBox vBoxProductos;
    // Hecho por: Noor
    private List<Articulo> getProducto() throws SQLException {
        List<Articulo> productos = new ArrayList<>();
        Articulo articulo = null;

        //Llamar a la consulta que me devuelve todos los articulos
        ConsultasBBDD consulta = new ConsultasBBDD();

        productos = consulta.consultaArticulos(productos);

        return productos;
    }
    // Hecho por: Noor
    public void initialize() throws IOException {
        try {
            productos.addAll(getProducto());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        HBox hbox = new HBox(); // Crea el primer HBox
        try {
            for (int i = 0; i < productos.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXML_itemProducto.fxml"));

                Parent itemClientes = fxmlLoader.load();

                // Obtener el controlador del elemento de artículo
                Controlador_itemProducto itemController = fxmlLoader.getController();

                // Llamar al método setData() y pasarle el objeto Articulo correspondiente
                itemController.setData(productos.get(i));

                //Propiedades Vbox
                vBoxProductos.setPrefHeight(vBoxProductos.getPrefHeight());
                vBoxProductos.setAlignment(Pos.CENTER);
                vBoxProductos.setSpacing(20);
                vBoxProductos.layout();

                //Propiedades Hbox
                hbox.getChildren().add(itemClientes);
                hbox.setAlignment(Pos.CENTER_LEFT);
                hbox.setSpacing(575);

                // Agrega el HBox actual al VBox
                vBoxProductos.getChildren().add(hbox);
                vBoxProductos.setAlignment(Pos.CENTER);

                // Crea un nuevo HBox para los próximos elementos
                hbox = new HBox();

            }
        }catch (IOException e) {
            e.printStackTrace();
        }
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
    public void mostrarHome(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_home_Noor.fxml"));

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
    // Hecho por: Noor
    public void mostrarPanelAdmin(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_panelAdmin_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
}
