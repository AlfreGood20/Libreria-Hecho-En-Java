package com.proyecto.utilidad;

import java.sql.Connection;
import java.sql.SQLException;

public interface ILogin {

    boolean autenticarUsuario(Connection conexion,String correo, String contrasena) throws SQLException;
}