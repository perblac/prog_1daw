/**
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
