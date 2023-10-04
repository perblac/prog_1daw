
package daw.persona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Una oficina en la que trabajan varias personas
 *
 * @author rperblac
 */
public class Oficina {
    /**
     * Nombre de la oficia
     */
    private String nombre;
    
    /**
     * Lista de trabajadores
     */
    private ArrayList<Persona> trabajadores;
    
    /**
     * Crea una oficina que se llama como indica el nombre recibido, y la lista de trabajadores está vacía.
     * @param nombre nombre de la oficina
     */
    public Oficina(String nombre){
        this.nombre = nombre;
        trabajadores = new ArrayList<Persona>();
    }
    
    /**
     * Crea una oficina que se llama como indica el nombre recibido, y un tipo
     * @param nombre nombre de la oficina
     * @param tipo 0: la lista de trabajadores estará vacía.<br/>
     * 1: la lista de trabajadores solo tiene este trabajador Antonio Pérez Pérez, 11111111H, 900, 28/2/2000.<br/>
     * 2: la lista de trabajadores tendrá al de tipo 1, y también a Luis López López, 22222222J,1000, 10/9/1995.<br/>
     * 3: la lista de trabajadores tendrá a los trabajadores de tipo 2 y a Ana Díaz Díaz. 33333333P, 1200, 21/5/1985
     * 
     * @exception IllegalArgumentException si el valor de tipo no está entre 0 y 3
     */
    public Oficina(String nombre, int tipo) throws IllegalArgumentException{
        this.nombre = nombre;
        if  ((tipo > 3) || (tipo < 0)) throw new IllegalArgumentException("Valor de tipo mayor de 3 o menor de 0");
        else
        {
            if (tipo == 0)
                trabajadores = new ArrayList<>();
            else
            {
                trabajadores = new ArrayList<>();
                switch(tipo)
                {
                    case 3:
                        trabajadores.add(new Persona("Ana Díaz Díaz", 33333333, 'P', 1200, LocalDate.of(1985, 5, 21)));
                    case 2:
                        trabajadores.add(new Persona("Luis López López", 22222222, 'J', 1000, LocalDate.of(1995, 9, 10)));
                    case 1:
                        trabajadores.add(new Persona("Antonio Pérez Pérez", 11111111, 'H', 900, LocalDate.of(2000, 2, 28)));
                        break;
                }
            }
                
        }
    }
    
    /**
     * Crea una oficina llamada “Industrias DAW”, que es de tipo 3.
     */
    public Oficina(){
        this("Industrias DAW", 3);
    }
    
    /**
     * Añade a la oficina el trabajador pasado como parámetro.
     * @param p persona a añadir como empleado
     */
    public void añadirEmpleado(Persona p) {
        this.trabajadores.add(p);
    }
    
    /**
     * Crea una persona con los parámetros recibidos y la añade a la oficina.
     * @param nombre nombre del nuevo empleado
     * @param DNI dni del nuevo empleado
     * @param sueldo sueldo del nuevo empleado
     * @param fechaNac fecha de nacimiento del nuevo empleado
     */
    public void añadirEmpleado(String nombre, String DNI, double sueldo, LocalDate fechaNac) {
        Persona empleado = new Persona(nombre,new DNI(DNI).numero, new DNI(DNI).letra ,sueldo,fechaNac);
        this.trabajadores.add(empleado);
    }
    
    /**
     * Devuelve el nombre de la oficina
     * @return nombre de la oficina
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Devuelve un ArrayList con los trabajadores de la oficina
     * @return lista de trabajadores
     */
    public ArrayList<Persona> getTrabajadores() {
        return this.trabajadores;
    }
    
    /**
     * Devuelve el número de trabajadores que hay en la oficina.
     * @return número de trabajadores de la oficina
     */
    public int getTotalEmpleados() {        
        return this.trabajadores.size();
    }
    
    /**
     * Devuelve el número de trabajadores que son mileuristas.
     * @return número de trabajadores mileuristas
     */
    public int getTotalEmpleadosMileuristas() {
        int r = 0;
        for (Persona p : this.trabajadores)
        {
            if (p.esMileurista()) r++;            
        }
        return r;
    } 
    
    /**
     * Devuelve una lista formada por todos los empleados que son mileuristas.
     * @return lista de los empleados que son mileuristas
     */
    public List<Persona> getMileuristas() {
        List<Persona> lista = new ArrayList();
        for (Persona p : this.trabajadores)
        {
            if (p.esMileurista()) lista.add(p);            
        }
        return lista;
    } 
    
    /**
     * Devuelve true si la persona pasada como parámetro trabaja en la empresa.
     * @param p la persona de la cual queremos comprobar la pertenencia a la empresa
     * @return pertenencia a la empresa de la persona p
     */
    public boolean trabaja(Persona p) {
        boolean trabaja = false;
        for (Persona t:this.trabajadores)
        {
            if ((t.getNombre().equals(p.getNombre()))&&(t.getDNI().numero == p.getDNI().numero)&&(t.getDNI().letra == p.getDNI().letra)) trabaja = true;
        }
        return trabaja;
    } 
    
    /**
     * Hace que todos los empleados cobren su sueldo.
     */
    public void pagarEmpleados() {
        for (Persona p : this.trabajadores)
        {
            p.cobrarSueldo();
        }
    } 
    
    /**
     * Muestra por pantalla un listado con todos los empleados de la empresa. Por cada empleado se mostrará su nombre, su sueldo y si es mileurista.
     */
    public void mostrarInformeEmpleados() {
        System.out.println("Nombre\t\t\tSueldo\tMileurista");
        for (Persona p : this.trabajadores)
        {
            System.out.println(p.getNombre() + (p.getNombre().length()>14?"\t":"\t\t") + p.getSueldo() + "\t" + (p.esMileurista()?"SI":"NO"));
        }
    }
    
    /**
     * Devuelve la media de los sueldos de todos los empleados de la oficina. Si la oficina no tiene empleados el método lanza una excepción.
     * @return la media de los sueldos de los empleados
     * @throws Exception 
     */
    public double getSueldoMedio() throws Exception {
        double sueldomedio = 0;
        if (this.trabajadores.isEmpty())
        {
            Exception e = new Exception("La oficina no tiene trabajadores");
            throw e;
        } else
        {
            for (Persona p : this.trabajadores)
            {
                sueldomedio += p.getSueldo();
            }
            sueldomedio = (double) (sueldomedio / this.trabajadores.size());
        }
        return sueldomedio;
    }

}
