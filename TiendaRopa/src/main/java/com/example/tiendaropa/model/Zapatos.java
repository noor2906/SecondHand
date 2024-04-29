package com.example.tiendaropa.model;
import java.util.List;

public class Zapatos extends Accesorios {

    //ATRIBUTOS
    private int talla;
    private String tipo_suela;

    //CONSTRUCTOR

    public Zapatos(int codigo, String nombre, int precio, String marca, String descripcion, List<Material> materiales, String estilo, String tipo, boolean personalizado, int talla, String tipo_suela) {
        super(codigo, nombre, precio, marca, descripcion, materiales, estilo, tipo, personalizado);
        this.talla = talla;
        this.tipo_suela = tipo_suela;
    }

    //GET Y SET

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
