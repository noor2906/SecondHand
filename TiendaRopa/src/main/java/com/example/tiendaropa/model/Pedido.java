package com.example.tiendaropa.model;

import java.time.LocalDate;

public class Pedido {
    //Atributos
    private  int numero;
    private  String fecha;
    private  String direccionEnvio;
    private  String estado;



    //Constructor

    public Pedido() {
        this.numero = numero;
        this.fecha = fecha;
        this.direccionEnvio = direccionEnvio;
        this.estado = estado;
    }


    //Getters y setters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public  LocalDate getFecha() {
        LocalDate fechaActual = LocalDate.now();
        fecha = String.valueOf(fechaActual);
        return fechaActual;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public  String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public  String getEstado() {
        return estado;
    }

    public  void setEstado(String estado) {
        this.estado = estado;
    }

}
