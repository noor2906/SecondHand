package com.example.tiendaropa.Conexiones;

import com.example.tiendaropa.model.Cliente;
import com.example.tiendaropa.model.Departamento;
import com.example.tiendaropa.model.Empleado;
import com.example.tiendaropa.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModificacionesBBDD {

    // Método para actualizar los datos de un empleado
    // Hecho por: Carol
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

    // Hecho por: Vero
    public int deshabilitarYHabilitarUsuario(Usuario usuario){//devuelve int que será -1 si ha dado error el método, 1 si se ha habilitado el usuario y 0 si se ha deshabilitado
        ConexionBBDD conn = new ConexionBBDD();
        int habilitado = -1;
        try{
            conn.conectarBBDD();
            conn.crearSentencia();
            String tabla;
            if(usuario instanceof Cliente){
                tabla = "cliente";
            } else if (usuario instanceof Empleado) {
                tabla = "empleado";
            }else {tabla = null;}
            if (usuario.isActivo()==true){
                conn.updateSQL("update "+tabla+" set activo = 0 where dni = '"+usuario.getDni()+"';" );
                System.out.println("Se ha deshabilitado el usuario");
                habilitado=0;
            }else if (usuario.isActivo()==false){
                conn.updateSQL("update "+tabla+" set activo = 1 where dni = '"+usuario.getDni()+"';" );
                System.out.println("Se ha habilitado el usuario");
                habilitado=1;
            }
        }catch (Exception e){
            System.out.println(e);
        }finally{
            conn.desconectarBBDD();
        }
        return habilitado;
    }
}
