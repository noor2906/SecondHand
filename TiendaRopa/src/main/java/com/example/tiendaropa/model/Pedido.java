package com.example.tiendaropa.model;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
    //Atributos
    private static int numero;
    private static String fecha;
    private static String direccionEnvio;
    private static String estado;



    //Constructor

    public Pedido(int numero, String fecha, String direccionEnvio, String estado) {
        this.numero = numero;
        this.fecha = fecha;
        this.direccionEnvio = direccionEnvio;
        this.estado = estado;
    }


    //Getters y setters

    public static int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static LocalDate getFecha() {
        LocalDate fechaActual = LocalDate.now();
        fecha = String.valueOf(fechaActual);
        return fechaActual;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public static String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public static String getEstado() {
        return estado;
    }

    public static void setEstado(String estado) {
        Pedido.estado = estado;
    }

}
