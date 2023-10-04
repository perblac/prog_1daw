package e27t2;

/**Enunciado: Consulta el pdf de la librería “java net” y busca la clase InetAddress. Realiza un programa que pregunte por teclado al usuario una dirección IP y un número llamado timeout. El ordenador nos indicará si puede hacer ping a la IP indicada, esperando el tiempo que dice la variable timeout.
 *
 * @author rperblac
 */
import java.util.Scanner;
import java.net.InetAddress;

public class E27t2 {
    
    public static void main(String[] args) {
        String direccion;                               // String para la entrada de ip
        int timeout = 0;                                // Variable para el timeout
        boolean ipvalida;                               // Condición de validez de la ip
        boolean timeoutvalido;                          // Condición de validez del timeout
        InetAddress ip = null;                          // variable ip de clase InetAddress
        
//      Entrada de IP
        do
        {
            System.out.println("Escriba una dirección IP");
            direccion = new Scanner(System.in).next();
            ipvalida = true;
            try
            {
                ip = InetAddress.getByName(direccion);
            } catch (Exception e)
            {
                System.out.println(e.getLocalizedMessage());
                ipvalida = false;
            }
        } while (!(ipvalida));
        
//      Entrada de timeout        
        do
        {
            timeoutvalido = true;
            System.out .println("Escriba el timeout (en milisegundos)");
            try
            {
                timeout = new Scanner(System.in).nextInt();
            } catch (Exception e)
            {
                System.out.println("Introduzca un valor entero válido");
                timeoutvalido = false;
            }
            
            if ((timeout<0)&&(timeoutvalido)) // El timeout debe ser positivo
            {
                System.out.println("Introduzca un valor positivo");
                timeoutvalido = false;
            }
            
        } while (!(timeoutvalido));

// Ejecución del 'ping'        
        boolean test = false;
        try
        {
                test = ip.isReachable(timeout);
                System.out.println("Haciendo ping a "+ip+"..."+test);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    
}