package com.example.tiendaropa.model;
import java.util.List;

public class Pantalon extends Ropa {
    protected String tipoPantalon;
    protected boolean tieneBolsillos;


    //CONSTRUCTOR

    public Pantalon(int codigo, String nombre, float precio, String marca, String descripcion, boolean activo, String imagen, Material material, String talla, String color, String tipoCierre, String tipoRopa, String tipoPantalon, boolean tieneBolsillos) {
        super(codigo, nombre, precio, marca, descripcion, activo, imagen, material, talla, color, tipoCierre, tipoRopa);
        this.tipoPantalon = tipoPantalon;
        this.tieneBolsillos = tieneBolsillos;
    }

    //GETTER Y SETTER

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
}
