
package construccion;

/**
 * Es un tipo de hotel que solo tiene 3 plantas y admite hasta 6 clientes.
 * @author rperblac
 */
public class CasaRural extends Hotel{
    /**
     * Construye una casa rural con una dirección. La casa rural tiene 3 plantas y un máximo de 6 clientes.
     * @param d dirección de la casa rural
     */
    public CasaRural(String d) {
        super(d, 3, 6);        
    }
}
