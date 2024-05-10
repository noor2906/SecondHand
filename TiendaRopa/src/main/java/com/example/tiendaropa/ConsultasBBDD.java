package com.example.tiendaropa;

import com.example.tiendaropa.model.Cliente;
import com.example.tiendaropa.model.Departamento;
import com.example.tiendaropa.model.Empleado;
import com.example.tiendaropa.model.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ConsultasBBDD {
    //LOGIN ------------------------------------------------------------------------------------------------------------
    public Usuario login(String user, String pass){
        ConexionBBDD conn = new ConexionBBDD();
        ResultSet rs;
        Usuario usuario = null;
        try {
            if (user != null && pass != null) {
                conn.conectarBBDD();
                conn.crearSentencia();
                rs = conn.ejecutarSQL("select * from cliente where email='" + user + "' or dni='" + user + "' and pass='" + pass + "'");
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
                    rs = conn.ejecutarSQL("select * from empleado where email='" + user + "' or dni='" + user + "' and pass='" + pass + "'");
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
        conn.desconectarBBDD();
        return usuario;

    }
    public HashMap<Integer,Departamento> crearDepartamentos(HashMap<Integer,Departamento> mapaDepartamentos) throws SQLException {
        ConexionBBDD conn = new ConexionBBDD();
        ResultSet rs;
        Departamento departamento = null;
        conn.conectarBBDD();
        conn.crearSentencia();
        rs=conn.ejecutarSQL("select * from departamento");
        while (rs.next()) {
            departamento = new Departamento(rs.getInt("codigo"), rs.getString("nombre"));
            mapaDepartamentos.put(rs.getInt("codigo"),departamento);
        }
        conn.desconectarBBDD();
        return mapaDepartamentos;
    }

}
