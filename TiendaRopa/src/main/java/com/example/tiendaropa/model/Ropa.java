package com.example.tiendaropa.model;

import java.util.List;

public class Ropa extends Articulo {

    //ATRIBUTOS
    protected String talla;
    protected String color;
    protected String tipoCierre;


    //CONSTRUCTOR
    public Ropa(int codigo, String nombre, int precio, String marca, String descripcion, List<Material> materiales, String talla, String color, String tipoCierre) {
        super(codigo, nombre, precio, marca, descripcion, materiales);
        this.talla = talla;
        this.color = color;
        this.tipoCierre = tipoCierre;
    }

    //GET Y SET

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }


    //METODOS

}
