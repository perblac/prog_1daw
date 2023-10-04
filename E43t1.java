/**Enunciado: Realiza un programa que indique la cantidad de dinero que hay que cobrar o devolver a un cliente de una tienda, de esta forma:
	a) El programa comienza preguntando el precio del artículo.
	b) A continuación, se pregunta la cantidad de dinero que da el cliente. (esta cantidad puede ser mayor o menor que el precio del artículo)
	c) El programa indicará si al cliente le falta dinero o si es necesario darle el cambio. En ambos casos se indicará la cantidad de dinero necesaria.
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E43t1 {

    public static void main(String[] args) {
        float precio, pago;
        System.out.println("Precio del artículo: ");
        precio = new Scanner(System.in).nextFloat();
        System.out.println("Cantidad pagada: ");
        pago = new Scanner(System.in).nextFloat();
        if (pago < precio) {
            System.out.println("Falta por pagar " + (precio - pago));
        } else {
            System.out.println("Cantidad a devolver: " + (pago - precio));
        }
    }
}
