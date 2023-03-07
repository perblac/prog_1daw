
package contraseñas;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *  Generador de contraseñas que no puede generar contraseñas repetidas.
 * @author rperblac
 */
public class GeneradorContraseñasUnicas extends GeneradorContraseñas {
    /**
     * Set en el que se van guardando todas las contraseñas generadas.
     */
    private Set<String> contraseñasGeneradas;
    /**
     * Crea un generador de contraseñas unicas, creando su Random interno
     */
    public GeneradorContraseñasUnicas() {
        super();
        contraseñasGeneradas = new HashSet<String>();
    }
    /**
     * Crea un generador de contraseñas unicas con el Random suministrado.
     * @param r objeto Random a utilizar
     */
    public GeneradorContraseñasUnicas(Random r) {
        super(r);
        contraseñasGeneradas = new HashSet<String>();
    }
    /**
     * Genera una contraseña usando el total de caracteres pasado como parámetro. Cada vez que se genera, se compruebe que no está repetida, volviéndola a generar en caso de que sea así.
     * @param longitud longitud de la contraseña deseada
     * @return cadena de contraseña generada
     */
    @Override
    public String generarContraseña(int longitud) {
        String s;
        do {
            s = super.generarContraseña(longitud);            
        } while ((contraseñasGeneradas.contains(s)));
        contraseñasGeneradas.add(s);
        return s;
    }
    /**
     * Genera una contraseña de 12 caracteres. Cada vez que se genera, se compruebe que no está repetida, volviéndola a generar en caso de que sea así.
     * @return cadena de contraseña generada
     */
    @Override
    public String generarContraseña() {
        String s;
        do {
            s = super.generarContraseña(12);            
        } while ((contraseñasGeneradas.contains(s)));
        contraseñasGeneradas.add(s);
        return s;
    }    
}
