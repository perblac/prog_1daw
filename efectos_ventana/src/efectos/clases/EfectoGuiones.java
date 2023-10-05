package efectos.clases;

/**
 * Separador de guiones.
 *
 * @author rperblac
 */
public class EfectoGuiones extends EfectoEspecial {

    /**
     * Crea un efecto "Separador de guiones"
     */
    public EfectoGuiones() {
        super("Separador de guiones");
        System.out.println("Creado el efecto " + super.getNombre());
    }

    /**
     * Cambia los espacios por guiones bajos
     *
     * @param frase cadena a transformar
     * @return cadena transformada
     */
    @Override
    public String aplicarEfecto(String frase) {
        String r = frase.replace(" ", "_");
        return r;
    }

}
