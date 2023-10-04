/**Enunciado: : En una clase de 26 alumnos ha aprobado el 66% de alumnos, ha suspendido el 19.5% y el resto no se han presentado. Realiza un programa que muestre por pantalla el número de alumnos de cada tipo.
 *
 * @author rperblac
 */
public class E33t1 {
    public static void main(String[] args) {
        int alumnos = 26, aprobados, suspensos, nopresentados;
        aprobados = (int) (alumnos * 66) / 100; //conversion explícita de float (la cuenta) a int
        suspensos = (int) (alumnos * 19.5) / 100;
        nopresentados = alumnos - aprobados - suspensos;
        System.out.println("Total alumnos: " + alumnos + "\nAprobados: " + aprobados + "\nSuspensos: " + suspensos + "\nNo presentados: " + nopresentados);
    }

}
