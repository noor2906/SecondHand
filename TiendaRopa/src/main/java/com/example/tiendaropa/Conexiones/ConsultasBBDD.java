package com.example.tiendaropa.Conexiones;

import com.example.tiendaropa.model.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public HashMap<Integer,Material> crearMateriales(HashMap<Integer, Material> mapaMateriales) throws SQLException {
        ConexionBBDD con = new ConexionBBDD();
        ResultSet rs;
        Material material = null;

        con.conectarBBDD();
        con.crearSentencia();
        rs=con.ejecutarSQL("select * from material");
        while (rs.next()) {
            material = new Material(rs.getInt("codigo"), rs.getString("denominacion"));

            mapaMateriales.put(rs.getInt("codigo"),material);
        }
        con.desconectarBBDD();
        return mapaMateriales;
    }

    public List<Articulo> consultaArticulos(List<Articulo> arrayArticulos) throws SQLException {
        ConexionBBDD con = new ConexionBBDD();
        ResultSet rs;

        con.conectarBBDD();
        con.crearSentencia();
        rs = con.ejecutarSQL("SELECT * FROM articulo");

        while (rs.next()) {
            Articulo articulo = new Articulo(
                    rs.getInt("cod_art"),
                    rs.getString("nombre"),
                    rs.getFloat("precio"),
                    rs.getString("marca"),
                    rs.getString("descripcion"),
                    rs.getBoolean("activo"),
                    rs.getString("imagen"),
                    Material.seleccionarMaterial(rs.getInt("material"))
            );
            arrayArticulos.add(articulo);
        }

        con.desconectarBBDD();
        return arrayArticulos;
    }

}
