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


    //Obtenemos artículos y los guardamos el una List
    // Hecho por: Noor
    private List<Articulo> getArticulos() throws SQLException {
        List<Articulo> articulos = new ArrayList<>();

        //Llamar a la consulta que me devuelve todos los articulos
        ConsultasBBDD consulta = new ConsultasBBDD();

        articulos = consulta.consultaArticulos(articulos);

        return articulos;
    }

    //Tercer intento
    // Hecho por: Noor
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            //Añadimos a la lista de ésta clase los artículos obtenidos desde getArticulos()
            articulos.addAll(getArticulos());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int column = 0;

        HBox hbox = new HBox(); // Crea el primer HBox

        try {
            for (int i = 0; i < articulos.size(); i++) {

                //Instanciamos un FXML loader y como recurso indicamos el item FXML a usar
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXML_itemArticuloCatalogo.fxml"));

                //Cargamos el FXML (devuelve la raíz del gráfico de la escena)
                Parent itemArticulo = fxmlLoader.load();

                //Instanciamos el controlador del elemento de artículo
                Controlador_itemCatalogo itemController = fxmlLoader.getController();

                //Por cada artículo del ArrayList introducimos en el item los datos indicados en el método setData()
                itemController.setData(articulos.get(i));

                //Propiedades Vbox
                vBoxArticulos.setPrefHeight(vBoxArticulos.getPrefHeight() - 80);

                //Propiedades Hbox
                hbox.setAlignment(Pos.CENTER_LEFT);
                hbox.setSpacing(25);
                hbox.setPadding(new Insets(0,0,0,80));


                // Agregar el contenido cargado al hbox
                hbox.getChildren().add(itemArticulo);

                //Vamos aumentando el número de columnas
                column++;

                // Si el HBox actual tiene tres elementos, crea un nuevo HBox
                if (column == 3) {
                    // Agrega el HBox actual al VBox
                    vBoxArticulos.getChildren().add(hbox);
                    vBoxArticulos.setAlignment(Pos.CENTER);
                    // Crea un nuevo HBox para los próximos elementos
                    hbox = new HBox();
                    column = 0;
                }
            }

            // Si hay artículos restantes que no llenan una fila completa
            if (column > 0) {
                vBoxArticulos.getChildren().add(hbox);
            }

        } catch (IOException e) {
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
    // Hecho por: Noor
    public void mostrarHome(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_home_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Noor
    public void mostrarLogin(MouseEvent event) throws IOException {
        // Usuario,String path y el if hecho por: Vero
        Usuario usuario = Controlador_login.getUsuario();
        String path;
        if (usuario instanceof Cliente){
            path = "";
        } else if (usuario instanceof Empleado) {
            path = "FXML_panelAdmin_Noor.fxml";
        }else {
            path = "FXML_login_Carol.fxml";
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource(path));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Noor
    public void mostrarCarrito(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_carrito_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Carol
    public void mostrarAyudaPantalla(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_1ayudaPantalla_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Carol
    public void mostrarPrecFrec(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_2PrecFrecPantalla_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Carol
    public void mostrarEstadoPedido(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_3EstadoPedidoPantalla_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Carol
    public void mostrarDevoluciones(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_4DevolucionesPantalla_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Carol
    public void mostrarEnviosPantalla(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_5EnviosPantalla_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Carol
    public void mostrarFPPBack(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_6FPPBack_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Carol
    public void mostrarFCCBack(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_7FCCBackPantalla_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Carol
    public void mostrarFPCBack(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_8FPCBackPantallaCarol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Carol
    public void mostrarFPrefCBack(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_9FPrefCBackPantalla_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }


}
