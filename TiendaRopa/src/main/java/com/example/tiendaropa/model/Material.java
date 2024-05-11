package com.example.tiendaropa.model;

import com.example.tiendaropa.Conexiones.ConsultasBBDD;

import java.sql.SQLException;
import java.util.HashMap;


public class Material {
    //Atributos
    private int codigo;
    private String nombre;
    private static HashMap<Integer, Material> mapaMateriales = new HashMap<Integer, Material>();


    //Constructor
    public Material(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    //Getter y setter
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Método donde se rellena el mapa mediante una consulta
    public static void rellenarMapaMateriales() throws SQLException {
        ConsultasBBDD consulta = new ConsultasBBDD();
        mapaMateriales =consulta.crearMateriales(mapaMateriales);
    }


    public static Material seleccionarMaterial(int id){
        return mapaMateriales.get(id);
    }


   /* // METODO QUE RECIBE EL CODIGO DEL ARTICULO Y DEVUELVE UN STRING CON EL MATERIAL DEL ARTICULO

    //consulta a la BBDD donde sacamos el código del material

    public static String obtenerDenominacionMaterial(int codigoArticulo){

        ConexionBBDD conexion = new ConexionBBDD();
        conexion.conectarBBDD();
        conexion.crearSentencia();

        ResultSet rs = conexion.ejecutarSQL("select material.codigo from articulo, material " +
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
            conexion.desconectarBBDD();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return denominacionMaterial;
    }*/
}
