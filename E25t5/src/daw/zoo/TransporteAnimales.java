
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
     * Añade un animal a la jaula, solo si hay una plaza disponible para él y no se supera el peso máximo
     * @param a animal a añadir
     * @return true si se pudo añadir al animal
     */
    @Override
    public boolean añadir(Animal a) {
        boolean r = false;
        if (!this.animales.isEmpty())
        {
            Class c = this.animales.iterator().next().getClass();
            if (c.isInstance(a))
            {
                r = (this.comprobarDisponibilidadPlaza())
                && ((this.getPesoActual() + a.getPeso()) <= this.getPesoMaximo());
            }
        }
        else
        {
            r = (this.comprobarDisponibilidadPlaza())
                && ((this.getPesoActual() + a.getPeso()) <= this.getPesoMaximo());
        }        
        if (r) this.animales.add(a);
        return r;
    }
}
