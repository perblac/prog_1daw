/**Enunciado: Una academia contrata al estudiante del ejercicio anterior y le ofrece un sueldo mensual de 200€ fijos más el 15€ mensuales por cada alumno. Supongamos que hay 30 alumnos apuntados en la academia, que van una hora todas las tardes de lunes a viernes y que cada uno paga 100€ al mes. Realiza un programa que calcule:
	a) ¿Cuánto dinero gana el estudiante que da las clases?
	b) ¿Cuánto dinero gana la academia al mes?
 *
 * @author rperblac
 */
public class E19t1 {

    public static void main(String[] args) {
        int pagoalumnos, gananciaestudiante, gananciaacademia;
        pagoalumnos = 30 * 100; // 30 alumnos pagan 100€ cada mes
        gananciaestudiante = 200 + 15 * 30; // 200€ mas 15 por estudiante
        gananciaacademia = pagoalumnos - gananciaestudiante;
        System.out.println("¿Cuánto gana el estudiante? " + gananciaestudiante);
        System.out.println("¿Cuánto gana la academia? " + gananciaacademia);
    }

}
