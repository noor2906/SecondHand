package com.example.tiendaropa.Conexiones;

import com.example.tiendaropa.model.Departamento;
import com.example.tiendaropa.model.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModificacionesBBDD {

    private Connection conexion = null;
    private ResultSet rs = null;
    private Statement sentenciaSQL = null;

    // Constructor vacío
    public ModificacionesBBDD() {}

    // Método para conectar a la BBDD
    public void conectarBBDD() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:4000/tienda_ropa", "root", "");
            System.out.println("Conexión hecha!");
        } catch (SQLException e) {
            System.out.println("Conexión denegada");
            throw new RuntimeException(e);
        }
    }

    // Método para cerrar la conexión a la BBDD
    public void cerrarConexion() {
        try {
            if (rs != null) { // Si el resultado de la sentencia no es nulo, cerramos
                rs.close();
            }
            if (sentenciaSQL != null) { // Si la sentencia no es nula, cerramos
                sentenciaSQL.close();
            }
            if (conexion != null) { // Si la conexión no es nula, cerramos
                conexion.close();
            }
            System.out.println("Cerrando correctamente...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para actualizar los datos de un empleado
    public void actualizarEmpleado(String dni, String nombre, String apellidos, String telefono, String fNacimiento, String email, String direccion, boolean tienePrivilegios) throws SQLException {
        String query = "UPDATE empleados SET nombre = ?, apellidos = ?, telefono = ?, fNacimiento = ?, e_mail = ?, direccion = ?, tienePrivilegios = ? WHERE dni = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, telefono);
            pstmt.setString(4, fNacimiento);
            pstmt.setString(5, email);
            pstmt.setString(6, direccion);
            pstmt.setBoolean(7, tienePrivilegios);
            pstmt.setString(8, dni);
            pstmt.executeUpdate();
            System.out.println("Empleado actualizado correctamente.");
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar los datos del empleado", e);
        }
    }
}
