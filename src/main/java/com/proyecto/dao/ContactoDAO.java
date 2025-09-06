package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.proyecto.modelo.Contacto;
import com.proyecto.utilidad.IContacto;

public class ContactoDAO implements IContacto{

    @Override
    public boolean registrarContacto(Connection conexion, Contacto contacto) throws SQLException {
        String comando="INSERT INTO contactos(nombre, apellidos, numero_telefono, correo, direccion, categoria, foto_perfil) VALUES(?,?,?,?,?,?,?)";

        try(PreparedStatement sentenciaPreparada=conexion.prepareStatement(comando)){
            sentenciaPreparada.setString(1, contacto.getNombre());
            sentenciaPreparada.setString(2, contacto.getApellidos());
            sentenciaPreparada.setString(3, contacto.getNumeroTelefono());
            sentenciaPreparada.setString(4, contacto.getCorreo());
            sentenciaPreparada.setString(5, contacto.getDireccion());
            sentenciaPreparada.setString(6, contacto.getCategoria());
            sentenciaPreparada.setString(7, contacto.getFotoPerfil());

            int filasAfectadas=sentenciaPreparada.executeUpdate();
            return filasAfectadas>0;
        }

    }

    @Override
    public Contacto obtenerContactoPorNombre(Connection conexion, String nombre) throws SQLException {
        String comando="SELECT * FROM contactos WHERE nombre=?";

        try(PreparedStatement consulta=conexion.prepareStatement(comando)){
            consulta.setString(1, nombre);
            
            try(ResultSet resultado=consulta.executeQuery()){

                if(resultado.next()){
                    return new Contacto(
                        resultado.getString("nombre"),
                        resultado.getString("apellidos"),
                        resultado.getString("numero_telefono"),
                        resultado.getString("correo"),
                        resultado.getString("direccion"),
                        resultado.getString("categoria"),
                        resultado.getString("foto_perfil")
                    );
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public List<Contacto> obtenerTodosLosContactos(Connection conexion) throws SQLException {
        List<Contacto>listado=new ArrayList<>();
        String comando="SELECT * FROM contactos";

        try(Statement consulta=conexion.createStatement()){
            try(ResultSet resultado=consulta.executeQuery(comando)){
                while (resultado.next()) {
                    Contacto contacto=new Contacto();
                    contacto.setNombre(resultado.getString("nombre"));
                    contacto.setApellidos(resultado.getString("apellidos"));
                    contacto.setNumeroTelefono(resultado.getString("numero_telefono"));
                    contacto.setCorreo(resultado.getString("correo"));
                    contacto.setDireccion(resultado.getString("direccion"));
                    contacto.setCategoria(resultado.getString("categoria"));
                    contacto.setFotoPerfil(resultado.getString("foto_perfil"));
                    listado.add(contacto);
                }
            }
        }
        return listado;
    }

    @Override
    public boolean actualizarContacto(Connection conexion, Contacto contacto) throws SQLException {

        String comando="UPDATE contactos SET nombre=?, apellidos=?, numero_telefono=?, correo=?,direccion=?, categoria=?  WHERE nombre=?";

        try(PreparedStatement consulta = conexion.prepareStatement(comando)){
            consulta.setString(1, contacto.getNombre());
            consulta.setString(2, contacto.getApellidos());
            consulta.setString(3, contacto.getNumeroTelefono());
            consulta.setString(4, contacto.getCorreo());
            consulta.setString(5, contacto.getDireccion());
            consulta.setString(6, contacto.getCategoria());
            consulta.setString(7, contacto.getNombre());
            int filasAfectadas = consulta.executeUpdate();
            return filasAfectadas > 0;
        }
    }

    @Override
    public boolean eliminarContacto(Connection conexion, String nombre) throws SQLException {
        String comando="DELETE FROM contactos WHERE nombre=?";

        try(PreparedStatement sentenciaPreparada=conexion.prepareStatement(comando)){
            sentenciaPreparada.setString(1, nombre);

            int filasAfectadas=sentenciaPreparada.executeUpdate();
            return filasAfectadas>0;
        }
    }

}
