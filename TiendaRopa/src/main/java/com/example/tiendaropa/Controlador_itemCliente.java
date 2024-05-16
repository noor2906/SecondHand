package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.ConsultasBBDD;
import com.example.tiendaropa.Conexiones.ModificacionesBBDD;
import com.example.tiendaropa.model.Cliente;
import com.example.tiendaropa.model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Controlador_itemCliente {
    @FXML
    private Text txtCliente;
    @FXML
    private CheckBox chbxActivo;
    private Cliente cliente;
    public void initialize(){
        chbxActivo.setSelected(true);
    }
    public void setData(Cliente cliente) throws FileNotFoundException {

        this.cliente = cliente;

        txtCliente.setText(cliente.getE_mail()+" | "+cliente.getDni());

    }
    public void chbxActivado(ActionEvent actionEvent) {
        ModificacionesBBDD modificacion = new ModificacionesBBDD();
        if(!chbxActivo.isSelected()){
            modificacion.desactivarCliente();
        }
    }

    public void mostrarInfoCliente(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_infoEmpleado_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

}
