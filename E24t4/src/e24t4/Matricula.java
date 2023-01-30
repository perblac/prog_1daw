
package e24t4;

/**
 * Representa la matrícula de un alumno en una asignatura
 * 
 * @author rperblac
 */
public class Matricula {
    /**
     * Guarda el siguiente número que se usará para matricular a un alumno. El primer número de matrícula disponible es el 1.
     */
    private static int siguienteNumeroMatricula;
    
    /**
     * Número de matrícula del objeto Matricula.
     */
    private int numeroMatricula;
    
    /**
     * Nombre del alumno matriculado.
     */
    private String nombreAlumno;
    
    /**
     * Nombre de la asignatura de la matrícula.
     */
    private String nombreAsignatura;
    static {
        siguienteNumeroMatricula = 1;
    }
    
    /**
     * Crea una matrícula para un alumno en la asignatura indicada.
     * @param nombreAlumno nombre del alumno a matricular
     * @param nombreAsignatura nombre de la asignatura en que se matricula
     */
    public Matricula(String nombreAlumno, String nombreAsignatura) {
        this.numeroMatricula = siguienteNumeroMatricula;
        siguienteNumeroMatricula++;
        this.nombreAlumno = nombreAlumno;
        this.nombreAsignatura = nombreAsignatura;
    }
    
    /**
     * Devuelve el nombre del alumno de una matrícula.
     * @return nombre del alumno matriculado
     */
    public String getNombreAlumno() {
        return this.nombreAlumno;
    }
    
    /**
     * Devuelve el nombre de la asignatura de una matrícula
     * @return nombre de la asignatura de la matrícula
     */
    public String getNombreAsignatura() {
        return this.nombreAsignatura;
    }
    
    /**
     * Devuelve el numero de matrícula de una matrícula
     * @return número de matrícula del objeto Matricula
     */
    public int getNumeroMatrícula() {
        return this.numeroMatricula;
    }
}
