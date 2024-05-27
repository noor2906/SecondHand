package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.InsercionesBBDD;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Controlador_itemAltaCamisa {
    @FXML
    private Button btnClear1;

    @FXML
    private Button btnClear2;

    @FXML
    private Button btnClear3;

    @FXML
    private Button btnClear4;

    @FXML
    private CheckBox chBoxEstampadaAltaProducto;

    @FXML
    private TextField txtfColorAltaProducto, txtfTallaAltaProducto, txtfTipoCierreAltaProducto, txtfTipoMangaAltaProducto;

    public void setData(){

        //Propiedades articulo
        String talla = txtfTallaAltaProducto.getText();
        String color = txtfColorAltaProducto.getText();
        String tipoCierre = txtfTipoCierreAltaProducto.getText();
        String tipoManga = txtfTipoMangaAltaProducto.getText();
        boolean estampada = true;

       /* if (chBoxEstampadaAltaProducto.isSelected()){
            estampada = true;
        }else{
            estampada = false;
        }*/

        InsercionesBBDD.insercionCamisa(talla,color,tipoCierre,tipoManga,estampada);

    }
}
