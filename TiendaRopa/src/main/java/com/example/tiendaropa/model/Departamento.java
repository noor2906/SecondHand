package com.example.tiendaropa.model;

import java.util.List;

public class Departamento {
    //Atributos
    private String codigo;
    private String nombre;
    private static List<Administrador> listaAdministradores;


    //Constructor
    public Departamento(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    //Getters y setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static List<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    //Métodos
    public static void anyadirAdministrador(Administrador admin){
        listaAdministradores.add(admin);
    }

}
