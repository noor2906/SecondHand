package com.example.tiendaropa.model;

public class Ropa extends Articulo {

    //ATRIBUTOS
    protected String talla;
    protected String color;
    protected String tipoCierre;

    protected String tipoRopa; //se puede hacer un instanceOf en vez de este atributo


    //CONSTRUCTOR

    public Ropa(int codigo, String nombre, float precio, String marca, String descripcion, boolean activo, String imagen,
                Material material, String talla, String color, String tipoCierre, String tipoRopa) {
        super(codigo, nombre, precio, marca, descripcion, activo, imagen, material);
        this.talla = talla;
        this.color = color;
        this.tipoCierre = tipoCierre;
        this.tipoRopa = tipoRopa;
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

    public String getTipoRopa() {
        return tipoRopa;
    }

    public void setTipoRopa(String tipoRopa) {
        this.tipoRopa = tipoRopa;
    }


//METODOS

}
