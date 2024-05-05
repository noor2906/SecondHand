package com.example.tiendaropa.model;

public class Ropa extends Articulo {

    //ATRIBUTOS
    protected String talla;
    protected String color;
    protected String tipoCierre;
    protected boolean impermeable;
    protected String tipoManga;
    protected boolean estampada;
    protected String tipoPantalon;
    protected boolean tieneBolsillos;
    protected String tipoRopa; //se puede hacer un instanceOf en vez de este atributo


    //CONSTRUCTOR

    public Ropa(int codigo, String nombre, float precio, String marca, String descripcion, boolean activo, String imagen,
                String material, String talla, String color, String tipoCierre, boolean impermeable, String tipoManga,
                boolean estampada, String tipoPantalon, boolean tieneBolsillos, String tipoRopa) {
        super(codigo, nombre, precio, marca, descripcion, activo, imagen, material);
        this.talla = talla;
        this.color = color;
        this.tipoCierre = tipoCierre;
        this.impermeable = impermeable;
        this.tipoManga = tipoManga;
        this.estampada = estampada;
        this.tipoPantalon = tipoPantalon;
        this.tieneBolsillos = tieneBolsillos;
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

    public boolean isImpermeable() {
        return impermeable;
    }

    public void setImpermeable(boolean impermeable) {
        this.impermeable = impermeable;
    }

    public String getTipoManga() {
        return tipoManga;
    }

    public void setTipoManga(String tipoManga) {
        this.tipoManga = tipoManga;
    }

    public boolean isEstampada() {
        return estampada;
    }

    public void setEstampada(boolean estampada) {
        this.estampada = estampada;
    }

    public String getTipoPantalon() {
        return tipoPantalon;
    }

    public void setTipoPantalon(String tipoPantalon) {
        this.tipoPantalon = tipoPantalon;
    }

    public boolean isTieneBolsillos() {
        return tieneBolsillos;
    }

    public void setTieneBolsillos(boolean tieneBolsillos) {
        this.tieneBolsillos = tieneBolsillos;
    }

    public String getTipoRopa() {
        return tipoRopa;
    }

    public void setTipoRopa(String tipoRopa) {
        this.tipoRopa = tipoRopa;
    }

//METODOS

}
