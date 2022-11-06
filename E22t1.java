/**Enunciado: Un profesor realiza un test a sus alumnos. El test tiene 30 preguntas (todas las preguntas valen lo mismo) con cuatro opciones cada una. Se supone que tres preguntas falladas te quitan una bien. Las preguntas sin contestar no quitan puntos. Realiza un programa que calcule y muestre por pantalla la nota de un alumno que tiene 22 preguntas bien, 6 mal y 2 sin contestar.
 *
 * @author rperblac
 */
public class E22t1 {

    public static void main(String[] args) {
        float bien = 22, mal = (6 / 3) * -1;
        float nota = ((bien + mal)/30)*10;
        System.out.println("Nota: " + nota);
    }

}
