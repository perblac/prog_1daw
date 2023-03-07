
package contraseñas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * Generador de contraseñas únicas que las guarda en un archivo
 * @author rperblac
 */
public class GeneradorContraseñasUnicasArchivo extends GeneradorContraseñas{
    /**
     * Indica la ruta del archivo donde se irán guardando las contraseñas generadas
     */
    private File archivo;
    /**
     * Set en el que se van guardando todas las contraseñas generadas.
     */
    private Set<String> contraseñasGeneradas;
    /**
     * Crea un generador de contraseñas únicas, creando su Random interno. Guarda las contraseñas generadas en un archivo especificado.
     * @param ruta ruta del archivo donde se irán guardando las contraseñas generadas
     */
    public GeneradorContraseñasUnicasArchivo(String ruta) {
        super();
        archivo = new File(ruta);
        contraseñasGeneradas = new HashSet<String>();
    }
    /**
     * Crea un generador de contraseñas únicas con el Random suministrado. Guarda las contraseñas generadas en un archivo especificado.
     * @param ruta ruta del archivo donde se irán guardando las contraseñas generadas
     * @param r objeto Random a utilizar
     */
    public GeneradorContraseñasUnicasArchivo(String ruta, Random r) {
        super(r);
        archivo = new File(ruta);
        contraseñasGeneradas = new HashSet<String>();
    }
    /**
     * Genera una contraseña única usando el total de caracteres pasado como parámetro.
     * @param longitud longitud de la contraseña deseada
     * @return cadena de contraseña generada
     */
    @Override
    public String generarContraseña(int longitud) {
        // Si no existe aún el archivo del generador, lo creamos
        if (!archivo.exists()) try {
            archivo.createNewFile();
        } catch (IOException ex) {
            System.out.println("Error al crear archivo: " + ex.getMessage());
        }
        // Lista de contraseñas del archivo
        HashSet<String> lista = new HashSet<>();
        try {
            FileReader fr = new FileReader(archivo);
            Scanner s = new Scanner(fr);
            while (s.hasNext())
            {
                lista.add(s.nextLine());
            }
            s.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("No se pudo cerrar el archivo: " + ex.getMessage());
        }
        // Generamos una contraseña que no esté ni en las generadas ni en el archivo
        String s = "";
        do {
            s = super.generarContraseña(longitud);            
        } while(lista.contains(s)||contraseñasGeneradas.contains(s));
        // Añadimos la nueva contraseña a las generadas y al archivo
        contraseñasGeneradas.add(s);
        try {
            FileWriter fw = new FileWriter(archivo, true);
            fw.write(s);
            fw.write(System.lineSeparator());
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error en el acceso al archivo: " + ex.getMessage());
        }        
        return s;
    }
}
