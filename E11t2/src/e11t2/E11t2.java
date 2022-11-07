package e11t2;

/**Enunciado: Haz otro programa que cree dos cajas, cada una con un mensaje diferente. Hacer un programa que intercambie los mensajes de las dos cajas.
 *
 * @author rperblac
 */
import bpc.daw.objetos.*;

public class E11t2 {
    static void imprime(String temp1,String temp2)
    {
        System.out.println("Caja1: "+temp1+", Caja2: "+temp2);    
    }
    
    public static void main(String[] args) {
        String temp1, temp2, cadena1 = "Mensaje de la primera caja", cadena2 = "Mensaje de la segunda caja";
        Caja c1= new Caja(cadena1);
        Caja c2= new Caja(cadena2);
        c1.abrirCaja();
        c2.abrirCaja();        
        temp1 = c1.getMensaje();
        temp2 = c2.getMensaje();
        imprime(temp1,temp2);
        System.out.println("\n> CAMBIO >\n");
        c1.cambiarMensaje(temp2);
        c2.cambiarMensaje(temp1);
        temp1 = c1.getMensaje();
        temp2 = c2.getMensaje();
        imprime(temp1,temp2);
    }
    
}
