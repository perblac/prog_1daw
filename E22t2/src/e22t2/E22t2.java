package e22t2;

/**Enunciado: En la librería ObjetosSencillos.jar se encuentra la clase TarjetaCrédito. Haz un programa que cree una tarjeta de crédito con contraseña 1111 y saldo 5000€. Mostrar la información de la cuenta por pantalla. Sacar 2000 € y volver a mostrar la información.
 *
 * @author rperblac
 */
import bpc.daw.objetos.TarjetaCredito;
import java.util.Scanner;

public class E22t2 {
   public static void main(String[] args) {
       TarjetaCredito t = new TarjetaCredito(5000,1111);
       int saldo=-1,clave = -1;
       boolean error = false;

       do
       {
           error = false;
           System.out.println("¿Clave?: ");
       try
       {
           clave = new Scanner(System.in).nextInt();
           if ((clave<1000)||(clave>9999))
           {
               throw new Exception();
           }
       }
       catch (Exception e)
       {
           error = true;
           System.out.println("introduzca una clave numérica de cuatro dígitos");
       }
       } while (error);
       
       error= false;
       try
       {
           saldo = t.getSaldo(clave);
       }
       catch (Exception e)
       {
           error = true;
           System.out.println("No se puede mostrar saldo: "+e.getMessage());
       }

       if (!error)
       {
       System.out.println("Saldo: " + saldo + "€");
       }
       
       System.out.println("Retirada de 2000€");

       do
       {
           error = false;
           System.out.println("¿Clave?: ");
       try
       {
           clave = new Scanner(System.in).nextInt();
           if ((clave<1000)||(clave>9999))
           {
               throw new Exception();
           }
       }
       catch (Exception e)
       {
           error = true;
           System.out.println("introduzca una clave numérica de cuatro dígitos");
       }
       } while (error);
       
       error= false;

       try
       {
           if (t.sacarDinero(2000, clave))
           {
               System.out.println("Dinero retirado");
           }
           else
           {
               System.out.println("Saldo insuficiente, no se retiró dinero");
           }
       }
       catch (Exception e)
       {
           error = true;
           System.out.println("No se puede retirar dinero: "+e.getMessage());
       }
       
       try
       {
           saldo = t.getSaldo(clave);
       }
       catch (Exception e)
       {
           error = true;
           System.out.println("No se puede mostrar saldo: "+e.getMessage());
       }

       
       if (!error)
       {
       System.out.println("Saldo: " + saldo + "€");
       }
    }
    
}
