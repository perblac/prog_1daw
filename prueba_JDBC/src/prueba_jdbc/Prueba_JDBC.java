
package prueba_jdbc;

import java.awt.Container;
import java.sql.*;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author rperblac
 */
        
public class Prueba_JDBC {
    
    private static Connection conexion = null;
    private static Statement sentencia = null;
	
    private static String IP_JDBC  = "128.0.0.1";
    private static String PORT_JDBC  = "3306";
    private static String BD_JDBC  = "mysql";
    
    private static String URL_JDBC = "jdbc:mysql://"+IP_JDBC+":"+PORT_JDBC+"/"+BD_JDBC;
    private static String USER_JDBC = "root";
    private static String PASS_JDBC = "root";
    
    private static String seleccionTabla = "";
    private static boolean salidaGraf = false;
    
    private static JFrame tablaGraf;
    private static JTable tablaDatos;
    private static JScrollPane scroll;
    
    
    public static void main(String[] args) {
        
        /// Registrar driver de MariaDB/Mysql
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException errorDriver) {
            System.out.println("Error al registrar el driver de Mysql. " + errorDriver);
        }
        
        // Campos de entrada
        String ip, puerto, usuario, password, baseDatos;

        // Entrada de datos
        boolean estado = false;
        do {
            System.out.println("Introduzca IP: ");
            ip = new Scanner(System.in).nextLine();
            IP_JDBC = (ip.isBlank()?IP_JDBC:ip);
            
            System.out.println("Introduzca puerto: ");
            puerto = new Scanner(System.in).nextLine();
            PORT_JDBC = (puerto.isBlank()?PORT_JDBC:puerto);
            
            System.out.println("Introduzca usuario: ");
            usuario = new Scanner(System.in).nextLine();
            USER_JDBC = (usuario.isBlank()?USER_JDBC:usuario);
            
            System.out.println("Introduzca contraseña: ");
            password = new Scanner(System.in).nextLine();
            PASS_JDBC = (password.isBlank()?PASS_JDBC:password);
        
            URL_JDBC = "jdbc:mysql://"+IP_JDBC+":"+PORT_JDBC;//+"/"+BD_JDBC;
            estado = conectar();
            System.out.println(""+((estado)?"Conexión realizada con éxito":"No se pudo realizar la conexión con estos datos:"+
                    "\nIP: " + IP_JDBC +
                    "\nPuerto: " + PORT_JDBC +
                    "\nUsuario: " + USER_JDBC +
                    "\nContraseña: " + PASS_JDBC));
        } while (!estado);
        
        // Intentamos obtener l
        java.util.List<String> bds;
        bds = sacarBDs();
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion");
            }
        }
        
        // Elegir base de datos
        boolean bdCorrecta = false;
        do {            
            System.out.println("Seleccione base de datos: ");
            baseDatos = new Scanner(System.in).nextLine();
            BD_JDBC = (baseDatos.isBlank())?BD_JDBC:baseDatos;
            
            if (bds.contains(baseDatos))
            {
                bdCorrecta = true;
                URL_JDBC = "jdbc:mysql://"+IP_JDBC+":"+PORT_JDBC+"/"+BD_JDBC;
                conectar();
            }
            else
            System.out.println("No se encuentra la base de datos " + baseDatos);
        } while (!bdCorrecta);
        
        // Obtenemos los nombres de las tablas de la BD seleccionada
        java.util.List<String> tablas = sacarTablas();
        
        // Elegir tabla
        boolean tablaCorrecta = false;
        
        do {
            
            System.out.print("Tablas: ");
            for (String nombre:tablas) {
                System.out.print(nombre + " ");                
            }
            
            System.out.println("\nSeleccione tabla "+ ((!salidaGraf)?"":"[salida gráfica activada]") +"(-1 = todas, -2 = salir, -3 = marcar salida gráfica): ");
            seleccionTabla = new Scanner(System.in).next();
            
            switch (seleccionTabla) {
                case "-1":
                    tablaCorrecta = true;
                    sacar();
                    break;
                case "-2":
                    cerrarConexion();
                    System.exit(0);            
                case "-3":
                    if (!salidaGraf) salidaGraf = true;
                    else salidaGraf = false;
                    break;
                default:
                    if (tablas.contains(seleccionTabla)) {
                        tablaCorrecta = true;
                        if (salidaGraf){
                            iniciarPanel(sacarTodo(seleccionTabla), seleccionTabla);
                        }
                        else sacarTodo(seleccionTabla);
                    }
                    else
                        System.out.println("No se encuentra la tabla " + seleccionTabla);
                    break;
            }
        } while(!tablaCorrecta);
        
        cerrarConexion();
    }
    
