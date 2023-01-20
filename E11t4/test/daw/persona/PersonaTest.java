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
        assertEquals(nom, p1.nombre);
        assertEquals(dni1,p1.dni);
        assertEquals(s, p1.sueldo, 0);
        assertEquals(hoy, p1.fechaNacimiento);
    }
    
    @Test
    public void Persona_String_int_char_double_LocalDate() {
        String nom = "Pepe";
        int num = 12345678;
        char letra = 'Z';
        double s = 900;
        LocalDate hoy = LocalDate.now();
        Persona p1 = new Persona(nom, num, letra, s,  hoy);
        assertEquals(nom, p1.nombre);
        assertEquals(num,p1.dni.numero);
        assertEquals(letra,p1.dni.letra);
        assertEquals(s, p1.sueldo, 0);
        assertEquals(hoy, p1.fechaNacimiento);                
    }
    
    @Test
    public void Persona_String_DNI() {
        String nom = "Pepe";
        String dni = "12345678Z";
        DNI dni1 = new DNI(dni);
        LocalDate hace20años = LocalDate.now().minusYears(20);
        double s = 900;
        Persona p1 = new Persona(nom, dni1);
        assertEquals(nom, p1.nombre);
        assertEquals(dni1,p1.dni);
        assertEquals(s, p1.sueldo, 0);
        assertEquals(hace20años, p1.fechaNacimiento);
    }
    
    @Test
    public void Persona_String_int_char() {
        String nom = "Pepe";
        int num = 12345678;
        char letra = 'Z';
        LocalDate hace20años = LocalDate.now().minusYears(20);
        double s = 900;
        Persona p1 = new Persona(nom, num, letra);
        assertEquals(nom, p1.nombre);
        assertEquals(num,p1.dni.numero);
        assertEquals(letra,p1.dni.letra);
        assertEquals(s, p1.sueldo,0);
        assertEquals(hace20años, p1.fechaNacimiento);
    }
    
    @Test
    public void aumentarSueldo() {
        String nom = "Pepe";
        String dni = "12345678Z";
        DNI dni1 = new DNI(dni);
        Persona p1 = new Persona(nom, dni1);
        p1.aumentarSueldo(10);
        assertEquals(990, p1.sueldo,0);
    }
    
    @Test
    public void cobrarSueldo() {
        String nom = "Pepe";
        String dni = "12345678Z";
        DNI dni1 = new DNI(dni);
        Persona p1 = new Persona(nom, dni1);
        p1.cobrarSueldo();
        assertEquals(900, p1.cuenta.saldo);
    }

}