package com.example.tiendaropa.model;
import java.util.List;

public class Accesorios extends Articulo {

    //ATRIBUTOS
    protected String estilo;
    protected boolean personalizado;

    //Atributos bolso
    private int capacidad;
    private String tipo_cierre;

    //Atributo zapatos
    private int talla;
    private String tipo_suela;


    //CONSTRUCTOR

    public Accesorios(int codArt, String nombre, int precio, String marca, String descripcion, boolean activo, String imagen, int material, String estilo, boolean personalizado, int capacidad, String tipo_cierre, int talla, String tipo_suela) {
        super(codArt, nombre, precio, marca, descripcion, activo, imagen, material);
        this.estilo = estilo;
        this.personalizado = personalizado;
        this.capacidad = capacidad;
        this.tipo_cierre = tipo_cierre;
        this.talla = talla;
        this.tipo_suela = tipo_suela;
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

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo_cierre() {
        return tipo_cierre;
    }

    public void setTipo_cierre(String tipo_cierre) {
        this.tipo_cierre = tipo_cierre;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getTipo_suela() {
        return tipo_suela;
    }

    public void setTipo_suela(String tipo_suela) {
        this.tipo_suela = tipo_suela;
    }


    //METODOS

}
