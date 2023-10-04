package e5t3;

/** Enunciado: Según el reglamento de la federación de caza, un cazador no puede cazar más piezas de las que se permiten en un día. Queremos hacer un programa que nos lleve la cuenta de piezas cazadas e indique cuando se ha excedido el límite. Para ello primero se leerá por teclado el límite del día y a continuación los valores de las piezas cazadas en el orden que se obtienen. El programa imprimirá un mensaje en el momento en que el límite haya sido excedido. Después de que cada pieza ha sido registrada, el programa mostrará el número total de piezas que se llevan hasta ese momento cazadas.
 *
 * @author rperblac
 */
import java.util.Scanner;
import java.io.IOException;

public class E5t3 {

    public static void main(String[] args) {
        int piezasmax = 1, cazadas = 0, lleva = 0;
        boolean ok = false;
        System.out.print("¿Cuántas piezas se pueden cazar hoy? ");
        do
        {
            try
            {
                piezasmax = new Scanner(System.in).nextInt();
                if (piezasmax > 0) ok = true;
                else System.out.println("Introduzca un número positivo distinto a cero");                
            }
            catch (Exception e)
            {
                System.out.println("Introduzca un numero entero");
            }
            
        } while (!ok);
        System.out.println("--- Empezamos la caza");
        while (lleva<=piezasmax)
        {
            System.out.println("Introduzca el número de piezas cazadas");
            ok = false;
            do
            {
                try
                {
                    cazadas = new Scanner(System.in).nextInt();
                    if (cazadas<0) System.out.println("Introduzca un número positivo");
                    else ok = true;                    
                } catch (Exception e)
                {
                    System.out.println("Introduzca un número entero");
                }
            } while (!ok);
            lleva = lleva + cazadas;
            if (lleva<=piezasmax)
            {
                System.out.println("Usted lleva cazadas " + lleva + " piezas de " + piezasmax + " posibles");
            }
        }
        System.out.println("El número máximo de piezas ha sido excedido\nPulse Enter para finalizar");
        try
        {
            System.in.read();
        }
        catch(IOException e)
        {
            System.out.println(e);
        } 
    }
    
}
