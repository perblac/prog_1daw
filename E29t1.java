/**Enunciado: : Un usuario de un programa pulsa el botón de imprimir. Solo se puede realizar esta operación si la impresora está encendida, tiene tinta y el número de folios que hay en la impresora es mayor que el número de folios del trabajo que se van a imprimir. Realiza un programa que pida al usuario por teclado el porcentaje de tinta, los folios que hay en la impresora, los folios que se desean imprimir y si la impresora está encendida. El programa mostrará si se puede imprimir
 *
 * @author rperblac
 */
import java.util.Scanner;

public class E29t1 {

    public static void main(String[] args) {
        byte tinta;
        int foliosImpresora, foliosTrabajo;
        boolean impresoraEncendida;
        System.out.println("Porcentaje de tinta (0-100): ");
        tinta = new Scanner(System.in).nextByte();
        System.out.println("Folios en impresora: ");
        foliosImpresora = new Scanner(System.in).nextInt();
        System.out.println("Folios a imprimir: ");
        foliosTrabajo = new Scanner(System.in).nextInt();
        System.out.println("¿Está la impresora encendida? ");
        String estado = new Scanner(System.in).nextLine();
        if ((estado.equals("si")) || (estado.equals("Si")) || (estado.equals("SI")) || (estado.equals("sí")) || (estado.equals("Sí")) || (estado.equals("SÍ")) || (estado.equals("1"))) {
            impresoraEncendida = true;
        } else {
            impresoraEncendida = false;
        }
        if ((tinta > 0) && (foliosImpresora > foliosTrabajo) && (impresoraEncendida)) {
            System.out.println("Puede imprimir");
        } else {
            System.out.println("No puede imprimir");
        }
    }
}
