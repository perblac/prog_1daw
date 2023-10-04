package e50t2;

/** Enunciado: Consulta la documentación de la interfaz List<T> y la clase ArrayList<T> y haz un programa que las use para crear una lista de Strings llamada “mensajes” y haga estas acciones:
    a) Rellene la lista con 5 palabras (las que tú quieras)
    b) Muestre por pantalla el tamaño de la lista
    c) Muestre por pantalla la palabra de la posición 3 de la lista.
    d) Llame al método toString de la lista y muestre por pantalla lo que produce
    e) Elimine el primer dato de la lista
    f) Muestre el tamaño de la lista
    g) Muestre por pantalla la palabra de la posición 3 de la lista
    h) Llame al método toString de la lista y muestre por pantalla lo que produce
 *
 * @author rperblac
 */
import java.util.ArrayList;

public class E50t2 {

    public static void main(String[] args) {
// crear una lista de Strings llamada “mensajes”        
        ArrayList<String> mensajes = new ArrayList();
        
// a) Rellene la lista con 5 palabras (las que tú quieras)        
        mensajes.add("pétalo");
        mensajes.add("sépalo");
        mensajes.add("estambre");
        mensajes.add("pistilo");
        mensajes.add("cáliz");
        
// b) Muestre por pantalla el tamaño de la lista
        System.out.println("La lista \"mensajes\" tiene " + mensajes.size() + " elementos");
        
// c) Muestre por pantalla la palabra de la posición 3 de la lista.
        System.out.println("En la posición 3 está el elemento \"" + mensajes.get(2) + "\"");

// d) Llame al método toString de la lista y muestre por pantalla lo que produce
        System.out.println("El método .toString de la lista produce lo siguiente:\n" + mensajes.toString());
        
// e) Elimine el primer dato de la lista        
        mensajes.remove(0);
        
// f) Muestre el tamaño de la lista        
        System.out.println("Después de eliminar el primer dato, la lista \"mensajes\" tiene " + mensajes.size() + " elementos");
        
// g) Muestre por pantalla la palabra de la posición 3 de la lista        
        System.out.println("Ahora, en la posición 3 está el elemento \"" + mensajes.get(2) + "\"");
        
// h) Llame al método toString de la lista y muestre por pantalla lo que produce        
        System.out.println("Ahora, el método .toString de la lista produce lo siguiente:\n" + mensajes.toString());
    }
    
}
