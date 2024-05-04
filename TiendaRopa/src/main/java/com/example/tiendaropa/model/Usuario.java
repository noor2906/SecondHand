package com.example.tiendaropa.model;

public abstract class Usuario {
    protected String dni, nombre, apellidos, telefono, fNacimiento, e_mail, pass, direccion;
    protected boolean activo;

    public Usuario(String dni, String nombre, String apellidos, String telefono, String fNacimiento, String e_mail, String pass, boolean activo, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fNacimiento = fNacimiento;
        this.e_mail = e_mail;
        this.pass = pass;
        this.activo = activo;
        this.direccion = direccion;
    }
}
