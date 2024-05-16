package com.example.tiendaropa;

import com.example.tiendaropa.model.Articulo;
import com.example.tiendaropa.model.Empleado;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controlador_ItemEmpleado {

    @FXML
    private Text txtEmpleadoItem;

    @FXML
    private Button btnEditarEmpleado;

    @FXML
    private CheckBox chbxDesabilitarEmpleado;

    Empleado empleado;

    //Cargamos la informacion del empleado

    public void setData(Empleado empleado) throws FileNotFoundException {

        this.empleado = empleado;

        txtEmpleadoItem.setText(empleado.getNombre());

    }

    //Añadimos infromacion al boton de editar empleado, haciendo que dirija y carge la informacion correspondiente al empleado en el que clicamos.

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
