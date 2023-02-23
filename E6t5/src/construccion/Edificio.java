
package construccion;

/**
 * Representa un edificio que tiene una dirección y una cantidad de plantas, que debe ser positiva.
 * @author rperblac
 */
public class Edificio {
    /**
     * Dirección del edificio
     */
    protected String direccion;
    /**
     * Número de plantas del edificio
     */
    protected int numeroPlantas;
    /**
     * Construye un edificio con una dirección y una cantidad de plantas, que debe ser positiva.
     * @param d dirección del edificio
     * @param np número de plantas del edificio
     * @throws IllegalArgumentException si el número de plantas no es positivo o es 0
     */
    public Edificio(String d, int np) throws IllegalArgumentException{
        this.direccion = d;
        if (np <= 0) throw new IllegalArgumentException("La altura debe ser positiva");
        this.numeroPlantas = np;
    }
    /**
     * Devuelve la dirección del edificio
     * @return dirección del edificio
     */
    public String getDireccion() {
        return this.direccion;
    }
    /**
     * Devuelve el número de plantas del edificio
     * @return número de plantas
     */
    public int getNumeroPlantas() {
        return this.numeroPlantas;
    }
}
