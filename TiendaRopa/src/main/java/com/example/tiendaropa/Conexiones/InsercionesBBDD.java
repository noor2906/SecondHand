package com.example.tiendaropa.Conexiones;

import java.sql.SQLException;

public class InsercionesBBDD {

    public static int insercionRegistro( String nombre,String contra, String apellidos,String telefono,String email,String dni,String direccion,int metodoPago,String fecha, boolean fidelizacion){
        ConexionBBDD conn = new ConexionBBDD();
        conn.conectarBBDD();
        conn.crearSentencia();
        String sql= "INSERT INTO CLIENTE (DNI, nombre, apellidos, telefono, f_nacimiento, direccion, email, pass, " +
                "saldo_cuenta, num_pedidos, dir_envio, tarjeta_fidelizacion, activo, m_pago) " +
                "VALUES ('"+dni+"', '"+nombre+"', '"+apellidos+"', '"+telefono+"', '"+fecha+"', '"+direccion+"', '"+
                email+"', '"+contra+"', 1000.00, 0, '"+direccion+"',"+ fidelizacion+", 1,"+metodoPago+")";
        int ok=conn.updateSQL(sql);
        conn.desconectarBBDD();
        return ok;
    }
}
