package efectos.programa;

import efectos.clases.*;
import java.util.Scanner;

/**
 * Menú de aplicación de efectos
 *
 * @author rperblac
 */
public class menu {

    public static void main(String[] args) {

        System.out.print("Introduzca una frase: ");
        String frase = new Scanner(System.in).nextLine();
        int op = 0;
        System.out.println("1) Aplicar todos los efectos a la frase\n"
                + "2) Aplicar sólo los efectos simétricos");
        do {
            String r = new Scanner(System.in).next();
            if (r == null) {
                System.out.println("Opción incorrecta");
            } else {
                try {
                    op = Integer.parseInt(r.charAt(0) + "");
                    if (op < 1 || op > 2) {
                        System.out.println("Valor no válido");
                    }
                } catch (Exception e) {
                    System.out.println("Valor no válido");
                }
            }
        } while (op < 1 || op > 2);
        switch (op) {
            case 1:
                for (EfectoEspecial e : EfectoEspecial.EFECTOS) {
                    frase = e.aplicarEfecto(frase);
                }
                break;
            case 2:
                for (EfectoEspecial e : EfectoEspecial.EFECTOS) {
                    if (e instanceof Simetrico) {
                        frase = e.aplicarEfecto(frase);
                    }
                }
                break;
        }
        System.out.println(frase);
    }

}
