package com.example.tiendaropa.model;

public class Empleado extends Usuario{
    //Atributos
    private boolean tienePrivilegios;
    private Departamento departamento;

    //Constructor

    public Empleado(String dni, String nombre, String apellidos, String telefono, String fNacimiento, String e_mail, String pass, boolean activo, String direccion, boolean tienePrivilegios, Departamento departamento) {
        super(dni, nombre, apellidos, telefono, fNacimiento, e_mail, pass, activo, direccion);
        this.tienePrivilegios = tienePrivilegios;
        this.departamento = departamento;
    }

    //Getters y Setters
    public boolean isTienePrivilegios() {
        return tienePrivilegios;
    }

    public void setTienePrivilegios(boolean tienePrivilegios) {
        this.tienePrivilegios = tienePrivilegios;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    //! BORRAR más adelante
    @Override
    public String toString() {
        return "Empleado{" +
                "tienePrivilegios=" + tienePrivilegios +
                ", departamento=" + departamento +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fNacimiento='" + fNacimiento + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", pass='" + pass + '\'' +
                ", direccion='" + direccion + '\'' +
                ", activo=" + activo +
                '}';
    }
}
