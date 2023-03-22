
package efectos.clases;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la clase EfectoInverso
 * @author rperblac
 */
public class EfectoInversoTest {

    public EfectoInversoTest() {
    }

    @Test
    public void testAplicarEfecto() {
        EfectoInverso ei = new EfectoInverso();
        String frase = "prueba";
        String resultado = "abeurp";
        String test = ei.aplicarEfecto(frase);
        assertEquals(resultado, test);
    }

}