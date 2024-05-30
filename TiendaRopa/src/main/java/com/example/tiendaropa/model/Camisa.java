package com.example.tiendaropa.model;


public class Camisa extends Ropa{
    // Creada por: Carol y editada por: Noor

    //ATRIBUTOS
    private String tipoManga;
    private boolean estampada;


    //CONSTRUCTOR

    public Camisa(int codigo, String nombre, float precio, String marca, String descripcion, boolean activo, String imagen, Material material, String talla, String color, String tipoCierre, String tipoRopa, String tipoManga, boolean estampada) {
        super(codigo, nombre, precio, marca, descripcion, activo, imagen, material, talla, color, tipoCierre, tipoRopa);
        this.tipoManga = tipoManga;
        this.estampada = estampada;
    }

    public Camisa(int codigo, String nombre, float precio, String marca, String descripcion, boolean activo, String imagen, Material material, String talla, String color, String tipoCierre, String tipoRopa){
        super(codigo, nombre, precio, marca, descripcion, activo, imagen, material, talla, color, tipoCierre, tipoRopa);
    }

    //GETTER Y SETTER

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


    //METODOS
}
