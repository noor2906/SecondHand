package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.InsercionesBBDD;
import com.example.tiendaropa.model.Cliente;
import com.example.tiendaropa.model.Empleado;
import com.example.tiendaropa.model.MetodoPago;
import com.example.tiendaropa.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

public class Controlador_registroUsuario {
    @FXML
    private CheckBox chbxFidelizacion;
    @FXML
    private DatePicker dpFecha;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtContra;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtDni;
    @FXML
    private TextField txtDireccion;
    @FXML
    private ComboBox<String> combList;
    private HashMap<Integer,MetodoPago> mapaPagos = MetodoPago.getMapaMetodoPago();
    private boolean fidelizacion;
    // Hecho por: Vero
    public void initialize(){
        ObservableList<String> soList = FXCollections.observableArrayList();
        for (Integer k:mapaPagos.keySet()) {
            soList.add(mapaPagos.get(k).getDescripcion());
        }
        combList.setItems(soList);
    }
    // Hecho por: Vero
    public void registrar(MouseEvent event) throws IOException {
        int ok=0;
        String nombre = txtNombre.getText();
        String contra = txtContra.getText();
        String apellidos = txtApellidos.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        String dni = txtDni.getText();
        String direccion = txtDireccion.getText();
        String pago = combList.getValue();
        String fecha = String.valueOf(dpFecha.getValue());
        fidelizacion = chbxFidelizacion.isSelected();
        int mPago = 0;
        if (!dni.equals("") && !nombre.equals("") && !apellidos.equals("") && !email.equals("") && !direccion.equals("") && !contra.equals("")){
            for (Integer k:mapaPagos.keySet()) { // sacar este método
                if (mapaPagos.get(k).getDescripcion().equals(pago)){
                    mPago = k;
                }
            }
            ok=InsercionesBBDD.insercionRegistro(nombre,contra,apellidos,telefono,email,dni,direccion,mPago,fecha,fidelizacion);
        }else {
            System.out.println("\nRegistro: Te has dejado algún campo importante\n");
        }
        if (ok>0){mostrarLogin(event);}

    }

    //BOTONES ----------------------------------------------------------------------------------------------------------

    //Método que enlaza el botón del menú hamburguesa a la pantalla del menú
    // Hecho por: Noor
    public void mostrarMenu(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_menuHamburguesa_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Carol
    public void mostrarHome(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_home_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    // Hecho por: Carol
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
    // Hecho por: Carol
    public void mostrarCarrito(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_carrito_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    // Botones Limpiar hechos por: Vero
    public void limpiarNombre(MouseEvent actionEvent) {
        txtNombre.clear();
    }
    public void limpiarApellidos(MouseEvent actionEvent) {
        txtApellidos.clear();
    }
    public void limpiarDni(MouseEvent actionEvent) {
        txtDni.clear();
    }
    public void limpiarEmail(MouseEvent actionEvent) {
        txtEmail.clear();
    }
    public void limpiarContra(MouseEvent actionEvent) {
        txtContra.clear();
    }
    public void limpiarDireccion(MouseEvent actionEvent) {
        txtDireccion.clear();
    }
    public void limpiarTelefono(MouseEvent actionEvent) {
        txtTelefono.clear();
    }
}
