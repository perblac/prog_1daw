/** ejercicio de clase en el que hay que realizar un programa que multiplique números enteros pasados como argumentos
 *
 * @author rperblac
 */

public class multiplicador {

    public static void main(String args[]) {
        int a=0,i;
        long acumulador = 0;
        boolean errorenvalores = false;
        
        // Si se ejecuta sin argumentos, escribimos las instrucciones y salimos
        if ((args.length)<1)
        {
            System.out.println("Multiplicador. Un programa para multiplicar números.\nUso:\n\tjava multiplicador [numero1] [numero2] ... [numero x]");
            System.exit(0);
        }

        if (args.length<2) // Comprobamos que al menos hay dos argumentos
        {
            System.out.println("Introduzca al menos dos números");
        }
        else
        {
            i=0;
            acumulador=1;

            while (i<args.length)
            {
                try
                {
                //  a = Integer.parseInt(args[i+1]);    // Quitar comentario en esta línea para provocar excepción ArrayIndexOutOfBoundsException                 
                    a = Integer.parseInt(args[i]);                       
                } catch (Exception e)
                {
                    System.out.print("\nError en valores: " + e);
                    errorenvalores = true;
                }
                
                
                if (!(errorenvalores))  // Sólo seguimos imprimiendo la multiplicación si no hay error en los valores
                {
                    if (i==0)   // El primer número no lleva signo de multiplicacion delante, los demás sí
                    {
                        System.out.print(a);
                    } else
                    {
                        System.out.print(" x " + a);
                    }
                }

                acumulador = acumulador * a;
                ++i;
            }
            if (errorenvalores) //Si hubo error en los valores salimos sin imprimir el resultado
            {
                System.exit(1);
            }
            
            System.out.println(" = " + acumulador);
        }
    }
}
