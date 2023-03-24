package efectos.clases;

import java.util.ArrayList;
import java.util.List;

/**
 * Un efecto especial que puede aplicarse sobre una frase.
 *
 * @author rperblac
 */
public abstract class EfectoEspecial {

    /**
     * Lista con objetos de los efectos disponibles
     */
    public static List<EfectoEspecial> EFECTOS;

    /**
     * Nombre del efecto especial
     */
    private String nombre;

    static {
        EFECTOS = new ArrayList<>();
    }

    /**
     * Crea un efecto especial con un nombre especificado y lo añade a la lista
     * de efectos
     *
     * @param n nombre del efecto especial
     */
    public EfectoEspecial(String n) {
        this.nombre = n;
        EFECTOS.add(this);
    }

    /**
     * Devuelve el nombre del efecto especial
     *
     * @return nombre del efecto especial
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Transforma la frase recibida en otra, que será la “aplicación del efecto”
     *
     * @param frase cadena a transformar
     * @return cadena transformada
     */
    public abstract String aplicarEfecto(String frase);
}
