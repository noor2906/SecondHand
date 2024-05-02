package com.example.tiendaropa.model;

import java.util.List;

public class Pedido {
    //Atributos
    private int numero;
    private String fecha;
    private String direccionEnvio;
    private String estado;
    private LineaPedido lineaPedido;
    private int cantidadArticulo;


    //Constructor

    public Pedido(int numero, String fecha, String direccionEnvio, String estado, LineaPedido lineaPedido, int cantidadArticulo) {
        this.numero = numero;
        this.fecha = fecha;
        this.direccionEnvio = direccionEnvio;
        this.estado = estado;
        this.lineaPedido = lineaPedido;
        this.cantidadArticulo = cantidadArticulo;
    }


    //Getters y setters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LineaPedido getLineaPedido() {
        return lineaPedido;
    }

    public void setLineaPedido(LineaPedido lineaPedido) {
        this.lineaPedido = lineaPedido;
    }

    public int getCantidadArticulo() {
        return cantidadArticulo;
    }

    public void setCantidadArticulo(int cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }
}
