
package daw.zoo;

/**
 * Representa un tigre
 * @author rperblac
 */
public class Tigre extends Animal{
    /**
     * Crea un tigre con un nombre y un peso
     * @param n nombre del tigre
     * @param peso peso del tigre
     */
    public Tigre(String n, int peso) {
        super(n,peso);
    }

    /**
     * Ruge el tigre
     */
    @Override
    public void emitirSonido() {
        System.out.println("RUAAAH!");
    }
    
}
