package com.example.tiendaropa.Conexiones;

import com.example.tiendaropa.model.Departamento;
import com.example.tiendaropa.model.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModificacionesBBDD {

    // Método para actualizar los datos de un empleado
    public void actualizarEmpleado(String dni, String nombre, String apellidos, String telefono, String fNacimiento, String email, String direccion, boolean tienePrivilegios) throws SQLException {

        ConexionBBDD conn = new ConexionBBDD();
        String query = "UPDATE empleado SET nombre = ?, apellidos = ?, telefono = ?, f_nacimiento = ?, email = ?, direccion = ?, tiene_privilegios = ? WHERE DNI = ?";

        try {
            conn.conectarBBDD();
            PreparedStatement pstmt = conn.getPreparedStatement(query);

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
        } finally {
            conn.desconectarBBDD();
        }
    }
}
