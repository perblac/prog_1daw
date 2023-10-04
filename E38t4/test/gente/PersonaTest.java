
package gente;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class PersonaTest {

    public PersonaTest() {
    }
    
    @Test
    public void testPersona_String() {
        Persona p = new Persona("A");
        assertEquals("gente.Persona", p.getClass().getName());
    }

    @Test
    public void testGetNombre() {
        String nombre = "A";
        Persona p = new Persona(nombre);
        assertEquals(nombre, p.getNombre());
    }

    @Test
    public void testGetAltura() {
        for (int i = 0; i < 100; i++)
        {            
            Persona p = new Persona("");
            assertTrue((p.getAltura()>=1.50)&(p.getAltura()<=2.10));
        }
    }

    @Test/*
    public void testCompareTo() {
        Persona p, q;
        p = new Persona("A");
        q = new Persona("B");
        int dif = 0;
        int altA = (int) (p.getAltura()*100);
        int altB = (int) (q.getAltura()*100);
        if (altA>altB)
        {
            dif = altA - altB;
        }
        if (altA<altB)
        {
            dif = (int) -(altB - altA);
        }
        assertEquals(dif, p.compareTo(q));
    }*/
    public void testCompareTo() {
        Persona p, q;
        p = new Persona("A");
        q = new Persona("B");
        assertEquals(-1, p.compareTo(q));
        assertEquals(1, q.compareTo(p));
        assertEquals(0, p.compareTo(p));
    }

}