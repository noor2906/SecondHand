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
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Controlador_itemCliente {
    @FXML
    private Button btnActivo;
    @FXML
    private Text txtCliente;
    private Cliente cliente;
    @FXML
    private Pane paneCliente;

    // Hecho por: Vero
    public void setData(Cliente clientes) throws FileNotFoundException {
        cliente = clientes;
        if (cliente.isActivo()==true){
            btnActivo.setText("✔");
            paneCliente.setStyle("-fx-background-color: #E6F5F2;");
        }else {
            btnActivo.setText("✗");
            paneCliente.setStyle("-fx-background-color: #D0B0A5;");
        }

        txtCliente.setText(cliente.getE_mail()+" | "+cliente.getDni());
    }
    // Hecho por: Vero
    public void activarYDesactivarCliente(MouseEvent actionEvent) { // Para habilitar y deshabilitar clientes
        ModificacionesBBDD modificacion = new ModificacionesBBDD(); // hace el update en BBDD
        int habilitado;
         habilitado=modificacion.deshabilitarYHabilitarUsuario(cliente); //Recoge el resultado(int) del update
         switch (habilitado){
             case 0://Si el resultado es 0 se ha deshabilitado el cliente
                 cliente.setActivo(false); //cambia el atributo activo a false del objeto cliente
                 btnActivo.setText("✗"); // cambia el texto del boton
                 paneCliente.setStyle("-fx-background-color: #D0B0A5;");
                 break;
             case 1://Si el resultado es 1 se ha habilitado el cliente
                 cliente.setActivo(true);
                 btnActivo.setText("✔");
                 paneCliente.setStyle("-fx-background-color: #E6F5F2;");
                 break;
             case -1://Si el resultado es -1 el update ha dado error.
                 System.out.println("No se ha podido hacer la modificación");
         }
    }
    // Hecho por: Vero
    public void mostrarInfoCliente(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_edicionUsuario_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

}
