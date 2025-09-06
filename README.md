# Funcionamiento de la libreria
  <img width="1227" height="448" alt="image" src="https://github.com/user-attachments/assets/97b12288-19b6-4f70-9dbd-122814e88d5f" />

# Otro ejemplo de como usarlo

````java
  //Esto se hace para no pasar como parametro cada uno usar builder
  Usuario usuario=Usuario.Builder()
  .nombre()
  .apellidos()
  //Aqui seguiras poniendo los demas datos
  ...Build();

  //Obtener conexion
  Connection conexion=Conexion.getInstacia().getConexion();

  //Aqui mandas a llamar el metodo que hara (Insertar, eliminar, buscar, ect)
  //Tener en cuenta que recibe como parametro
  boolean guardado = new UsuarioDAO().registrarUsuario(conexion, usuario);

  if(!guardado){
    System.out.pritnln("No se puedo guardar");
  }

  // Muy importante cerrar sesion
  Conexion.getInstancia().cerrarSesion();
````
