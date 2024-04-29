package com.example.tiendaropa.model;


public class Cliente extends Usuario{
    // Atributos
    private boolean tarjetaFidelizacion;
    private String cuenta, dirEnvio;
    private int numPedidos;
    private MetodoPago metodoPago;

    // Constructor
    public Cliente(String dni, String nombre, String apellidos, String telefono, String f_nacimiento, String e_mail, boolean tarjeta_fidelizacion, String cuenta, String dir_envio, int num_pedidos, MetodoPago metodoPago) {
        super(dni, nombre, apellidos, telefono, f_nacimiento, e_mail);
        this.tarjetaFidelizacion = tarjeta_fidelizacion;
        this.cuenta = cuenta;
        this.dirEnvio = dir_envio;
        this.numPedidos = num_pedidos;
        this.metodoPago = metodoPago;
    }

    // Getters y Setters
    public boolean isTarjetaFidelizacion() {
        return tarjetaFidelizacion;
    }

    public void setTarjetaFidelizacion(boolean tarjetaFidelizacion) {
        this.tarjetaFidelizacion = tarjetaFidelizacion;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getDirEnvio() {
        return dirEnvio;
    }

    public void setDirEnvio(String dirEnvio) {
        this.dirEnvio = dirEnvio;
    }

    public int getNumPedidos() {
        return numPedidos;
    }

    public void setNumPedidos(int numPedidos) {
        this.numPedidos = numPedidos;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}
