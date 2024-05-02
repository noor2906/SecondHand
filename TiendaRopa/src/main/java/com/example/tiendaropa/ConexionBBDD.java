package com.example.tiendaropa;
import java.sql.*;

public class ConexionBBDD {
private Connection conexion = null;
    private Statement sentenciaSQL = null;
    private ResultSet rs = null;

    public ConexionBBDD() {}

    public void conectar(){
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:4000/tienda_ropa","root","");
            System.out.println("Conexión hecha!");
        }catch (SQLException e){
            System.out.println("Conexión denegada");
            System.out.println(e);
        }
    }
    public void crearSentencia(){
        try {
            sentenciaSQL = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            System.out.println("No se puede hacer la sentencia");
            throw new RuntimeException(e);
        }
    }
    public void ejecutarSQL(String sql){
        try {
            rs = sentenciaSQL.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void desconectar(){
        try { rs.close(); } catch (Exception e) { /* Ignored */ }
        try { sentenciaSQL.close(); } catch (Exception e) { /* Ignored */ }
        try { conexion.close();System.out.println("Conexión cerrada!"); } catch (Exception e) { /* Ignored */ }
    }

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
}
