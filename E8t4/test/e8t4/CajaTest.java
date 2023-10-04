package e8t4;

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
    
    /**
     * Prueba el método setMensaje(String m)
     */
    @Test
    public void testsetMensaje() {
        Caja a4 = new Caja();
        Caja a5 = new Caja();
        String nuevomensaje = "prueba";
        a4.abierto = true;
        a4.setMensaje(nuevomensaje);
        a5.setMensaje(nuevomensaje);
        assertEquals(nuevomensaje, a4.mensaje);
        assertEquals("Viva el tema 7", a5.mensaje);
    }
    
    /**
     * Prueba el método pasarMayusculas()
     */
    @Test
    public void testpasarMayusculas() {
        Caja a6 = new Caja();
        String mays = "VIVA EL TEMA 7";
        a6.pasarMayusculas();
        assertEquals(mays, a6.mensaje);
    }
}
