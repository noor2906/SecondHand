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
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controlador_ItemEmpleado {

    @FXML
    private TextField txtEmpleadoItem;

    @FXML
    private Button btnEditarEmpleado;

    @FXML
    private CheckBox chbxDesabilitarEmpleado;

    Empleado empleado;

    public void setData(Empleado empleado) throws FileNotFoundException {

        this.empleado = empleado;

        txtEmpleadoItem.setText(empleado.getNombre());

    }

    public void mostrarInfoEmpleado(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("FXML_infoEmpleado_Carol.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
}
