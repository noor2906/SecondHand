package com.example.tiendaropa;

import com.example.tiendaropa.model.Articulo;
import com.example.tiendaropa.model.LineaPedido;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Controlador_itemCarrito {

    private Articulo articuloCarrito;
    @FXML
    private TextField txtCarritoTituloArticulo;

    @FXML
    private int txtCarritoPrecioArticulo;
    @FXML
    private ImageView imgCarritoArticulo;
    @FXML
    private ImageView imgCarritoArticuloi;
    private int codigoArticulo;
    private int precioArticulo;
    Articulo articulo;


    // Hecho por: Carol
    public void setData(Articulo articuloCarrito) throws FileNotFoundException {

        this.codigoArticulo = articuloCarrito.getCodigo();

        //Nombre producto -----------------------------------------------------------------------------------------------

        txtCarritoTituloArticulo.setText(articuloCarrito.getNombre());
        txtCarritoPrecioArticulo = (int) articuloCarrito.getPrecio();

        //Imagen -------------------------------------------------------------------------------------------------------

        // Cargar la imagen desde el archivo
        FileInputStream rutaImagen = new FileInputStream("src/main/resources/com/example/tiendaropa/images/" + articuloCarrito.getImagen());

        Image imgArticulo = new Image(rutaImagen);
        imgCarritoArticuloi.setImage(imgArticulo);

    }

}
