package e12t3;

/** Enunciado: Realiza un programa que pida una por una, las notas de los alumnos
comprendidas entre 0 y 10 sin decimales. Cuando el usuario introduzca un -1, se mostrará la
mayor nota, la menor, y la nota media de todos ellos.
 *
 * @author rperblac
 */
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Collections;
import java.util.ArrayList;
import java.lang.Math;

public class E12t3 {
// Rutina para introducir notas    
    public static int pideNota(){
        int nota = -1;
        boolean buenaentrada = false; // ¿Tenemos ya un valor entero entre -1 y 10?
        while (!buenaentrada)
        {
            try
            {
                System.out.println("Introduzca nota: ");
                nota = new Scanner(System.in).nextInt();
                if (nota<(-1)||nota>10) System.out.println("Solo se admiten valores -1 (terminar), o entre 0 y 10");
                else buenaentrada = true;
            } catch (InputMismatchException ime)
            {
                System.out.println("Solo se admiten números enteros");
            }
        }
        return nota;
    }
// Rutina para calcular media    
    public static double media(ArrayList m) {
        double sum = 0;
        for (int i = 0; i < m.size(); i++) {
            sum += (int) m.get(i);
        }
        return sum / m.size();
    }
// Programa principal    
    public static void main(String[] args) {
        System.out.println("NOTAS\n-----"   // Menú
                + "\nVaya introduciendo las notas de una en una"
                + "\nCuando termine introduzca -1"
                + "\n(No se admiten decimales)");
        ArrayList<Integer> listaNotas; // Array para calculo de notas
        listaNotas = new ArrayList<Integer>();
        int notaintroducida; // Variable temporal para la última nota introducida        
        boolean terminar = false; // ¿Hemos terminado?
        
        do
        {
            notaintroducida = pideNota();
            if (notaintroducida == -1) terminar = true;
            else
            {
                listaNotas.add(notaintroducida);
                System.out.println(listaNotas.toString()); // Comentando esta linea quitamos el eco del estado de la lista
            }
        } while (!terminar);
        
        int notaMinima = Collections.min(listaNotas);
        int notaMaxima = Collections.max(listaNotas);
        int notaMedia = (int) Math.round(media(listaNotas));
        System.out.println(listaNotas.toString()+
                "\nNota Máxima : " + notaMaxima +
                "\t Nota Mínima: " + notaMinima +
                "\t\tNota Media : " + notaMedia);
    }
    
}