// --- Método para abrir una tabla en ventana con los datos pasados ---
    static void iniciarPanel(String[][] datos, String titulo) {
        tablaGraf = new JFrame();
        Container panel = tablaGraf.getContentPane();
        
        // Pasamos los nombres de columnas y los datos a dos arrays para crear
        // la tabla
        int x = datos.length;
        int y = datos[0].length;
        String[] nomColumnas = new String[y];
        String[][] datosTabla;
        // Si la tabla no está vacía rellenamos los arrays con los datos
        if (x>1){
            datosTabla = new String[x-2][y];
            for (int i = 0; i < y; i++) 
            {
                nomColumnas[i] = datos[0][i];
            }
            for (int i = 2; i < x; i++)
            {
                for (int j = 0; j < y; j++)
                {
                    datosTabla[i-2][j] = datos[i][j];
                }
            }            
        }
        else // y si está vacía, con cadenas vacías
        {
            for (int i = 0; i < y; i++) 
            {
                nomColumnas[i] = datos[0][i];
            }
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
        tablaGraf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tablaGraf.pack();
        tablaGraf.setVisible(true);
    }

// --- Método para intentar conectar a la BD ---
    static boolean conectar() {
        boolean conexionCorrecta = true;
        
        // Realizar conexión a la BD                        
        try {
            conexion = DriverManager.getConnection(
                    URL_JDBC,
                    USER_JDBC,
                    PASS_JDBC
            );
        } catch (SQLException ex) {
            System.out.println("Error SQL conexion. " + ex);
            conexionCorrecta = false;
        }
        
        // Comprobar que se realizó correctamente
        boolean valida = false;
        if (conexionCorrecta) {
            try {
                valida = conexion.isValid(5000);
            } catch (SQLException ex) {
                System.out.println("Error de comprobacion de conexion");
                conexionCorrecta = false;
            }
        }
        String comprueba = valida ? "Ok":"No conexion";
        System.out.println("Conexion: " + comprueba);
        
        return conexionCorrecta;
    }
    
// --- Método que intenta cerrar la conexión si está abierta ---
    static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion");
            }
        }
    }
    
// --- Método para sacar todo el contenido de una tabla ---
    static String[][] sacarTodo(String tabla) {
        // Sentencia sql
        String sql = "SELECT * FROM " + tabla;
        
        // Crear la frase de petición
        try {
            sentencia = conexion.createStatement();
        } catch (SQLException ex) {
            System.out.println("Error de creacion de sentencia");
        }
        
        // Hacer la petición a la BD
        ResultSet salida = null;
        try {
            salida = sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error de ejecución de sentencia");
        }
        
        // Leer los metadatos para obtener nº de filas y 
        // nº y nombre de columnas
        ResultSetMetaData metadatos = null;
        try {
             metadatos = salida.getMetaData();
        } catch (SQLException ex) {
            System.out.println("Error de obtención de metadatos");
        }
        
        int numCol = 0;
        int filas = 0;
        try {
             numCol = metadatos.getColumnCount();
             filas = (int) ((com.mysql.cj.jdbc.result.ResultSetImpl)salida).getUpdateCount();
        } catch (SQLException ex) {
            System.out.println("Error de lectura de nº de columnas");
        }
                
        String[] nombreCol = new String[numCol];
        for (int i = 1; i <= numCol; i++) {
            try {
                nombreCol[i-1] = metadatos.getColumnName(i);
            } catch (SQLException ex) {
                System.out.println("Error de lectura del nombre de columna " + i);
            }
        }        
        
        // Matriz en la que insertamos la tabla
        String[][] matriz = new String[filas + 2][numCol];
        
        String t = "\t";
        
        System.out.println("Tabla " + tabla + ": ");
        
        // Bucle de cabeceras
        for (int j = 0; j <= numCol - 1; j++) {
            matriz[0][j] = nombreCol[j];
            if (filas > 1)
            {
                matriz[1][j] = "-".repeat(nombreCol[j].length());                
            }
        }
        
        // Bucle de lectura de contenidos
        for (int i = 2; i <= filas + 1; i++)
        {
            try {
                salida.next();
            } catch (SQLException ex) {
                System.out.println("Error de next");
            }
            for (int j = 0; j <= numCol - 1; j++)
            {
                try {
                    matriz[i][j] = salida.getString(matriz[0][j]);
                } catch (SQLException ex) {
                    System.out.println("Error de salida en sacarTodo");
                }
            }
        }        
        
        // Representación de la tabla
        for (int i = 0; i <= filas + 1; i++) {
            for (int j = 0; j <= numCol - 1; j++)
            {
                String palabra = matriz[i][j];
                if (palabra == null) palabra = "null";
                System.out.print(palabra + (palabra.length()>7?t:t+t));
            }
            System.out.println();
        }
        System.out.println();
        
        if (sentencia != null) {
            try {
                sentencia.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la petición sql");
            }
        }
        if (salida != null) {
            try {
                salida.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar el ResultSet");
            }
        }
        
        return matriz;
    }
    
