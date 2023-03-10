
package daw.zoo;

import java.util.HashSet;
import java.util.Set;

/**
 * Representa a cualquier cosa que pueda guardar un conjunto de animales.
 * @author rperblac
 */

public abstract class ContenedorAnimales {
    
    /**
     * Conjunto con los animales que hay en el contenedor.
     */
    protected Set<Animal> animales;
    
    /**
     * Crea un contenedor de animales con un conjunto de animales vacío
     */
    public ContenedorAnimales() {
        this.animales = new HashSet<>();
    }
    
    /**
     * Añade un animal al contenedor, solo si hay una plaza disponible para él.
     * @param a animal a añadir
     * @return true si se pudo añadir al animal
     */
    public boolean añadir(Animal a) {
        boolean r = this.comprobarDisponibilidadPlaza(a);
        if (r)
        {
            a.setEncerrado(true);
            this.animales.add(a);
        }
        return r;
    }
    
    /**
     * Retira el animal del contenedor
     * @param a animal a retirar
     * @return false si el animal no está en el contenedor
     */
    public boolean retirar(Animal a) {
        boolean r = this.animales.contains(a);
        if (r)
        {
            a.setEncerrado(false);
            this.animales.remove(a);
        }
        return r;
    }
    
    /**
     * Devuelve el peso de todos los animales que hay en el contenedor.
     * @return peso total de todos los animales
     */
    public int getPesoActual() {
        int peso = 0;
        for (Animal a:this.animales)
        {
            peso += a.getPeso();
        }
        return peso;
    }
    
    /**
     * Devuelve el número de animales que hay en el contenedor.
     * @return número total de animales
     */
    public int getNumeroAnimales() {
        return this.animales.size();
    }
    
    /**
     * Método para saber si el animal recibido como parámetro puede ser añadido o no, al contenedor.
     * @param a animal que se quiere añadir
     * @return true si el animal se puede añadir al contenedor
     */
    protected abstract boolean comprobarDisponibilidadPlaza(Animal a);
}
