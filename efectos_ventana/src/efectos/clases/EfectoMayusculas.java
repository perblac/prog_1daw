package efectos.clases;

/**
 * Pasar a mayúsculas.
 *
 * @author rperblac
 */
public class EfectoMayusculas extends EfectoEspecial {

    /**
     * Crea un efecto "Pasar a mayúsculas"
     */
    public EfectoMayusculas() {
        super("Pasar a mayúsculas");
        System.out.println("Creado el efecto " + super.getNombre());
    }

    /**
     * Pasa a mayúsculas la frase
     *
     * @param frase cadena a transformar
     * @return cadena transformada
     */
    @Override
    public String aplicarEfecto(String frase) {
        String r = frase.toUpperCase();
        return r;
    }

}
