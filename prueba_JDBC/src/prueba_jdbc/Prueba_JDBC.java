
package prueba_jdbc;

import java.sql.*;

/**
 *
 * @author rperblac
 */
        
public class Prueba_JDBC {
    
    private static Connection conexion = null;
    private static Statement sentencia = null;
    
	private String IP_JDBC = "192.168.1.2";
	private String PORT_JDBC = "3306";
	private String BD_JDBC = "database";
    private static String URL_JDBC = "jdbc:mysql://"+IP_JDBC+":"+PORT_JDBC+"/"+BD_JDBC;
                    // ToDo: implementar selección de BBDDs, entrada de usuario y contraseña
                    //"jdbc:mysql://192.168.1.25:3333/crm",
                    //"jdbc:mysql://192.168.1.25:3333/ventas",
    private static String USER_JDBC = "user";
    private static String PASS_JDBC = "password";
    
    public static void main(String[] args) {
        
        /// Registrar driver de MariaDB/Mysql
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException errorDriver) {
            System.out.println("Error al registrar el driver de Mysql. " + errorDriver);
        }
                
        // Realizar conexión a la BD                        
        try {
            conexion = DriverManager.getConnection(
                    URL_JDBC,
                    USER_JDBC,
                    PASS_JDBC
            );
        } catch (SQLException ex) {
            System.out.println("Error SQL conexion. " + ex);
        }
        
        // Comprobar que se realizó correctamente
        boolean valida = false;
        try {
            valida = conexion.isValid(5000);
        } catch (SQLException ex) {
            System.out.println("Error de comprobacion de conexion");
        }
        String comprueba = valida ? "Ok":"No conexion";
        System.out.println("Conexion: " + comprueba);
        
        sacar();
    }
    
    static void sacar() {
        java.util.List<String> tablas = sacarTablas();
        for (String tabla:tablas)
        {
          sacarTodo(tabla);
        }
    }
    
    
// --- Método para sacar todo el contenido de una tabla ---
    static void sacarTodo(String tabla) {
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
            matriz[1][j] = "-".repeat(nombreCol[j].length());
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
        System.out.print("Tablas: ");
        try {
            while (salida.next())
            {
                try {
                    String nombre = salida.getString(nombreCol);
                    System.out.print(nombre + " ");
                    listaTablas.add(nombre);
                } catch (SQLException ex) {
                    System.out.println("Error de salida en sacarTablas");            
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error de lectura de salida");
        }
        System.out.println("\n");
        
        
        return listaTablas;
    }
}