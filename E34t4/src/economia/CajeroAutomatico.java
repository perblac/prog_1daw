
package economia;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa un cajero automático.
 * @author rperblac
 */
public class CajeroAutomatico implements Adinerado {
    private Map<Integer,Integer> billetes;
    /**
     * Crea un Cajero para guardar monedas y billetes de 1, 5, 10, 20 y 50€, pero inicialmente no tiene dinero.
     */
    public CajeroAutomatico() {
        this.billetes = new HashMap();
        billetes.put(1,0);
        billetes.put(5,0);
        billetes.put(10,0);
        billetes.put(20,0);
        billetes.put(50,0);        
    }
    /**
     * Devuelve la cantidad de dinero que tenga el objeto.
     * @return dinero del objeto
     */
    @Override
    public double getDineroTotal() {
        double total = 0;
        total += billetes.get(1);
        total += 5 * (billetes.get(5));
        total += 10 * (billetes.get(10));
        total += 20 * (billetes.get(20));
        total += 50 * (billetes.get(50));
        return total;
    }
    /**
     * Descompone la cantidad pasada como parámetro en monedas y billetes de 1, 5, 10, 20 y 50€ y los añade a la propiedad “billetes”
     * @param cantidad dinero añadido al objeto
     * @return false si no es posible añadir cantidad al objeto
     */
    @Override
    public boolean añadirDinero(int cantidad) {
        boolean ret;
        if (cantidad<0)
        {
            ret = false;
        }
        else
        {
            int bil50 = cantidad/50;
            billetes.put(50,(billetes.get(50) + bil50));
            cantidad -= 50*bil50;
            
            int bil20 = cantidad/20;
            billetes.put(20,(billetes.get(20) + bil20));
            cantidad -= 20*bil50;
            
            int bil10 = cantidad/10;
            billetes.put(10,(billetes.get(10) + bil10));
            cantidad -= 10*bil50;
            
            int bil5 = cantidad/5;
            billetes.put(5,(billetes.get(5) + bil5));
            cantidad -= 5*bil50;
            
            billetes.put(1, (billetes.get(1) + cantidad));
            cantidad -= cantidad;
            
            ret = true;
        }
        
        return ret;
    }

    @Override
    public boolean retirarDinero(int cantidad) {
        boolean ret;
        return ret;
    }
}
