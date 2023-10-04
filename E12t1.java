/**Enunciado: Haz un programa que pida al usuario por teclado tres números con decimales: precioNormal, porcentajeRebaja y precioRebajado. El programa mostrará por pantalla el precio normal y el rebajado, tras haber aplicado el porcentaje de descuento indicado en la variable porcentajeRebaja. La salida del programa deberá tener el siguiente formato:
    Precio normal del artículo: …… euros
    Porcentaje de rebaja aplicado: ….. %
    Descuento aplicado: …… euros
    Precio final del artículo: ……. euros
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E12t1 {
    public static void main(String args[]) {
        float precioNormal, porcentajeRebaja, precioRebajado, descuentoAplicado;
        System.out.print("Introduzca precio normal: ");
        precioNormal = new Scanner(System.in).nextFloat();
        System.out.print("Introduzca porcentaje de rebaja: ");
        porcentajeRebaja = new Scanner(System.in).nextFloat();
        System.out.print("Introduzca precio rebajado: ");
        precioRebajado = new Scanner(System.in).nextFloat();
        descuentoAplicado = (float) ((precioNormal*porcentajeRebaja)/100.0);
        System.out.println("\nPrecio normal del artículo: "+precioNormal+
                " euros\nPorcentaje de rebaja aplicado: "+porcentajeRebaja+
                " %\nDescuento aplicado: "+descuentoAplicado+
                " euros\nPrecio final del artículo: "+(precioNormal-descuentoAplicado)+
                " euros (Usted introdujo "+precioRebajado+" euros)");
    }
}
