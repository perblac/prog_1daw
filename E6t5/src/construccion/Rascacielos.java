
package construccion;

/**
 * Es un tipo de edificio rascacielos del que se guarda la altura.
 * @author rperblac
 */
public class Rascacielos extends Edificio{
    /**
     * Altura del edificio.
     */
    private int altura;
    /**
     * Construye un edificio de tipo rascacielos con una dirección, un número de plantas y una altura, que debe ser positiva.
     * @param d dirección del reascacielos
     * @param np número de plantas
     * @param a altura del rascacielos
     * @throws IllegalArgumentException si la altura o el número de plantas no son positivas o son 0 
     */    
    public Rascacielos(String d, int np, int a) throws IllegalArgumentException {
        super(d, np);
        if (a <= 0) throw new IllegalArgumentException("La altura debe ser positiva");
        //this.altura = a;
        this.altura = 10 + (np * 3);
    }
    /**
     * Devuelve la altura del rascacielos.
     * @return altura del rascacielos
     */
    public int getAltura() {
        return this.altura;
    }
}
