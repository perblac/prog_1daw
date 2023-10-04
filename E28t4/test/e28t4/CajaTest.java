package e28t4;

import e28t4.Caja;
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
        assertEquals(null, a1.getMensaje());
        assertEquals(false,a1.getAbierto());
        a1.abrir();
        assertEquals("prueba1", a1.getMensaje());
    }
    
    /**
     * Prueba el constructor con estado y mensaje
     */
    @Test
    public void testConstructorBooleanString() {
        Caja a2 = new Caja(true, "prueba2");
        assertEquals("prueba2", a2.getMensaje());
        assertEquals(true,a2.getAbierto());
    }
    
    /**
     * Prueba el constructor por defecto
     */
    @Test
    public void testConstructor() {
        Caja a3 = new Caja();
        assertEquals(null, a3.getMensaje());
        assertEquals(false,a3.getAbierto());
        a3.abrir();
        assertEquals("Viva el tema 7", a3.getMensaje());
    }
    
    /**
     * Prueba el método setMensaje(String m)
     */
    @Test
    public void testsetMensaje() {
        Caja a4 = new Caja();
        Caja a5 = new Caja();
        String nuevomensaje = "prueba";
        a4.abrir();
        a4.setMensaje(nuevomensaje);
        a5.setMensaje(nuevomensaje);
        assertEquals(nuevomensaje, a4.getMensaje());
        assertEquals(null, a5.getMensaje());
        a5.abrir();
        assertEquals("Viva el tema 7", a5.getMensaje());
    }
    
    /**
     * Prueba el método pasarMayusculas()
     */
    @Test
    public void testpasarMayusculas() {
        Caja a6 = new Caja();
        String mays = "VIVA EL TEMA 7";
        a6.pasarMayusculas();
        assertEquals(null, a6.getMensaje());
        a6.abrir();
        assertEquals(mays, a6.getMensaje());
    }
}
