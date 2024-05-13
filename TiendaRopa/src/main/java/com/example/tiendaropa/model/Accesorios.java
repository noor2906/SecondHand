package com.example.tiendaropa.model;

public class Accesorios extends Articulo {

    //ATRIBUTOS
    protected String estilo;
    protected boolean personalizado;

    protected String tipoAccesorio;

    //Atributos bolso
    private int capacidad;
    private String tipoCierre;

    //Atributo zapatos
    private int talla;
    private String tipoSuela;


    //CONSTRUCTOR

    public Accesorios(int codigo, String nombre, float precio, String marca, String descripcion, boolean activo,
                      String imagen, Material material, String estilo, boolean personalizado, String tipo_cierre,
                      int capacidad, int talla, String tipo_suela, String tipoAccesorio) {
        super(codigo, nombre, precio, marca, descripcion, activo, imagen, material);
        this.estilo = estilo;
        this.personalizado = personalizado;
        this.tipoCierre = tipo_cierre;
        this.capacidad = capacidad;
        this.tipoSuela = tipo_suela;
        this.talla = talla;
        this.tipoAccesorio = tipoAccesorio;
    }


    //GET Y SET
    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public boolean isPersonalizado() {
        return personalizado;
    }

    public void setPersonalizado(boolean personalizado) {
        this.personalizado = personalizado;
    }

    public String getTipoAccesorio() {
        return tipoAccesorio;
    }

    public void setTipoAccesorio(String tipoAccesorio) {
        this.tipoAccesorio = tipoAccesorio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }

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


    //METODOS

}