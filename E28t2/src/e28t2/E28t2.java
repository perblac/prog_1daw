package e28t2;

/**Enunciado: Usa la clase InetAddress para hacer un programa que pregunte por un nombre de equipo de la red y nos muestre su dirección IP.
 *
 * @author rperblac
 */
import java.net.InetAddress;
import java.util.Scanner;

public class E28t2 {

    public static void main(String[] args) {
        InetAddress direccion = null;       // variable clase InetAddress para la direccion
        String entrada = null, host = null; // Strings: entrada para la entrada del host, host para la direccion del host

        System.out.println("Introduzca host: ");
        entrada = new Scanner(System.in).next();
        try
        {
            direccion = InetAddress.getByName(entrada);
            host = direccion.getHostAddress();                  // una variable InetAddres se compone de {host/ip}. Con esto sacamos la ip
        } catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        if (host!=null)
        {
            System.out.println("IP: "+host);
        }
    }    
}