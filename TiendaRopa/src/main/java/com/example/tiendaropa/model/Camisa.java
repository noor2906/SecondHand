package com.example.tiendaropa.model;
import java.util.List;

public class Camisa extends Ropa {

    //ATRIBUTOS
    private String tipo_manga;
    private boolean estampada;

    //CONSTRUCTOR
    public Camisa(int codigo, String nombre, int precio, String marca, String descripcion, List<Material> materiales, String talla, String color, String tipoCierre, String tipo_manga, boolean estampada) {
        super(codigo, nombre, precio, marca, descripcion, materiales, talla, color, tipoCierre);
        this.tipo_manga = tipo_manga;
        this.estampada = estampada;
    }

    //GET Y SET
    public String getTipo_manga() {
        return tipo_manga;
    }

    public void setTipo_manga(String tipo_manga) {
        this.tipo_manga = tipo_manga;
    }

    public boolean isEstampada() {
        return estampada;
    }

    public void setEstampada(boolean estampada) {
        this.estampada = estampada;
    }

    //METODOS

}
