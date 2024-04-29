package com.example.tiendaropa.model;
import java.util.List;

public class Bolso extends Accesorios {

    //ATRIBUTOS
    private int capacidad;
    private String tipo_cierre;

    //CONSTRUCTOR

    public Bolso(int codigo, String nombre, int precio, String marca, String descripcion, List<Material> materiales, String estilo, String tipo, boolean personalizado, int capacidad, String tipo_cierre) {
        super(codigo, nombre, precio, marca, descripcion, materiales, estilo, tipo, personalizado);
        this.capacidad = capacidad;
        this.tipo_cierre = tipo_cierre;
    }

    //GET Y SET

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

    //METODOS

}

