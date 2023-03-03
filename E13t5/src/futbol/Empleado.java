
package futbol;

/**
 * Es un empleado cualquiera del equipo de fútbol.
 * @author rperblac
 */
public class Empleado implements Nombrable{
    /**
     * El nombre del empleado
     */
    private String nombre;
    /**
     * Dinero que gana el empleado
     */
    private double sueldo;
    /**
     * La cantidad de dinero que tiene el empleado en su banco
     */
    private double dinero;
    /**
     * Crea un nuevo empleado con un nombre y un sueldo
     * @param n nombre del empleado
     * @param s suledo del empleado. Será 1 si se introduce 0 o menos
     */
    public Empleado(String n, double s) {
        this.nombre = n;
        s = (s<1)?1:s;
        this.sueldo = s;
        this.dinero = 0;
    }
    /**
     * Devuelve el sueldo del empleado
     * @return sueldo del empleado
     */
    public double getSueldo() {
        return this.sueldo;
    }
    /**
     * Devuelve el dinero que tiene en el banco el empleado
     * @return dinero en el banco
     */
    public double getDinero() {
        return this.dinero;
    }
    /**
     * Ingresa al empleado la cantidad de dinero pasada como parámetro. Si dicha cantidad es menor que su sueldo, la ingresa, y a continuación lanza una CabreoException
     * @param cantidad cantidad a ingresar al empleado. Cantidades negativas se convertirán en 0 automáticamente.
     * @throws CabreoException si la cantidad ingresada es menor que el sueldo del empleado
     */
    public void cobrar(double cantidad) throws CabreoException {
        cantidad = (cantidad<0)?0:cantidad;
        this.dinero += cantidad;
        if ((this instanceof EmpleadoPrimable) && (((EmpleadoPrimable) this).esPrimado()))
        {
            if (cantidad<(this.sueldo + (this.sueldo / 10))) throw new CabreoException("Al empleado " + this.nombre + " no se le han pagado " + ((this.sueldo + (this.sueldo / 10)) - cantidad) + " euros");
        } else
        {
            if (cantidad<this.sueldo) throw new CabreoException("Al empleado " + this.nombre + " no se le han pagado " + (this.sueldo - cantidad) + " euros");            
        }
    }

    /**
     * Devuelve el nombre del empleado
     * @return nombre del empleado
     */
    @Override
    public String getNombre() {
        return this.nombre;
    }
}
