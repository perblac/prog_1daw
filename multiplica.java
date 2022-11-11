/** ejercicio de clase en el que hay que realizar un programa que multiplique dos números enteros pasados como argumentos
 *
 * @author rperblac
 */

public class multiplica {

    public static void main(String args[]) {
        String primero = null, segundo = null, leerprimero;
        boolean multientrada = false;
        int a=0,b=0,i;
        long acumulador = 0;
        
        // Si se ejecuta sin argumentos, escribimos las instrucciones y salimos
        if ((args.length)<1)
        {
            System.out.println("Multiplica. Un programa para multiplicar números.\nUso:\n\tPara dos números -> java multiplica.java [numero1] [numero2]\n\tPara varios numeros -> java multiplica -m [numero1] [numero2] ... [numero x]");
            System.exit(0);
        }
        
        
        leerprimero = args[0];
        if (leerprimero.equals("-m"))
        {
            multientrada = true;
        }
        
        
        if (((args.length)>2)&&(!(multientrada)))
        {
            System.out.println("Introduzca exactamente dos argumentos");
            System.exit(1);
        }
        
        if (!(multientrada))
        {
            try
            {
                primero = args[0];
                segundo = args[1];

            } catch (Exception e)
            {
                System.out.println ("Introduzca como argumentos dos números a multiplicar\nEjemplo: java multiplicar 3 7");
                System.exit(1);
            }
            try
            {
                a = Integer.parseInt(primero);
                b = Integer.parseInt(segundo);

            } catch (Exception e)
            {
                System.out.println("Introduzca exactamente dos valores enteros\nEjemplo: java multiplicar 3 7");
                System.exit(1);
            }
            System.out.println(a + " x " + b + " = " + (a*b));
        }
        else
        {
            if (args.length<3)
            {
                System.out.println("Introduzca al menos dos números");
            } else
            {
                i=1;
                acumulador=1;
                
                while (i<args.length)
                {
                    try
                    {
                        a = Integer.parseInt(args[i]);                       
                    } catch (Exception e)
                    {
                        System.out.println("Error en valores: "+e.getMessage());
                        System.exit(1);
                    }
                    
                    if (i==1)
                    {
                        System.out.print(a);
                    } else
                    {
                        System.out.print(" x " + a);
                    }
                    
                    acumulador = acumulador * a;
                    ++i;
                }
                
                System.out.println(" = " + acumulador);
            }
        }
    }
}
