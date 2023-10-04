package e23t2;

/**Enunciado: Haz un programa que cree una tarjeta de crédito con contraseña 2222 y saldo 1000€. Mostrar la información de la cuenta por pantalla. Ingresar 100 € y volver a mostrar la información. Retirar 2800 € de ella y volver a mostrar la información.
 *
 * @author rperblac
 */
import java.util.Scanner;
import bpc.daw.objetos.TarjetaCredito;

public class E23t2 {

    public static void main(String[] args) {
        TarjetaCredito t = new TarjetaCredito(1000,2222);
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

       error = false;
       t.ingresarDinero(100);
       System.out.println("Ingreso de 100€ realizado");

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
       
       System.out.println("Retirada de 2800€");
       
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
           if (t.sacarDinero(2800, clave))
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
