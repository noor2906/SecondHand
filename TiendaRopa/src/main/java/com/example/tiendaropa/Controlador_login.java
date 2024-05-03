package com.example.tiendaropa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Controlador_login {
  private ConexionBBDD conn = new ConexionBBDD();
    @FXML
    private TextField txtContraLogin;
    @FXML
    private TextField txtDatoLogin;

    public void login(ActionEvent actionEvent) {
        Alert a = new Alert(Alert.AlertType.NONE);
        boolean ok;
        String user = txtDatoLogin.getText();
        String pass = txtContraLogin.getText();
        conn.conectar();
        conn.crearSentencia();
        ok=conn.login(user,pass);
        conn.desconectar();
        if (ok){
            mostrarHome(actionEvent);
        }else {
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setHeaderText(null);
            a.setContentText("El usuario no existe :(");
            a.show();
        }
    }
      public void mostrarHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML_home_Noor.fxml")));

        stage.setScene(new Scene(root));
        stage.show();
    }
    public void mostrarRegistro(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML_registroUsuario_Carol.fxml")));

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void limpiarUser(ActionEvent actionEvent) {
        txtDatoLogin.clear();
    }

    public void limpiarContra(ActionEvent actionEvent) {
        txtContraLogin.clear();
    }
}
