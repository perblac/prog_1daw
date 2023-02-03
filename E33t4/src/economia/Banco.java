
package economia;

/**
 * Representa un banco
 * @author rperblac
 */
public class Banco implements Adinerado {
    private double dinero;
    /**
     * Crea un Banco cuyo dinero almacenado es 0
     */
    public Banco() {
        this.dinero = 0.0;
    }
    
    /**
     * Devuelve la cantidad de dinero que tenga el objeto.
     * @return dinero del objeto
     */
    public double getDineroTotal() {
        return this.dinero;
    }

    /**
     * Recibe una cantidad e incrementa la cantidad de dinero del objeto. Devuelve false si no es posible añadir la cantidad de dinero al objeto.
     * @param cantidad dinero añadido a objeto
     * @return false si no es posible añadir cantidad al objeto
     */
    public boolean añadirDinero(int cantidad) {
        boolean ret;
        if (cantidad>0)
        {
            this.dinero += cantidad;
            ret = true;
        }
        else
        {
            ret = false;
        }
        return ret;
    }

    /**
     * Recibe una cantidad y decrementa la cantidad de dinero del objeto. Devuelve false si el objeto no tiene dinero suficiente para retirar dicha cantidad.
     * @param cantidad dinero retirado a objeto
     * @return false si el objeto no tiene dinero suficiente para retirar cantidad
     */
    public boolean retirarDinero(int cantidad) {
        boolean ret;
        if (this.dinero<Math.abs(cantidad))
        {
            ret = false;
        }
        else
        {
            this.dinero -= Math.abs(cantidad);
            ret = true;
        }
        return ret;
    }

}
