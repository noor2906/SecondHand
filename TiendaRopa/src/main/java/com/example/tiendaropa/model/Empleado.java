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

    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public String getDni() {
        return super.getDni();
    }

    @Override
    public void setDni(String dni) {
        super.setDni(dni);
    }

    @Override
    public String getApellidos() {
        return super.getApellidos();
    }

    @Override
    public void setApellidos(String apellidos) {
        super.setApellidos(apellidos);
    }

    @Override
    public String getTelefono() {
        return super.getTelefono();
    }

    @Override
    public void setTelefono(String telefono) {
        super.setTelefono(telefono);
    }

    @Override
    public String getfNacimiento() {
        return super.getfNacimiento();
    }

    @Override
    public void setfNacimiento(String fNacimiento) {
        super.setfNacimiento(fNacimiento);
    }

    @Override
    public String getE_mail() {
        return super.getE_mail();
    }

    @Override
    public void setE_mail(String e_mail) {
        super.setE_mail(e_mail);
    }

    @Override
    public String getPass() {
        return super.getPass();
    }

    @Override
    public void setPass(String pass) {
        super.setPass(pass);
    }

    @Override
    public String getDireccion() {
        return super.getDireccion();
    }

    @Override
    public void setDireccion(String direccion) {
        super.setDireccion(direccion);
    }

    @Override
    public boolean isActivo() {
        return super.isActivo();
    }

    @Override
    public void setActivo(boolean activo) {
        super.setActivo(activo);
    }

    public int contarApellidos() {
        if (apellidos == null || apellidos.trim().isEmpty()) {
            return 0;
        }
        return apellidos.trim().split("\\s+").length;
    }

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
