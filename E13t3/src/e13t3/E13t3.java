package e13t3;

/** Enunciado: Usa las clases LocalDate y DateTimeFormatter para hacer un programa que pregunte al usuario un número de mes (entre 1 y 12) y un año. El programa mostrará por pantalla todos los días de ese mes, con el siguiente formato: “día/mes/año y día de la semana”
 *
 * @author rperblac
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class E13t3 {
    public static int pideMes(){
        int mes = 0;
        boolean buenaentrada = false; // ¿Tenemos ya un valor entero entre 1 y 12?
        while (!buenaentrada)
        {
            try
            {
                System.out.println("Número del mes");
                mes = new Scanner(System.in).nextInt();
                if (mes<1||mes>12) System.out.println("Solo se admiten valores entre 1 y 12");
                else buenaentrada = true;
            } catch (InputMismatchException ime)
            {
                System.out.println("Solo se admiten números enteros");
            }
        }
        return mes;
    }
    
    public static int pideAño(){
        int año = 0;
        boolean buenaentrada = false; // ¿Tenemos ya un valor entero entre 1 y 12?
        while (!buenaentrada)
        {
            try
            {
                System.out.println("Número del año");
                año = new Scanner(System.in).nextInt();
                if (año<1900||año>2100) System.out.println("Solo se admiten valores entre 1900 y 2100");
                else buenaentrada = true;
            } catch (InputMismatchException ime)
            {
                System.out.println("Solo se admiten números enteros");
            }
        }
        return año;
    }
    
    public static void main(String[] args) {
        LocalDate fecha;
        int mes = pideMes();
        int año = pideAño();
        fecha = LocalDate.of(año,mes,1);
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy eeee");        
        
        for (int i=1;i<=fecha.lengthOfMonth();i++)
        {
            fecha = fecha.withDayOfMonth(i);
            System.out.println(fecha.format(formato1));
        }
        
    }    
}
