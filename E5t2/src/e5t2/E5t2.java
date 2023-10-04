package e5t2;

/**Enunciado: Realiza un programa con la librería de Mario Bros en el que haya dos cañones. Haz que el primero dispare dos veces y el segundo tres. Pregunta a los dos cañones cuántas veces han disparado y muestra dichos valores por pantalla.
 *
 * @author rperblac
 */
import bpc.daw.mario.*;

public class E5t2 {

    public static void main(String[] args) {
        Cañon c1 = new Cañon (200, 752);
        Cañon c2 = new Cañon (1300, 752);
        c1.disparar(2000, 752);
        c2.disparar(-100, 752);
        c1.disparar(2000, 702);
        c2.disparar(-100, 702);
        c2.disparar(-100, 652);
        System.out.println("Cañon1 disparó "+c1.getTotalDisparosRealizados()+
                " veces y Cañon2 disparó "+c2.getTotalDisparosRealizados()+" veces");
    }
    
}
