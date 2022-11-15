package e27t2;

/**Enunciado: Consulta el pdf de la librería “java net” y busca la clase InetAddress. Realiza un programa que pregunte por teclado al usuario una dirección IP y un número llamado timeout. El ordenador nos indicará si puede hacer ping a la IP indicada, esperando el tiempo que dice la variable timeout.
 *
 * @author rperblac
 */
import java.util.Scanner;
import java.net.InetAddress;

public class E27t2 {
    
// Funcion para contar los "." en la entrada de ip    
    public static int contarCaracteres(String cadena, char caracter) {
        int posicion, contador = 0; //  posición guarda el índice del caracter cada vez que se encuentra, contador cuenta las veces
        posicion = cadena.indexOf(caracter);
        while (posicion != -1) { //mientras se encuentre el caracter
            contador++;           //se cuenta
            posicion = cadena.indexOf(caracter, posicion + 1);
        }
        return contador;
}
    public static void main(String[] args) {
        byte[] ip = new byte[] {0,0,0,0};               // Array para recibir la ip de destino
        String[] iptexto = new String[] {"","","",""};  // Array String para la entrada de la ip
        String direccion;                               // String para la entrada de ip
        int timeout = 0;                                // Variable para el timeout
        int i;                                          // Acumulador
        boolean ipvalida = true;                        // Condición de validez de la ip
        boolean timeoutvalido;                          // Condición de validez del timeout
        
//      Entrada de IP
        do
        {
            System.out.println("Escriba una dirección IP");
            direccion = new Scanner(System.in).next();
            if (contarCaracteres(direccion,'.')!=3) // La cadena introducida debe contener exactamente tres puntos
            {
                System.out.println("Use el formato a.b.c.d");
            }
        } while (contarCaracteres(direccion,'.')!=3);

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
        
        
//      Sacamos trozos del String direccion al array iptexto[]
            iptexto[0] = direccion.substring(0,direccion.indexOf("."));
            direccion = direccion.substring(direccion.indexOf(".")+1);
            iptexto[1] = direccion.substring(0,direccion.indexOf("."));
            direccion = direccion.substring(direccion.indexOf(".")+1);
            iptexto[2] = direccion.substring(0,direccion.indexOf("."));
            direccion = direccion.substring(direccion.indexOf(".")+1);
            iptexto[3] = direccion.substring(0);
            
//      Sacamos bytes del array iptexto[] y los pasamos al array ip[]

/*      for (i=0;i>3;++i)
        {
            try
            {
                ip[i]=Byte.parseByte(iptexto[i]);
            } catch(Exception e)
            {
                System.out.println("El octeto "+iptexto[i]+" no es un valor byte válido");
                ipvalida = false;
            }
        }
*/
        try
            {
                ip[0]=Byte.parseByte(iptexto[0]);
            } catch(Exception e)
                {
                    System.out.println("El octeto "+iptexto[0]+" no es un valor byte válido");
                    ipvalida = false;
                }
        try
            {
                ip[1]=Byte.parseByte(iptexto[1]);
            } catch(Exception e)
                {
                    System.out.println("El octeto "+iptexto[1]+" no es un valor byte válido");
                    ipvalida = false;
                }
                
        try
            {
                ip[2]=Byte.parseByte(iptexto[2]);
            } catch(Exception e)
                {
                    System.out.println("El octeto "+iptexto[2]+" no es un valor byte válido");
                    ipvalida = false;
                }

        try
            {
                ip[3]=Byte.parseByte(iptexto[3]);
            } catch(Exception e)
                {
                    System.out.println("El octeto "+iptexto[3]+" no es un valor byte válido");
                    ipvalida = false;
                }
        
       
//      Comprobamos que cada octeto está en rango
        for (i=0;i>3;i++)
        {
            if ((ip[i]<0)||(ip[i]>254))
            {
                System.out.println("Valor en ip fuera de rango ("+ip[i]+")");
                ipvalida = false;
            }
        }
        
        if (!(ipvalida))
        {
            System.exit(1);
        }
       
        boolean test = false;
        try
        {
                InetAddress ipInet = InetAddress.getByAddress("",ip);
                test = ipInet.isReachable(timeout);
                System.out.println("Haciendo ping a "+ipInet+"..."+test);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    
}
