package com.example.tiendaropa.model;

import com.example.tiendaropa.ConexionBBDD;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Material {
    // METODO QUE RECIBE EL CODIGO DEL ARTICULO Y DEVUELVE UN STRING CON EL MATERIAL DEL ARTICULO

    //consulta a la BBDD donde sacamos el código del material

    public static String obtenerDenominacionMaterial(int codigoArticulo){

        ConexionBBDD conexion = new ConexionBBDD();
        conexion.conectar();
        conexion.crearSentencia();

        ResultSet rs = conexion.ejecutarSentencia("select material.codigo from articulo, material " +
                "where material.codigo = articulo.material and articulo.cod_art =" + codigoArticulo);
        String denominacionMaterial = "";
        int codigoMaterial = 0;

        try{
            while (rs.next()){
                codigoMaterial = rs.getInt("codigo");

                //switch donde asociamos cada codigo a un 'material' de tipo String

                switch (codigoMaterial){
                    case 1 -> denominacionMaterial = "Algodón";
                    case 2 -> denominacionMaterial = "Poliéster";
                    case 3 -> denominacionMaterial = "Seda";
                    case 4 -> denominacionMaterial = "Cuero";
                    case 5 -> denominacionMaterial = "Lana";
                    case 6 -> denominacionMaterial = "Pana";
                    case 7 -> denominacionMaterial = "Franela";
                    case 8 -> denominacionMaterial = "Lino";
                    case 9 -> denominacionMaterial = "Cachemira";
                    case 10 -> denominacionMaterial = "Terciopelo";
                }
            }
            conexion.cerrarConexion();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return denominacionMaterial;
    }
}
