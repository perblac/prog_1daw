
package contraseñas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Generador de contraseñas que guarda todas las contraseñas que genera en un archivo.
 * @author rperblac
 */
public class GeneradorContraseñasArchivo extends GeneradorContraseñas {
    /**
     * Indica la ruta del archivo donde se irán guardando las contraseñas generadas
     */
    private File archivo;
    /**
     * Crea un generador de contraseñas, creando su Random interno. Guarda las contraseñas generadas en un archivo especificado.
     * @param ruta ruta del archivo donde se irán guardando las contraseñas generadas
     */
    public GeneradorContraseñasArchivo(String ruta) {
        super();
        archivo = new File(ruta);        
    }
    /**
     * Crea un generador de contraseñas con el Random suministrado. Guarda las contraseñas generadas en un archivo especificado.
     * @param ruta ruta del archivo donde se irán guardando las contraseñas generadas
     * @param r objeto Random a utilizar
     */
    public GeneradorContraseñasArchivo(String ruta, Random r) {
        super(r);
        archivo = new File(ruta);        
    }
    /**
     * Genera una contraseña usando el total de caracteres pasado como parámetro.
     * @param longitud longitud de la contraseña deseada
     * @return cadena de contraseña generada
     */
    @Override
    public String generarContraseña(int longitud) {
        String s = super.generarContraseña(longitud);
        try {
            FileWriter fw = new FileWriter(archivo, true);
            fw.write(s);
            fw.write(System.lineSeparator());
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error en el acceso al archivo: "+ex.getMessage());
        }
        return s.toString();
    }
}
