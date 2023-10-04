/**Enunciado: Una tienda realiza descuentos a personas menores de edad y también a personas mayores de 60 años. Realiza un programa que pregunte una edad y nos muestre si tiene descuento.
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E27t1 {

    public static void main(String[] args) {
        System.out.println("Introduzca su edad: ");
        byte edad = new Scanner(System.in).nextByte();
        if (edad<18)
        {
            System.out.println("Tiene descuento por ser menor de edad");
        }
        else if (edad>60)
        {
            System.out.println("Tiene descuento por ser mayor de 60");
        }
        else
        {
            System.out.println("No tiene descuento");
        }
    }
    
}
