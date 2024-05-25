package com.example.tiendaropa.model;

import com.example.tiendaropa.Conexiones.ConsultasBBDD;

import java.sql.SQLException;
import java.util.HashMap;


public class Material {
    //Atributos
    private int codigo;
    private String nombre;
    private static HashMap<Integer, Material> mapaMateriales = new HashMap<Integer, Material>();


    //Constructor
    public Material(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    //Getter y setter
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

    public static HashMap<Integer, Material> getMapaMateriales() {
        return mapaMateriales;
    }

    public static void setMapaMateriales(HashMap<Integer, Material> mapaMateriales) {
        Material.mapaMateriales = mapaMateriales;
    }

    //Método donde se rellena el mapa mediante una consulta
    public static void rellenarMapaMateriales() throws SQLException {
        ConsultasBBDD consulta = new ConsultasBBDD();
        mapaMateriales =consulta.crearMateriales(mapaMateriales);
    }


    public static Material seleccionarMaterial(int id){
        return mapaMateriales.get(id);
    }

    //No quitar, ayuda a mostrar el material en la ficha_Producto
    @Override
    public String toString() {
        return this.nombre;
    }

    public static void recorrerMapaMateriales(){
        for (Integer k:mapaMateriales.keySet()) {
            System.out.println(mapaMateriales.get(k).getNombre());
        }
    }
}
