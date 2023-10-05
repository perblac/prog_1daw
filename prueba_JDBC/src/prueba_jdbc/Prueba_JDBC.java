
package prueba_jdbc;

import java.awt.Container;
import java.sql.*;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import static java.lang.System.out;

/**
 * T7-ConexBD_v2
 * @author rperblac
 */
        
public class Prueba_JDBC {
    // Objeto conexión a bd
    private static Connection conexion = null;
    // Objeto sentencia sql
    private static Statement sentencia = null;
    
    // Parámetros de conexión y valores por defecto
    //      ip
    private static String IP_JDBC  = "128.0.0.1";
    //      puerto
    private static String PORT_JDBC  = "3306";
    //      usuario
    private static String USER_JDBC = "user";
    //      contraseña
    private static String PASS_JDBC = "password";
    //      base de datos
    private static String BD_JDBC  = "test";
    //      url para conexión
    private static String URL_JDBC = "jdbc:mysql://"+IP_JDBC+":"+PORT_JDBC+"/"+BD_JDBC;
    
    // Tabla seleccionada para mostrar
    private static String seleccionTabla = "";
    
    // Flag de salida gráfica
    private static boolean salidaGraf = false;
    
    // Elementos para salida gráfica
    private static JFrame tablaGraf;
    private static JTable tablaDatos;
    private static JScrollPane scroll;
    
    public static void main(String[] args) {
        // Registramos el driver
        registrarDriverMariaDB();
        
        // Conectar a servidor o salir
        while (true) {
            out.println("Opción:"
                    + "\n\t1 = Conectar a servidor de base de datos"
                    + "\n\t2 = Salir");
            String opcion = new Scanner(System.in).next();
            switch(opcion){
                case "1":
                    if (conectarConServidorBD()) {
                        elegirBD();
                        // Menu de opciones
                        menu();
                        cerrarConexion();                        
                    }
                    break;
                case "2":
                    cerrarConexion();
                    System.exit(0);
                    break;
                default:
                    out.println("\nOpción incorrecta\n");
                    break;
            }
        }
    }
    
