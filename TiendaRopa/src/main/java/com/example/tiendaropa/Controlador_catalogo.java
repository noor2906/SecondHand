package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.ConsultasBBDD;
import com.example.tiendaropa.model.*;
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

public class Controlador_catalogo implements Initializable {

    @FXML
    private VBox vBoxArticulos;
    private List<Articulo> articulos = new ArrayList<>();


    //Obtenemos artículos
    private List<Articulo> getArticulos() throws SQLException {
        List<Articulo> articulos = new ArrayList<>();
        Articulo articulo = null;

        //Llamar a la consulta que me devuelve todos los articulos
        ConsultasBBDD consulta = new ConsultasBBDD();

        articulos = consulta.consultaArticulos(articulos);

        /*for (int i = 0; i < articulos.size(); i++) {
            articulo = new Articulo();
            articulo.setNombre("Camiseta de Noor");
            articulo.setPrecio(5);
            articulo.setImagen("imagen1.jpg");
            articulos.add(articulo);
        }*/

        return articulos;
    }

    //Tercer intento
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            articulos.addAll(getArticulos());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int column = 0;
        int row = 0;

        HBox hbox = new HBox(); // Crea el primer HBox

        try {
            for (int i = 0; i < articulos.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXML_itemArticuloCatalogo.fxml"));

                Parent itemArticulo = fxmlLoader.load();

                // Obtener el controlador del elemento de artículo
                Controlador_itemCatalogo itemController = fxmlLoader.getController();

                // Llamar al método setData() y pasarle el objeto Articulo correspondiente
                itemController.setData(articulos.get(i));

                //Propiedades Vbox
                vBoxArticulos.setPrefHeight(vBoxArticulos.getPrefHeight() + 80);

                //Propiedades Hbox
                hbox.setAlignment(Pos.CENTER_LEFT);
                hbox.setSpacing(25);
                hbox.setPadding(new Insets(0,0,0,80));


                // Agregar el contenido cargado al hbox
                hbox.getChildren().add(itemArticulo);

                column++;
                // Si el HBox actual tiene tres elementos, crea un nuevo HBox
                if (column == 3) {
                    // Agrega el HBox actual al VBox
                    vBoxArticulos.getChildren().add(hbox);
                    vBoxArticulos.setAlignment(Pos.CENTER);
                    // Crea un nuevo HBox para los próximos elementos
                    hbox = new HBox();
                    column = 0;
                    row++;
                }
            }

            // Si hay artículos restantes que no llenan una fila completa
            if (column > 0) {
                vBoxArticulos.getChildren().add(hbox);
                //hbox.setAlignment(Pos.CENTER_LEFT);
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

//Primer intento
   /* @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        articulos.addAll(getArticulos());
        int column = 0;
        int row = 0;

            try {
                for (int i = 0; i < articulos.size(); i++) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("FXML_itemArticuloCatalogo.fxml"));

                    Controlador_itemCatalogo controladorItemCatalogo = fxmlLoader.getController();
                    controladorItemCatalogo.setData(articulos.get(i));

                    paneCatalogo.add(scrollCatalogos, column++, row);

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }*/


//Segundo intento
    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        articulos.addAll(getArticulos());
        int column = 0;
        int row = 0;

        try {
            for (int i = 0; i < articulos.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXML_itemArticuloCatalogo.fxml"));

                // Carga el elemento individual del artículo desde el archivo FXML
                Pane itemArticulo = fxmlLoader.load();

                // Obtén el controlador del elemento individual del artículo
                Controlador_itemCatalogo controladorItemCatalogo = fxmlLoader.getController();
                controladorItemCatalogo.setData(articulos.get(i));

                // Agrega el elemento individual del artículo al Pane (paneCatalogo)
                paneCatalogo.getChildren().add(itemArticulo);

                // Incrementa las coordenadas de columna y fila para el siguiente elemento

                if (column == 3) {
                    column = 0;
                    row++;
                }

                column++;

                paneCatalogo.getChildren().add();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
