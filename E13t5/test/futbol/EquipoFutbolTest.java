
package futbol;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de la clase EquipoFutbol
 * @author rperblac
 */
public class EquipoFutbolTest {
    String nombreEquipo = "Daw";
    double presupuesto = 100000;
    EquipoFutbol equipo = new EquipoFutbol(nombreEquipo, presupuesto);
    double sueldo = 1400;
    String nomEntrenador = "Paco";
    Entrenador ent = new Entrenador(nomEntrenador, sueldo);
    String nomFutbolista1 = "Romario";
    String nomFutbolista2 = "Pelé";
    String nomFutbolista3 = "Leo";
    Futbolista f1 = new Futbolista(nomFutbolista1, sueldo, 9);
    Futbolista f2 = new Futbolista(nomFutbolista2, sueldo, 11);
    Futbolista f3 = new Futbolista(nomFutbolista3, sueldo, 10);
    String nomCuerpoTecnico = "Antonio";
    String puesto = "Preparador físico";
    CuerpoTecnico ct = new CuerpoTecnico(nomCuerpoTecnico, sueldo, puesto);
    
    @org.junit.Before
    public void preparacion() {
        f3.primar();
        equipo.addEmpleado(ent);
        equipo.addEmpleado(f1);
        equipo.addEmpleado(f2);
        equipo.addEmpleado(f3);
        equipo.addEmpleado(ct);
    }

    public EquipoFutbolTest() {
    }
    
    @Test
    public void testEquipoFutbol_String_double() {
        assertEquals("futbol.EquipoFutbol", equipo.getClass().getName());
    }

    @Test
    public void testGetEmpleados() {
        int empleados = 0;
        for (Empleado a:equipo.getEmpleados())
        {
            empleados++;
        }
        assertEquals(empleados, equipo.getEmpleados().size());
    }

    @Test
    public void testGetPresupuesto() {
        assertEquals(presupuesto, equipo.getPresupuesto(), 0);
    }

    @Test
    public void testAddEmpleado() {
        String nomFutbolista4 = "Angel";
        Futbolista f4 = new Futbolista(nomFutbolista4, sueldo, 8);
        equipo.addEmpleado(f4);
        assertTrue(equipo.getEmpleados().contains(f4));
    }
    
    @Test
    public void testAddEmpleado_ExcepcionJugadores() {
        String nombreEquipo = "Daw2";
        double presupuesto = 100000;
        EquipoFutbol equipo2 = new EquipoFutbol(nombreEquipo, presupuesto);
        String nomFutbolista5 = "Foobar";
        Futbolista f5 = new Futbolista(nomFutbolista5, sueldo, 25);
        for (int i = 0; i < 25; i++)
        {
            equipo2.addEmpleado(f5);
        }
        try
        {
            equipo2.addEmpleado(f5);
            fail("No se lanzó la excepción esperada");
        } catch(IllegalArgumentException iae)
        {
            if (iae.getMessage().contains("Se alcanzó el máximo número de jugadores en plantilla"))
            {
                System.out.println(iae.getMessage());                
            }
            else fail("Se lanzó una excepción distinta a la esperada. (Se lanzó: " + iae.getMessage() + ")");
        }
    }
    
    @Test
    public void testAddEmpleado_ExcepcionEntrenador() {
        String nombreEquipo = "Daw3";
        double presupuesto = 100000;
        EquipoFutbol equipo3 = new EquipoFutbol(nombreEquipo, presupuesto);
        String entrenador = "Foobar";
        double sueldo2 = 1400;
        Entrenador ent2 = new Entrenador(entrenador, sueldo2);
        equipo3.addEmpleado(ent2);
        try
        {
            equipo3.addEmpleado(ent2);
            fail("No se lanzó la excepción esperada");
        } catch(IllegalArgumentException iae)
        {
            if (iae.getMessage().contains("El equipo no puede tener más de un entrenador."))
            {
                System.out.println(iae.getMessage());                
            }
            else fail("Se lanzó una excepción distinta a la esperada. (Se lanzó: " + iae.getMessage() + ")");
        }
    }

    @Test
    public void testPagarSueldoEmpleados_correcto() {
        double saldorestante = 0;
        double apagar = 0;
        for (Empleado e:equipo.getEmpleados())
            {
                if ((e instanceof EmpleadoPrimable)&&(((EmpleadoPrimable) e).esPrimado())) {                    
                    apagar += e.getSueldo() + (e.getSueldo() / 10);                    
                }
                else
                {   
                    apagar += e.getSueldo();                                       
                }
            }
        saldorestante = equipo.getPresupuesto() - apagar;
        equipo.pagarSueldoEmpleados();
        assertEquals(saldorestante, equipo.getPresupuesto(), 0);
    }
    
    @Test
    public void testPagarSueldoEmpleados_nohaypresupuesto() {
        String nombreEquipo2 = "Daw4";
        double presupuesto2 = 5000;
        EquipoFutbol equipo4 = new EquipoFutbol(nombreEquipo2, presupuesto2);
        double sueldo2 = 1400;
        String nomEntrenador2 = "Paco";
        Entrenador ent2 = new Entrenador(nomEntrenador2, sueldo2);
        String nomFutbolista4 = "Romario";
        String nomFutbolista5 = "Pelé";
        String nomFutbolista6 = "Leo";
        Futbolista f4 = new Futbolista(nomFutbolista4, sueldo2, 9);
        Futbolista f5 = new Futbolista(nomFutbolista5, sueldo2, 11);
        Futbolista f6 = new Futbolista(nomFutbolista6, sueldo2, 10);
        f6.primar();
        equipo4.addEmpleado(ent2);
        equipo4.addEmpleado(f4);
        equipo4.addEmpleado(f5);
        equipo4.addEmpleado(f6);
        double presInicial = equipo4.getPresupuesto();
        equipo4.pagarSueldoEmpleados();
        assertTrue(presInicial > equipo4.getPresupuesto());
    }

    @Test
    public void testGetNombre() {
        assertEquals(nombreEquipo, equipo.getNombre());
    }

}