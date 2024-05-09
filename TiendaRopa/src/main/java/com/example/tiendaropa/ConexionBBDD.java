package com.example.tiendaropa;
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

    public void desconectarBBDD(){
        try { rs.close(); } catch (Exception e) {System.out.println("rs no se ha cerrado");}
        try { sentenciaSQL.close(); } catch (Exception e) { System.out.println("Sentencia no se ha cerrado");}
        try { conexion.close();System.out.println("Conexión cerrada!"); } catch (Exception e) { System.out.println("Conexión no se ha cerrado"); }
    }

    //LOGIN ------------------------------------------------------------------------------------------------------------
    public Usuario login(String user, String pass){
        Usuario usuario = null;
        /*        boolean ok = false;*/
        try {
            if (user != null && pass != null) {
                rs = ejecutarSQL("select * from cliente where email='" + user + "' or dni='" + user + "' and pass='" + pass + "'");
                if (rs.next()) {
                    usuario = new Cliente(rs.getString("dni"),
                            rs.getString("nombre"),
                            rs.getString("apellidos"),
                            rs.getString("telefono"),
                            rs.getString("f_nacimiento"),
                            rs.getString("email"),
                            rs.getString("pass"),
                            rs.getBoolean("activo"),
                            rs.getString("direccion"),
                            rs.getBoolean("tarjeta_fidelizacion"),
                            rs.getFloat("saldo_cuenta"),
                            rs.getString("dir_envio"),
                            rs.getInt("num_pedidos")
                    );
                }else {
                    rs = ejecutarSQL("select * from empleado where email='" + user + "' or dni='" + user + "' and pass='" + pass + "'");
                    if (rs.next()) {

                        usuario = new Empleado(rs.getString("dni"),
                                rs.getString("nombre"),
                                rs.getString("apellidos"),
                                rs.getString("telefono"),
                                rs.getString("f_nacimiento"),
                                rs.getString("email"),
                                rs.getString("pass"),
                                rs.getBoolean("activo"),
                                rs.getString("direccion"),
                                rs.getBoolean("tiene_privilegios"),
                                Departamento.seleccionarDpto(rs.getInt("dpto"))
                        );
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
    public HashMap<Integer,Departamento> crearDepartamentos(HashMap<Integer,Departamento> mapaDepartamentos) throws SQLException {
        Departamento departamento = null;
        conectarBBDD();
        crearSentencia();
        rs=ejecutarSQL("select * from departamento");
        while (rs.next()) {
            int dpto = rs.getInt("codigo");
            departamento = new Departamento(rs.getInt("codigo"), rs.getString("nombre"));
            mapaDepartamentos.put(dpto,departamento);
        }
        desconectarBBDD();
        return mapaDepartamentos;
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
