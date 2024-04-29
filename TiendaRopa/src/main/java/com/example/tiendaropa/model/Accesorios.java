package com.example.tiendaropa.model;
import java.util.List;

public class Accesorios extends Articulo {

    //ATRIBUTOS
    protected String estilo;
    protected String tipo;
    protected boolean personalizado;


    //CONSTRUCTOR
    public Accesorios(int codigo, String nombre, int precio, String marca, String descripcion, List<Material> materiales, String estilo, String tipo, boolean personalizado) {
        super(codigo, nombre, precio, marca, descripcion, materiales);
        this.estilo = estilo;
        this.tipo = tipo;
        this.personalizado = personalizado;
    }


    //GET Y SET
    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isPersonalizado() {
        return personalizado;
    }

    public void setPersonalizado(boolean personalizado) {
        this.personalizado = personalizado;
    }

    //METODOS

}
