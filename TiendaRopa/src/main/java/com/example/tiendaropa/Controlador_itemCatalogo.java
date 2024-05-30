package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.ConsultasBBDD;
import com.example.tiendaropa.Conexiones.InsercionesBBDD;
import com.example.tiendaropa.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class Controlador_itemCatalogo{

    private InsercionesBBDD insercionesBBDD = new InsercionesBBDD();

    @FXML
    private ImageView imgItemCatalogo;

    @FXML
    private TextField txtfNombreItemCatalogo;

    @FXML
    private TextField txtfPrecioItemCatalogo;

    Articulo articulo;

    Usuario usuario = Controlador_login.getUsuario();

    // Hecho por: Noor
    public void setData(Articulo articulo) throws FileNotFoundException {

        this.articulo = articulo;

        txtfNombreItemCatalogo.setText(articulo.getNombre());
        txtfPrecioItemCatalogo.setText(String.valueOf(articulo.getPrecio()));

        //Imagen -------------------------------------------------------------------------------------------------------

        // Cargar la imagen desde el archivo
        FileInputStream rutaImagen = new FileInputStream("src/main/resources/com/example/tiendaropa/images/" + articulo.getImagen());

        Image imgArticulo = new Image(rutaImagen);
        imgItemCatalogo.setImage(imgArticulo);

    }
    // Hecho por: Noor
    public void mostrarFichaProducto(MouseEvent event) {
        try {
            //Instanciamos un FXML loader y como recurso indicamos el item FXML a usar
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_fichaProducto_Carol.fxml"));

            //Cargamos el FXML (devuelve la raíz del gráfico de la escena)
            Parent root = loader.load();

            // Utiliza el evento del mouse para obtener la ventana (Stage) actual.
            // Esto se hace obteniendo la fuente del evento (el nodo que disparó el evento),
            // luego la escena de ese nodo, y finalmente la ventana de esa escena.

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            //Instanciamos el controlador de la ficha producto
            Controlador_fichaProducto productoController = loader.getController();

            //Por cada artículo que se esté cargando en el setData() lo guardo en una variable de instancia y cargo
            //los datos de dicho artículo con el método cargarArticulo()
            productoController.cargarArticulo(this.articulo);

            //Crea una nueva escena con la raíz del gráfico de la escena cargada y la establece en la ventana (stage).
            stage.setScene(new Scene(root));

            //Muestra la nueva escena en la ventan
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Hecho por carol:
    private void insertarPedidoCarrito() {

        if (usuario == null) {
            System.out.println("No hay ningún usuario autenticado.");
            return; // Salir del método para evitar errores
        }

        LocalDate fechaPedido = LocalDate.now();
        String dirEnvio = usuario.getDireccion();
        String estado = "En proceso";
        String dniCliente = usuario.getDni();
        String fechaPedidoString = fechaPedido.toString();
        try {
            // Verificar si insercionesBBDD es nulo antes de llamar al método
            if (insercionesBBDD != null) {
                insercionesBBDD.insertarPedido(fechaPedidoString, dirEnvio, estado, dniCliente);
                System.out.println("Pedido insertado correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    //Hecho por carol:
    private void insertarLineaPedidoCarrito(Integer numPedido) {

        int codigoArticulo = articulo.getCodigo();
        int cantidad = 1;

        try {
            // Verificar si insercionesBBDD es nulo antes de llamar al método
            if (insercionesBBDD != null) {
                insercionesBBDD.insertarLineaPedido(codigoArticulo, numPedido, cantidad);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    //Hecho por carol:
    public void addArticuloCarrito(MouseEvent event){

        Alert noUsuario = new Alert(Alert.AlertType.NONE);

        if (usuario != null){

        Alert artAgotado = new Alert(Alert.AlertType.NONE);
        ConsultasBBDD consulta = new ConsultasBBDD();

        Integer numPedido = consulta.getNumeroPedidoEnProceso(usuario);

        if (numPedido == null){
            insertarPedidoCarrito();
            numPedido = consulta.getNumeroPedidoEnProceso(usuario);
        }


        int codigoArticulo = articulo.getCodigo();
        boolean existeLineaPedido = consulta.existeLineaPedido(numPedido, codigoArticulo);

        if (!existeLineaPedido){
            insertarLineaPedidoCarrito(numPedido);
        } else {
            artAgotado.setAlertType(Alert.AlertType.INFORMATION);
            artAgotado.setHeaderText(null);
            artAgotado.setContentText("Producto Agotado, por favor, seleccione otro");
            artAgotado.show();
        }
        } else {
            noUsuario.setAlertType(Alert.AlertType.INFORMATION);
            noUsuario.setHeaderText(null);
            noUsuario.setContentText("Debe iniciar sesión para añadir articulos al carrito");
            noUsuario.show();
        }

    }
}
