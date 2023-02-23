
package construccion;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase Edificio
 * @author rperblac
 */
public class EdificioTest {

    public EdificioTest() {
    }
    
    @Test
    public void testEdificio_String_int() {
        String dir = "calle a nº 1";
        int np = 10;
        Edificio e = new Edificio(dir, np);
        assertEquals("construccion.Edificio", e.getClass().getName());
        int np0 = 0;
        try
        {
            Edificio f = new Edificio(dir, np0);
            fail("No se lanzó la excepción esperada");
        } catch (IllegalArgumentException iae)
        {
            System.out.println("Se lanzó la excepción con éxito: " + iae.getMessage());
        }        
    }

    @Test
    public void testGetDireccion() {
        String dir = "calle a nº 1";
        int np = 10;
        Edificio e = new Edificio(dir, np);
        assertEquals(dir, e.getDireccion());
    }

    @Test
    public void testGetNumeroPlantas() {
        String dir = "calle a nº 1";
        int np = 10;
        Edificio e = new Edificio(dir, np);
        assertEquals(np, e.getNumeroPlantas());
    }

}