
package futbol;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un equipo de fútbol.
 * @author rperblac
 */
public class EquipoFutbol implements Nombrable{
    /**
     * El nombre del equipo de fútbol
     */
    private String nombre;
    /**
     * Una lista con todos los empleados del equipo. Inicialmente el equipo se crea sin empleados.
     */
    private List<Empleado> empleados;
    /**
     * El total de dinero disponible en el equipo, del que deberá pagarse a los jugadores.
     */
    private double presupuesto;
    /**
     * Crea un equipo de fútbol con un nombre y un presupuesto, inicialmente sin empleados.
     * @param n nombre del equipo
     * @param p presupuesto del equipo
     */
    public EquipoFutbol(String n, double p) {
        this.nombre = n;
        this.presupuesto = p;
        this.empleados = new ArrayList<>();
    }
    /**
     * Devuelve un array con la lista de empleados del equipo
     * @return lista de empleados
     */
    public List<Empleado> getEmpleados() {
        return this.empleados;
    }
    /**
     * Devuelve el presupuesto del que dispone el equipo
     * @return presupuesto del equipo
     */
    public double getPresupuesto() {
        return this.presupuesto;
    }
    /**
     * Añade un empleado al equipo. Solo debe haber un entrenador, por lo que si
     * se intenta añadir más de un entrenador, se lanzará una
     * IllegalArgumentException. De igual forma, solo se admiten hasta 25
     * jugadores en plantilla.
     *
     * @param e empleado a añadir al equipo
     */
    public void addEmpleado(Empleado e) throws IllegalArgumentException{
        // Máximo de jugadores en plantilla
        int maxJugadores = 25;
        if (e instanceof Entrenador)
        {
            int numEntrenadores = 0;
            Empleado entrenador = null;
            for (Empleado a:this.empleados)
            {
                if (a instanceof Entrenador) {
                    numEntrenadores++;
                    entrenador = a;
                }
            }
            if (numEntrenadores > 0) throw new IllegalArgumentException("El equipo no puede tener más de un entrenador. El entrenador actual es " + entrenador.getNombre());
            else this.empleados.add(e);
        } else
        if (e instanceof Futbolista)
        {
            int numJugadores = 0;
            for (Empleado a:this.empleados)
            {
                if (a instanceof Futbolista) {
                    numJugadores++;
                }
            }
            if (numJugadores >= maxJugadores) throw new IllegalArgumentException("Se alcanzó el máximo número de jugadores en plantilla (" + maxJugadores + ")");
            else this.empleados.add(e);
        } else
        {
            this.empleados.add(e);
        }
    }
    /**
     * Paga a cada empleado el sueldo pasado como parámetro y lo retira del
     * presupuesto. Hay que tener en cuenta que a los empleados primados se les
     * deberá pagar un 10% más de su sueldo. Si no hay presupuesto suficiente
     * para pagar a un empleado, se dividirá el presupuesto restante entre el
     * número de jugadores que falten por pagar, y se les abonará dicha
     * cantidad. Se mostrará por pantalla el mensaje devuelto por la excepción
     * correspondiente.
     */
    public void pagarSueldoEmpleados() {
        
        double abonos = 0; // Cantidad a pagar en sueldos
        
        for (Empleado e:this.empleados)
        {
            if (e instanceof EmpleadoPrimable) 
            {
                abonos += (((EmpleadoPrimable) e).esPrimado())?
                        (e.getSueldo() + (e.getSueldo()/10))
                        :e.getSueldo();
            } else
            {
                abonos += e.getSueldo();
            }
        }
        
        if (abonos > this.presupuesto)
        {
            double paga = this.presupuesto / this.empleados.size();
            double pagado = 0;
            for (Empleado e:this.empleados)
            {
                if ((e instanceof EmpleadoPrimable)&&(((EmpleadoPrimable) e).esPrimado())) {
                    if ((e.getSueldo() + (e.getSueldo() / 10)) > paga)
                    {
                        try {
                            e.cobrar(paga);
                        } catch (CabreoException ce) {
                            System.out.println(ce.getMessage());
                        }
                        pagado += paga;
                    }
                    else
                    {
                        try {
                            e.cobrar(e.getSueldo() + (e.getSueldo() / 10));
                        } catch (CabreoException ce) {
                            System.out.println(ce.getMessage());
                        }
                        pagado += e.getSueldo() + (e.getSueldo() / 10);
                    }
                }
                else
                {
                    if (e.getSueldo() > paga)
                    {
                        try {
                            e.cobrar(paga);
                        } catch (CabreoException ce) {
                            System.out.println(ce.getMessage());
                        }
                        pagado += paga;
                    }
                    else
                    {
                        try {
                            e.cobrar(e.getSueldo());
                        } catch (CabreoException ce) {
                            System.out.println(ce.getMessage());
                        }
                        pagado += e.getSueldo();
                    }                    
                }
            }
            System.out.println("Total pagado: " + pagado);
            this.presupuesto -= pagado;
            System.out.println("Presupuesto restante: " + this.presupuesto);
        }
        else
        {
            double pagado = 0;
            for (Empleado e:this.empleados)
            {
                if ((e instanceof EmpleadoPrimable)&&(((EmpleadoPrimable) e).esPrimado())) {                    
                    try {
                        e.cobrar(e.getSueldo() + (e.getSueldo() / 10));
                    } catch (CabreoException ce) {
                        System.out.println(ce.getMessage());
                    }
                    pagado += e.getSueldo() + (e.getSueldo() / 10);                    
                }
                else
                {                    
                    try {
                        e.cobrar(e.getSueldo());
                    } catch (CabreoException ce) {
                        System.out.println(ce.getMessage());
                    }
                    pagado += e.getSueldo();                                       
                }
            }
            System.out.println("Total pagado: " + pagado);
            this.presupuesto -= pagado;
            System.out.println("Presupuesto restante: " + this.presupuesto);            
        }
    }

    /**
     * Devuelve el nombre del equipo
     * @return nombre del equipo
     */
    @Override
    public String getNombre() {
        return this.nombre;
    }
}
