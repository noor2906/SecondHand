package com.example.tiendaropa.model;
import java.util.List;

public class Zapatos extends Accesorios {

    //CONSTRUCTOR

    public Zapatos(int codigo, String nombre, float precio, String marca, String descripcion, boolean activo, String imagen, String material, String estilo, boolean personalizado, String tipo_cierre, int capacidad, int talla, String tipo_suela, String tipoAccesorio) {
        super(codigo, nombre, precio, marca, descripcion, activo, imagen, material, estilo, personalizado, tipo_cierre, capacidad, talla, tipo_suela, tipoAccesorio);
    }
}
