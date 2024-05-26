package com.example.tiendaropa;

import com.example.tiendaropa.model.Articulo;
import com.example.tiendaropa.model.Empleado;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controlador_itemCarrito {

    private Articulo articulo;
    @FXML
    private TextField txtCarritoTituloArticulo;

    @FXML
    private TextField txtCarritoPrecioArticulo;

    @FXML
    private ImageView imgCarritoArticulo;


    public void setData(Articulo articulo) throws FileNotFoundException {
        this.articulo = articulo;
        txtCarritoTituloArticulo.setText(articulo.getNombre());
        txtCarritoPrecioArticulo.setText(articulo.getPrecio() + "");

        // Cargar la imagen desde el archivo
        FileInputStream rutaImagen = new FileInputStream("src/main/resources/com/example/tiendaropa/images/" + articulo.getImagen());

        Image imgArticulo = new Image(rutaImagen);
        imgCarritoArticulo.setImage(imgArticulo);
    }

}
