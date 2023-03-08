
package paqueteria;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase Paquete
 * @author rperblac
 */
public class PaqueteTest {
    String producto = "cosa";
    String destino = "una casa";
    int prioridad = Paquete.ALTA;
    Paquete p = new Paquete(producto, destino, prioridad);

    public PaqueteTest() {
    }
    
    @Test
    public void testPaquete_String_String_int() {
        assertEquals("paqueteria.Paquete", p.getClass().getName());
    }

    @Test
    public void testGetProducto() {
        assertEquals(producto, p.getProducto());
    }

    @Test
    public void testGetDireccionDestino() {
        assertEquals(destino, p.getDireccionDestino());
    }

    @Test
    public void testGetPrioridad() {
        assertEquals(prioridad, p.getPrioridad());
    }

    @Test
    public void testEquals() {
        Paquete q = new Paquete(producto, destino, Paquete.BAJA);
        assertTrue(p.equals(q));
    }

    @Test
    public void testHashCode() {
        int i = 3*p.getProducto().hashCode() + 7*p.getDireccionDestino().hashCode() + 11*p.getPrioridad();
        assertEquals(i, p.hashCode());
    }

    @Test
    public void testCompareTo() {
        Paquete q = new Paquete(producto, destino, Paquete.BAJA);
        int dif = -2;
        assertEquals(dif, p.compareTo(q));
    }

}