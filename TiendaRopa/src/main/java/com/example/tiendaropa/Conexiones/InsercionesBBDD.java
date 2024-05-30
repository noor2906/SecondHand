package com.example.tiendaropa.Conexiones;

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

    // Hecho por: Noor
    public static int insercionProducto(String nombre, String precio, String marca, String imagen, String descripcion, boolean activo, int material) {
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

    // Hecho por: Noor
    public static int insercionCamisa(String talla, String color, String tipoCierre, String tipoManga, boolean estampada) {
        ConexionBBDD conn = new ConexionBBDD();
        conn.conectarBBDD();
        conn.crearSentencia();
        String sql = "INSERT INTO ROPA (cod_art, talla, color, tipo_cierre, tipo_manga, estampada, tipo_ropa) " +
                "VALUES ((select max(cod_art) from articulo), ?, ?, ?, ?, ?, 'Camisa')";

        //distinct last_insert_id()

        try (PreparedStatement pstmt = conn.getPreparedStatement(sql)) {
            pstmt.setString(1, talla);
            pstmt.setString(2, color);
            pstmt.setString(3, tipoCierre);
            pstmt.setString(4, tipoManga);
            pstmt.setBoolean(5, estampada);

            int ok = pstmt.executeUpdate();
            conn.desconectarBBDD();
            return ok;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Hecho por: Noor
    public static int insercionChaqueta(String talla, String color, String tipoCierre, boolean impermeable) {
        ConexionBBDD conn = new ConexionBBDD();
        conn.conectarBBDD();
        conn.crearSentencia();
        String sql = "INSERT INTO ROPA (cod_art, talla, color, tipo_cierre, impermeable, tipo_ropa) " +
                "VALUES ((select max(cod_art) from articulo), ?, ?, ?, ?, 'Chaqueta')";

        //distinct last_insert_id()

        try (PreparedStatement pstmt = conn.getPreparedStatement(sql)) {
            pstmt.setString(1, talla);
            pstmt.setString(2, color);
            pstmt.setString(3, tipoCierre);
            pstmt.setBoolean(4, impermeable);

            int ok = pstmt.executeUpdate();
            conn.desconectarBBDD();
            return ok;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int insercionPantalon(String talla, String color, String tipoCierre, boolean tieneBolsillos, String tipoPantalon) {
        ConexionBBDD conn = new ConexionBBDD();
        conn.conectarBBDD();
        conn.crearSentencia();
        String sql = "INSERT INTO ROPA (cod_art, talla, color, tipo_cierre, tipo_pantalon, tien_bolsillos, tipo_ropa) " +
                "VALUES ((select max(cod_art) from articulo), ?, ?, ?, ?,?, 'Pantalón')";


        //distinct last_insert_id()

        try (PreparedStatement pstmt = conn.getPreparedStatement(sql)) {
            pstmt.setString(1, talla);
            pstmt.setString(2, color);
            pstmt.setString(3, tipoCierre);
            pstmt.setString(4, tipoPantalon);
            pstmt.setBoolean(5, tieneBolsillos);

            int ok = pstmt.executeUpdate();
            conn.desconectarBBDD();
            return ok;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Hecho por: Noor
    public static int insercionZapatos(String estilo, boolean personalizado, String tipoSuela, int talla) {
        ConexionBBDD conn = new ConexionBBDD();
        conn.conectarBBDD();
        conn.crearSentencia();
        String sql = "INSERT INTO ACCESORIO (cod_art, estilo, personalizado, tipo_suela, talla, tipo_accesorio) " +
                "VALUES ((select max(cod_art) from articulo), ?, ?, ?, ?, 'Zapatos')";

        //distinct last_insert_id()

        try (PreparedStatement pstmt = conn.getPreparedStatement(sql)) {
            pstmt.setString(1, estilo);
            pstmt.setBoolean(2, personalizado);
            pstmt.setString(3, tipoSuela);
            pstmt.setInt(4, talla);

            int ok = pstmt.executeUpdate();
            conn.desconectarBBDD();
            return ok;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Hecho por: Noor
    public static int insercionBolso(String estilo, boolean personalizado, String tipoCierre, int capacidad) {
        ConexionBBDD conn = new ConexionBBDD();
        conn.conectarBBDD();
        conn.crearSentencia();
        String sql = "INSERT INTO ACCESORIO (cod_art, estilo, personalizado, tipo_cierre, capacidad, tipo_accesorio) " +
                     "VALUES ((select max(cod_art) from articulo), ?, ?, ?, ?, 'Bolso')";

        //distinct last_insert_id()

        try (PreparedStatement pstmt = conn.getPreparedStatement(sql)) {
            pstmt.setString(1, estilo);
            pstmt.setBoolean(2, personalizado);
            pstmt.setString(3, tipoCierre);
            pstmt.setInt(4, capacidad);

            int ok = pstmt.executeUpdate();
            conn.desconectarBBDD();
            return ok;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

}
