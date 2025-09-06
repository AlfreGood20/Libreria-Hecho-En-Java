package com.proyecto.utilidad;

import java.sql.Connection;
import java.sql.SQLException;

import com.proyecto.modelo.Usuario;

public interface IUsuario {

    boolean registrarUsuario(Connection conexion, Usuario usuario) throws SQLException;
}