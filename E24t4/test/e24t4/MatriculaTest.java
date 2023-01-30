package e24t4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rperblac
 */
public class MatriculaTest {

    public MatriculaTest() {
    }

    @Test
    public void testGetNombreAlumno() {
        String nombre = "Juan Jiménez Jiménez";
        String asignatura = "Programación";
        Matricula m = new Matricula(nombre, asignatura);
        assertEquals(nombre, m.getNombreAlumno());
    }
    
    @Test
    public void testGetNumeroMatrícula() {
        String nombre = "Beatriz Baños Baños";
        String asignatura = "Programación";
        Matricula m = new Matricula(nombre, asignatura);
        assertEquals(2, m.getNumeroMatrícula());
    }


    @Test
    public void testGetNombreAsignatura() {
        String nombre = "Ana Santos Santos";
        String asignatura = "Programación";
        Matricula m = new Matricula(nombre, asignatura);
        assertEquals(asignatura, m.getNombreAsignatura());
    }

    @Test
    public void testMatricula() {
        String nombre = "Luis Gómez Gómez";
        String asignatura = "Programación";
        Matricula m = new Matricula(nombre, asignatura);
        assertEquals(nombre, m.getNombreAlumno());
        assertEquals(asignatura, m.getNombreAsignatura());
        assertEquals(4, m.getNumeroMatrícula());
    }
}