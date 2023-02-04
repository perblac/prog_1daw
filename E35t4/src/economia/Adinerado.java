
package economia;

/**
 * Representa algo que tiene dinero
 * @author rperblac
 */

public interface Adinerado {
    /**
     * Devuelve la cantidad de dinero que tenga el objeto.
     * @return dinero del objeto
     */
    public double getDineroTotal();
    
    /**
     * Recibe una cantidad e incrementa la cantidad de dinero del objeto. Devuelve false si no es posible añadir la cantidad de dinero al objeto.
     * @param cantidad dinero añadido a objeto
     * @return false si no es posible añadir cantidad al objeto
     */
    public boolean añadirDinero(int cantidad);
    
    /**
     * Recibe una cantidad y decrementa la cantidad de dinero del objeto. Devuelve false si el objeto no tiene dinero suficiente para retirar dicha cantidad.
     * @param cantidad dinero retirado a objeto
     * @return false si el objeto no tiene dinero suficiente para retirar cantidad
     */
    public boolean retirarDinero(int cantidad);
}
