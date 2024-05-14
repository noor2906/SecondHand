package com.example.tiendaropa;

import com.example.tiendaropa.model.Articulo;
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
            // Load the target scene FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_fichaProducto_Carol.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Usando el evento para obtener la ventana actual
            Controlador_fichaProducto productoController = loader.getController();
            productoController.cargarArticulo(this.articulo);

            // Set the scene for the stage
            stage.setScene(new Scene(root));

            // Show the target scene
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
