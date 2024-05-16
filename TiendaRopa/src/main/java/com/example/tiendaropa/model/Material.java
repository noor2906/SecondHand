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

    //Método donde se rellena el mapa mediante una consulta
    public static void rellenarMapaMateriales() throws SQLException {
        ConsultasBBDD consulta = new ConsultasBBDD();
        mapaMateriales =consulta.crearMateriales(mapaMateriales);
    }


    public static Material seleccionarMaterial(int id){
        return mapaMateriales.get(id);
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