    private static void registrarDriverMariaDB() {
        /// Registrar driver de MariaDB/Mysql
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException errorDriver) {
            out.println("Error al registrar el driver de Mysql. " + errorDriver);
        }
    }
    
    private static boolean conectarConServidorBD() {
        // Campos de entrada
        String ip, puerto, usuario, password;
        
        // Estado de la conexión
        boolean estado;
        
        // Entrada de datos
        out.println("Introduzca IP: ");
        ip = new Scanner(System.in).nextLine();
        IP_JDBC = (ip.isBlank()?IP_JDBC:ip);

        out.println("Introduzca puerto: ");
        puerto = new Scanner(System.in).nextLine();
        PORT_JDBC = (puerto.isBlank()?PORT_JDBC:puerto);

        out.println("Introduzca usuario: ");
        usuario = new Scanner(System.in).nextLine();
        USER_JDBC = (usuario.isBlank()?USER_JDBC:usuario);

        out.println("Introduzca contraseña: ");
        password = new Scanner(System.in).nextLine();
        PASS_JDBC = (password.isBlank()?PASS_JDBC:password);

        URL_JDBC = "jdbc:mysql://"+IP_JDBC+":"+PORT_JDBC;//+"/"+BD_JDBC;
        estado = conectar();
        out.println(((estado)?"Conexión realizada con éxito":"No se pudo realizar la conexión con estos datos:"+
                "\nIP: " + IP_JDBC +
                "\nPuerto: " + PORT_JDBC +
                "\nUsuario: " + USER_JDBC +
                "\nContraseña: " + PASS_JDBC + "\n"));
            
        return estado;
    }
    
    private static void elegirBD() {        
        // Intentamos obtener las bases de datos
        
        //      BD que se quiere seleccionar
        String baseDatos;
        
        //      lista de BDs disponibles
        java.util.List<String> bds;
        bds = sacarBDs();

        // Elegir base de datos
        boolean bdCorrecta = false;
        do {            
            out.println("Seleccione base de datos: ");
            baseDatos = new Scanner(System.in).nextLine();
            BD_JDBC = (baseDatos.isBlank())?BD_JDBC:baseDatos;
            
            if (bds.contains(baseDatos))
            {
                bdCorrecta = true;
                URL_JDBC = "jdbc:mysql://"+IP_JDBC+":"+PORT_JDBC+"/"+BD_JDBC;
                conectar();
            }
            else
            out.println("No se encuentra la base de datos " + baseDatos);
        } while (!bdCorrecta);        
    }
    
    private static void menu() {
        // Tablas para elegir
        java.util.List<String> tablas;
        
        // Bucle del menú
        do {
            // Mostrar BD actual y tablas
            tablas = sacarNombreTablas();
            out.println("[BD:"+BD_JDBC+"]");
            out.print("Tablas: ");
            for (String nombre:tablas) {
                out.print(nombre + " ");                
            }
            // Mostrar opciones
            out.println("\nEscriba el nombre de la tabla que desea ver"
                      + "\no una de las siguientes opciones:\n"+
                    ((salidaGraf)?"[salida gráfica activada]\n":"") +
                                "\t1 = Ver todas las tablas"
                            + "\n\t2 = Marcar salida gráfica"
                            + "\n\t3 = Crear BD 'test'"
                            + "\n\t4 = Crear tabla 'test'"
                            + "\n\t5 = Poblar tabla 'test'"
                            + "\n\t6 = Ejecutar borrado en 'test' inseguro"
                            + "\n\t7 = Ejecutar borrado en 'test' seguro"
                            + "\n\t8 = Borrar tabla 'test'"
                            + "\n\t9 = Volver a elegir BD"
                            + "\n\t* = Nueva conexión"
                            + "\n\t0 = Salir");
            
            // Leer opción
            seleccionTabla = new Scanner(System.in).next();
            
            switch (seleccionTabla) {
                case "1":
                    mostrarTodasLasTablas();
                    break;            
                case "2":
                    salidaGraf = !salidaGraf;
                    break;
                case "3":
                    boolean ret6 = crearBDTest();
                    break;
                case "4":
                    boolean ret1;
                    if (BD_JDBC.equals("test")) ret1 = crearTablaTest();
                    else out.println("Esta opción solo se puede ejecutar en la BD 'test'");
                    break;
                case "5":
                    boolean ret2;
                    if (BD_JDBC.equals("test")) ret2 = poblarTablaTest();
                    else out.println("Esta opción solo se puede ejecutar en la BD 'test'");
                    break;
                case "6":
                    boolean ret3;
                    if (BD_JDBC.equals("test")) ret3 = borrarTuplaInseguro();
                    else out.println("Esta opción solo se puede ejecutar en la BD 'test'");
                    break;
                case "7":
                    boolean ret4;
                    if (BD_JDBC.equals("test")) ret4 = borrarTuplaSeguro();
                    else out.println("Esta opción solo se puede ejecutar en la BD 'test'");
                    break;
                case "8":
                    boolean ret5;
                    if (BD_JDBC.equals("test")) ret5 = borrarTablaTest();
                    else out.println("Esta opción solo se puede ejecutar en la BD 'test'");
                    break;
                case "9":
                    cerrarConexion();
                    conectar();
                    elegirBD();
                    break;
                case "*":
                    return;
                case "0":
                    cerrarConexion();
                    System.exit(0);
                default:
                    if (tablas.contains(seleccionTabla)) {
                        if (salidaGraf){
                            iniciarPanel(mostrarTabla(seleccionTabla), seleccionTabla);
                        }
                        else mostrarTabla(seleccionTabla);
                    }
                    else
                        out.println("No se encuentra la tabla " + seleccionTabla);
                    break;
            }
        } while(true);
    }
    
    private static void iniciarPanel(String[][] datos, String titulo) {
        // --- Función para abrir una tabla en ventana con los datos pasados ---
        
        tablaGraf = new JFrame();
        Container panel = tablaGraf.getContentPane();
        
        // Pasamos los nombres de columnas y los datos del array 'datos' a dos
        // nuevos arrays (nomColumnas y datosTabla) para crear la tabla
        int x = datos.length;
        int y = datos[0].length;
        String[] nomColumnas = new String[y];
        String[][] datosTabla;
        
        // Si la tabla no está vacía ( x > 1 porque en una tabla vacía sólo
        // tenemos 1 línea con los nombres ) rellenamos los arrays con los datos
        System.out.println("x: "+x);
        if ( x > 1 ){
            // x - 2 -> dos lineas menos que 'datos' ya que no contiene la cabecera
            datosTabla = new String[x - 2][y];
            // Pasamos los nombres de columnas a nomColumnas
            for (int i = 0; i < y; i++) 
            {
                nomColumnas[i] = datos[0][i];
            }
            // Pasamos los datos a datosTabla
            for (int i = 2; i < x; i++)
            {
                for (int j = 0; j < y; j++)
                {
                    datosTabla[i-2][j] = datos[i][j];
                }
            }            
        }
        // ... y si la tabla está vacía, rellenamos los datos con cadenas vacías
        else 
        {
            // Pasamos los nombres de columnas a nomColumnas
            for (int i = 0; i < y; i++) 
            {
                nomColumnas[i] = datos[0][i];
            }
            // Llenamos una linea de cadenas vacías en datosTabla
            datosTabla = new String[1][y];
            for (int j = 0; j < y; j++)
            {
                datosTabla[0][j] = "";
            }
        }
        
        tablaDatos = new JTable(datosTabla, nomColumnas);
        tablaDatos.setPreferredScrollableViewportSize(new java.awt.Dimension(500,100));
        
        scroll = new JScrollPane(tablaDatos);
        
        panel.add(scroll);
        
        tablaGraf.setSize(500,100);
        tablaGraf.setLocationRelativeTo(null);
        tablaGraf.setTitle("Tabla " + titulo);
        tablaGraf.pack();
        tablaGraf.setVisible(true);
    }

    private static boolean conectar() {
        // --- Función para intentar conectar a la BD ---
        
        boolean conexionCorrecta = true;
        
        // Realizar conexión a la BD                        
        try {
            conexion = DriverManager.getConnection(
                    URL_JDBC,
                    USER_JDBC,
                    PASS_JDBC
            );
        } catch (SQLException ex) {
            out.println("Error SQL conexión. " + ex);
            conexionCorrecta = false;
        }
        
        // Comprobar que se realizó correctamente
        boolean valida = false;
        if (conexionCorrecta) {
            try {
                valida = conexion.isValid(30);
            } catch (SQLException ex) {
                out.println("Error de comprobacion de conexión. " + ex);
                conexionCorrecta = false;
            }
        }
        
        // Imprimir estado de la conexión
        out.println("Conexion: " + (valida ? "Ok":"No conexion"));
        
        return conexionCorrecta;
    }
    
    private static void cerrarConexion() {
        // --- Función que intenta cerrar la conexión si está abierta ---
        
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                out.println("Error al cerrar la conexion");
            }
        }
    }
    
    private static String[][] mostrarTabla(String tabla) {
        // --- Función para sacar el contenido de una tabla ---
        
        // Sentencia sql
        String sql = "SELECT * FROM " + tabla;
        
        // Crear la sentencia de petición
        try {
            sentencia = conexion.createStatement();
        } catch (SQLException ex) {
            out.println("Error de creacion de sentencia. " + ex);
        }
        
        // Hacer la petición a la BD
        ResultSet salida = null;
        try {
            salida = sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            out.println("Error de ejecución de sentencia. " + ex);
        }
        
        // Leer los metadatos para obtener nº de filas y nº y nombre de columnas
        ResultSetMetaData metadatos = null;
        try {
             if (salida != null) metadatos = salida.getMetaData();
             else out.println("No hubo salida de la petición. No se pudieron obtener metadatos.");
        } catch (SQLException ex) {
            out.println("Error de obtención de metadatos. " + ex);
        }
        
        int numCol = 0;
        int filas = 0;
        try {
            if (salida != null && metadatos != null)
            {
                 numCol = metadatos.getColumnCount();
                 filas = (int) ((com.mysql.cj.jdbc.result.ResultSetImpl)salida).getUpdateCount();                
            }
        } catch (SQLException ex) {
            out.println("Error de lectura de nº de columnas");
        }
                
        String[] nombreCol = new String[numCol];
        for (int i = 1; i <= numCol; i++) {
            try {
                if (metadatos != null) nombreCol[i-1] = metadatos.getColumnName(i);
            } catch (SQLException ex) {
                out.println("Error de lectura del nombre de columna " + i);
            }
        }        
        
        // Matriz en la que insertamos la tabla
        String[][] matriz = new String[filas + 2][numCol];
        
        // Signo de tabulado para organizar la salida
        String t = "\t";
        
        out.println("Tabla " + tabla + ": ");
        
        // Bucle de cabeceras
        for (int j = 0; j <= numCol - 1; j++) {
            // Nombres de columnas
            matriz[0][j] = nombreCol[j];
            // Guiones bajo los nombres, sólo si la tabla no está vacía
            if (filas > 1)
            {
                matriz[1][j] = "-".repeat(nombreCol[j].length());                
            }
        }
        
        // Bucle de lectura de contenidos
        for (int i = 2; i <= filas + 1; i++)
        {
            try {
                if (salida != null) salida.next();
            } catch (SQLException ex) {
                out.println("Error de next");
            }
            for (int j = 0; j <= numCol - 1; j++)
            {
                try {
                    if (salida != null) matriz[i][j] = salida.getString(matriz[0][j]);
                } catch (SQLException ex) {
                    out.println("Error de salida en mostrarTabla");
                }
            }
        }        
        
        // Representación de la tabla
        for (int i = 0; i <= filas + 1; i++) {
            for (int j = 0; j <= numCol - 1; j++)
            {
                String palabra = matriz[i][j];
                if (palabra == null) palabra = "null";
                out.print(palabra + (palabra.length()>7?t:t+t));
            }
            out.println();
        }
        // Fin de tabla
        out.println("--- Fin de tabla [" + tabla + "] ---");
        
        // Cerramos sentencia y salida si se utilizaron
        if (sentencia != null) {
            try {
                sentencia.close();
            } catch (SQLException ex) {
                out.println("Error al cerrar la petición sql");
            }
        }
        if (salida != null) {
            try {
                salida.close();
            } catch (SQLException ex) {
                out.println("Error al cerrar el ResultSet");
            }
        }
        
        // Devolvemos los datos
        return matriz;
    }
    
    private static void mostrarTodasLasTablas() {
    // --- Función que saca el contenido de todas las tablas ---    
        java.util.List<String> tablas = sacarNombreTablas();
        for (String tabla:tablas)
        {
            if (salidaGraf)
            {                
                iniciarPanel(mostrarTabla(tabla), tabla);
            }
            else mostrarTabla(tabla);
        }
    }    
  
    private static java.util.List<String> sacarNombreTablas() {
    // --- Función para sacar los nombres de las tablas ---
    
        // Sentencia sql
        String sql="SHOW tables";
        
        // Crear la frase de petición
        try {
            sentencia = conexion.createStatement();
        } catch (SQLException ex) {
            out.println("Error de creacion de sentencia. " + ex);
        }
        
        // Hacer la petición a la BD
        ResultSet salida = null;
        try {
            salida = sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            out.println("Error de ejecución de sentencia. " + ex);
        }
        
        // Leer los metadatos para obtener nombre de la columna "Tablas"
        String nombreCol = null;
        ResultSetMetaData metadatos = null;
        try {
             if (salida != null) metadatos = salida.getMetaData();
             if (metadatos != null) nombreCol = metadatos.getColumnLabel(1);
        } catch (SQLException ex) {
            out.println("Error de obtención de metadatos. " + ex);
        }
        
        // Lista de tablas
        java.util.List<String> listaTablas = new java.util.ArrayList<String>();
        
        // Lectura y salida del resultado ResultSet
        try {
            if (salida != null)
            {
                while (salida.next())
                {
                    try {
                        String nombre = salida.getString(nombreCol);
                        listaTablas.add(nombre);
                    } catch (SQLException ex) {
                        out.println("Error de salida en sacarTablas");            
                    }
                }                
            }
        } catch (SQLException ex) {
            out.println("Error de lectura de salida");
        }
        
        // Cerramos sentencia y salida si se utilizaron
        if (sentencia != null) {
            try {
                sentencia.close();
            } catch (SQLException ex) {
                out.println("Error al cerrar la petición sql");
            }
        }
        if (salida != null) {
            try {
                salida.close();
            } catch (SQLException ex) {
                out.println("Error al cerrar el ResultSet");
            }
        }
        
        // Devolvemos la lista de nombres de tablas
        return listaTablas;
    }
    
    private static java.util.List<String> sacarBDs() {
    // --- Función para sacar los nombres de las BDs ---    
    
        // Sentencia sql
        String sql="SHOW databases";
        
        // Crear la frase de petición
        try {
            sentencia = conexion.createStatement();
        } catch (SQLException ex) {
            out.println("Error de creacion de sentencia. " + ex);
        }
        
        // Hacer la petición a la BD
        ResultSet salida = null;
        try {
            salida = sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            out.println("Error de ejecución de sentencia. " + ex);
        }
        
        // Leer los metadatos para obtener nombre de la columna "Tablas"
        String nombreCol = null;
        ResultSetMetaData metadatos = null;
        try {
             if (salida != null) metadatos = salida.getMetaData();
             if (metadatos != null) nombreCol = metadatos.getColumnLabel(1);
        } catch (SQLException ex) {
            out.println("Error de obtención de metadatos en sacarBDs. " + ex);
        }
        
        // Lista de bases de datos disponible
        java.util.List<String> listaBDs = new java.util.ArrayList<String>();
        
        // Lectura y salida del resultado ResultSet
        out.print("Bases de datos: ");
        try {
            if (salida != null)
            {
                while (salida.next())
                {
                    try {
                        String nombre = salida.getString(nombreCol);
                        out.print(nombre + " ");
                        listaBDs.add(nombre);
                    } catch (SQLException ex) {
                        out.println("Error de salida en sacarBDs. " + ex);            
                    }
                }                
            }
        } catch (SQLException ex) {
            out.println("Error de lectura de salida en sacarBDs. " + ex);
        }
        out.println("\n");
        
        // Cerramos sentencia y salida si se utilizaron
        if (sentencia != null) {
            try {
                sentencia.close();
            } catch (SQLException ex) {
                out.println("Error al cerrar la petición sql");
            }
        }
        if (salida != null) {
            try {
                salida.close();
            } catch (SQLException ex) {
                out.println("Error al cerrar el ResultSet");
            }
        }
        
        // Devolvemos la lista de bases de datos disponibles
        return listaBDs;
    }

    private static boolean crearBDTest() {
        boolean sinerrores = true;
        
        // Sentencia sql
        String sql="CREATE DATABASE test;";
        
        out.println("Sentencia de creacion de BD test:\n"+sql);
        
        // Crear la frase de petición
        try {
            sentencia = conexion.createStatement();
            out.println("Sentencia creada con éxito");
        } catch (SQLException ex) {
            sinerrores = false;
            out.println("Error de creacion de sentencia al crear BD test\n" + ex);
        }
        
        // Hacer la petición a la BD
        try {
            sentencia.execute(sql);
            out.println("BD test creada con éxito");
        } catch (SQLException ex) {
            sinerrores = false;
            out.println("Error de ejecución de sentencia al crear BD test\n" + ex);
        }
        return sinerrores;
    }

    private static boolean crearTablaTest() {
        boolean sinerrores = true;
        
        // Sentencia sql
        String sql="CREATE TABLE IF NOT EXISTS test ("
                + "clave INT UNSIGNED AUTO_INCREMENT,"
                + "nombre CHAR(10),"
                + "PRIMARY KEY (clave));";
        
        out.println("Sentencia de creacion de tabla test:\n"+sql);
        
        // Crear la frase de petición
        try {
            sentencia = conexion.createStatement();
            out.println("Sentencia creada con éxito");
        } catch (SQLException ex) {
            sinerrores = false;
            out.println("Error de creacion de sentencia al crear tabla test\n" + ex);
        }
        
        // Hacer la petición a la BD
        try {
            sentencia.execute(sql);
            out.println("Tabla test creada con éxito");
        } catch (SQLException ex) {
            sinerrores = false;
            out.println("Error de ejecución de sentencia al crear tabla test\n" + ex);
        }
        
        return sinerrores;
    }

    private static boolean poblarTablaTest() {
        boolean sinerrores = true;
        
        // Sentencia sql
        String sql="INSERT INTO test(nombre)"
                + "VALUES('Juan'),"
                + "('Paco'),"
                + "('Maria'),"
                + "('Pepa'),"
                + "('Marcos');";
        
        out.println("Sentencia de población de tabla test:\n"+sql);
        
        // Crear la frase de petición
        try {
            sentencia = conexion.createStatement();
            out.println("Sentencia creada con éxito");
        } catch (SQLException ex) {
            sinerrores = false;
            out.println("Error de creacion de sentencia al poblar tabla\n" + ex);
        }
        
        // Hacer la petición a la BD
        try {
            sentencia.execute(sql);
            out.println("Tabla test poblada con éxito");
        } catch (SQLException ex) {
            sinerrores = false;
            out.println("Error de ejecución de sentencia al poblar tabla\n" + ex);
        }        
        
        return sinerrores;
    }
    
    private static boolean borrarTuplaInseguro() {
        boolean sinerrores = true;
        
        // Entrada de clave
        out.println("Introduzca clave a borrar: ");
        String clave = new Scanner(System.in).nextLine();
        
        // Sentencia sql
        String sql="DELETE FROM test WHERE clave = '" + clave + "';";
                
        out.println("Sentencia de borrado en tabla test:\n"+sql);
        
        // Crear la frase de petición
        try {
            sentencia = conexion.createStatement();
            out.println("Sentencia creada con éxito");
        } catch (SQLException ex) {
            sinerrores = false;
            out.println("Error de creacion de sentencia al borrar en tabla test\n" + ex);
        }
        
        // Hacer la petición a la BD
        try {
            sentencia.execute(sql);
            out.println("Borrado en test ejecutado con éxito");
        } catch (SQLException ex) {
            sinerrores = false;
            out.println("Error de ejecución de sentencia al borrar en tabla test\n" + ex);
        }
        
        return sinerrores;
    }
    
    private static boolean borrarTuplaSeguro() {
        boolean sinerrores = true;
        
        // Entrada de clave
        out.println("Introduzca clave a borrar: ");
        //      sólo tomamos una palabra ( next() en vez de nextLine() )
        String clave = new Scanner(System.in).next();
        //      borramos las comillas simples y dobles que hubiera
        clave=clave.replace("\'", "");        
        clave=clave.replace("\"", "");        
        
        // Sentencia sql
        String sql="DELETE FROM test WHERE clave = ? ;";
        
        PreparedStatement sentenciaP = null;        
        
        // Crear la frase de petición
        try {
            sentenciaP = conexion.prepareStatement(sql);
            sentenciaP.setString(1, clave);
            out.println("Sentencia creada con éxito");
        } catch (SQLException ex) {
            sinerrores = false;
            out.println("Error de creacion de sentencia al borrar en tabla test\n" + ex);
        }
        
        if (sentenciaP != null) out.println("Sentencia de borrado en tabla test:\n"+sentenciaP.toString());
        else out.println("No se pudo generar la sentencia de borrado en tabla test");
        
        // Hacer la petición a la BD
        try {
            if (sentenciaP != null)
            {
                sentenciaP.execute();
                out.println("Borrado en test ejecutado con éxito");
            }
        } catch (SQLException ex) {
            sinerrores = false;
            out.println("Error de ejecución de sentencia al borrar en tabla test\n" + ex);
        }
        
        return sinerrores;
    }
    
    private static boolean borrarTablaTest() {
        boolean sinerrores = true;
        
        // Sentencia sql
        String sql="DROP TABLE test;";
        
        out.println("Sentencia de creacion de tabla test:\n"+sql);
        
        // Crear la frase de petición
        try {
            sentencia = conexion.createStatement();
            out.println("Sentencia creada con éxito");
        } catch (SQLException ex) {
            sinerrores = false;
            out.println("Error de creacion de sentencia al crear tabla\n" + ex);
        }
        
        // Hacer la petición a la BD
        try {
            sentencia.execute(sql);
            out.println("Tabla test creada con éxito");
        } catch (SQLException ex) {
            sinerrores = false;
            out.println("Error de ejecución de sentencia al crear tabla\n" + ex);
        }
        
        return sinerrores;
    }
}
