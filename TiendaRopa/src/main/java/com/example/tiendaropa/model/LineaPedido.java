package com.example.tiendaropa.model;

public class LineaPedido {
    //Atributos
    private int codArt; //Hacer método que vincule el código del Artículo
    private int numPedido; // '' '' '' codigo del pedido
    private int cantidad;

    //Contructor

    public LineaPedido(int codArt, int numPedido, int cantidad) {
        this.codArt = codArt;
        this.numPedido = numPedido;
        this.cantidad = cantidad;
    }

    //Getters y setters

    public int getCodArt() {
        return codArt;
    }

    public void setCodArt(int codArt) {
        this.codArt = codArt;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
