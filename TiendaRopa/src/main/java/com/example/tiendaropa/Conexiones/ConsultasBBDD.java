package com.example.tiendaropa.Conexiones;

import com.example.tiendaropa.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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
                            rs.getInt("num_pedidos"),
                            MetodoPago.seleccionarMetodoPago(rs.getInt("m_pago"))
                    );
                }else {
                    rs = conn.ejecutarSQL("select * from empleado where email='" + user + "' or dni='" + user + "' and pass='" + pass + "'");
                    if (rs.next()) {
                    /*(Comentario de: Carol) IMPORTANTE! - La conexion a la BBDD solo está en el if de arriba, en el else no,
                     asi que si por algun motivo entra al else..va a petar, habria que conectar antes del if o añadirlo en los dos sitios */
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
        }finally {
            conn.desconectarBBDD();
        }
        return usuario;

    }

    //DEPARTAMENTOS ----------------------------------------------------------------------------------------------------
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
    //METODO PAGO ------------------------------------------------------------------------------------------------------
    public HashMap<Integer,MetodoPago> crearMetodosPago(HashMap<Integer,MetodoPago> mapaPagos) throws SQLException {
        ConexionBBDD conn = new ConexionBBDD();
        ResultSet rs;
        MetodoPago mPago = null;
        conn.conectarBBDD();
        conn.crearSentencia();
        rs=conn.ejecutarSQL("select * from metodo_pago");
        while (rs.next()) {
            mPago = new MetodoPago(rs.getInt("codigo"), rs.getString("descripcion"));
            mapaPagos.put(rs.getInt("codigo"),mPago);
        }
        conn.desconectarBBDD();
        return mapaPagos;
    }
    // Lista Clientes
    public List<Cliente> recogerListaClientes(List<Cliente> clientes){
        ConexionBBDD conn = new ConexionBBDD();
        ResultSet rs;
        try {
            conn.conectarBBDD();
            conn.crearSentencia();
            rs = conn.ejecutarSQL("select * from cliente");
            while (rs.next()) {

                Cliente cliente = new Cliente(rs.getString("dni"),
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
                        rs.getInt("num_pedidos"),
                        MetodoPago.seleccionarMetodoPago(rs.getInt("m_pago"))
                );

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            conn.desconectarBBDD();
        }
        return clientes;

    }

    //MATERIALES -------------------------------------------------------------------------------------------------------
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

    //ARTICULOS --------------------------------------------------------------------------------------------------------
    public List<Articulo> consultaArticulos(List<Articulo> arrayArticulos) throws SQLException {
        ConexionBBDD con = new ConexionBBDD();
        ResultSet rs;

        Articulo articulo = null;

        con.conectarBBDD();
        con.crearSentencia();
        rs = con.ejecutarSQL("select articulo.*, ropa.talla as talla_ropa, ropa.color, ropa.tipo_cierre as tipo_cierre_ropa, ropa.impermeable, ropa.tipo_manga, ropa.estampada, ropa.tipo_pantalon, ropa.tien_bolsillos,\n" +
                "ropa.tipo_ropa, accesorio.estilo, accesorio.personalizado, accesorio.tipo_cierre as tipo_cierre_accesorio, accesorio.capacidad, accesorio.tipo_suela, accesorio.talla as talla_accesorio,\n" +
                "accesorio.tipo_accesorio from ropa right join articulo on ropa.cod_art = articulo.cod_art left join accesorio on accesorio.cod_art = articulo.cod_art join material on articulo.material = material.codigo where articulo.activo = 1;");

        try {

            while (rs.next()) {

                //Propiedades artículo

                int codigoArt = rs.getInt("cod_art");
                String nombre = rs.getString("nombre");
                float precio = rs.getFloat("precio");
                String marca = rs.getString("marca");
                String descripcion = rs.getString("descripcion");
                boolean activo = rs.getBoolean("activo");
                String imagen = rs.getString("imagen");
                Material material = Material.seleccionarMaterial(rs.getInt("material"));

                //Propiedades ropa

                String tallaRopa = rs.getString("talla_ropa");
                String color = rs.getString("color");
                String tipoCierreRopa = rs.getString("tipo_cierre_ropa");
                boolean impermeable = rs.getBoolean("impermeable");
                String tipoManga = rs.getString("tipo_manga");
                boolean estampada = rs.getBoolean("estampada");
                String tipoPantalon = rs.getString("tipo_pantalon");
                boolean tieneBolsillos = rs.getBoolean("tien_bolsillos");
                String tipoRopa = rs.getString("tipo_ropa");

                //Propiedades accesorio

                String estilo = rs.getString("estilo");
                boolean personalizado = rs.getBoolean("personalizado");
                String tipoCierreAccesorio = rs.getString("tipo_cierre_accesorio");
                int capacidad = rs.getInt("capacidad");
                String tipoSuela = rs.getString("tipo_suela");
                int tallaAccesorio = rs.getInt("talla_accesorio");
                String tipoAccesorio = rs.getString("tipo_accesorio");

                if (tipoRopa !=null) {

                    if (Objects.equals(tipoRopa, "Camisa")) {
                        articulo = new Camisa(codigoArt, nombre, precio, marca, descripcion, activo, imagen, material,
                                tallaRopa, color, tipoCierreRopa, tipoRopa, tipoManga, estampada);

                    } else if (Objects.equals(tipoRopa, "Pantalón")) {
                        articulo = new Pantalon(codigoArt, nombre, precio, marca, descripcion, activo, imagen, material,
                                tallaRopa, color, tipoCierreRopa, tipoRopa, tipoPantalon, tieneBolsillos);

                    } else if (Objects.equals(tipoRopa, "Chaqueta")) {
                        articulo = new Chaqueta(codigoArt, nombre, precio, marca, descripcion, activo, imagen, material,
                                tallaRopa, color, tipoCierreRopa, tipoRopa, impermeable);
                    }

                }

                if (tipoAccesorio !=null) {
                    if (tipoAccesorio.equals("Bolso")){
                        articulo = new Bolso(codigoArt, nombre, precio, marca, descripcion, activo, imagen, material,
                                estilo, personalizado, tipoAccesorio, capacidad, tipoCierreAccesorio);

                    } else if (tipoAccesorio.equals("Zapatos")){
                        articulo = new Zapatos(codigoArt, nombre, precio, marca, descripcion, activo, imagen, material,
                                estilo, personalizado, tipoAccesorio, tallaAccesorio, tipoSuela);

                    }
                }

                arrayArticulos.add(articulo);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Para ver los artículos
       /* System.out.println("ARTICULOS");
        for (int i = 0; i < arrayArticulos.size(); i++) {
            System.out.println(arrayArticulos.get(i));
        }*/

        con.desconectarBBDD();
        return arrayArticulos;
    }

    //EMPLEADOS --------------------------------------------------------------------------------------------------------

    public List<Empleado> listaEmpleados(){
        ConexionBBDD conn = new ConexionBBDD();
        ResultSet rs;
        List<Empleado> empleados = new ArrayList<>();
        try {
            conn.conectarBBDD();
            conn.crearSentencia();
            rs = conn.ejecutarSQL("select * from empleado");
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
                );

                empleados.add(empleado);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            conn.desconectarBBDD();
        }
        return empleados;

    }

}
