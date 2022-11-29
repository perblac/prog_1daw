package e4t3;

/** Enunciado: Realiza un programa que pregunte al usuario "¿Eres mayor de edad (si/no)?". Si el usuario escribe "Si", el ordenador mostrará un mensaje "El usuario es mayor de edad". Si el usuario escribe "No", el ordenador mostrará "El usuario es menor de edad". Si el usuario escribe cualquier otra cosa, el ordenador mostrará "No te entiendo" y volverá a hacer la pregunta hasta que el usuario escriba lo correcto.
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E4t3 {

    public static void main(String[] args) {
        String entrada;
        boolean novale = true;
        do
        {
            System.out.println("¿Eres mayor de edad (si/no)?");
            entrada = new Scanner(System.in).next();
            if (!entrada.equals("si")&&!entrada.equals("no")&&!entrada.equals("Si")&&!entrada.equals("No")&&!entrada.equals("SI")&&!entrada.equals("NO")&&!entrada.equals("s")&&!entrada.equals("n")&&!entrada.equals("S")&&!entrada.equals("N"))
            {
                System.out.println("No te entiendo.");
            }
            else
            {
                novale = false;
            }
        } while (novale);
        switch (entrada)
        {
            case "S":
            case "s":
            case "Si":
            case "si":
            case "SI":
                System.out.println("El usuario es mayor de edad");
                break;
            case "N":
            case "n":
            case "No":
            case "no":
            case "NO":
                System.out.println("El usuario es menor de edad");
                break;              
        }
    }
    
}
