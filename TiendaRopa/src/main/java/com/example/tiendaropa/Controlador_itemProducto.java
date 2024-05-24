package com.example.tiendaropa;

import com.example.tiendaropa.model.Articulo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Controlador_itemProducto {
    @FXML
    private Button btnActivoProducto;

    @FXML
    private Button btnEditarProducto;

    @FXML
    private ImageView imgProducto;

    @FXML
    private Text txtNombreProducto;

    Articulo articulo;

    public void setData(Articulo articulo) throws FileNotFoundException {

        this.articulo = articulo;

        txtNombreProducto.setText(articulo.getNombre());

        //Imagen -------------------------------------------------------------------------------------------------------

        // Cargar la imagen desde el archivo
        FileInputStream rutaImagen = new FileInputStream("TiendaRopa/src/main/resources/com/example/tiendaropa/images/" + articulo.getImagen());

        Image imgArticulo = new Image(rutaImagen);
        imgProducto.setImage(imgArticulo);

    }
}
