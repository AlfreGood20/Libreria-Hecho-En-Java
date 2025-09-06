package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.proyecto.utilidad.ILogin;

public class LoginDAO implements ILogin{

    @Override
    public boolean autenticarUsuario(Connection conexion,String correo, String contrasena) throws SQLException {
        String comando="SELECT * FROM usuarios WHERE correo=? AND contrasena=?";

        try(PreparedStatement consulta=conexion.prepareStatement(comando)){
            consulta.setString(1, correo);
            consulta.setString(2, contrasena);

            try(ResultSet resultado=consulta.executeQuery()){
                return resultado.next();
            }
        }
    }
    
}