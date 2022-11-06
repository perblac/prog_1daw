/**Enunciado: Un videoclub alquila la película "El padrino" a 3.5 €/día y "Odisea 2001" por 2.95 €/día. Haz un programa que muestre por pantalla cuánto dinero se necesita para alquilar dos días estas películas. Haz que también se muestre por pantalla si es suficiente un billete de 5€ para pagar dicho alquiler.
 *
 * @author rperblac
 */
public class E16t1 {

    public static void main(String[] args) {
        double elpadrino = 3.5, odisea = 2.95;
        /* double elpadrino = 1.25, odisea = 1.25;
            ^esta línea para que dé Sí
        */
        System.out.println("Precio para alquilar El Padrino y Odisea 2001 dos días: "+(elpadrino*2+odisea*2));
        System.out.print("¿Es suficiente 5€? ");
        if ((elpadrino*2+odisea*2)<=5)
            System.out.println("Sí");
        else
            System.out.println("No");        
    }
    
}
