package com.proyecto.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Contacto {
    private String nombre;
    private String apellidos;
    private String numeroTelefono;
    private String correo;
    private String direccion;
    private String categoria;
    private String fotoPerfil;
}