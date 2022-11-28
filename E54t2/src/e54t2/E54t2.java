package e54t2;

/** Enunciado: Haz un programa que haga esto:
    a) Crea una lista de 10 palabras (las que tú quieras)
    b) Muestra por pantalla la salida del método toString de la lista
    c) Busca en la clase Collections un método que nos ordene la lista y llámalo.
    d) Una vez ordenada, muestra por pantalla la salida del método toString de la lista
 *
 * @author rperblac
 */
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class E54t2 {

    public static void main(String[] args) {
// a) Crea una lista de 10 palabras (las que tú quieras)        
        List<String> lista = new ArrayList();
        lista.add("pepino");
        lista.add("berenjena");
        lista.add("lechuga");
        lista.add("pimiento");
        lista.add("tomate");
        lista.add("maiz");
        lista.add("patata");
        lista.add("rábano");
        lista.add("cebolla");
        lista.add("zanahoria");
// b) Muestra por pantalla la salida del método toString de la lista        
        System.out.println("Lista antes de ordenar: \n" + lista.toString());
// c) Busca en la clase Collections un método que nos ordene la lista y llámalo.
        Collections.sort(lista);
// d) Una vez ordenada, muestra por pantalla la salida del método toString de la lista
        System.out.println("Lista después de ordenar: \n" + lista.toString());
    }
    
}
