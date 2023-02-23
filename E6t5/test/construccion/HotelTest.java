
package construccion;

import java.util.NoSuchElementException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase Hotel
 * @author rperblac
 */
public class HotelTest {

    public HotelTest() {
    }
    
    @Test
    public void testHotel_String_int_int() {
        String dir = "calle a nº 1";
        int np = 10;
        int m = 120;
        Hotel h = new Hotel(dir, np, m);
        assertEquals("construccion.Hotel", h.getClass().getName());
        int m0 = -1;
        try
        {
            Hotel h0 = new Hotel(dir, np, m0);
            fail("No se lanzó la excepción esperada");
        } catch (IllegalArgumentException iae)
        {
            System.out.println("Excepción lanzada con éxito: " + iae.getMessage());
        }        
    }

    @Test
    public void testAñadirCliente() {
        String dir = "calle a nº 1";
        int np = 10;
        int m = 120;
        Hotel h = new Hotel(dir, np, m);
        assertEquals(0,h.getNumeroClientes());
        String c = "Paco";
        h.añadirCliente(c);
        assertEquals(1, h.getNumeroClientes());
        int m0 = 0;
        Hotel h0 = new Hotel(dir, np, m0);
        try
        {
            h0.añadirCliente(c);
            fail("No se lanzó la excepción esperada");
        } catch(IllegalStateException iae)
        {
            System.out.println("Excepción lanzada con éxito: " + iae.getMessage());
        }
    }

    @Test
    public void testRetirarCliente() {
        String dir = "calle a nº 1";
        int np = 10;
        int m = 120;
        Hotel h = new Hotel(dir, np, m);
        String c = "Paco";
        h.añadirCliente(c);
        assertEquals(1, h.getNumeroClientes());
        h.retirarCliente(c);
        assertEquals(0,h.getNumeroClientes());
        try
        {
            h.retirarCliente(c);
            fail("No se lanzó la excepción esperada");
        } catch(NoSuchElementException nse)
        {
            System.out.println("Excepción lanzada con éxito: " + nse.getMessage());
        }
    }

    @Test
    public void testGetNumeroClientes() {
        String dir = "calle a nº 1";
        int np = 10;
        int m = 120;
        Hotel h = new Hotel(dir, np, m);
        String c = "Paco";
        h.añadirCliente(c);
        assertEquals(1, h.getNumeroClientes());
        h.retirarCliente(c);
        assertEquals(0,h.getNumeroClientes());
    }

}