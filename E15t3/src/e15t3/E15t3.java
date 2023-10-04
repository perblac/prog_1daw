package e15t3;

/** Enunciado: Usa la Consola DAW para realizar un programa que muestre 20 veces por pantalla la frase "En clase no se juega" cada una en renglón diferente. Las veces impares se alinearán a la izquierda y las pares a la derecha.
 *
 * @author rperblac
 */
import bpc.daw.consola.Consola;
import bpc.daw.consola.CapaTexto;
import bpc.daw.consola.Teclado;

public class E15t3 {

    public static void main(String[] args) {
        Consola cons = new Consola();
        CapaTexto capat = cons.getCapaTexto();
        Teclado tecl = cons.getTeclado();
        String cadena = "En clase no se juega";
        String numeracion;
        int ancho = capat.getNumeroColumnas();
        int posx;
        int fila;
        
        for (int i = 1; i <= 20; i++)
        {
            fila = i;
            numeracion = "" + i + ") ";
            posx = ancho - cadena.length() - numeracion.length();
            if (i % 2 == 0) capat.print(fila, posx, numeracion + cadena);
            else capat.print(fila,0, numeracion + cadena);
        }
        tecl.leerCaracter();
    }
    
}
