package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.ConexionBBDD;
import com.example.tiendaropa.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Controlador_fichaProducto { //es lo que hace que se cargue automáticamente

    ConexionBBDD conexion = new ConexionBBDD();


    //Atributos migas de pan -------------------------------------------------------------------------------------------

    @FXML
    private Button btnMigasPanTipoArticulo;

    @FXML
    private Button btnMigasPanSubtipo;

    @FXML
    private Button btnMigasPanNombreProducto;

    @FXML
    private TextField txtfMigasPanNombreProducto;

    @FXML
    private TextField txtfMigasPanSubtipo;

    @FXML
    private TextField txtfMigasPanTipoArticulo;


    //Atributos articulo  ----------------------------------------------------------------------------------------------

    @FXML
    TextField txtNombreProducto, txtPrecioProducto;

    @FXML
    private TextArea txtaMarca;

    @FXML
    private TextArea txtaDescripcion;

    @FXML
    private ImageView imagenProducto;

    @FXML
    private Button btnRetrocesoFichaProducto;


    //Atributos '¿cómo soy?'  ------------------------------------------------------------------------------------------

    @FXML
    private HBox hBoxPropiedadesArticulo;

    @FXML
    private HBox hBoxPropiedadesSubtipo;


    Articulo articulo;


    // INITIALIZE  -----------------------------------------------------------------------------------------------------


    /* NOTAS */


    //URL -> ventana en la que estamos
    //ResourceBundle -> es para cuando pasas datos entre escenas


    //ROPA -------------------------------------------------------------------------------------------------------------

    //Cargamos la ropa en la pantalla
    public void cargarArticulo(Articulo articulo) throws FileNotFoundException {

        //Propiedades de un artículo cualquiera ------------------------------------------------------------------------

        txtNombreProducto.setText(articulo.getNombre());
        txtPrecioProducto.setText(String.valueOf(articulo.getPrecio()));
        txtaMarca.setText(articulo.getMarca());
        txtaDescripcion.setText(articulo.getDescripcion());

        //Imagen -------------------------------------------------------------------------------------------------------

        FileInputStream rutaImagen = new FileInputStream("TiendaRopa/src/main/resources/com/example/tiendaropa/images/" + articulo.getImagen());

        Image imgArticulo = new Image(rutaImagen);
        imagenProducto.setImage(imgArticulo);
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

    public void retroceder(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_catologo_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

}
