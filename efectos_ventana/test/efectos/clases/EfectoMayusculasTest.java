
package efectos.clases;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la clase EfectoMayusculas
 * 
 * @author rperblac
 */
public class EfectoMayusculasTest {

    public EfectoMayusculasTest() {
    }

    @Test
    public void testAplicarEfecto() {
        EfectoMayusculas em = new EfectoMayusculas();
        String frase = "prueba";
        String resultado = "PRUEBA";
        String test = em.aplicarEfecto(frase);
        assertEquals(resultado, test);
    }

}