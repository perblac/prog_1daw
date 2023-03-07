
package contraseñas;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase GeneradorContraseñasInvertidas
 * @author rperblac
 */
public class GeneradorContraseñasInvertidasTest {

    public GeneradorContraseñasInvertidasTest() {
    }
    
    @Test
    public void testGeneradorContraseñasInvertidas() {
        GeneradorContraseñasInvertidas gci = new GeneradorContraseñasInvertidas();
        assertEquals("contraseñas.GeneradorContraseñasInvertidas", gci.getClass().getName());
    }
    
    @Test
    public void testGeneradorContraseñasInvertidas_Random() {
        Random r = new Random(0);
        Random q = new Random(0);
        int longitud = 8;
        GeneradorContraseñasInvertidas gci = new GeneradorContraseñasInvertidas(q);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < longitud; i++){
            int tipo = r.nextInt(3);
            switch (tipo){
                case 0:
                    s.append((char) (r.nextInt(10)+48));
                    break;
                case 1:
                    s.append((char) (r.nextInt(26)+65));
                    break;
                case 2:
                    s.append((char) (r.nextInt(26)+97));
                    break;
            }            
        }
        String i = "";
        for (char c:s.toString().toCharArray()) {
            if (Character.isLowerCase(c)) c = Character.toUpperCase(c);
            else if (Character.isUpperCase(c)) c = Character.toLowerCase(c);
            i += c;
        }
        String generada = gci.generarContraseña(longitud);
        System.out.println(generada + " : " + s.toString() + " -> " + i);
        assertEquals("contraseñas.GeneradorContraseñasInvertidas", gci.getClass().getName());
        assertEquals(i, generada);
    }

    @Test
    public void testGenerarContraseña_int() {
       int longitud = 15;
       GeneradorContraseñasInvertidas gci = new GeneradorContraseñasInvertidas();
       String c = gci.generarContraseña(longitud);
       System.out.println(c);
       assertEquals(longitud, c.length());
    }

}