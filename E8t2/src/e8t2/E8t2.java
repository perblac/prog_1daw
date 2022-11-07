package e8t2;

/**Enunciado: Haz un programa en el que haya dos depósitos de agua de capacidad máxima 20 litros y con capacidades iniciales 15 y 5 litros respectivamente. Retira del primero cinco litros de agua y añádelos al segundo. Dibuja los depósitos antes y después de la operación.
 *
 * @author rperblac
 */
import bpc.daw.objetos.*;

public class E8t2 {

    public static void main(String[] args) {
        int maxcap = 20, capini1 = 15, capini2 = 5, trasvase = 5,i;
        DepositoAgua a = new DepositoAgua(capini1,maxcap);
        DepositoAgua b = new DepositoAgua(capini2,maxcap);
        a.dibujar();
        b.dibujar();
        for (i=0;i<trasvase;i++)
        {
            a.retirarLitro();
            b.añadirLitro();
        }
        a.dibujar();
        b.dibujar();        
    }
    
}
