package com.example.tiendaropa;

import com.example.tiendaropa.model.Cliente;
import com.example.tiendaropa.model.Empleado;
import com.example.tiendaropa.model.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Controlador_carrito {





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
}
