
package Loteria;

/**
 * Representa una bola que tiene un numero.
 * @author rperblac
 */
public class Bola {
    /**
     * El número de la bola.
     */
    private int numero;
    /**
     * Cra una bola con un número.
     * @param numero número de la bola
     */
    public Bola(int numero) {
        this.numero = numero;
    }
    /**
     * Devuelve el número de la bola
     * @return número de la bola
     */
    public int getNumero() {
        return this.numero;
    }
}
