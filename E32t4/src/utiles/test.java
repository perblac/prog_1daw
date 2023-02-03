
package utiles;

import bpc.daw.consola.*;

/**
 * Main de pruebas de la clase Boligrafo
 * @author rperblac
 */
public class test {

    public static void main(String[] args) {
        String texto = "Esto es un texto de prueba";
        Consola co = new Consola();
        CapaTexto ct = co.getCapaTexto();
        Teclado t = co.getTeclado();
        Boligrafo boli = new Boligrafo(ct);
        boli.escribir(texto);
        ct.println("");
        boli.setColor(3);
        boli.escribir(texto);
        ct.println("");
        boli.escribirGuay(texto);
        System.out.println(ct.getPosicion() + " " + ct.getPosicionEscritura());
        t.setTipoCursor(Teclado.CURSOR_NULO);
        t.leerCaracter();
        ct.cls();
    }

}
