package daw.persona;

import java.time.LocalDate;
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
    public void Persona_String_DNI_double_LocalDate() {
        String nom = "Pepe";
        DNI dni1 = new DNI("12345678Z");
        LocalDate hoy = LocalDate.now();
        double s = 100.0;
        Persona p1 = new Persona(nom, dni1, s, hoy);
        assertEquals(nom, p1.getNombre());
        assertEquals(dni1,p1.getDNI());
        assertEquals(s, p1.getSueldo(), 0);
        assertEquals(hoy, p1.getFechaNacimiento());
        assertEquals(0, p1.getCuentaCorriente().saldo);
    }
    
    @Test
    public void Persona_String_int_char_double_LocalDate() {
        String nom = "Pepe";
        int num = 12345678;
        char letra = 'Z';
        double s = 900;
        LocalDate hoy = LocalDate.now();
        Persona p1 = new Persona(nom, num, letra, s,  hoy);
        assertEquals(nom, p1.getNombre());
        assertEquals(num,p1.getDNI().numero);
        assertEquals(letra,p1.getDNI().letra);
        assertEquals(s, p1.getSueldo(), 0);
        assertEquals(hoy, p1.getFechaNacimiento());
        assertEquals(0, p1.getCuentaCorriente().saldo);
    }
    
    @Test
    public void Persona_String_DNI() {
        String nom = "Pepe";
        String dni = "12345678Z";
        DNI dni1 = new DNI(dni);
        LocalDate hace20años = LocalDate.now().minusYears(20);
        double s = 900;
        Persona p1 = new Persona(nom, dni1);
        assertEquals(nom, p1.getNombre());
        assertEquals(dni1,p1.getDNI());
        assertEquals(s, p1.getSueldo(), 0);
        assertEquals(hace20años, p1.getFechaNacimiento());
        assertEquals(0, p1.getCuentaCorriente().saldo);
    }
    
    @Test
    public void Persona_String_int_char() {
        String nom = "Pepe";
        int num = 12345678;
        char letra = 'Z';
        LocalDate hace20años = LocalDate.now().minusYears(20);
        double s = 900;
        Persona p1 = new Persona(nom, num, letra);
        assertEquals(nom, p1.getNombre());
        assertEquals(num,p1.getDNI().numero);
        assertEquals(letra,p1.getDNI().letra);
        assertEquals(s, p1.getSueldo(),0);
        assertEquals(hace20años, p1.getFechaNacimiento());
        assertEquals(0, p1.getCuentaCorriente().saldo);
    }
    
    @Test
    public void aumentarSueldo() {
        String nom = "Pepe";
        String dni = "12345678Z";
        DNI dni1 = new DNI(dni);
        Persona p1 = new Persona(nom, dni1);
        p1.aumentarSueldo(10);
        assertEquals(990, p1.getSueldo(),0);
    }
    
    @Test
    public void cobrarSueldo() {
        String nom = "Pepe";
        String dni = "12345678Z";
        DNI dni1 = new DNI(dni);
        Persona p1 = new Persona(nom, dni1);
        p1.cobrarSueldo();
        assertEquals(900, p1.getCuentaCorriente().saldo);
    }
    
    @Test
    public void esMayorEdad() {
        String nom = "Pepe";
        int num = 12345678;
        char letra = 'Z';
        LocalDate hace20años = LocalDate.now().minusYears(20);
        double s = 900;
        Persona p1 = new Persona(nom, num, letra, s,  hace20años);
        nom = "Mario";
        num = 12345678;
        letra = 'Z';
        hace20años = LocalDate.now().minusYears(17);
        s = 900;
        Persona p2 = new Persona(nom, num, letra, s,  hace20años);
        assertEquals(true, p1.esMayorEdad());
        assertEquals(false, p2.esMayorEdad());
    }
    
    @Test
    public void tieneDinero() {
        String nom = "Pepe";
        int num = 12345678;
        char letra = 'Z';
        LocalDate hace20años = LocalDate.now().minusYears(20);
        double s = 900;
        Persona p1 = new Persona(nom, num, letra, s,  hace20años);
        nom = "Pepe";
        num = 12345678;
        letra = 'Z';
        hace20años = LocalDate.now().minusYears(20);
        s = 900;
        Persona p2 = new Persona(nom, num, letra, s,  hace20años);
        p1.cobrarSueldo();
        assertEquals(true, p1.tieneDinero());
        assertEquals(false, p2.tieneDinero());
    }
    
    @Test
    public void esMileurista() {
        String nom = "Pepe";
        int num = 12345678;
        char letra = 'Z';
        LocalDate hace20años = LocalDate.now().minusYears(20);
        double s = 900;
        Persona p1 = new Persona(nom, num, letra, s,  hace20años);
        nom = "Pepe";
        num = 12345678;
        letra = 'Z';
        hace20años = LocalDate.now().minusYears(20);
        s = 1900;
        Persona p2 = new Persona(nom, num, letra, s,  hace20años);
        assertEquals(true, p1.esMileurista());
        assertEquals(false, p2.esMileurista());
    }

}