package com.proyecto.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.proyecto.modelo.Usuario;
import com.proyecto.utilidad.IUsuario;

public class UsuarioDAO implements IUsuario{

    @Override
    public boolean registrarUsuario(Connection conexion, Usuario usuario) throws SQLException {
        String comando="INSERT INTO usuarios(nombre, apellidos, numero_telefono, direccion, correo, contrasena) VALUES(?,?,?,?,?,?)";

        try(var sentenciaPreparada=conexion.prepareStatement(comando)){
            sentenciaPreparada.setString(1, usuario.getNombre());
            sentenciaPreparada.setString(2, usuario.getApellidos());
            sentenciaPreparada.setString(3, usuario.getNumeroTelefono());
            sentenciaPreparada.setString(4, usuario.getDireccion());
            sentenciaPreparada.setString(5, usuario.getCorreo());
            sentenciaPreparada.setString(6, usuario.getContrasena());

            int filasAfectadas=sentenciaPreparada.executeUpdate();
            return filasAfectadas>0;
        }
    }
}