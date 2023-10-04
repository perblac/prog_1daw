package e2t4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class CajaTest {
    /**
     * Tests para la clase Caja
     */
    public CajaTest() {
    }

    /**
     * Prueba el constructor con mensaje
     */
    @Test
    public void testConstructorString() {
        Caja a1 = new Caja("prueba1");
        assertEquals("prueba1", a1.mensaje);
        assertEquals(false,a1.abierto);
    }
    
    /**
     * Prueba el constructor con estado y mensaje
     */
    @Test
    public void testConstructorBooleanString() {
        Caja a2 = new Caja(true, "prueba2");
        assertEquals("prueba2", a2.mensaje);
        assertEquals(true,a2.abierto);
    }
    
    /**
     * Prueba el constructor por defecto
     */
    @Test
    public void testConstructor() {
        Caja a3 = new Caja();
        assertEquals("Viva el tema 7", a3.mensaje);
        assertEquals(false,a3.abierto);
    }
    
}
