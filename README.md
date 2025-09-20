# Como crear una libreria en java 😬

- Paso 1
  Crear un proyecto MAVEN (Gestor Dependencias)
- Paso 2
  Hacer la funcionalidad de la libreria (Funciones)
- Paso 3
  En la consola usar el comando:
  ```
  mvn clean package
  ````
Finalmente tendras tu libreria, el archivo .jar es el que usaras en otros proyectos.

# Como usar la libreria en otro proyecto
- Paso 1
  Importar el archivo.jar al proyecto copiar y pegar en la raiz o en alguna carpeta
- Paso 2
  Si tu proyecto usa maven o gradle importarlo como dependencia en maven se hace asi:
  ```` XML
    <dependencies> 
        <dependency>
            <groupId>com.proyecto</groupId>
            <artifactId>libreria</artifactId>
            <version>1.0-SNAPSHOT</version>
            <scope>system</scope>        <---Aqui pondras el url de la libreria--->
            <systemPath>${project.basedir}/libreria-1.0-SNAPSHOT.jar</systemPath>
        </dependency>
    </dependencies>
  ````
Finalmente usar la libreria en tu proyecto 👨‍💻🛠️


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
