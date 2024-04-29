package com.example.tiendaropa.model;

public class Material {

    //ATRIBUTOS
    private int cod_material;
    private String denominacion;


    //CONSTRUCTOR
    public Material(int cod_material, String denominacion) {
        this.cod_material = cod_material;
        this.denominacion = denominacion;
    }


    //GET Y SET
    public int getCod_material() {
        return cod_material;
    }

    public void setCod_material(int cod_material) {
        this.cod_material = cod_material;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    //METODOS
}
