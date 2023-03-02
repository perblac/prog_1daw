
package adivinanzas;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase Adivinanza
 * @author rperblac
 */
public class AdivinanzaTest {

    public AdivinanzaTest() {
    }
    
    @Test
    public void testAdivinanza_String_String() {        
        String enunciado = "a";
        String respCorrecta = "b";
        Adivinanza a = new Adivinanza(enunciado, respCorrecta);
        assertEquals("adivinanzas.Adivinanza", a.getClass().getName());
    }

    @Test
    public void testGetEnunciado() {        
        String enunciado = "a";
        String respCorrecta = "b";
        Adivinanza a = new Adivinanza(enunciado, respCorrecta);
        assertEquals(enunciado, a.getEnunciado());
    }

    @Test
    public void testComprobar_correcto() throws Exception {        
        String enunciado = "a";
        String respCorrecta = "b";
        Adivinanza a = new Adivinanza(enunciado, respCorrecta);
        String respuesta = "b";
        System.out.println(a.getEnunciado());
        try
        {
            a.comprobar(respuesta);
        } catch (AdivinanzaException ae)
        {
            fail("Se lanzó una excepción inesperada: " + ae.getMessage());
        }
    }
    
    @Test
    public void testComprobar_tiemposuperado() throws Exception {        
        String enunciado = "a";
        String respCorrecta = "b";
        Adivinanza a = new Adivinanza(enunciado, respCorrecta);
        String respuesta = "b";
        System.out.println(a.getEnunciado());
        try {
            Thread.sleep(30000);
        } catch (Exception ex) {
            fail("Error en la orden sleep del thread");
        }
        try
        {
            a.comprobar(respuesta);
            fail("No se lanzó la excepción esperada");
        } catch (TiempoSuperadoException tse)
        {
            System.out.println("Se lanzó la excepción esperada: " + tse.getMessage());
        }
    }
    
    @Test
    public void testComprobar_incorrecto() throws Exception {        
        String enunciado = "a";
        String respCorrecta = "b";
        Adivinanza a = new Adivinanza(enunciado, respCorrecta);
        String respuesta = "c";
        System.out.println(a.getEnunciado());
        try
        {
            a.comprobar(respuesta);
            fail("No se lanzó la excepción esperada");
        } catch (AdivinanzaIncorrectaException aie)
        {
            System.out.println("Se lanzó la excepción esperada: " + aie.getMessage());
        }
    }

}