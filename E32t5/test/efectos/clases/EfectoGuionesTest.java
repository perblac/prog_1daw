
package efectos.clases;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test de la clase EfectoGuiones
 * @author rperblac
 */
public class EfectoGuionesTest {

    public EfectoGuionesTest() {
    }

    @Test
    public void testAplicarEfecto() {
        EfectoGuiones eg = new EfectoGuiones();
        String frase = "p r u e b a";
        String resultado = "p_r_u_e_b_a";
        String test = eg.aplicarEfecto(frase);
        assertEquals(resultado, test);
    }

}