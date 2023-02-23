
package tienda;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class ComprasTest {

    public ComprasTest() {
    }

    @Test
    public void testRegistrarCompra() throws Exception {
        double presupuesto = 1000;
        double compra = 100;
        Compras c = new Compras(presupuesto);
        c.registrarCompra(compra);
        List<Double> lista = new ArrayList();
        lista.add(compra);
        assertEquals(lista.get(0), c.getListaComprado().get(0));
        assertEquals(presupuesto - compra, c.getPresupuesto(),0);        
    }

    @Test(expected=java.lang.Exception.class)
    public void testRegistrarCompra_error() throws Exception{
        double presupuesto = 1000;
        double compra = 2000;
        Compras c = new Compras(presupuesto);
        c.registrarCompra(compra);            
        fail("No se lanzó la excepción esperada.");
    }
    
    @Test
    public void testGetPresupuesto() {
        double presupuesto = 1000;
        double compra = 100;
        Compras c = new Compras(presupuesto);
        try {
            c.registrarCompra(compra);
        } catch (Exception ex) {
            fail("Se lanzó una excepción que no se debía");
            System.out.println(ex.getMessage());
        }
        assertEquals(presupuesto - compra, c.getPresupuesto(),0);
    }

    @Test
    public void testGetListaComprado() throws Exception {
        double presupuesto = 1000;
        double compra = 100;
        Compras c = new Compras(presupuesto);
        c.registrarCompra(compra);
        c.registrarCompra(compra);
        c.registrarCompra(compra);
        List<Double> lista = new ArrayList();
        lista.add(compra);
        lista.add(compra);
        lista.add(compra);
        assertEquals(lista.get(0), c.getListaComprado().get(0),0);
        assertEquals(lista.get(1), c.getListaComprado().get(1),0);
        assertEquals(lista.get(2), c.getListaComprado().get(2),0);
        assertEquals(presupuesto - (compra * lista.size()), c.getPresupuesto(),0);   
    }

}