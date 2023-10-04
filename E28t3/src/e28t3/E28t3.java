package e28t3;

/**
 * Enunciado: Realiza un programa en el que haya una variable llamada "contraseña" iniciada con el valor que tú quieras. A continuación el programa pedirá al usuario que introduzca la contraseña. El usuario solo tiene 5 intentos para ponerla bien. En caso de que el usuario la acierte, el programa dirá "Acceso permitido". Si se agotan los intentos, se mostrará "Acceso denegado". En todo momento el programa mostrará el número de intentos restantes.
 *
 * @author rperblac
 */

import java.util.Scanner;

public class E28t3 {

    public static void main(String[] args) {
        String contraseña = "123", intento = null;
        int intentos = 0, prueba;
        boolean bien; // ¿Se introdujo un nº de 3 cifras?
        System.out.println ("Introduzca contraseña (3 cifras):");
        while (intentos < 5)
        {
            do // Bucle de entrada
            {
                try
                {
                    intento = new Scanner(System.in).next();
                    prueba = Integer.parseInt(intento);
                    if (intento.length()==3)
                    {
                        if ((!((intento.charAt(0) > 47) && (intento.charAt(0) < 58)))
                        || (!((intento.charAt(1) > 47) && (intento.charAt(1) < 58)))
                        || (!((intento.charAt(2) > 47) && (intento.charAt(2) < 58))))
                        {
                            System.out.println("Introduzca tres cifras");
                            bien = false;
                        }
                        else bien = true;                        
                    }
                    else
                    {
                        System.out.println("Introduzca tres cifras");
                        bien = false;

                    }
                }
                catch (NumberFormatException ime)
                {
                    System.out.println("Introduzca tres cifras");
                    bien = false;
                }
            } while (!bien);
            
            intentos++;
            
            // Chequeo de intentos y contraseña
            if (!(intento.equals(contraseña)))
            {
                System.out.println("Acceso denegado. Le quedan " + (5 - intentos) + " intentos de 5");
                if (intentos == 5)
                {
                    System.out.println("Se terminaron los intentos");
                }
            }
            else
            {
                System.out.println("Acceso permitido. Le quedaban " + (5 - intentos) + " intentos de 5");
                intentos = 5;
            }
        }
    }

}
