
package trabajadores;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase Programador
 * @author rperblac
 */
public class ProgramadorTest {
    
    String nombre = "Paco";
    int sueldo = 1000;
    int numDNI = 12345678;
    char letraDNI = 'Z';
    int ppm = 150;
    Teclado tj = new TecladoJava();
    Programador p = new Programador(nombre, sueldo, numDNI, letraDNI, ppm);

    public ProgramadorTest() {
    }
    
    @Test
    public void testProgramador_String_int_int_char_int() {
        assertEquals("trabajadores.Programador", p.getClass().getName());        
    }

    @Test
    public void testAprenderLenguaje() {
        String lenguaje = "Java";
        String holaMundoJava = "System.out.println(\"Hola Mundo!\");";
        p.aprenderLenguaje(lenguaje, holaMundoJava);
        assertEquals(holaMundoJava, p.programarHolaMundo(lenguaje));
    }

    @Test
    public void testProgramarHolaMundo() {
        String lenguajeJ = "Java";
        String lenguajeC = "C++";
        String holaMundoJava = "System.out.println(\"Hola Mundo!\");";
        p.aprenderLenguaje(lenguajeJ, holaMundoJava);
        assertEquals(holaMundoJava, p.programarHolaMundo(lenguajeJ));
        try {
            String holaMundoC = p.programarHolaMundo(lenguajeC);
            fail("No se lanzó la excepción esperada");
        } catch (IllegalStateException ise)
        {
            System.out.println("Se capturó con éxito la excepción esperada: " + ise.getMessage());
        }
    }
}