package com.example.tiendaropa.model;

public class Accesorios extends Articulo {
    // Creada por: Carol y editada por: Noor

    //ATRIBUTOS
    protected String estilo;
    protected boolean personalizado;

    protected String tipoAccesorio;


    //CONSTRUCTOR
    public Accesorios(int codigo, String nombre, float precio, String marca, String descripcion, boolean activo, String imagen, Material material, String estilo, boolean personalizado, String tipoAccesorio) {
        super(codigo, nombre, precio, marca, descripcion, activo, imagen, material);
        this.estilo = estilo;
        this.personalizado = personalizado;
        this.tipoAccesorio = tipoAccesorio;
    }

    //GETTERS Y SETTERS


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

    //METODOS
    @Override
    public String toString() {
        return "Accesorios{" +
                "estilo='" + estilo + '\'' +
                ", personalizado=" + personalizado +
                ", tipoAccesorio='" + tipoAccesorio + '\'' +
                '}';
    }
}