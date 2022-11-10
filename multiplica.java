/**
 *
 * @author rperblac
 */
public class multiplica {

    public static void main(String args[]) {
        String primero = null, segundo = null;
        int a=0,b=0;
        
        try
        {
            primero = args[0];
            segundo = args[1];
            
        } catch (Exception e)
        {
            System.out.println ("Introduzca como argumentos dos números a multiplicar\nEjemplo: java multiplicar 3 7");
            System.exit(0);
        }
        try
        {
            a = Integer.parseInt(primero);
            b = Integer.parseInt(segundo);
            
        } catch (Exception e)
        {
            System.out.println("Introduzca exactamente dos valores enteros\nEjemplo: java multiplicar 3 7");
            System.exit(0);
        }
        System.out.println(a+" x "+b+" = "+(a*b));
    }
}
