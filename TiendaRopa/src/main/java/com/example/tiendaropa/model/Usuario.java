package com.example.tiendaropa.model;

public abstract class Usuario {
    protected String dni, nombre, apellidos, telefono, f_nacimiento, e_mail;

    public Usuario(String dni, String nombre, String apellidos, String telefono, String f_nacimiento, String e_mail) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.f_nacimiento = f_nacimiento;
        this.e_mail = e_mail;
    }
}
