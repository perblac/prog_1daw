package e36t3;
/** Enunciado: Realiza un programa que pregunte al usuario una cadena de caracteres con su
NIF. El programa deberá analizarla y decir si se trata de un NIF correcto o incorrecto. Un NIF
correcto está formado por 8 dígitos y una letra. Los dígitos deben estar comprendidos entre 0
y 9 y la letra debe calcularse tal y como se indica en un ejercicio del tema anterior.
 *
 * @author rperblac
 */
import static java.lang.System.out;
import java.util.Scanner;


public class E36t3 {

    public static void main(String[] args) {
        int resto;
        char[] letrasdni = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E','T'};
        boolean dnicorrecto = false; // ¿Se introdujo un dni con el formato correcto?
        String dni = null;
        while (!dnicorrecto)
        {
            out.print("dni: ");
            dni = new Scanner(System.in).nextLine();
            if (dni.length()==9) // Debe tener 9 caracteres
            {
                String numeros = dni.substring(0,8); // Los 8 primeros a "numeros"
                String letra = dni.substring(8,9); // El noveno a "letra"
                if (numeros.chars().allMatch(Character::isDigit)) // "numeros" deben ser dígitos
                {
                    if (Character.isLetter(letra.charAt(0))) // "letra" debe ser un carácter
                    {
                        char letradni = Character.toUpperCase(letra.charAt(0)); // Pasa la letra a mayúscula
                        resto = Integer.parseInt(numeros)%23;
                        if (letradni == letrasdni[resto]) dnicorrecto = true;
                        else out.println("La letra no correspode. Debería ser " + letrasdni[resto] + " para el número " + numeros);
                    } else
                    {
                        out.println("El noveno caracter debe ser una letra");
                    }
                } else
                {
                    out.println("El dni debe comenzar con 8 números");
                }
            } else
            {
                out.println("El formato de dni son 8 números y una letra (00000000A)");
            }
        }
        out.println("Presione enter para salir.");
        String sal = new Scanner(System.in).nextLine();
    }
    
}
