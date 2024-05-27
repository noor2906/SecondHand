package com.example.tiendaropa;

import com.example.tiendaropa.model.Empleado;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Controlador_ItemEmpleado {

    @FXML
    private Text txtEmpleadoItem;

    @FXML
    private Button btnEditarEmpleado;

    @FXML
    private CheckBox chbxDesabilitarEmpleado;

    @FXML
    private Pane pnEmpleado;

    @FXML
    private HBox hboxBotones;

    @FXML
    private HBox hboxCheckBox;

    private Empleado empleado;

    private Controlador_login controladorLogin;
    // Hecho por: Carol
    @FXML
    public void initialize() {
        chbxDesabilitarEmpleado.selectedProperty().addListener((observable, habilitado, deshabilitado) -> {
            if (deshabilitado) {
                btnEditarEmpleado.setDisable(true);
                pnEmpleado.setStyle("-fx-background-color: #D0B0A5;");
                hboxCheckBox.setStyle("-fx-background-color: #D0B0A5;");
                hboxBotones.setStyle("-fx-background-color: #D0B0A5;");
            } else {
                btnEditarEmpleado.setDisable(false);
                pnEmpleado.setStyle("-fx-background-color: #E6F5F2;");
                hboxCheckBox.setStyle("-fx-background-color: #E6F5F2;");
                hboxBotones.setStyle("-fx-background-color: #E6F5F2;");
            }
        });
    }

    // Hecho por: Carol
    public void setData(Empleado empleado) throws FileNotFoundException {
        this.empleado = empleado;
        txtEmpleadoItem.setText(empleado.getNombre() + " " + empleado.getApellidos());
    }

    //Añadimos infromacion al boton de editar empleado, haciendo que dirija y carge la informacion correspondiente al empleado en el que clicamos.
    // Hecho por: Carol
    public void mostrarInfoEmpleado(MouseEvent event) {
        try {
            // Load the target scene FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_infoEmpleadoEditable_Carol.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Usando el evento para obtener la ventana actual
            Controlador_infoEmpleadoEditable productoController = loader.getController();
            productoController.cargarEmpleado(this.empleado);

            // Set the scene for the stage
            stage.setScene(new Scene(root));

            // Show the target scene
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
