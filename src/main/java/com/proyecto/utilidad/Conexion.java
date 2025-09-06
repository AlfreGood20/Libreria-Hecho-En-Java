package com.proyecto.utilidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

    private final String url="jdbc:sqlite:DATA_BASE.db";
    private Connection conexion=null;
    private static Conexion instancia;

    private Conexion() {

		try {
			conexion = DriverManager.getConnection(url);
		} catch (SQLException error) {
			System.err.println(error);
		}

	}

    public static Conexion getInstancia() {
		if (instancia == null) {
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getConexion() {
		try {
			if (conexion == null || conexion.isClosed()) {
				conexion = DriverManager.getConnection(url);
			}
		} catch (SQLException e) {
			System.err.println("Error al obtener la conexión: " + e.getMessage());
		}
		return conexion;
	}

	public void cerrarConexion() {

		try {

			if (conexion != null && !conexion.isClosed()) {
				conexion.close();
			}

		} catch (SQLException error) {
			System.err.println(error.getMessage());
		}
	}
}
