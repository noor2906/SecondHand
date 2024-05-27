package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.ModificacionesBBDD;
import com.example.tiendaropa.model.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Controlador_itemCliente {

    public Button btnActivo;
    @FXML
    private Text txtCliente;
    private Cliente cliente;
    public void initialize(){

    }
    // Hecho por: Vero
    public void setData(Cliente cliente) throws FileNotFoundException {

        this.cliente = cliente;
        if (cliente.isActivo()){
            btnActivo.setText("Habilitar");
        }else {
            btnActivo.setText("Deshabilitar");
        }

        txtCliente.setText(cliente.getE_mail()+" | "+cliente.getDni());

    }
    // Hecho por: Vero
    public void activarYDesactivarCliente(MouseEvent actionEvent) {
        ModificacionesBBDD modificacion = new ModificacionesBBDD();
        int habilitado;
         habilitado=modificacion.deshabilitarYHabilitarUsuario(cliente);
         switch (habilitado){
             case 0:
                 cliente.setActivo(false);
                 btnActivo.setText("Habilitar");
                 break;
             case 1:
                 cliente.setActivo(true);
                 btnActivo.setText("Deshabilitar");
                 break;
             case -1:
                 System.out.println("No se ha podido hacer la modificación");
         }
    }
    // Hecho por: Vero
    public void mostrarInfoCliente(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_infoEmpleado_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

}
