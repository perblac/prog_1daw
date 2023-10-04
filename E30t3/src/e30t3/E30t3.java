package e30t3;

/** Enunciado: Realiza un programa que pregunte al usuario una cantidad en segundos, borre la pantalla y con letras grandes y en el centro de la pantalla se muestre una cuenta atrás que se actualiza cada segundo. Al llegar a 0, el programa finalizará.
 *
 * @author rperblac
 */
import java.util.Scanner;
import bpc.daw.consola.*;

public class E30t3 {
    
    public static void main(String[] args) {
        Consola cons = new Consola();
        Teclado tecl = cons.getTeclado();
        CapaTexto capat = cons.getCapaTexto();
        int segundos = 0;
        boolean bien;

        capat.print("Introduzca cantidad en segundos: ");
        do
        {
            try {
                segundos = tecl.leerNumeroEntero();
                bien = true;
            }catch (Exception e){
                capat.print("Introduzca un número entero");
                bien = false;
            }
        }
        while (!bien);
        
        capat.cls();
        capat.setTamTexto(200f);
        for (int i = 0; i<=segundos; i++ )
        {   
            capat.cls();
            capat.print(capat.getNumeroFilas()/2,capat.getNumeroColumnas()/2,(segundos-i)+"");
            try{
                Thread.sleep(999);
            } catch (InterruptedException ie)
            {
                capat.setTamTexto(12f);
                capat.cls();
                capat.print(ie.getLocalizedMessage());
            }
        }
    }
    
}
