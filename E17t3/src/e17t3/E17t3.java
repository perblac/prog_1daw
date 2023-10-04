package e17t3;

/** Enunciado: Realiza un programa que pregunte por teclado una dirección IP y un número
entero. El programa usará la clase InetAddress para realizar la cantidad de pings indicada a la
dirección IP, midiendo el tiempo empleado en hacer cada uno (clases Instant y Duration), y
mostrará el resultado de esta forma:
 *
 * @author rperblac
 */
import java.util.Scanner;
import java.net.InetAddress;
import java.time.Instant;
import java.time.Duration;

public class E17t3 {
    public static InetAddress pideDireccion(){
        String direccion;  // String para la entrada de ip        
        boolean ipvalida;  // ¿Tenemos ya la dirección?
        InetAddress ip = null;
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
        return ip;
    }
    
    public static int pideVeces(){
        int veces = 1; // Nº de veces = 1 por defecto
        int maxveces = 10; // Máximo numero de pings válido
        boolean vecesvalido = false; // ¿Tenemos un nº de veces valido?
        do
        {
            System.out.println("Escriba nº de veces");            
            
            try
            {
                veces = new Scanner(System.in).nextInt();
                if (veces>0&&veces<=maxveces) vecesvalido = true;
                else System.out.println("Introduzca un número entre 1 y " + maxveces);
            } catch (Exception e)
            {
                System.out.println(e.getLocalizedMessage());
                vecesvalido = false;
            }
            
        } while (!vecesvalido);
        return veces;        
    }

    public static void main(String[] args) {
        Instant ahora,despues;
        boolean test = false;
        int tiempo;
        
        InetAddress direccion = pideDireccion();
        int veces = pideVeces();
        
        System.out.println("Haciendo ping a " + direccion.getHostName()+" ["+direccion.getHostAddress()+"]");
        for (int i = 1; i <= veces; i++)
        {
            test = false;
            ahora = Instant.now();
            try
            {
                test = direccion.isReachable(1000);
                despues = Instant.now();
                tiempo = (int) Duration.between(ahora, despues).toMillis();
                System.out.println(i + ".- " + direccion.getHostAddress() + ": tiempo=" + tiempo + "ms ..." + test);
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    
}
