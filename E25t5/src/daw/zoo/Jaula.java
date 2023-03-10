
package daw.zoo;

/**
 * Representa una jaula que admite una capacidadMáxima de animales, pero sin que se supere un pesoMáximo.
 * @author rperblac
 */
public class Jaula extends ContenedorAnimales{
    /**
     * Capacidad máxima de la jaula
     */
    private int capacidadMaxima;
    
    /**
     * Peso máximo de la jaula
     */
    private int pesoMaximo;
    
    /**
     * Crea una jaula con una capacidad máxima y un peso máximo
     * @param cm capacidad máxima
     * @param pm peso máximo
     */
    public Jaula(int cm, int pm) {
        super();
        this.capacidadMaxima = cm;
        this.pesoMaximo = pm;
    }
    /**
     * Devuelve la capacidad máxima de la jaula
     * @return capacidad máxima de la jaula
     */
    public int getCapacidadMaxima() {
        return this.capacidadMaxima;
    }
    /**
     * Devuelve el peso máximo de la jaula
     * @return peso máximo de la jaula
     */
    public int getPesoMaximo() {
        return this.pesoMaximo;
    }
    
    /**
     * Devuelve si el animal recibido como parámetro puede ser añadido o no, a la jaula
     * @return true si el animal se puede añadir a la jaula
     */
    @Override
    public boolean comprobarDisponibilidadPlaza() { 
        return (this.getNumeroAnimales() < this.getCapacidadMaxima()) && (this.getPesoActual() < this.getPesoMaximo());
    }
    
    /**
     * Añade un animal a la jaula, solo si hay una plaza disponible para él y no se supera el peso máximo
     * @param a animal a añadir
     * @return true si se pudo añadir al animal
     */
    @Override
    public boolean añadir(Animal a) {
        boolean r = (this.comprobarDisponibilidadPlaza())
                && ((this.getPesoActual() + a.getPeso()) <= this.getPesoMaximo());
        if (r) this.animales.add(a);
        return r;
    }
}
