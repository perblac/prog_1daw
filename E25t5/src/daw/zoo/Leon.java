
package daw.zoo;

/**
 * Representa un león
 * @author rperblac
 */
public class Leon extends Animal{
    /**
     * Crea un león con un nombre y un peso
     * @param n nombre del león
     * @param peso peso del león
     */
    public Leon(String n, int peso) {
        super(n,peso);
    }

    /**
     * Ruge el león
     */
    @Override
    public void emitirSonido() {
        System.out.println("ROAAAR!");
    }
    
}
