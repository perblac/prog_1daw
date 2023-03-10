
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
    
    /**
     * Compara un tigre con otro objeto, a través del nombre
     * @param o objeto a comparar con el tigre
     * @return true si los dos son tigres y tienen el mismo nombre
     */
    @Override
    public boolean equals(Object o) {
        boolean r = false;
        if (o instanceof Tigre)
        {
            r = super.equals(o);
        }
        return r;
    }
    
}
