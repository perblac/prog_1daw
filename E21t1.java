/**Enunciado: Un profesor hace un examen en el que la teoría vale un 40% de la nota y los problemas un 60%. En total hay 8 preguntas de teoría (todas valen lo mismo) y 4 problemas (todos valen lo mismo). Un alumno contesta correctamente 6 preguntas de teoría y hace bien 1 problema. Realiza un programa que muestre por pantalla la nota del alumno
 *
 * @author rperblac
 */
public class E21t1 {

    public static void main(String[] args) {
        System.out.println("Nota del alumno: ");
        float teoria= (float) (6.0/8)*10;
        System.out.println("- Teoría (sobre 10):"+teoria);
        float practica= (float) (1.0/4)*10;
        System.out.println("- Práctica (sobre 10):"+practica);
        float total= (float) (teoria*4+practica*6)/10;
        System.out.println("\nTotal 40% teoria y 60% practica: "+total);
    }
    
}
