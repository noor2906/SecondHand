package com.example.tiendaropa.Conexiones;

import com.example.tiendaropa.Controlador_login;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsercionesBBDD {

    // Hecho por: Vero
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
    // Hecho por: Noor
    public static int insercionProducto(String nombre, String precio, String marca, String imagen, String descripcion, int material) {
        ConexionBBDD conn = new ConexionBBDD();
        conn.conectarBBDD();
        conn.crearSentencia();

        String sql = "INSERT INTO ARTICULO (nombre, precio, marca, descripcion, activo, imagen, material) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.getPreparedStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, precio);
            pstmt.setString(3, marca);
            pstmt.setString(4, descripcion);
//            pstmt.setBoolean(5, activo);
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

    // Hecho por: Noor
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

    //Empleado ---------------------------------------------------------------------------------------------------------

    // Hecho por: Carol
    public void insertarEmpleado(String dni, String nombre, String apellidos, String telefono, String fechaNacimiento, String email, String direccion, boolean tienePrivilegios, String pass, int tipoEmpleado) throws SQLException {
        ConexionBBDD conn = new ConexionBBDD();
        conn.conectarBBDD();
        conn.crearSentencia();
        // Obtener la conexión a la base de datos desde la instancia de ConexionBBDD
        PreparedStatement statement = null;
        try {
            // Preparar la consulta SQL para insertar un nuevo empleado
            String sql = "INSERT INTO empleado (DNI, nombre, apellidos, telefono, f_nacimiento, email, direccion, tiene_privilegios, pass, dpto) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Obtener el PreparedStatement desde la conexión
            statement = conn.getPreparedStatement(sql);
            statement.setString(1, dni);
            statement.setString(2, nombre);
            statement.setString(3, apellidos);
            statement.setString(4, telefono);
            statement.setString(5, fechaNacimiento);
            statement.setString(6, email);
            statement.setString(7, direccion);
            statement.setBoolean(8, tienePrivilegios);
            statement.setString(9,pass);
            statement.setInt(10,tipoEmpleado);

            // Ejecutar la consulta
            statement.executeUpdate();
        } finally {
            // Cerrar el PreparedStatement (liberar recursos)
            if (statement != null) {
                statement.close();
                conn.desconectarBBDD();
            }
        }
    }

    //Hecho por carol:
    //Insertar datos en la linea de pedido
    public void insertarPedido(String fechaPedidoString, String dirEnvio, String estado, String dniCliente) throws SQLException {
        ConexionBBDD conn = new ConexionBBDD();
        conn.conectarBBDD();
        conn.crearSentencia();
        // Obtener la conexión a la base de datos desde la instancia de ConexionBBDD
        PreparedStatement statement = null;
        try {

            String sql = "INSERT INTO pedido (fecha, dir_envio, estado, DNI_cliente) " +
                    "VALUES (?, ?, ?, ?)";

            // Obtener el PreparedStatement
            statement = conn.getPreparedStatement(sql);

            statement.setString(1, fechaPedidoString);
            statement.setString(2, dirEnvio);
            statement.setString(3, estado);
            statement.setString(4, dniCliente);

            // Ejecutar la consulta
            statement.executeUpdate();
        } finally {
            // Cerrar el PreparedStatement (liberar recursos)
            if (statement != null) {
                statement.close();
                conn.desconectarBBDD();
            }
        }
    }

    //Hecho por carol:
    //Insertar pedido tras añadir algo a la linea de pedido
    public void insertarLineaPedido(int codigoArticulo, int numPedido, int cantidad) throws SQLException {
        ConexionBBDD conn = new ConexionBBDD();
        conn.conectarBBDD();
        PreparedStatement statement = null;

        try {

            conn.conectarBBDD();
            // Preparar la consulta SQL para insertar
            String sql = "INSERT INTO linea_pedido (cod_art, num_pedido, cantidad) " +
                    "VALUES (?, ?, ?)";

            // Obtener el PreparedStatement
            statement = conn.getPreparedStatement(sql);
            statement.setInt(1, codigoArticulo);
            statement.setInt(2, numPedido);
            statement.setInt(3, cantidad);

            // Ejecutar la consulta
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // Cerrar el PreparedStatement y desconectar BBDD
            if (statement != null) {
                statement.close();
            }
            conn.desconectarBBDD();
        }
    }

}
