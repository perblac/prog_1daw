/**Enunciado: Estamos haciendo un programa de loterías y tenemos dos variables llamadas número y NúmeroPremiado, que se encuentran inicializadas con números de 5 cifras. El programa deberá mostrar por pantalla:
	a) Si el número coincide con el número premiado.
	b) Si el número tiene reintegro, es decir, se dan a la vez las dos siguientes condiciones:
		a. La primera cifra del número coincide con la primera cifra del número premiado
		b. La última cifra del número coincide con la última cifra del número premiado
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E52t1 {

    public static void main(String args[]) {

        int numero = 12345, NumeroPremiado = 17895;
        int cocn = numero / 10000, resn = numero % 10;
        int cocnp = numero / 10000, resnp = numero % 10;

        System.out.print("Introduzca su numero: ");
        numero = new Scanner(System.in).nextInt();
        System.out.print("\nIntroduzca numero premiado: ");
        NumeroPremiado = new Scanner(System.in).nextInt();
        cocn = numero / 10000;
        resn = numero % 10;
        cocnp = numero / 10000;
        resnp = numero % 10;
        

        if (numero == NumeroPremiado) {
            System.out.println("Su nº ha sido premiado (" + NumeroPremiado + ")");
        } else {
            System.out.println("Su nº no ha sido premiado (" + numero + ")\nEl nº premiado ha sido el " + NumeroPremiado);
        }

        if ((cocn == cocnp) && (resn == resnp)) {
            System.out.println("Tiene usted reintegro");
        }
    }
}
