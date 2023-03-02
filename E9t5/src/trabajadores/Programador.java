
package trabajadores;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa un empleado que conoce lenguajes de programación y sabe escribir el programa “Hola mundo” en ellos. Para eso dispone de un Map&lt;String,String&gt; donde guarda la asociación entre cada lenguaje conocido y el código fuente de su programa Hola Mundo.
 * @author rperblac
 */
public class Programador extends TrabajadorTecleante {
    /**
     * Tabla con los lenguajes conocidos por el programador y sus holaMundo correspondientes
     */
    private Map<String, String> lenguajes;
    /**
     * Crea un programador con un nombre, un dni, un sueldo y un número de pulsaciones por minuto.
     * @param n nombre del programador
     * @param s sueldo del programador
     * @param ndni número del DNI
     * @param ldni letra del DNI
     * @param ppm pulsaciones por minuto del programador
     */
    public Programador(String n, int s, int ndni, char ldni, int ppm) {
        super(n, s, ndni, ldni, ppm);
        this.teclado = null;
        this.lenguajes = new HashMap<>();
    }
    /**
     * Añade un leguaje de programación con su programa Hola Mundo correspondiente a la tabla de lenguajes conocidos por el programador
     * @param lenguaje lenguaje de programación a añadir
     * @param holaMundo código fuente del Hola Mundo para el lenguaje aprendido
     */
    public void aprenderLenguaje(String lenguaje, String holaMundo) {
        this.lenguajes.put(lenguaje, holaMundo);
    }
    /**
     * Devuelve el código fuente del programa Hola Mundo que corresponde al lenguaje introducido
     * @param lenguaje lenguaje de programación del que se quiere obtener el programa Hola Mundo
     * @return código fuente del programa Hola Mundo
     * @throws IllegalStateException si no se conoce el lenguaje solicitado
     */
    public String programarHolaMundo(String lenguaje) throws IllegalStateException{
        String ret;
        if (this.lenguajes.containsKey(lenguaje)) ret = this.lenguajes.get(lenguaje);
        else throw new IllegalStateException("No se conoce el lenguaje " + lenguaje);
        return ret;
    }
}
