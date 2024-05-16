package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.ConexionBBDD;
import com.example.tiendaropa.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class Controlador_fichaProducto implements Initializable { //es lo que hace que se cargue automáticamente

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


        if (articulo instanceof Ropa ropa){ //en vez de la variable Ropa ropa; lo ponemos en el if
            //Propiedades de la ropa -----------------------------------------------------------------------------------

            String [] propiedadesRopa = {String.valueOf(ropa.getMaterial()), ropa.getTalla(), ropa.getColor(), ropa.getTipoCierre()};

            hBoxPropiedadesArticulo.setSpacing(10);


            //Instanciamos el textField manualmente

            TextField txtfPropiedadesRopa = null;
            TextField txtfPropiedadesSubtipo = null;

            for (int i = 0; i < propiedadesRopa.length; i++) {

                hBoxPropiedadesArticulo.getChildren().add(txtfPropiedadesRopa = new TextField(propiedadesRopa[i]));

                textFieldPropiedades(txtfPropiedadesRopa);
            }

            // Migas de pan -> con el tipo_ropa ----------------------------------------------------------------------------
            String tipoRopa = ropa.getTipoRopa();

            if (Objects.equals(tipoRopa, "Camisa") || Objects.equals(tipoRopa, "Chaqueta") || Objects.equals(tipoRopa, "Pantalón")){
                txtfMigasPanTipoArticulo.setText("Ropa");
                txtfMigasPanSubtipo.setText(tipoRopa);
                txtfMigasPanNombreProducto.setText(ropa.getNombre());
            }


            if (articulo instanceof Camisa){
                //propiedades camisa

                String estampado = "";

                if(((Camisa) articulo).isEstampada()){
                    estampado = "Estampado";
                } else {
                    estampado = "No estampado";
                }

                String [] propiedadesCamisa = {((Camisa) articulo).getTipoManga(), estampado};

                for (int i = 0; i < propiedadesCamisa.length; i++) {
                    hBoxPropiedadesSubtipo.getChildren().add(txtfPropiedadesSubtipo = new TextField(propiedadesCamisa[i]));

                    textFieldPropiedades(txtfPropiedadesSubtipo);
                }


            } else if (articulo instanceof Chaqueta) {
                //propiedades chaqueta
                String impermeable = "";

                if(((Chaqueta) articulo).isImpermeable()){
                    impermeable = "Impermeable";
                } else{
                    impermeable = "No impermeable";
                }

                String [] propiedadesChaqueta = {impermeable};

                for (int i = 0; i < propiedadesChaqueta.length; i++) {
                    hBoxPropiedadesSubtipo.getChildren().add(txtfPropiedadesSubtipo = new TextField(propiedadesChaqueta[i]));

                    textFieldPropiedades(txtfPropiedadesSubtipo);
                }

            } else if (articulo instanceof Pantalon) {
                //propiedades pantalon
                String tieneBolsillos = "";

                if(((Pantalon) articulo).isTieneBolsillos()){
                    tieneBolsillos = "Con bolsillos";
                } else{
                    tieneBolsillos = "Sin bolsillos";
                }

                String [] propiedadesPantalon = {tieneBolsillos};

                for (int i = 0; i < propiedadesPantalon.length; i++) {
                    hBoxPropiedadesSubtipo.getChildren().add(txtfPropiedadesSubtipo = new TextField(propiedadesPantalon[i]));

                    textFieldPropiedades(txtfPropiedadesSubtipo);
                }

            }

        } else if (articulo instanceof Accesorios accesorio) { //en vez de la variable Accesorio accesorio; lo ponemos en el if
            //Propiedades de accesorio ---------------------------------------------------------------------------------

            String personalizado = "";

            if(accesorio.isPersonalizado()){
                personalizado = "Estampado";
            } else {
                personalizado = "No estampado";
            }


            String [] propiedadesAccesorio = {String.valueOf(articulo.getMaterial()), ((Accesorios) articulo).getEstilo(), personalizado};

            hBoxPropiedadesArticulo.setSpacing(10);

            //Instanciamos el textField manualmente

            TextField txtfPropiedadesAccesorio= null;
            TextField txtfPropiedadesSubtipo = null;

            for (int i = 0; i < propiedadesAccesorio.length; i++) {

                hBoxPropiedadesArticulo.getChildren().add(txtfPropiedadesAccesorio = new TextField(propiedadesAccesorio[i]));

                textFieldPropiedades(txtfPropiedadesAccesorio);

            }

            // Migas de pan -> con el tipo_accesorio -----------------------------------------------------------------------
            String tipoAccesorio = accesorio.getTipoAccesorio();

            if (tipoAccesorio.equals("Bolso") || tipoAccesorio.equals("Zapatos")){
                txtfMigasPanTipoArticulo.setText("Accesorio");
                txtfMigasPanSubtipo.setText(tipoAccesorio);
                txtfMigasPanNombreProducto.setText(accesorio.getNombre());
            }



            if (articulo instanceof Bolso){
               //propiedades bolso
                String [] propiedadesBolso = {String.valueOf(((Bolso) articulo).getCapacidad() + "L"), "Cierre: " +( (Bolso) articulo).getTipoCierre()};

                for (int i = 0; i < propiedadesBolso.length; i++) {
                    hBoxPropiedadesSubtipo.getChildren().add(txtfPropiedadesSubtipo = new TextField(propiedadesBolso[i]));

                    textFieldPropiedades(txtfPropiedadesSubtipo);
                }

            } else if (articulo instanceof Zapatos) {
                //propiedades zapatos
                String [] propiedadesZapatos = {((Zapatos) articulo).getTipoSuela(), String.valueOf(((Zapatos) articulo).getTalla())};

                for (int i = 0; i < propiedadesZapatos.length; i++) {
                    hBoxPropiedadesSubtipo.getChildren().add(txtfPropiedadesSubtipo = new TextField(propiedadesZapatos[i]));

                    textFieldPropiedades(txtfPropiedadesSubtipo);
                }
            }
        }
    }

    //Método para construir el textField de las propiedades
    public void textFieldPropiedades(TextField txtfPropiedades){
        txtfPropiedades.setPrefWidth(148);
        txtfPropiedades.setPrefHeight(57);
        txtfPropiedades.setAlignment(Pos.CENTER);
        txtfPropiedades.setEditable(false);
        txtfPropiedades.setStyle("-fx-margin: 1px; -fx-font-size: 18px; -fx-font-weight: bold; " +
                "-fx-background-color: black; -fx-text-fill: white; -fx-background-radius: 30;");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
