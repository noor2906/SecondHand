package com.example.tiendaropa.model;
import java.util.List;

public class Chaqueta extends Ropa {

    //CONSTRUCTOR
    public Chaqueta(int codigo, String nombre, float precio, String marca, String descripcion, boolean activo, String imagen, Material material, String talla, String color, String tipoCierre, boolean impermeable, String tipoManga, boolean estampada, String tipoPantalon, boolean tieneBolsillos, String tipoRopa) {
        super(codigo, nombre, precio, marca, descripcion, activo, imagen, material, talla, color, tipoCierre, impermeable, tipoManga, estampada, tipoPantalon, tieneBolsillos, tipoRopa);
    }
}