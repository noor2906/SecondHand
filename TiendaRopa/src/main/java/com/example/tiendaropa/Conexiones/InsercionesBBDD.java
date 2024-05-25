package com.example.tiendaropa.Conexiones;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsercionesBBDD {

    public static int insercionRegistro( String nombre,String contra, String apellidos,String telefono,String email,String dni,String direccion,int metodoPago,String fecha, boolean fidelizacion){
        ConexionBBDD conn = new ConexionBBDD();
        conn.conectarBBDD();
        conn.crearSentencia();
        String sql= "INSERT INTO CLIENTE (DNI, nombre, apellidos, telefono, f_nacimiento, direccion, email, pass, " +
                "saldo_cuenta, num_pedidos, dir_envio, tarjeta_fidelizacion, activo, m_pago) " +
                "VALUES ('"+dni+"', '"+nombre+"', '"+apellidos+"', '"+telefono+"', '"+fecha+"', '"+direccion+"', '"+
                email+"', '"+contra+"', 1000.00, 0, '"+direccion+"',"+ fidelizacion+", 1,"+metodoPago+")"; //saldoCuenta es 0!!!!!!!!!!! Att. Noor
        int ok=conn.updateSQL(sql);
        conn.desconectarBBDD();
        return ok;
    }

   /* public static int insercionProducto(String nombre, String precio, String marca, boolean activo, String imagen, String descripcion, String material){
        ConexionBBDD conn = new ConexionBBDD();
        conn.conectarBBDD();
        conn.crearSentencia();
        String sql= "INSERT INTO ARTICULO (nombre, precio, marca, descripcion, activo, imagen, material) VALUES\n" +
                "("+ nombre +","+ precio + "," + marca + "," + descripcion + "," +
                activo + "," + imagen + "," +  material + ")";

        int ok=conn.updateSQL(sql);
        conn.desconectarBBDD();
        return ok;
    }*/

    public static int insercionProducto(String nombre, String precio, String marca, boolean activo, String imagen, String descripcion, int material) {
        ConexionBBDD conn = new ConexionBBDD();
        conn.conectarBBDD();
        conn.crearSentencia();

        String sql = "INSERT INTO ARTICULO (nombre, precio, marca, descripcion, activo, imagen, material) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.getPreparedStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, precio);
            pstmt.setString(3, marca);
            pstmt.setString(4, descripcion);
            pstmt.setBoolean(5, activo);
            pstmt.setString(6, imagen);
            pstmt.setInt(7, material);

            int ok = pstmt.executeUpdate();
            conn.desconectarBBDD();
            return ok;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


    public static int insercionCamisa(String talla, String color, String tipoCierre,  String tipoManga, boolean estampada){
        ConexionBBDD conn = new ConexionBBDD();
        conn.conectarBBDD();
        conn.crearSentencia();
        String sql= "INSERT INTO ROPA (cod_art, talla, color, tipo_cierre, tipo_manga, estampada, tipo_ropa) VALUES\n" +
                "((select max(cod_art) from articulo)," + talla + "," + color + "," + tipoCierre + "," + tipoManga + "," + estampada + "'Camisa')";

        //distinct last_insert_id()

        int ok=conn.updateSQL(sql);
        conn.desconectarBBDD();
        return ok;
    }
}
