package efectos.clases;

/**
 * Inversión de letras.
 *
 * @author rperblac
 */
public class EfectoInverso extends EfectoEspecial implements Simetrico {

    /**
     * Crea un efecto "Inversión de letras"
     */
    public EfectoInverso() {
        super("Inversión de letras");
        System.out.println("Creado el efecto " + super.getNombre());
    }

    /**
     * Devuelve la frase al revés
     *
     * @param frase cadena a transformar
     * @return cadena transformada
     */
    @Override
    public String aplicarEfecto(String frase) {
        String r = new StringBuilder(frase).reverse().toString();
        return r;
    }

}
