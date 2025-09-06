package com.proyecto.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
    private String nombre;
    private String apellidos;
    private String numeroTelefono;
    private String direccion;
    private String correo;
    private String contrasena;
}