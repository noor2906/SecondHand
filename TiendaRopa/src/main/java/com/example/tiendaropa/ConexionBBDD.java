package com.example.tiendaropa;
import java.sql.*;

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

    public ResultSet ejecutarSentencia(String sentencia) {
        try {
            // almacenamos en el resultset la sentencia que hemos creado
            rs = sentenciaSQL.executeQuery(sentencia);
            System.out.println("Ejecutando sentencia");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
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


    public void desconectarBBDD(){
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


    //LOGIN ------------------------------------------------------------------------------------------------------------
    public boolean login(String user, String pass){
        boolean ok = false;
        try {
            if (user != null && pass != null) {
                String sql = "select * from cliente where email='" + user + "' or dni='" + user + "' and pass='" + pass + "'";
                rs = sentenciaSQL.executeQuery(sql);
                if (rs.next()) {
                    ok=true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ok;
    }






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
