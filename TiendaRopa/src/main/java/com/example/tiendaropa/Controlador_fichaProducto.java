/*
package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.ConexionBBDD;
import com.example.tiendaropa.model.Accesorios;
import com.example.tiendaropa.model.Material;
import com.example.tiendaropa.model.Ropa;
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
import java.sql.ResultSet;
import java.util.Objects;
import java.util.ResourceBundle;


public class Controlador_fichaProducto implements Initializable { //es lo que hace que se cargue automáticamente

    ConexionBBDD conexion = new ConexionBBDD();


    //ArrayList<Articulo> art;  // Lo puse aquí pq tuve una idea


    */
/* IDEA - NOOR  *//*


    //Instanciamos un artículo. Obtenemos ese artículo con algún método al hacer click en la pantalla de
    // catalogos y éste controlador se edita para que dependiendo del objeto que obtengamos (se haría con un instanceOf
    // pq heredan unas de otras), se hiciera una consulta u otra

    // Ej.: Articulo articulo = obtenerArticulo();

    // initialize -> if(articulo instanceOf Ropa){
    //                  *consulta a una ropa*
    //                }

    // y así con el artículo

    //nota: se parece al POO_AV3 de vehículos


    //Atributos migas de pan -------------------------------------------------------------------------------------------


    //Migas de pan  ----------------------------------------------------------------------------------------------------

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


    //Atributos '¿cómo soy?'  ------------------------------------------------------------------------------------------

    @FXML
    private Button btnPropiedad;

    @FXML
    private HBox hBoxPropiedadesArticulo;

    @FXML
    private HBox hBoxPropiedadesSubtipo;


    // INITIALIZE  -----------------------------------------------------------------------------------------------------


    */
