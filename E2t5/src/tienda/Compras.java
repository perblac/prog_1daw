
package tienda;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa las compras que vamos haciendo, de forma que podemos comprar lo que queramos pero sin pasarnos de un presupuesto.
 * @author rperblac
 */
public class Compras {
    private double presupuesto;
    private List<Double> precios;
    
    public Compras(double presupuesto) {
        if (presupuesto < 0) presupuesto = 0;
        this.presupuesto = presupuesto;
        this.precios = new ArrayList();
    }
    
    public void registrarCompra(double dinero) throws Exception {
        if (this.presupuesto - dinero < 0) throw new Exception ("No hay suficiente presupuesto. Faltan ..." + Math.abs(this.presupuesto - dinero) + " €");
        this.precios.add(dinero);
        this.presupuesto -= dinero;
    }
    
    public double getPresupuesto() {
        return this.presupuesto;
    }
    
    public List<Double> getListaComprado() {
        return precios;
    }
}
