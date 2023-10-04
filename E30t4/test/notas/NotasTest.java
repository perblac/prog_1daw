
package notas;

import java.util.OptionalDouble;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class NotasTest {

    public NotasTest() {
    }
    
    @Test
    public void testNotas() {
        Notas n = new Notas();
        assertEquals("notas.Notas", n.getClass().getName());
    }

    @Test
    public void testAñadirNota() {
        Notas n = new Notas();
        Double nota = 10.0;
        n.añadirNota(nota);
        assertEquals(nota, n.calcularNotaMaxima().getAsDouble(),0);
    }

    @Test
    public void testGetTotalNotas() {
        Notas n = new Notas();
        Double nota1 = 10.0;
        Double nota2 = 5.0;
        n.añadirNota(nota1);
        n.añadirNota(nota2);
        assertEquals(2,n.getTotalNotas());
    }

    @Test
    public void testCalcularNotaMedia() {
        Notas n = new Notas();
        Double nota1 = 10.0;
        Double nota2 = 5.0;
        n.añadirNota(nota1);
        n.añadirNota(nota2);
        assertEquals((nota1+nota2)/2,n.calcularNotaMedia().getAsDouble(),0);
        Notas m = new Notas();
        assertEquals(OptionalDouble.empty(), m.calcularNotaMedia());
    }

    @Test
    public void testCalcularNotaMaxima() {
        Notas n = new Notas();
        Double nota1 = 10.0;
        Double nota2 = 5.0;
        n.añadirNota(nota1);
        n.añadirNota(nota2);
        assertEquals(nota1, n.calcularNotaMaxima().getAsDouble(),0);
        Notas m = new Notas();
        assertEquals(OptionalDouble.empty(), m.calcularNotaMaxima());
    }

}