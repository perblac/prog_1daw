
package economia;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa un cajero automático
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
     * Descompone la cantidad pasada como parámetro en monedas y billetes de 1, 5, 10, 20 y 50€ y los añade a la propiedad “billetes”.
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
            cantidad -= 20*bil20;
            
            int bil10 = cantidad/10;
            billetes.put(10,(billetes.get(10) + bil10));
            cantidad -= 10*bil10;
            
            int bil5 = cantidad/5;
            billetes.put(5,(billetes.get(5) + bil5));
            cantidad -= 5*bil5;            
            
            billetes.put(1, (billetes.get(1) + cantidad));
            cantidad -= cantidad;
            
            ret = true;
        }
        
        return ret;
    }

    /**
     * Descompone la cantidad pasada como parámetro en monedas y billetes de 1, 5, 10, 20 y 50€ y los retira de la propiedad “billetes”.
     * @param cantidad dinero retirado a objeto
     * @return false si el objeto no tiene dinero suficiente para retirar cantidad
     */
    @Override
    public boolean retirarDinero(int cantidad) {
        boolean ret;
        if (this.getDineroTotal()<Math.abs(cantidad))
        {
            ret = false;
        }
        else
        {
            cantidad = Math.abs(cantidad);
            
            while (cantidad>0)
            {
            // billetes de 50
                int bil50 = cantidad/50;
                if (bil50 <= billetes.get(50))
                {
                    billetes.put(50,(billetes.get(50) - bil50));                
                }
                else
                {
                    bil50 = bil50 - billetes.get(50);
                    billetes.put(50,0); 
                }            
                cantidad -= 50*bil50;
                
            // billetes de 20
                int bil20 = cantidad/20;
                if (bil20 <= billetes.get(20))
                {
                    billetes.put(20,(billetes.get(20) - bil20));                
                }
                else
                {
                    bil20 = bil20 - billetes.get(20);
                    billetes.put(20,0); 
                }            
                cantidad -= 20*bil20;
                
            // billetes de 10
                int bil10 = cantidad/10;
                if (bil10 <= billetes.get(10))
                {
                    billetes.put(10,(billetes.get(10) - bil10));                
                }
                else
                {
                    bil10 = bil10 - billetes.get(10);
                    billetes.put(10,0); 
                }            
                cantidad -= 10*bil10;
                
            // billetes de 5
                int bil5 = cantidad/5;
                if (bil5 <= billetes.get(5))
                {
                    billetes.put(5,(billetes.get(5) - bil5));                
                }
                else
                {
                    bil5 = bil5 - billetes.get(5);
                    billetes.put(5,0); 
                }            
                cantidad -= 5*bil5;
                
            // monedas de 1
                if (cantidad <= billetes.get(1))
                {                    
                    billetes.put(1,(billetes.get(1) - cantidad));
                    cantidad = 0;
                }
                else
                {
                    if ((cantidad<5)&&(billetes.get(1)==0))
                    {
                        ret = false;
                        break;
                    }
                    else
                    {
                        cantidad = cantidad - billetes.get(1);
                        billetes.put(1,0);                         
                    }
                }
                
            }
            
            ret = true;
        }
        return ret;
    }
    
    /**
     * Devuelve el número de billetes de 50€ que hay en el cajero.
     * @return número de billetes de 50€ disponibles
     */
    public int getTotal50() {
        return this.billetes.get(50);
    }
    
    /**
     * Devuelve el número de billetes de 20€ que hay en el cajero.
     * @return número de billetes de 20€ disponibles
     */
    public int getTotal20() {
        return this.billetes.get(20);
    }
    /**
     * Devuelve el número de billetes de 10€ que hay en el cajero.
     * @return número de billetes de 10€ disponibles
     */
    public int getTotal10() {
        return this.billetes.get(10);
    }
    /**
     * Devuelve el número de billetes de 5€ que hay en el cajero.
     * @return número de billetes de 5€ disponibles
     */
    public int getTotal5() {
        return this.billetes.get(5);
    }
    /**
     * Devuelve el número de monedas de 1€ que hay en el cajero.
     * @return número de monedas de 1€ disponibles
     */
    public int getTotal1() {
        return this.billetes.get(50);
    }
}
