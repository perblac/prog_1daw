package e29t2;

/**Enunciado: Realiza las siguientes acciones en un programa y escribe si lanzan o no una excepción. En caso afirmativo, escribe el nombre de la excepción que se lanza.
    a) Por teclado se pide que el usuario escriba un número y el usuario escribe un texto
    b) Un programa necesita recuperar dos argumentos de la línea de comandos y no se pasa ninguno
    c) Creamos una caja vacía. Recuperamos el mensaje que tiene y mostramos por pantalla su longitud.
 *
 * @author rperblac
 */
import bpc.daw.objetos.Caja;
import java.util.Scanner;

public class E29t2 {

    public static void main(String[] args) {
        try {
            System.out.println("Escriba un numero: ");
            int numero = new Scanner(System.in).nextInt();
        }
        catch (Exception a)
        {
            System.out.println("Excepción A: " + a);
        }

        try {
            int argumentos = args.length;
            String a = args[0];
            String b = args[1];
        }
        catch (Exception b)
        {
            System.out.println("Excepción B: " + b);
        }

        try {
            String m = null;
            Caja caja = new Caja(m);
            caja.abrirCaja();
            System.out.println(caja.getMensaje().length());
        } catch (Exception c)
        {
            System.out.println("Excepción C: " + c);
        }
    }

}
