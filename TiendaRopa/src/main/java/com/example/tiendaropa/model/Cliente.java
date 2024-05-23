package com.example.tiendaropa.model;


public class Cliente extends Usuario{
    // Atributos
    private boolean tarjetaFidelizacion;
    private String dirEnvio;
    private float saldoCuenta;
    private int numPedidos;



    private MetodoPago metodoPago;

    // Constructor

    public Cliente(String dni, String nombre, String apellidos, String telefono, String f_nacimiento, String e_mail, String pass, boolean activo, String direccion, boolean tarjetaFidelizacion, float saldoCuenta, String dirEnvio, int numPedidos, MetodoPago metodoPago) {
        super(dni, nombre, apellidos, telefono, f_nacimiento, e_mail, pass, activo, direccion);
        this.tarjetaFidelizacion = tarjetaFidelizacion;
        this.saldoCuenta = saldoCuenta;
        this.dirEnvio = dirEnvio;
        this.numPedidos = numPedidos;
        this.metodoPago=metodoPago;
    }

    //Getters y setters
    public boolean isTarjetaFidelizacion() {
        return tarjetaFidelizacion;
    }

    public void setTarjetaFidelizacion(boolean tarjetaFidelizacion) {
        this.tarjetaFidelizacion = tarjetaFidelizacion;
    }

    public float getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(float saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
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
    public String getNombre(){
        return nombre;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "tarjetaFidelizacion=" + tarjetaFidelizacion +
                ", dirEnvio='" + dirEnvio + '\'' +
                ", saldoCuenta=" + saldoCuenta +
                ", numPedidos=" + numPedidos +
                ", metodoPago=" + metodoPago +
                '}';
    }
}
