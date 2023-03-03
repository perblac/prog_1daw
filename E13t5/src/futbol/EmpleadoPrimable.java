
package futbol;

/**
 * Representa un empleado al que se le puede ofrecer una prima por buen rendimiento. Por defecto, ningún empleado está primado.
 * @author rperblac
 */
public class EmpleadoPrimable extends Empleado{
    /**
     * True si el empleado ya ha sido primado
     */
    private boolean primado;
    /**
     * Crea un empleado primable con un nombre y un sueldo
     * @param n nombre del empleado
     * @param s sueldo del empleado
     */
    public EmpleadoPrimable(String n, double s) {
        super(n, s);
        this.primado = false;
    }
    /**
     * Prima al empleado
     */
    public void primar() {
        this.primado = true;
    }
    /**
     * Devuelve true si el empleado ha sido primado
     * @return estado de primado del empleado
     */
    public boolean esPrimado() {
        return this.primado;
    }
}
