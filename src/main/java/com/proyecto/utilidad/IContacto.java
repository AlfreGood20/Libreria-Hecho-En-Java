package com.proyecto.utilidad;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.proyecto.modelo.Contacto;

public interface IContacto {

    boolean registrarContacto(Connection conexion, Contacto contacto) throws SQLException;

    Contacto obtenerContactoPorNombre(Connection conexion, String nombre) throws SQLException;

    List<Contacto> obtenerTodosLosContactos(Connection conexion) throws SQLException;

    boolean actualizarContacto(Connection conexion, Contacto contacto) throws SQLException;

    boolean eliminarContacto(Connection conexion, String nombre) throws SQLException;
}