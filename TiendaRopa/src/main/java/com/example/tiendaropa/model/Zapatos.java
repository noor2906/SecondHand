package com.example.tiendaropa.model;
import java.util.List;

public class Zapatos extends Accesorios {

    //Atributo zapatos
    private int talla;
    private String tipoSuela;

    //CONSTRUCTOR

    public Zapatos(int codigo, String nombre, float precio, String marca, String descripcion, boolean activo, String imagen, Material material, String estilo, boolean personalizado, String tipoAccesorio, int talla, String tipoSuela) {
        super(codigo, nombre, precio, marca, descripcion, activo, imagen, material, estilo, personalizado, tipoAccesorio);
        this.talla = talla;
        this.tipoSuela = tipoSuela;
    }


    //Getters y setters

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getTipoSuela() {
        return tipoSuela;
    }

    public void setTipoSuela(String tipoSuela) {
        this.tipoSuela = tipoSuela;
    }
}
