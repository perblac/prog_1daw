
package trabajadores;

import bpc.daw.consola.CapaTexto;
import bpc.daw.consola.Consola;
import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase TecladoConsolaDAR
 * @author rperblac
 */
public class TecladoConsolaDAWTest {
    private Consola c = new Consola();
    private CapaTexto ct = c.getCapaTexto();

    public TecladoConsolaDAWTest() {
    }    

    @Test
    public void testEscribirTexto() {
        TecladoConsolaDAW tcd = new TecladoConsolaDAW(ct);
        String mensaje = "prueba";
        tcd.escribirTexto(mensaje);
        Point p = ct.getPosicionEscritura();
        int x = p.x;
        int xEsperado = 6*ct.getAnchoTexto();
        assertEquals(xEsperado + 1, x);
    }

}