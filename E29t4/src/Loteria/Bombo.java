
package Loteria;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

/**
 * Representa un Bombo que tiene una cola con todas las bolas que irán saliendo del bombo.
 * @author rperblac
 */
public class Bombo {
    /**
     * Cola de las bolas del bombo
     */
    private Queue<Bola> bolas;
    
    /**
     * Crea un bombo con un total de bolas introducido como parámetro
     * @param totalBolas número total de bolas del bombo
     */
    public Bombo(int totalBolas) {
        this.bolas = new ArrayDeque(totalBolas);
        for (int i = 0; i < totalBolas;i++)
        {
            Bola b = new Bola((int) (Math.random()*99) + 1);
            this.bolas.add(b);
        }
    }
    
    /**
     * Devuelve el tamaño del bombo
     * @return número de bolas en el bombo
     */
    public int getNumeroBolas() {
        int num = this.bolas.size();
        return num;
    }
    
    /**
     * Devuelve la última bola introducida en el bombo y la retira
     * @return una bola del bombo
     */
    public Optional<Bola> sacarBola() {
        return Optional.ofNullable(this.bolas.poll());
    }
}