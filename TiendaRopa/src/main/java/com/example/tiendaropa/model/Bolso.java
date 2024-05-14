package com.example.tiendaropa.model;
import java.util.List;

public class Bolso extends Accesorios {

    //Atributos bolso
    private int capacidad;
    private String tipoCierre;

    //CONSTRUCTOR

    public Bolso(int codigo, String nombre, float precio, String marca, String descripcion, boolean activo, String imagen, Material material, String estilo, boolean personalizado, String tipoAccesorio, int capacidad, String tipoCierre) {
        super(codigo, nombre, precio, marca, descripcion, activo, imagen, material, estilo, personalizado, tipoAccesorio);
        this.capacidad = capacidad;
        this.tipoCierre = tipoCierre;
    }


    //Getters y setters
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

    //Métodos

    @Override
    public String toString() {
        return "Bolso{" +
                "capacidad=" + capacidad +
                ", tipoCierre='" + tipoCierre + '\'' +
                '}';
    }
}

