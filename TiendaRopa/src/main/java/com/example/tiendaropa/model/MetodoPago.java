package com.example.tiendaropa.model;

import com.example.tiendaropa.Conexiones.ConsultasBBDD;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.HashMap;

public class MetodoPago {

    //Atributos
    private int codigo;
    private String descripcion;
    private static HashMap<Integer, MetodoPago> mapaMetodoPago = new HashMap<Integer, MetodoPago>();


    //Constructor
    public MetodoPago(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    //Getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static HashMap<Integer, MetodoPago> getMapaMetodoPago() {
        return mapaMetodoPago;
    }

    public static void setMapaMetodoPago(HashMap<Integer, MetodoPago> mapaMetodoPago) {
        MetodoPago.mapaMetodoPago = mapaMetodoPago;
    }

    //* Otros
    public static void rellenarMapaMetodoPago() throws SQLException {
        ConsultasBBDD consulta = new ConsultasBBDD();
        mapaMetodoPago =consulta.crearMetodosPago(mapaMetodoPago);
    }
    public static MetodoPago seleccionarMetodoPago(int id){
        return mapaMetodoPago.get(id);
    }
    //! Borrar más tarde
    @Override
    public String toString() {
        return "MetodoPago{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
    public static void recorrerMapa(){
        for (Integer k:mapaMetodoPago.keySet()) {
            System.out.println(mapaMetodoPago.get(k).getDescripcion());
        }
    }
}
