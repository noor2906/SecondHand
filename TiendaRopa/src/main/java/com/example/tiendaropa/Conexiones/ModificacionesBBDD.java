package com.example.tiendaropa.Conexiones;

import com.example.tiendaropa.model.Departamento;
import com.example.tiendaropa.model.Empleado;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ModificacionesBBDD {

    /*public void listaEmpleados(){
        ConexionBBDD conn = new ConexionBBDD();
        ResultSet rs;
        List<Empleado> empleados = new ArrayList<>();
        try {
            conn.conectarBBDD();
            conn.crearSentencia();
            rs = conn.ejecutarSQL("UPDATE empleados SET nombre = ?, apellidos = ?, telefono = ?, f_nacimiento = ?, email = ?, direccion = ?, tienePrivilegios = ? WHERE dni = ?" );
            while (rs.next()) {

                Empleado empleado = new Empleado(
                        rs.getString("dni"),
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
                );*/
}
