/**Enunciado: : Realiza un programa que cree una lista de 5 palabras. El programa deberá mostrar por pantalla el número de palabras de la lista, la primera y la última de ellas. El programa deberá estar hecho con fácil mantenimiento (esto es que si ampliamos o disminuimos el número de palabras de la lista no debemos tocar nada más en las restantes líneas del programa).
 *
 * @author rperblac
 */
public class E38t1 {

    public static void main(String[] args) {
        String[] palabras = {"Azul","Morado","Rojo","Naranja","Amarillo","Verde"};
        int totalPalabras = palabras.length;
        System.out.println("Número de palabras: "+totalPalabras);
        System.out.println("Primera palabra: "+palabras[0]);
        System.out.println("Última palabra: "+palabras[totalPalabras-1]);
    }
    
}
