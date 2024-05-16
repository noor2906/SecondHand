package com.example.tiendaropa.Conexiones;
import com.example.tiendaropa.model.Cliente;
import com.example.tiendaropa.model.Departamento;
import com.example.tiendaropa.model.Empleado;
import com.example.tiendaropa.model.Usuario;

import java.sql.*;
import java.util.HashMap;

public class ConexionBBDD {

    //Conexion
    private Connection conexion = null;

    //Interfaz statement guarda las sentencias de SQL
    private Statement sentenciaSQL = null;

    //Almacena el resultado de la sentencia
    private ResultSet rs = null;



    // MÉTODOS BÁSICOS PARA EL MANEJO DE LA BBDD -----------------------------------------------------------------------

    //Constructor vacío para llamarlo en el controlador a instanciar
    public ConexionBBDD() {}


    //Método para conectar a la BBDD - Verónica
    public void conectarBBDD(){
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:4000/tienda_ropa","root","");
            System.out.println("Conexión hecha!");
        }catch (SQLException e){
            System.out.println("Conexión denegada");
            System.out.println(e);
        }
    }


    //Método para crear la sentencia para la BBDD - Verónica
    public void crearSentencia(){
        try {
            sentenciaSQL = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            System.out.println("Creando sentencia");
        } catch (SQLException e) {
            System.out.println("No se puede hacer la sentencia");
            throw new RuntimeException(e);
        }
    }

    //Método para ejecutar la sentencia creada de la BBDD - Noor

    public ResultSet ejecutarSQL(String sql) {
        try {
            // almacenamos en el resultset la sentencia que hemos creado
            rs = sentenciaSQL.executeQuery(sql);
            System.out.println("Sentencia ejecutada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
    public void desconectarBBDD(){
        try { rs.close(); } catch (Exception e) {System.out.println("rs no se ha cerrado");}
        try { sentenciaSQL.close(); } catch (Exception e) { System.out.println("Sentencia no se ha cerrado");}
        try { conexion.close();System.out.println("Conexión cerrada!\n"); } catch (Exception e) { System.out.println("Conexión no se ha cerrado"); }
    }

    public int updateSQL(String sql) {// Para insertar cosas en la bbdd
        int ok = 0;
        // actualiza la BBDD
        try {
            sentenciaSQL.executeUpdate(sql);
            ok=1;
        } catch (SQLException e) {
            System.out.println(e);
            ok=-1;
        }
        return ok;
    }

    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        return conexion.prepareStatement(query);
    }


   /* //Método especifico para crear para conectar a la BBDD - Verónica (no se estaba usando)

    public void ejecutarSQL(String sql){
        try {
            rs = sentenciaSQL.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/


    //Método para desconectar de la BBDD - Noor


/*    public void desconectar(){
        try{
            if(rs != null){ //si el resultado de la sentencia no es nulo, cerramos
                rs.close();
            }

            if(sentenciaSQL != null) { //si la sentencia no es nula, cerramos
                sentenciaSQL.close();
            }

            System.out.println("Cerrando correctamente...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/


/*
    // Otros métodos de Conexion a BBDD que podríamos utilizar ---------------------------------------------------------

    public void conectarBBDD() {
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:4000/tienda_ropa", "root", "");
            System.out.println("Conectado");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cerrarConexion(){
        try{
            if(rs != null){ //si el resultado de la sentencia no es nulo, cerramos
                rs.close();
            }

            if(sentenciaSQL != null) { //si la sentencia no es nula, cerramos
                sentenciaSQL.close();
            }

            System.out.println("Cerrando correctamente...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //crearSentencia() igual

    }*/

}