// --- Método que saca el contenido de todas las tablas ---    
static void sacar() {
    java.util.List<String> tablas = sacarTablas();
    for (String tabla:tablas)
    {
        if (salidaGraf)
        {                
            iniciarPanel(sacarTodo(tabla), tabla);
        }
        else sacarTodo(tabla);
    }
}    
  
// --- Método para sacar los nombres de las tablas ---
    static java.util.List<String> sacarTablas() {
        // Sentencia sql
        String sql="SHOW tables";
        
        // Crear la frase de petición
        try {
            sentencia = conexion.createStatement();
        } catch (SQLException ex) {
            System.out.println("Error de creacion de sentencia");
        }
        
        // Hacer la petición a la BD
        ResultSet salida = null;
        try {
            salida = sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error de ejecución de sentencia");
        }
        
        // Leer los metadatos para obtener nombre de la columna "Tablas"
        String nombreCol = null;
        ResultSetMetaData metadatos = null;
        try {
             metadatos = salida.getMetaData();
             nombreCol = metadatos.getColumnLabel(1);
        } catch (SQLException ex) {
            System.out.println("Error de obtención de metadatos");
        }
        
        // Lista de tablas
        java.util.List<String> listaTablas = new java.util.ArrayList<String>();
        
        // Lectura y salida del resultado ResultSet
        //System.out.print("Tablas: ");                 ///
        try {
            while (salida.next())
            {
                try {
                    String nombre = salida.getString(nombreCol);
                    //System.out.print(nombre + " ");                       ///
                    listaTablas.add(nombre);
                } catch (SQLException ex) {
                    System.out.println("Error de salida en sacarTablas");            
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error de lectura de salida");
        }
        //System.out.println("\n");                                ///
        
        if (sentencia != null) {
            try {
                sentencia.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la petición sql");
            }
        }
        if (salida != null) {
            try {
                salida.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar el ResultSet");
            }
        }
        
        return listaTablas;
    }
    
// --- Método para sacar los nombres de las BBDDs ---    
    static java.util.List<String> sacarBDs() {
        // Sentencia sql
        String sql="SHOW databases";
        
        // Crear la frase de petición
        try {
            sentencia = conexion.createStatement();
        } catch (SQLException ex) {
            System.out.println("Error de creacion de sentencia");
        }
        
        // Hacer la petición a la BD
        ResultSet salida = null;
        try {
            salida = sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error de ejecución de sentencia");
        }
        
        // Leer los metadatos para obtener nombre de la columna "Tablas"
        String nombreCol = null;
        ResultSetMetaData metadatos = null;
        try {
             metadatos = salida.getMetaData();
             nombreCol = metadatos.getColumnLabel(1);
        } catch (SQLException ex) {
            System.out.println("Error de obtención de metadatos");
        }
        
        // Lista de tablas
        java.util.List<String> listaBDs = new java.util.ArrayList<String>();
        
        // Lectura y salida del resultado ResultSet
        System.out.print("Bases de datos: ");
        try {
            while (salida.next())
            {
                try {
                    String nombre = salida.getString(nombreCol);
                    System.out.print(nombre + " ");
                    listaBDs.add(nombre);
                } catch (SQLException ex) {
                    System.out.println("Error de salida en sacarBDs");            
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error de lectura de salida");
        }
        System.out.println("\n");
        
        if (sentencia != null) {
            try {
                sentencia.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la petición sql");
            }
        }
        if (salida != null) {
            try {
                salida.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar el ResultSet");
            }
        }
        
        return listaBDs;
    }

}
