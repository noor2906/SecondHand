package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.InsercionesBBDD;
import com.example.tiendaropa.model.Material;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.HashMap;

public class Controlador_altaProducto {


    @FXML
    private Button btnClear1,btnClear2,btnClear3,btnClear4;

    @FXML
    private Button btnCarrito, btnGuardarCambiosAltaProducto,btnLogin,btnMenu,btnRetrocederAltaProducto,btnTituloHeader;

    @FXML
    private TextField txtfPrecioAltaProducto,txtfImagenAltaProducto, txtfMarcaAltaProducto, txtfNombreAltaProducto;

    @FXML
    private ComboBox<String> cbTipoProducto, cbMaterialAltaProducto;

    @FXML
    private CheckBox checkBActivoAltaProducto;

    @FXML
    private TextArea txtaDescripcionAltaProducto;

    @FXML
    private VBox vBoxPropiedadesAlta;

    private HashMap<Integer, Material> mapaMateriales = Material.getMapaMateriales();

    private Parent itemActual;

    @FXML
    public void initialize() throws IOException {
        System.out.println("initialize called"); // Debug statement

        ObservableList<String> soListMateriales = FXCollections.observableArrayList();
        for (Integer k : mapaMateriales.keySet()) {
            soListMateriales.add(mapaMateriales.get(k).getNombre());
        }
        cbMaterialAltaProducto.setItems(soListMateriales);

        //NOTA: Averiguar + adelante como hacerlo + genérico
        ObservableList<String> soList = FXCollections.observableArrayList("Camisa", "Pantalon", "Chaqueta", "Bolso", "Zapato");
        cbTipoProducto.setItems(soList);


        cbTipoProducto.setOnAction(actionEvent -> {
                    String tipoSeleccionado = cbTipoProducto.getValue();
                    loadItem(tipoSeleccionado);
                }
        );

    }

    private void loadItem(String tipoSeleccionado){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXML_itemAlta" + tipoSeleccionado + "_Noor.fxml"));

            if (itemActual != null){
                vBoxPropiedadesAlta.getChildren().remove(itemActual);
            }

            itemActual = root;

            vBoxPropiedadesAlta.getChildren().add(itemActual);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void darAltaProducto(MouseEvent event) throws IOException {
        int ok = 0;
        int ok2 = 0;

        //Propiedades articulo
        String nombre = txtfNombreAltaProducto.getText();
        String precio = txtfPrecioAltaProducto.getText();
        String marca = txtfMarcaAltaProducto.getText();
        String descripcion = txtaDescripcionAltaProducto.getText();
        String imagen = txtfImagenAltaProducto.getText();
        //boolean activo = true;
        String material = cbMaterialAltaProducto.getValue();

       /* if (checkBActivoAltaProducto.isSelected()){
            activo = true;
        }else{
            activo = false;
        }*/

        //Material
        int mat = 0;

        if(!nombre.equals("") && !precio.equals("") && !marca.equals("") && !descripcion.equals("") && !imagen.equals("")){
            for (Integer k : mapaMateriales.keySet()){
                if (mapaMateriales.get(k).getNombre().equals(material)){
                    mat = k;
                }
            }

            ok = InsercionesBBDD.insercionProducto(nombre,precio,marca,imagen,descripcion,mat);

        } else {
            System.out.println("Te has dejado algún campo importante");
        }

        if (ok > 0 && ok2 > 0){
            mostrarListaProductos(event);
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

    public void mostrarPanelAdmin(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_panelAdmin_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void mostrarListaProductos(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_listaProductos_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }



    //Botones limpieza
    public void limpiarNombre(MouseEvent actionEvent) {
        txtfNombreAltaProducto.clear();
    }
    public void limpiarPrecio(MouseEvent actionEvent) {
        txtfPrecioAltaProducto.clear();
    }
    public void limpiarMarca(MouseEvent actionEvent) {
        txtfMarcaAltaProducto.clear();
    }
    public void limpiarDescripcion(ActionEvent actionEvent) {
        txtaDescripcionAltaProducto.clear();
    }

    //limpiarImagen??
}
