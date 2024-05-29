package com.example.tiendaropa;

import com.example.tiendaropa.model.Articulo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controlador_itemProducto {
    @FXML
    private Button btnActivoProducto;

    @FXML
    private Button btnEditarProducto;

    @FXML
    private ImageView imgProducto;

    @FXML
    private Text txtNombreProducto;

    private int codigoArticulo;

    Articulo articulo;
    // Hecho por: Noor
    public void setData(Articulo articulo) throws FileNotFoundException {

        this.articulo = articulo;
        this.codigoArticulo = articulo.getCodigo();

        //Nombre producto -----------------------------------------------------------------------------------------------

        txtNombreProducto.setText(articulo.getNombre());

        //Imagen -------------------------------------------------------------------------------------------------------

        // Cargar la imagen desde el archivo
        FileInputStream rutaImagen = new FileInputStream("src/main/resources/com/example/tiendaropa/images/" + articulo.getImagen());

        Image imgArticulo = new Image(rutaImagen);
        imgProducto.setImage(imgArticulo);

    }
    // Hecho por: Noor
    public void mostrarInfoProducto(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_altaProducto_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }
}
