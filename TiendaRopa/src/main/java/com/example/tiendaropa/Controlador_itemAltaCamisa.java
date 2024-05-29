package com.example.tiendaropa;

import com.example.tiendaropa.Conexiones.InsercionesBBDD;
import com.example.tiendaropa.model.Articulo;
import com.example.tiendaropa.model.Camisa;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Controlador_itemAltaCamisa {
    @FXML
    private Button btnClear1, btnClear2, btnClear3, btnClear4;

    @FXML
    private CheckBox chBoxEstampadaAltaProducto;

    @FXML
    private TextField txtfColorAltaProducto, txtfTallaAltaProducto, txtfTipoCierreAltaProducto, txtfTipoMangaAltaProducto;

//    Articulo articulo = new Camisa();

    private String talla;
    private String color;

    Controlador_itemAltaCamisa itemAltaCamisa;

    //se podría hacer así
    public Controlador_itemAltaCamisa getItemAltaCamisa() {
        return itemAltaCamisa;
    }

    public void setData(){

        //Propiedades articulo
        this.talla = txtfTallaAltaProducto.getText();
        this.color = txtfColorAltaProducto.getText();
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
