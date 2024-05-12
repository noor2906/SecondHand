package com.example.tiendaropa;

import com.example.tiendaropa.model.Articulo;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Controlador_itemCatalogo {

    @FXML
    private ImageView imgItemCatalogo;

    @FXML
    private TextField txtfNombreItemCatalogo;

    @FXML
    private TextField txtfPrecioItemCatalogo;

    public void setData(Articulo articulo) throws FileNotFoundException {

        txtfNombreItemCatalogo.setText(articulo.getNombre());
        txtfPrecioItemCatalogo.setText(String.valueOf(articulo.getPrecio()));

        //Imagen -------------------------------------------------------------------------------------------------------

        // Cargar la imagen desde el archivo
        FileInputStream rutaImagen = new FileInputStream("TiendaRopa/src/main/resources/com/example/tiendaropa/images/" + articulo.getImagen());

        Image imgArticulo = new Image(rutaImagen);
        imgItemCatalogo.setImage(imgArticulo);

    }


}
