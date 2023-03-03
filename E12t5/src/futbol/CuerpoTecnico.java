
package futbol;

/**
 * Un empleado que tiene asignado un puesto en el equipo, por ejemplo, entrenador de porteros, preparador físico, etc.
 * @author rperblac
 */
public class CuerpoTecnico extends Empleado{
    /**
     * Puesto en el equipo del empleado
     */
    private String puesto;
    /**
     * Crea un empleado del cuerpo tecnico con un nombre, un sueldo y un puesto
     * @param n nombre del empleado
     * @param s sueldo del empleado
     * @param p puesto del empleado
     */
    public CuerpoTecnico(String n, double s, String p) {
        super(n,s);
        this.puesto = p;
    }
    /**
     * Devuelve el puesto del empleado
     * @return puesto del empleado
     */
    public String getPuesto() {
        return this.puesto;
    }
}
