package e51t2;

/** Enunciado: Consulta la documentación de la interfaz Set<T> y la clase HashList<T> y haz un programa que las use para crear un conjunto de Strings llamado “mensajes” y haga esto:
    a) Rellene el conjunto con las mensajes: silla, mesa, niño, mesa, casa, silla, lápiz
    b) Muestre por pantalla el tamaño de la lista
    c) Llame al método toString de la lista y muestre por pantalla lo que produce
 *
 * @author rperblac
 */
import java.util.HashSet;

public class E51t2 {
    public static void main(String[] args) {
// Crear un conjunto de Strings llamado “mensajes”
        HashSet<String> mensajes = new HashSet();
        
// a) Rellene el conjunto con las mensajes: silla, mesa, niño, mesa, casa, silla, lápiz
        mensajes.add("silla");
        mensajes.add("mesa");
        mensajes.add("niño");
        mensajes.add("mesa");
        mensajes.add("casa");
        mensajes.add("silla");
        mensajes.add("lápiz");        
        
// b) Muestre por pantalla el tamaño de la lista        
        System.out.println("El tamaño de la lista \"mensajes\" es " + mensajes.size());
        
// c) Llame al método toString de la lista y muestre por pantalla lo que produce        
        System.out.println("El método toString de la lista produce lo siguiente\n" + mensajes.toString());        
    }
    
}
