package e13t2;

/**Enunciado: Consulta el pdf de la “Librería Estándar de Java” y busca la clase String. Haz un programa que pregunte tu nombre por teclado, y el ordenador lo muestre en mayúsculas, minúsculas y diga cuántos caracteres tiene.
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E13t2 {

    public static void main(String[] args) {
        System.out.println("Escribe tu nombre:");
        String nombre = new Scanner(System.in).nextLine();
        System.out.println("Tu nombre en mayúsculas: "+nombre.toUpperCase());
        System.out.println("Tu nombre en minúsculas: "+nombre.toLowerCase());
        System.out.println("Total de caracteres de tu nombre: "+nombre.replaceAll("\s","").length());        
    }
    
}
