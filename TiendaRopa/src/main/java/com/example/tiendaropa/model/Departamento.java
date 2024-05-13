package com.example.tiendaropa.model;

import com.example.tiendaropa.Conexiones.ConsultasBBDD;

import java.sql.SQLException;
import java.util.HashMap;

public class Departamento {
    //Atributos
    private int codigo;
    private String nombre;
    private static HashMap<Integer, Departamento> mapaDepartamentos = new HashMap<Integer, Departamento>();

    //Constructor
    public Departamento(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }


    //Getters y setters

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
    public static void rellenarMapaDpto() throws SQLException {
       ConsultasBBDD consulta = new ConsultasBBDD();
        mapaDepartamentos =consulta.crearDepartamentos(mapaDepartamentos);
    }
    public static Departamento seleccionarDpto(int id){
        return mapaDepartamentos.get(id);
    }

    //! BORRAR más adelante
    @Override
    public String toString() {
        return "Departamento{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
