/**Enunciado: Realiza un programa en el que haya una variable que almacena un carácter. El programa deberá mostrar por pantalla si ese carácter corresponde a una letra.
 *
 * @author rperblac
 */
public class E47t1 {

    public static void main(String args[]) {
        char caracter = 83;
        if ((caracter > 64) && (caracter < 123)) {
            System.out.println("El carácter es una letra (" + caracter + ")");
        } else {
            System.out.println("El carácter no es una letra");
        }
    }
}
