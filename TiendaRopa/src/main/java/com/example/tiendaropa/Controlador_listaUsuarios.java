package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.ConsultasBBDD;
import com.example.tiendaropa.model.Articulo;
import com.example.tiendaropa.model.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controlador_listaUsuarios {
    private List<Cliente> clientes = new ArrayList<>();
    @FXML
    private VBox vBoxClientes;

    private void getClientes() throws SQLException {
        ConsultasBBDD consulta = new ConsultasBBDD();
        clientes = consulta.recogerListaClientes(clientes);
    }
    private List<Cliente> getCliente() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = null;

        //Llamar a la consulta que me devuelve todos los articulos
        ConsultasBBDD consulta = new ConsultasBBDD();

        clientes = consulta.recogerListaClientes(clientes);

        return clientes;
    }
    public void initialize() throws IOException {
        try {
            clientes.addAll(getCliente());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int column = 0;
        int row = 0;

        HBox hbox = new HBox(); // Crea el primer HBox
        try {
            for (int i = 0; i <clientes.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXML_itemCLiente.fxml"));

                Parent itemClientes = fxmlLoader.load();

                // Obtener el controlador del elemento de artículo
                Controlador_itemCliente itemController = fxmlLoader.getController();

                // Llamar al método setData() y pasarle el objeto Cliente correspondiente
                itemController.setData(clientes.get(i));

                hbox.getChildren().add(itemClientes);

                hbox.setAlignment(Pos.CENTER_LEFT);
                hbox.setSpacing(25);
                hbox.setPadding(new Insets(10,0,0,80));


                // Agrega el HBox actual al VBox
                vBoxClientes.getChildren().add(hbox);
                vBoxClientes.setAlignment(Pos.CENTER);
                //Propiedades Vbox
                vBoxClientes.setPrefHeight(vBoxClientes.getPrefHeight() + 80);
                // Crea un nuevo HBox para los próximos elementos
                hbox = new HBox();
                row++;
            }
        }catch (IOException e) {
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

    public void volverPanelAdmin(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_panelAdmin_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
}