/* NOTAS *//*


    //URL -> ventana en la que estamos
    //ResourceBundle -> es para cuando pasas datos entre escenas


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {

            conexion.conectarBBDD();

            conexion.crearSentencia();


            //Consulta a la BBDD ROPA  ---------------------------------------------------------------------------------

            //ResultSet rs = conexion.ejecutarSentencia("select articulo.*, ropa.* from ropa join articulo on " +
            //                                         "ropa.cod_art = articulo.cod_art where articulo.cod_art = 7");
            //recogerRopa(rs);


            //Consulta a la BBDD ARTÍCULO  -----------------------------------------------------------------------------

            ResultSet rs = conexion.ejecutarSQL("select articulo.*, accesorio.* from accesorio join articulo " +
                    "on accesorio.cod_art = articulo.cod_art where articulo.cod_art = 20");
            recogerAccesorio(rs);


            System.out.println("Inicio correcto");


            conexion.desconectarBBDD();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //ROPA -------------------------------------------------------------------------------------------------------------

    //Método para recoger los datos de la ropa de la BBDD
    public Ropa recogerRopa(ResultSet rs)  {

        Ropa ropa = null;

        try{

            //Llamamos a las columnas que den como resultado la sentencia
            while (rs.next()){

                //Propiedades artículo

                String nombre = rs.getString("nombre");
                float precio = rs.getFloat("precio");
                String marca = rs.getString("marca");
                String descripcion = rs.getString("descripcion");
                int codArt = rs.getInt("cod_art");
                String imagen  = rs.getString("imagen");
                boolean activo  = rs.getBoolean("activo");
                Material material = Material.seleccionarMaterial(rs.getInt("material"));


                //Propiedades ropa

                String talla = rs.getString("talla");
                String color = rs.getString("color");
                String tipoCierre = rs.getString("tipo_cierre");
                boolean impermeable = rs.getBoolean("impermeable");
                String tipoManga = rs.getString("tipo_manga");
                boolean estampada = rs.getBoolean("estampada");
                String tipoPantalon = rs.getString("tipo_pantalon");
                boolean tieneBolsillos = rs.getBoolean("tien_bolsillos");
                String tipoRopa = rs.getString("tipo_ropa");

                ropa = new Ropa(codArt, nombre, precio, marca, descripcion, activo, imagen, material, talla, color, tipoCierre,
                        impermeable, tipoManga, estampada, tipoPantalon, tieneBolsillos, tipoRopa);

            }

            cargarRopa(ropa);

            System.out.println("Obtenemos ropa");
        } catch (Exception e) {
            System.out.println("No obtenemos ropa");
            throw new RuntimeException(e);
        }
        return (ropa); //devolverá la ropa si se carga correctamente
    }


    //Cargamos la ropa en la pantalla
    public void cargarRopa(Ropa ropa) throws FileNotFoundException {

        //Propiedades de un artículo cualquiera ------------------------------------------------------------------------

        txtNombreProducto.setText(ropa.getNombre());
        txtPrecioProducto.setText(String.valueOf(ropa.getPrecio()));
        txtaMarca.setText(ropa.getMarca());
        txtaDescripcion.setText(ropa.getDescripcion());


        // Migas de pan -> con el tipo_ropa ----------------------------------------------------------------------------
        String tipoRopa = ropa.getTipoRopa();

        if (Objects.equals(tipoRopa, "Camisa") || Objects.equals(tipoRopa, "Chaqueta") || Objects.equals(tipoRopa, "Pantalón")){
            txtfMigasPanTipoArticulo.setText("Ropa");
            txtfMigasPanSubtipo.setText(tipoRopa);
            txtfMigasPanNombreProducto.setText(ropa.getNombre());
        }


        //Imagen -------------------------------------------------------------------------------------------------------

        FileInputStream rutaImagen = new FileInputStream("TiendaRopa/src/main/resources/com/example/tiendaropa/images/" + ropa.getImagen());

        Image imgArticulo = new Image(rutaImagen);
        imagenProducto.setImage(imgArticulo);



        //Propiedades de la ropa ---------------------------------------------------------------------------------------

        String [] propiedadesRopa = {String.valueOf(ropa.getMaterial()), ropa.getTalla(), ropa.getColor(), ropa.getTipoCierre()};

        hBoxPropiedadesArticulo.setSpacing(10);


        //Instanciamos el textField manualmente

        TextField txtfPropiedadesRopa = null;
        TextField txtfPropiedadesSubtipo = null;

        try{

            for (int i = 0; i < propiedadesRopa.length; i++) {

                hBoxPropiedadesArticulo.getChildren().add(txtfPropiedadesRopa = new TextField(propiedadesRopa[i]));

                txtfPropiedadesRopa.setPrefWidth(148);
                txtfPropiedadesRopa.setPrefHeight(57);
                txtfPropiedadesRopa.setAlignment(Pos.CENTER);
                txtfPropiedadesRopa.setEditable(false);
                txtfPropiedadesRopa.setStyle("-fx-margin: 1px; -fx-font-size: 18px; -fx-font-weight: bold; " +
                        "-fx-background-color: black; -fx-text-fill: white; -fx-background-radius: 30;");

            }

            switch (ropa.getTipoRopa()){
                case "Camisa" -> {

                    String estampado = "";

                    if(ropa.isEstampada()){
                        estampado = "Estampado";
                    } else {
                        estampado = "No estampado";
                    }

                    String [] propiedadesCamisa = {ropa.getTipoManga(), estampado};

                    for (int i = 0; i < propiedadesCamisa.length; i++) {
                        hBoxPropiedadesSubtipo.getChildren().add(txtfPropiedadesSubtipo = new TextField(propiedadesCamisa[i]));

                        txtfPropiedadesSubtipo.setPrefWidth(148);
                        txtfPropiedadesSubtipo.setPrefHeight(57);
                        txtfPropiedadesSubtipo.setAlignment(Pos.CENTER);
                        txtfPropiedadesSubtipo.setEditable(false);
                        txtfPropiedadesSubtipo.setStyle("-fx-margin: 1px; -fx-font-size: 18px; -fx-font-weight: bold; " +
                                "-fx-background-color: black; -fx-text-fill: white; -fx-background-radius: 30;");
                    }
                }

                case "Chaqueta" -> {

                    String impermeable = "";

                    if(ropa.isImpermeable()){
                        impermeable = "Impermeable";
                    } else{
                        impermeable = "No impermeable";
                    }

                    String [] propiedadesChaqueta = {impermeable};

                    for (int i = 0; i < propiedadesChaqueta.length; i++) {
                        hBoxPropiedadesSubtipo.getChildren().add(txtfPropiedadesSubtipo = new TextField(propiedadesChaqueta[i]));

                        txtfPropiedadesSubtipo.setPrefWidth(148);
                        txtfPropiedadesSubtipo.setPrefHeight(57);
                        txtfPropiedadesSubtipo.setAlignment(Pos.CENTER);
                        txtfPropiedadesSubtipo.setEditable(false);
                        txtfPropiedadesSubtipo.setStyle("-fx-margin: 1px; -fx-font-size: 18px; -fx-font-weight: bold; " +
                                "-fx-background-color: black; -fx-text-fill: white; -fx-background-radius: 30;");
                    }
                }

                case "Pantalón" -> {
                    String tieneBolsillos = "";

                    if(ropa.isTieneBolsillos()){
                        tieneBolsillos = "Con bolsillos";
                    } else{
                        tieneBolsillos = "Sin bolsillos";
                    }

                    String [] propiedadesPantalon = {tieneBolsillos};

                    for (int i = 0; i < propiedadesPantalon.length; i++) {
                        hBoxPropiedadesSubtipo.getChildren().add(txtfPropiedadesSubtipo = new TextField(propiedadesPantalon[i]));

                        txtfPropiedadesSubtipo.setPrefWidth(148);
                        txtfPropiedadesSubtipo.setPrefHeight(57);
                        txtfPropiedadesSubtipo.setAlignment(Pos.CENTER);
                        txtfPropiedadesSubtipo.setEditable(false);
                        txtfPropiedadesSubtipo.setStyle("-fx-margin: 1px; -fx-font-size: 18px; -fx-font-weight: bold; " +
                                "-fx-background-color: black; -fx-text-fill: white; -fx-background-radius: 30;");
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error en los propiedades ropa");
            throw new RuntimeException(e);
        }
    }


    //ACCESORIOS -------------------------------------------------------------------------------------------------------

    //Método para recoger los datos del accesorio de la BBDD
    public Accesorios recogerAccesorio(ResultSet rs) {
        Accesorios accesorio = null;

        try{

            //Llamamos a las columnas que den como resultado la sentencia
            while (rs.next()){

                //Propiedades artículo

                int codArt = rs.getInt("cod_art");
                String nombre = rs.getString("nombre");
                float precio = rs.getFloat("precio");
                String descripcion = rs.getString("descripcion");
                String marca = rs.getString("marca");
                String imagen  = rs.getString("imagen");
                boolean activo  = rs.getBoolean("activo");
                Material material = Material.seleccionarMaterial(rs.getInt("material"));


                //Propiedades accesorio

                String estilo = rs.getString("estilo");
                boolean personalizado = rs.getBoolean("personalizado");
                String tipoCierre = rs.getString("tipo_cierre");
                int capacidad = rs.getInt("capacidad");
                String tipoSuela = rs.getString("tipo_suela");
                int talla = rs.getInt("talla");
                String tipoAccesorio = rs.getString("tipo_accesorio");


                accesorio = new Accesorios(codArt, nombre, precio, marca, descripcion, activo, imagen, material, estilo,
                        personalizado, tipoCierre, capacidad, talla, tipoSuela, tipoAccesorio);


                //Ingresar
                cargarAccesorio(accesorio);
            }

            System.out.println("Obtenemos accesorio");

        } catch (Exception e) {
            System.out.println("No obtenemos accesorio");
            throw new RuntimeException(e);
        }
        return (accesorio); //devolverá el accesorio si se carga correctamente
    }


    //Cargamos el accesorio en la pantalla
    public void cargarAccesorio(Accesorios accesorio) throws FileNotFoundException {

        //Propiedades de un artículo cualquiera ------------------------------------------------------------------------
        txtNombreProducto.setText(accesorio.getNombre());
        txtPrecioProducto.setText(String.valueOf(accesorio.getPrecio()));
        txtaMarca.setText(accesorio.getMarca());
        txtaDescripcion.setText(accesorio.getDescripcion());


        // Migas de pan -> con el tipo_accesorio -----------------------------------------------------------------------
        String tipoAccesorio = accesorio.getTipoAccesorio();

        if (tipoAccesorio.equals("Bolso") || tipoAccesorio.equals("Zapatos")){
            txtfMigasPanTipoArticulo.setText("Accesorio");
            txtfMigasPanSubtipo.setText(tipoAccesorio);
            txtfMigasPanNombreProducto.setText(accesorio.getNombre());
        }


        //Imagen -------------------------------------------------------------------------------------------------------
        FileInputStream rutaImagen = new FileInputStream("TiendaRopa/src/main/resources/com/example/tiendaropa/images/" + accesorio.getImagen());

        Image imgArticulo = new Image(rutaImagen);
        imagenProducto.setImage(imgArticulo);


        //Propiedades de accesorio -------------------------------------------------------------------------------------

        String personalizado = "";

        if(accesorio.isPersonalizado()){
            personalizado = "Estampado";
        } else {
            personalizado = "No estampado";
        }


        String [] propiedadesAccesorio = {String.valueOf(accesorio.getMaterial()), accesorio.getEstilo(), personalizado};

        hBoxPropiedadesArticulo.setSpacing(10);


        //Instanciamos el textField manualmente

        TextField txtfPropiedadesAccesorio= null;
        TextField txtfPropiedadesSubtipo = null;

        try{

            for (int i = 0; i < propiedadesAccesorio.length; i++) {

                hBoxPropiedadesArticulo.getChildren().add(txtfPropiedadesAccesorio = new TextField(propiedadesAccesorio[i]));

                txtfPropiedadesAccesorio.setPrefWidth(148);
                txtfPropiedadesAccesorio.setPrefHeight(57);
                txtfPropiedadesAccesorio.setAlignment(Pos.CENTER);
                txtfPropiedadesAccesorio.setEditable(false);
                txtfPropiedadesAccesorio.setStyle("-fx-margin: 1px; -fx-font-size: 18px; -fx-font-weight: bold; " +
                        "-fx-background-color: black; -fx-text-fill: white; -fx-background-radius: 30;");

            }

            switch (accesorio.getTipoAccesorio()){
                case "Bolso" -> {

                    String [] propiedadesBolso = {String.valueOf(accesorio.getCapacidad()), accesorio.getTipoCierre()};

                    for (int i = 0; i < propiedadesBolso.length; i++) {
                        hBoxPropiedadesSubtipo.getChildren().add(txtfPropiedadesSubtipo = new TextField(propiedadesBolso[i]));

                        txtfPropiedadesSubtipo.setPrefWidth(148);
                        txtfPropiedadesSubtipo.setPrefHeight(57);
                        txtfPropiedadesSubtipo.setAlignment(Pos.CENTER);
                        txtfPropiedadesSubtipo.setEditable(false);
                        txtfPropiedadesSubtipo.setStyle("-fx-margin: 1px; -fx-font-size: 18px; -fx-font-weight: bold; " +
                                "-fx-background-color: black; -fx-text-fill: white; -fx-background-radius: 30;");
                    }
                }

                case "Zapatos" -> {


                    String [] propiedadesZapatos = {accesorio.getTipoSuela(), String.valueOf(accesorio.getTalla())};

                    for (int i = 0; i < propiedadesZapatos.length; i++) {
                        hBoxPropiedadesSubtipo.getChildren().add(txtfPropiedadesSubtipo = new TextField(propiedadesZapatos[i]));

                        txtfPropiedadesSubtipo.setPrefWidth(148);
                        txtfPropiedadesSubtipo.setPrefHeight(57);
                        txtfPropiedadesSubtipo.setAlignment(Pos.CENTER);
                        txtfPropiedadesSubtipo.setEditable(false);
                        txtfPropiedadesSubtipo.setStyle("-fx-margin: 1px; -fx-font-size: 18px; -fx-font-weight: bold; " +
                                "-fx-background-color: black; -fx-text-fill: white; -fx-background-radius: 30;");
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error en los propiedades accesorios");
            throw new RuntimeException(e);
        }

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

}
*/
