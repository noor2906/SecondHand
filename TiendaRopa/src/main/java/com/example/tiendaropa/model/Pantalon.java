package com.example.tiendaropa.model;
import java.util.List;

public class Pantalon extends Ropa {

    //ATRIBUTOS
    private String tipo_pantalon;
    private boolean tieneBolsillos;

    //CONSTRUCTOR
    public Pantalon(int codigo, String nombre, int precio, String marca, String descripcion, List<Material> materiales, String talla, String color, String tipoCierre, String tipo_pantalon, boolean tieneBolsillos) {
        super(codigo, nombre, precio, marca, descripcion, materiales, talla, color, tipoCierre);
        this.tipo_pantalon = tipo_pantalon;
        this.tieneBolsillos = tieneBolsillos;
    }

    //GET Y SET
    public String getTipo_pantalon() {
        return tipo_pantalon;
    }

    public void setTipo_pantalon(String tipo_pantalon) {
        this.tipo_pantalon = tipo_pantalon;
    }

    public boolean isTieneBolsillos() {
        return tieneBolsillos;
    }

    public void setTieneBolsillos(boolean tieneBolsillos) {
        this.tieneBolsillos = tieneBolsillos;
    }

    //METODOS

}
