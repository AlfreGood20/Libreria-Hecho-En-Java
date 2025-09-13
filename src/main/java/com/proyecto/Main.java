package com.proyecto;

import java.sql.Connection;
import java.sql.SQLException;

import com.proyecto.dao.ContactoDAO;
import com.proyecto.modelo.Contacto;
import com.proyecto.utilidad.Conexion;

public class Main {
    public static void main(String[] args) throws SQLException {

        /* 
        Connection conexion= Conexion.getInstancia().getConexion();
        System.out.println("Conexion exitosa");
        Conexion.getInstancia().cerrarConexion();*/

        /* 
        Usuario usuario=Usuario.builder()
        .nombre("Juan")
        .apellidos("Perez")
        .numeroTelefono("123456789")
        .direccion("Calle Falsa 123")
        .correo("ejemplo@")
        .contrasena("password")
        .build();

        Contacto contacto=Contacto.builder()
        .nombre("Maria")
        .apellidos("lopez")
        .numeroTelefono("98765")
        .correo("correonuevo")
        .direccion("Avenida Siempre Viva 456")
        .categoria("Novia")
        .fotoPerfil("ruta/a/foto.jpg")
        .build();

        Connection conexion= Conexion.getInstancia().getConexion();

        new ContactoDAO().eliminarContacto(conexion, "Alfredo");
        Conexion.getInstancia().cerrarConexion();
    */

        Connection conexion= Conexion.getInstancia().getConexion();

        new ContactoDAO().eliminarContactoPorId(conexion, 4);
        new ContactoDAO().eliminarContactoPorId(conexion, 5);

        Contacto contactoRecuperado=new ContactoDAO().obtenerPorNombreCompleto(conexion, "Maria", "lopez");
        System.out.println(contactoRecuperado.toString());
        Conexion.getInstancia().cerrarConexion();
    }
}