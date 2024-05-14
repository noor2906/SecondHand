package com.example.tiendaropa.model;

public abstract class Articulo {

    //ATRIBUTOS
    private int codigo;
    private String nombre;
    private float precio;
    private String marca;
    private String descripcion;
    private boolean activo;
    private String imagen;
    private Material material;



    //CONSTRUCTORES ----------------------------------------------------------------------------------------------------

    public Articulo(){};


    public Articulo(int codigo, String nombre, float precio, String marca, String descripcion, boolean activo,
                    String imagen, Material material) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.descripcion = descripcion;
        this.activo = activo;
        this.imagen = imagen;
        this.material = material;
    }



    //GETTERS Y SETTERS ------------------------------------------------------------------------------------------------

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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
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

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }


    //Metodos

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", marca='" + marca + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", activo=" + activo +
                ", imagen='" + imagen + '\'' +
                ", material=" + material +
                '}';
    }
}
