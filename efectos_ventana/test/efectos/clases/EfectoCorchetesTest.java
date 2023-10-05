
package efectos.clases;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la clase EfectoCorchetes
 * @author rperblac
 */
public class EfectoCorchetesTest {

    public EfectoCorchetesTest() {
    }

    @Test
    public void testAplicarEfecto() {
        EfectoCorchetes ec = new EfectoCorchetes();
        String frase = "prueba";
        String resultado = "[prueba]";
        String test1 = ec.aplicarEfecto(frase);
        assertEquals(resultado, test1);
        String test2 = ec.aplicarEfecto(resultado);
        assertEquals(frase, test2);
    }

}