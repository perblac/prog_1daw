
package daw.zoo;

/**
 * Representa un vehículo especial que solamente puede admitir hasta 6 animales
 * del mismo tipo, sin que se superen los 500kg de peso.
 *
 * @author rperblac
 */
public class TransporteAnimales extends Jaula{
    /**
     * Máximo de animales admitido
     */
    static int maxAnimales = 6;
    
    /**
     * Peso máximo admitido
     */
    static int maxPeso = 500;
    
    /**
     * Crea un transporte de animales, para 6 animales o 500 kg.
     */
    public TransporteAnimales() {       
        super(maxAnimales, maxPeso);        
    }
    
    /**
     * Devuelve si el animal recibido como parámetro puede ser añadido o no, a la jaula
     * @param a animal que se quiere añadir
     * @return true si el animal se puede añadir a la jaula
     */
    public boolean comprobarDisponibilidadPlaza(Animal a) {
        boolean r = false;
        if (!this.animales.isEmpty())
        {
            Class c = this.animales.iterator().next().getClass();
            if (c.isInstance(a))
            {
                r = (this.getNumeroAnimales() < this.getCapacidadMaxima()) && ((this.getPesoActual() + a.getPeso()) <= this.getPesoMaximo());
            }
        }
        else
        {
            r = (this.getNumeroAnimales() < this.getCapacidadMaxima()) && ((this.getPesoActual() + a.getPeso()) <= this.getPesoMaximo());
        }
        return r;
    }
}
