package com.example.tiendaropa.model;


public class Camisa extends Ropa{

    //ATRIBUTOS
    private String tipoManga;
    private boolean estampada;


    //CONSTRUCTOR

    public Camisa(int codigo, String nombre, float precio, String marca, String descripcion, boolean activo, String imagen, String material, String talla, String color, String tipoCierre, boolean impermeable, String tipoManga, boolean estampada, String tipoPantalon, boolean tieneBolsillos, String tipoRopa, String tipoManga1, boolean estampada1) {
        super(codigo, nombre, precio, marca, descripcion, activo, imagen, material, talla, color, tipoCierre, impermeable, tipoManga, estampada, tipoPantalon, tieneBolsillos, tipoRopa);
        this.tipoManga = tipoManga1;
        this.estampada = estampada1;
    }


    //GETTER Y SETTER

    @Override
    public String getTipoManga() {
        return tipoManga;
    }

    @Override
    public void setTipoManga(String tipoManga) {
        this.tipoManga = tipoManga;
    }

    @Override
    public boolean isEstampada() {
        return estampada;
    }

    @Override
    public void setEstampada(boolean estampada) {
        this.estampada = estampada;
    }


    //METODOS
}
