package efectos.clases;

/**
 * Envoltura de corchetes.
 *
 * @author rperblac
 */
public class EfectoCorchetes extends EfectoEspecial implements Simetrico {

    /**
     * Crea un efecto "Envoltura de corchetes"
     */
    EfectoCorchetes() {
        super("Envoltura de corchetes");
        System.out.println("Creado el efecto " + super.getNombre());
    }

    /**
     * Encierra la frase entre [ y ], pero si el texto empieza y termina por
     * ellos, los elimina.
     *
     * @param frase cadena a transformar
     * @return cadena transformada
     */
    @Override
    public String aplicarEfecto(String frase) {
        String r;
        if ((frase.charAt(0) == '[') && (frase.charAt(frase.length() - 1) == ']')) {
            r = frase.substring(1, frase.length() - 1);
        } else {
            r = new StringBuilder("[").append(frase).append("]").toString();
        }
        return r;
    }

}
