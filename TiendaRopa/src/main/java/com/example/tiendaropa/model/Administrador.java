package com.example.tiendaropa.model;

public class Administrador extends Usuario{
    //Atributos
    private String rol;
    private boolean tienePrivilegios;
    private int nivelAcceso;

    //Constructor
    public Administrador(String dni, String nombre, String apellidos, String telefono, String f_nacimiento, String e_mail, String rol, boolean tiene_privilegios, int nivel_acceso) {
        super(dni, nombre, apellidos, telefono, f_nacimiento, e_mail);
        this.rol = rol;
        this.tienePrivilegios = tiene_privilegios;
        this.nivelAcceso = nivel_acceso;
    }
    //Getters y Setters

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isTienePrivilegios() {
        return tienePrivilegios;
    }

    public void setTienePrivilegios(boolean tienePrivilegios) {
        this.tienePrivilegios = tienePrivilegios;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }
}
