package com.example.tiendaropa.model;
import java.util.List;

public class Chaqueta extends Ropa {

    //ATRIBUTOS
    private boolean impermeable;

    //CONSTRUCTOR
    public Chaqueta(int codigo, String nombre, int precio, String marca, String descripcion, List<Material> materiales, String talla, String color, String tipoCierre, boolean impermeable) {
        super(codigo, nombre, precio, marca, descripcion, materiales, talla, color, tipoCierre);
        this.impermeable = impermeable;
    }

    //GET Y SET
    public boolean isImpermeable() {
        return impermeable;
    }

    public void setImpermeable(boolean impermeable) {
        this.impermeable = impermeable;
    }

//METODOS

}