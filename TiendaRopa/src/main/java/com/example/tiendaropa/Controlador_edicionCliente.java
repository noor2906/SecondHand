package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.ModificacionesBBDD;
import com.example.tiendaropa.model.Cliente;
import com.example.tiendaropa.model.MetodoPago;
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
import java.time.LocalDate;
import java.util.HashMap;

public class Controlador_edicionCliente {
    @FXML
    private Button btnCerrarSesion;
    @FXML
    private Button btnClear16;
    @FXML
    private Button btnClear1;
    @FXML
    private Button btnClear12;
    @FXML
    private Button btnClear14;
    @FXML
    private Button btnClear15;
    @FXML
    private Button btnClear13;
    @FXML
    private Button btnClear11;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnMenu;
    @FXML
    private Button btnCarrito;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnEdicion;
    @FXML
    private Cliente cliente;
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
    private HashMap<Integer, MetodoPago> mapaPagos = MetodoPago.getMapaMetodoPago();
    private boolean fidelizacion;
    private boolean edicion = false;
    //hecho por: Vero
    public void initialize(){
        ObservableList<String> soList = FXCollections.observableArrayList();
        for (Integer k:mapaPagos.keySet()) {
            soList.add(mapaPagos.get(k).getDescripcion());
        }
        combList.setItems(soList);
        btnLogin.setDisable(true);
        btnCerrarSesion.setVisible(false);
        deshabilitarEdicion();
        if (Controlador_login.getUsuario() instanceof Cliente){
            cargarCliente((Cliente)Controlador_login.getUsuario());
            btnCerrarSesion.setVisible(true);
        }

    }
    //hecho por: Vero
    public void cargarCliente(Cliente client){
        cliente=client;
        txtNombre.setText(cliente.getNombre());
        txtApellidos.setText(cliente.getApellidos());
        LocalDate date = LocalDate.parse(cliente.getfNacimiento());
        dpFecha.setValue(date);
        txtDni.setText(cliente.getDni());
        txtEmail.setText(cliente.getE_mail());
        txtTelefono.setText(cliente.getTelefono());
        txtDireccion.setText(cliente.getDireccion());
        combList.getSelectionModel().select(cliente.getMetodoPago().getDescripcion());
        chbxFidelizacion.setSelected(cliente.isTarjetaFidelizacion());

    }


    public void edicion(MouseEvent event){
        if (!edicion){
            edicion = true;
            habilitarEdicion();
        }else {
            edicion = false;
            deshabilitarEdicion();
        }
    }
    //hecho por: Vero
    public void deshabilitarEdicion(){//Deshabilita botones y campos
        btnEdicion.setText("Editar");
        btnGuardar.setDisable(true);
        btnLogin.setDisable(true);
        txtNombre.setDisable(true);
        txtApellidos.setDisable(true);
        dpFecha.setDisable(true);
        txtDni.setDisable(true);
        txtEmail.setDisable(true);
        txtContra.setDisable(true);
        txtTelefono.setDisable(true);
        txtDireccion.setDisable(true);
        combList.setDisable(true);
        chbxFidelizacion.setDisable(true);
        btnClear1.setVisible(false);
        btnClear11.setVisible(false);
        btnClear12.setVisible(false);
        btnClear15.setVisible(false);
        btnClear13.setVisible(false);
        btnClear14.setVisible(false);
        btnClear16.setVisible(false);
    }
    //hecho por: Vero
    public void habilitarEdicion(){//Habilita botones y campos
        btnEdicion.setText("Cancelar");
        btnGuardar.setDisable(false);
        btnLogin.setDisable(true);
        txtNombre.setDisable(false);
        txtApellidos.setDisable(false);
        dpFecha.setDisable(false);
        txtDni.setDisable(true);
        txtEmail.setDisable(false);
        txtContra.setDisable(false);
        txtTelefono.setDisable(false);
        txtDireccion.setDisable(false);
        combList.setDisable(false);
        chbxFidelizacion.setDisable(false);
        btnClear1.setVisible(true);
        btnClear11.setVisible(true);
        btnClear12.setVisible(true);
        btnClear15.setVisible(false);
        btnClear13.setVisible(true);
        btnClear14.setVisible(true);
        btnClear16.setVisible(true);
        txtContra.setPromptText("Nueva contraseña");
    }
    public void actualizarCliente(MouseEvent event) {
        btnEdicion.setText("Volver");
        String nombre = txtNombre.getText();
        String contra = txtContra.getText();
        String apellidos = txtApellidos.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        String dni = cliente.getDni();
        String direccion = txtDireccion.getText();
        String pago = combList.getValue();
        String fecha = String.valueOf(dpFecha.getValue());
        fidelizacion = chbxFidelizacion.isSelected();

        if (contra.equals("")){contra = cliente.getPass();}
        if (nombre.equals("")){nombre = cliente.getNombre();}
        if (apellidos.equals("")){apellidos = cliente.getApellidos();}
        if (telefono.equals("")){telefono = cliente.getTelefono();}
        if (email.equals("")){email = cliente.getE_mail();}
        if (direccion.equals("")){direccion = cliente.getDireccion();}
        if (pago.equals("")){pago = String.valueOf(cliente.getMetodoPago().getCodigo());}
        if (fecha.equals("")){fecha = cliente.getfNacimiento();}
        int mPago = 1;

        for (Integer k:mapaPagos.keySet()) {
            if (mapaPagos.get(k).getDescripcion().equals(pago)){
                mPago = k;
            }
        }
        ModificacionesBBDD modificacion = new ModificacionesBBDD();
        modificacion.actualizarCliente(nombre,contra,apellidos,telefono,email,dni,direccion,mPago,fecha,fidelizacion);

    }
    public void cerrarSesion(MouseEvent event) throws IOException {
        Controlador_login.setUsuario(null);
        mostrarHome(event);
    }
    //Botones
    //hecho por: Vero
    public void mostrarListaClientes(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_listaUsuarios_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    public void retroceder(MouseEvent event) throws IOException {
        if (Controlador_login.getUsuario() instanceof Cliente){
            mostrarHome(event);
        }else {
            mostrarListaClientes(event);
        }
    }
    public void mostrarCarrito(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_carrito_Noor.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
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
