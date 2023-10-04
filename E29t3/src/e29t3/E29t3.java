package e29t3;

/** Enunciado: Supongamos que un diccionario español – inglés tiene las palabras de la tabla. Realiza un programa que pregunte por teclado al usuario una palabra en español y nos salga su palabra traducida al inglés.
    hola    casa    caballo hacha   manzana ventana tortuga ratón   mesa
    hello   house   horse   axe     apple   window  turtle  mouse   table
 *
 * @author rperblac
 */
import java.util.Hashtable;
import java.util.Scanner;

public class E29t3 {

    public static void main(String[] args) {
        Hashtable<String, String> diccio = new Hashtable<String, String>();
        diccio.put("hola", "hello");
        diccio.put("casa", "house");
        diccio.put("caballo", "horse");
        diccio.put("hacha", "axe");
        diccio.put("manzana", "apple");
        diccio.put("ventana", "window");
        diccio.put("tortuga", "turtle");
        diccio.put("ratón", "mouse");
        diccio.put("mesa", "table");
        System.out.println("Introduzca palabra");
        String palabra = new Scanner(System.in).next();
        String traducida = diccio.get(palabra);
        if (traducida != null) System.out.println("La palabra " + palabra + " se escribe \"" + traducida +"\" en inglés");
        else System.out.println("La palabra " + palabra + " no está en nuestro diccionario");
        
    }
    
}
