package com.example.tiendaropa.model;
import java.util.List;

public abstract class Articulo {

    //ATRIBUTOS
    private int codigo;
    private String nombre;
    private int precio;
    private String marca;
    private String descripcion;
    private List<Material> materiales;


    //CONSTRUCTOR
    public Articulo(int codigo, String nombre, int precio, String marca, String descripcion, List<Material> materiales) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.descripcion = descripcion;
        this.materiales = materiales;
    }

    //GET Y SET
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }

    //toString

    @Override
    public String toString() {
        return "Articulo: " + "\n" +
                "- Código: [" + codigo + "] \n" +
                "- Nombre: '" + nombre + "' \n" +
                "- Precio: " + precio + " €" + "\n"+
                "- Marca: '" + marca + "' \n" +
                "- Descripcion: [" + descripcion +"] \n" +
                "- Materiales: " + materiales + "";
    }

    //METODOS

}
