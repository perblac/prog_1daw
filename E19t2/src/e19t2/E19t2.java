package e19t2;

/**Enunciado: Consulta el pdf de la librería “java io” y encuentra la clase File. Realiza un programa que pregunte al usuario por teclado la ruta de un archivo. El programa deberá decir cuántos bytes y cuántos megabytes ocupa en el disco duro.
 *
 * @author rperblac
 */
import java.util.Scanner;
import java.io.*;
public class E19t2 {

    public static void main(String[] args) {
        System.out.println("Introduzca ruta de archivo: ");
        String ruta = new Scanner(System.in).next();
        int tamaño = (int) new File(ruta).length();
        System.out.println("Bytes: " + tamaño+ "\nMBs: "+((tamaño/1024.0)/1024.0));
    }
    
}
