package com.example.tiendaropa.model;

import java.util.List;

public class Pedido {
    //Atributos
    private int numero;
    private String fecha;
    private String direccionEnvio;
    private String estado;
    private static List<Articulo> listaArticulos;
    private int cantidadArticulo;


    //Constructor
    public Pedido(int numero, String fecha, String direccionEnvio, String estado) {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDir_envio() {
        return direccionEnvio;
    }

    public void setDir_envio(String dir_envio) {
        this.direccionEnvio = dir_envio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Articulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(List<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public int getCantidadArticulo() {
        return cantidadArticulo;
    }

    public void setCantidadArticulo(int cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }

    public static void anyadirArticulo(Articulo articulo){
        listaArticulos.add(articulo);
    }

    public static int contarCantidad(){
        return listaArticulos.size();
    }
}
