package e17t2;

/**Enunciado: Como ya sabes, una dirección de correo tiene el formato nombre@dominio. Realiza un programa que pregunte al usuario su nombre y después su dominio. En caso de que el dominio termine en .com o .es, el programa el programa formará una nueva variable llamada “correo” a partir de ellos y la mostrará por pantalla. En caso contrario, mostrará un mensaje de error “El dominio es incorrecto”.
 *
 * @author rperblac
 */
import java.util.Scanner;
public class E17t2 {

    public static void main(String[] args) {
        String nombre, dominio, correo;
        System.out.println("¿Cuál es tu nombre?");
        nombre = new Scanner(System.in).next();
        System.out.println("¿Cuál es tu dominio?");
        dominio = new Scanner(System.in).next();
        if ((dominio.endsWith(".com"))||(dominio.endsWith(".es"))){
        correo = nombre.concat("@");
        correo = correo.concat(dominio);    
        System.out.println("Tu correo es: "+correo);
        } else {
            System.out.println("El dominio es incorrecto");
        }
    }
    
}
