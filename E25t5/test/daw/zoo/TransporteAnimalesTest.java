
package daw.zoo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la clase TransporteAnimales
 * @author rperblac
 */
public class TransporteAnimalesTest {
    
    public TransporteAnimalesTest() {
    }

    @Test
    public void testAñadir() {
        // Prueba límite peso 500 kg;
        TransporteAnimales ta = new TransporteAnimales();
        String nombreL = "Leo";
        int pesoL = 100;
        Leon l;
            // 5 animales de 100 kg -> ok
        for (int i = 0; i < 5; i++)
        {
            l = new Leon(nombreL + i, pesoL);
            assertTrue(ta.añadir(l));
        }
            // 1 más -> fail
        l = new Leon(nombreL + 5, pesoL);
        assertFalse(ta.añadir(l));
        
        // Prueba distintos tipos
        TransporteAnimales ta2 = new TransporteAnimales();
        String nombreT = "Tony";
        int pesoT = 90;
        Tigre t = new Tigre(nombreT, pesoT);
            // 1 tigre -> ok
        assertTrue(ta2.añadir(t));
            // + 1 leon -> fail
        assertFalse(ta2.añadir(l));
    }

}