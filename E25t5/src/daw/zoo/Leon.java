
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
    
    /**
     * Compara un leon con otro objeto, a través del nombre
     * @param o objeto a comparar con el leon
     * @return true si los dos son leones y tienen el mismo nombre
     */
    @Override
    public boolean equals(Object o) {
        boolean r = false;
        if (o instanceof Leon)
        {
            r = super.equals(o);
        }
        return r;
    }
}
