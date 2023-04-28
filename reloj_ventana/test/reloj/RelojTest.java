
package reloj;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class RelojTest {

    public RelojTest() {
    }
    
    @Test
    public void testReloj() {
        Reloj r = new Reloj();
        assertEquals("reloj.Reloj", r.getClass().getName());
    }

    @Test
    public void testAñadir() {
        Reloj r = new Reloj();
        int segundos = 30;
        r.añadir(segundos);
        assertEquals(LocalTime.now().plusSeconds((long)segundos).format(DateTimeFormatter.ofPattern("HH:mm:ss")), r.toString());
    }

    @Test
    public void testEsNoche() {
        Reloj r = new Reloj();
        boolean esnoche = (LocalTime.now().isAfter(LocalTime.of(20,0))||LocalTime.now().isBefore(LocalTime.of(8, 0)));
        assertEquals(esnoche, r.esNoche());
    }

    @Test
    public void testEsperar() {
        int segundos = 3;
        LocalTime ahora, despues;
        Reloj r = new Reloj();
        ahora = LocalTime.now();
        despues = ahora.plusSeconds((long) segundos);
        r.esperar(segundos);
        assertEquals(despues.format(DateTimeFormatter.ofPattern("HH:mm:ss")), r.toString());
    }

    @Test
    public void testToString() {
        Reloj r = new Reloj();
        String ahora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String cadena = r.toString();
        assertEquals(ahora, cadena);
    }

}