package com.example.tiendaropa;

import com.example.tiendaropa.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controlador_itemCatalogo{

    @FXML
    private ImageView imgItemCatalogo;

    @FXML
    private TextField txtfNombreItemCatalogo;

    @FXML
    private TextField txtfPrecioItemCatalogo;


    //Paso de variable a la ficha producto con el método mostrarFichaProducto()
    Articulo articulo;

    public void setData(Articulo articulo) throws FileNotFoundException {

        this.articulo = articulo;

        txtfNombreItemCatalogo.setText(articulo.getNombre());
        txtfPrecioItemCatalogo.setText(String.valueOf(articulo.getPrecio()));

        //Imagen -------------------------------------------------------------------------------------------------------

        // Cargar la imagen desde el archivo
        FileInputStream rutaImagen = new FileInputStream("TiendaRopa/src/main/resources/com/example/tiendaropa/images/" + articulo.getImagen());

        Image imgArticulo = new Image(rutaImagen);
        imgItemCatalogo.setImage(imgArticulo);

    }

    public void mostrarFichaProducto(MouseEvent event) {
        try {
            //Instanciamos un FXML loader y como recurso indicamos el item FXML a usar
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_fichaProducto_Carol.fxml"));

            //Cargamos el FXML (devuelve la raíz del gráfico de la escena)
            Parent root = loader.load();

            // Utiliza el evento del mouse para obtener la ventana (Stage) actual.
            // Esto se hace obteniendo la fuente del evento (el nodo que disparó el evento),
            // luego la escena de ese nodo, y finalmente la ventana de esa escena.

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            //Instanciamos el controlador de la ficha producto
            Controlador_fichaProducto productoController = loader.getController();

            //Por cada artículo que se esté cargando en el setData() lo guardo en una variable de instancia y cargo
            //los datos de dicho artículo con el método cargarArticulo()
            productoController.cargarArticulo(this.articulo);

            //Crea una nueva escena con la raíz del gráfico de la escena cargada y la establece en la ventana (stage).
            stage.setScene(new Scene(root));

            //Muestra la nueva escena en la ventan
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void añadirArticuloCarrito(){

        Aplicacion.carrito.add(this.articulo);
    }


}
