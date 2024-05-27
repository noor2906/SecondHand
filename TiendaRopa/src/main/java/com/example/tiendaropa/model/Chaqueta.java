package com.example.tiendaropa.model;
import java.util.List;

public class Chaqueta extends Ropa {
    // Creada por: Carol y editada por: Noor
    protected boolean impermeable;

    //CONSTRUCTOR

    public Chaqueta(int codigo, String nombre, float precio, String marca, String descripcion, boolean activo, String imagen, Material material, String talla, String color, String tipoCierre, String tipoRopa, boolean impermeable) {
        super(codigo, nombre, precio, marca, descripcion, activo, imagen, material, talla, color, tipoCierre, tipoRopa);
        this.impermeable = impermeable;
    }

    //GETTER Y SETTER

    public boolean isImpermeable() {
        return impermeable;
    }

    public void setImpermeable(boolean impermeable) {
        this.impermeable = impermeable;
    }
}