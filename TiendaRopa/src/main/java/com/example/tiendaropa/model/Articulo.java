package com.example.tiendaropa.model;

public abstract class Articulo {

    //ATRIBUTOS
    private int codArt;
    private String nombre;
    private int precio;
    private String marca;
    private String descripcion;
    private boolean activo;
    private String imagen;
    private int material;


    //CONSTRUCTOR

    public Articulo(int codArt, String nombre, int precio, String marca, String descripcion, boolean activo, String imagen, int material) {
        this.codArt = codArt;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.descripcion = descripcion;
        this.activo = activo;
        this.imagen = imagen;
        this.material = material;
    }


    //GET Y SET

    public int getCodArt() {
        return codArt;
    }

    public void setCodArt(int codArt) {
        this.codArt = codArt;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }


    //METODOS

}
