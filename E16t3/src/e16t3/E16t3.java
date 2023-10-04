package e16t3;

/** Enunciado: Usa la Consola DAW para realizar un programa que muestre 20 veces por pantalla la frase "En clase no se juega" de forma que las primeras 10 veces aparezcan pegadas a la izquierda y las siguientes 10 veces aparezcan pegadas a la derecha.
 *
 * @author rperblac
 */
import bpc.daw.consola.*;

public class E16t3 {

    public static void main(String[] args) {
        Consola cons = new Consola();
        CapaTexto capat = cons.getCapaTexto();
        Teclado tecl = cons.getTeclado();
        String cadena = "En clase no se juega";
        String numeracion;
        int ancho = capat.getNumeroColumnas();
        int posx;
        int fila;
        int total = 20;
        
        for (int i = 1; i <= total; i++)
        {
            numeracion = "" + i + ") ";
            if (i<=total/2)
            {
                fila = i;
                capat.print(fila,0, numeracion + cadena);
            }
            else
            {
                fila = i-total/2;
                posx = ancho - cadena.length() - numeracion.length();
                capat.print(fila, posx, numeracion + cadena);
            }
        }

        tecl.leerCaracter();
    }

}
