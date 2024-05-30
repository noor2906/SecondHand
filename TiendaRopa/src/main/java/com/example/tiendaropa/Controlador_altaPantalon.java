package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.InsercionesBBDD;
import com.example.tiendaropa.model.Cliente;
import com.example.tiendaropa.model.Empleado;
import com.example.tiendaropa.model.Material;
import com.example.tiendaropa.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class Controlador_altaPantalon {

    //Header -----------------------------------------------------------------------------------------------------------
    @FXML
    private Button btnCarrito, btnTituloHeader,  btnLogin, btnMenu, btnDarAltaCamisa, btnRetrocederPanelAltaProducto;
    @FXML
    private TextField txtfBusqueda;


    //Atributos alta articulo -------------------------------------------------------------------------------------------

    @FXML
    private Button btnClearArt1,btnClearArt2,btnClearArt3,btnClearArt4;

    @FXML
    private TextField txtfImagenAltaProducto, txtfMarcaAltaProducto, txtfNombreAltaProducto, txtfPrecioAltaProducto;

    @FXML
    private TextArea txtaDescripcionAltaProducto;

    @FXML
    private CheckBox checkBActivoAltaProducto;

    @FXML
    private ComboBox<String> cbMaterialAltaProducto;

    private HashMap<Integer, Material> mapaMateriales = Material.getMapaMateriales();


    //Atributos alta pantalon ------------------------------------------------------------------------------------------
    @FXML
    private Button btnClearPantalon1, btnClearPantalon2, btnClearPantalon3, btnClearPantalon4;

    @FXML
    private TextField txtfTallaAltaPantalon, txtfColorAltaPantalon, txtfTipoCierreAltaPantalon, txtfTipoPantalonAltaPantalon;

    @FXML
    private CheckBox chBoxBolsillosAltaPantalon;


    // Hecho por: Noor
    @FXML
    public void initialize() throws IOException {

        //Cargamos la lista de materiales en el comboBox
        ObservableList<String> soListMateriales = FXCollections.observableArrayList();
        for (Integer k : mapaMateriales.keySet()) {
            soListMateriales.add(mapaMateriales.get(k).getNombre());
        }
        cbMaterialAltaProducto.setItems(soListMateriales);
    }


    public void darAltaPantalon(MouseEvent event) throws IOException {
        int ok = 0;
        int ok2 = 0;

        //Propiedades articulo
        String nombre = txtfNombreAltaProducto.getText();
        String precio = txtfPrecioAltaProducto.getText();
        String marca = txtfMarcaAltaProducto.getText();
        String descripcion = txtaDescripcionAltaProducto.getText();
        String imagen = txtfImagenAltaProducto.getText();
        boolean activo = checkBActivoAltaProducto.isSelected();
        String material = cbMaterialAltaProducto.getValue();

        //Propiedades pantalon
        String talla = txtfTallaAltaPantalon.getText();
        String color = txtfColorAltaPantalon.getText();
        String tipoCierre = txtfTipoCierreAltaPantalon.getText();
        String tipoPantalon = txtfTipoPantalonAltaPantalon.getText();
        boolean bolsillos = chBoxBolsillosAltaPantalon.isSelected();


        //Material
        int mat = 0;

        //Si estos campos no están vacíos
        if(!nombre.equals("") && !precio.equals("") && !marca.equals("") && !descripcion.equals("") &&
                !imagen.equals("") && !material.equals("") && !talla.equals("") && !color.equals("") && !tipoCierre.equals("") &&
                !tipoPantalon.equals("")){

            //Cargamos el material
            for (Integer k : mapaMateriales.keySet()){
                if (mapaMateriales.get(k).getNombre().equals(material)){
                    mat = k;
                }
            }

            //Hacemos las inserciones
            ok = InsercionesBBDD.insercionProducto(nombre,precio,marca,imagen,descripcion,activo, mat);
            ok2 = InsercionesBBDD.insercionPantalon(talla,color,tipoCierre,bolsillos, tipoPantalon);

        } else {
            alertaCamposObligatorios();
        }

        if (ok > 0 && ok2 > 0){
            mostrarListaProductos(event);
        }
    }

    public void alertaCamposObligatorios(){
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.ERROR);
        a.setHeaderText(null);
        a.setContentText("Te has dejado un campo importante");
        a.show();
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
        // Usuario,String path y el if hecho por: Vero
        // Controla que el usuario haya hecho login o lo redirige al login
        Usuario usuario = Controlador_login.getUsuario();
        String path;
        if (usuario instanceof Cliente){// Si el usuario es cliente redirige a su edición
            path = "FXML_edicionUsuario_Carol.fxml";
        } else if (usuario instanceof Empleado) {// Si el usuario es empleado redirige a Panel Admin
            path = "FXML_panelAdmin_Noor.fxml";
        }else {// En el caso de que no sea ni empleado ni cliente significaria que no ha hecho login
            path = "FXML_login_Carol.fxml";
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource(path));

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void mostrarCarrito(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_carrito_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void mostrarPanelAltaProducto(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_panelAltaProducto_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    //Una vez que se registra se va a la lista de productos
    public void mostrarListaProductos(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_listaProductos_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }


    //Botones limpieza articulo ----------------------------------------------------------------------------------------
    public void limpiarNombre(MouseEvent event) {
        txtfNombreAltaProducto.clear();
    }
    public void limpiarPrecio(MouseEvent event) {
        txtfPrecioAltaProducto.clear();
    }
    public void limpiarMarca(MouseEvent event) {
        txtfMarcaAltaProducto.clear();
    }
    public void limpiarDescripcion(MouseEvent event) {
        txtaDescripcionAltaProducto.clear();
    }


    //Botones limpieza pantalon ----------------------------------------------------------------------------------------

    public void limpiarTalla(MouseEvent event) {txtfTallaAltaPantalon.clear();}
    public void limpiarColor(MouseEvent event) {txtfColorAltaPantalon.clear();}
    public void limpiarTipoCierre(MouseEvent event) {txtfTipoCierreAltaPantalon.clear();}
    public void limpiarTipoPantalon(MouseEvent event) {txtfTipoPantalonAltaPantalon.clear();}


}
