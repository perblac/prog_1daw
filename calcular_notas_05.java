
/**
 *
 * rperblac
 * "calcular_notas.java"
 * v1.05
 * 
 * Cambios: .02 ajustes de representación en tablas
 * 
 *          .03 añadidas funciones media2() y media3()
 *          
 *          .04 introducción y cálculos reparados
 * 
 *          .05 implementado try_catch
 */
import java.util.Scanner;
import static java.lang.System.out;
import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class calcular_notas_05 {

    private static float media2(float a, float b)
        {
            float media = (float)((a+b)/2);
            return media;
        }

    private static float media3(float a, float b, float c)
        {
            float media = (float)((a+b+c)/3);
            return media;
        }

    public static void main(String args[]) {
        float entradanotas;                                         // Variable temporal de entrada de datos
        int i;                                                      // Contador para bucles for
        float unidad[] = {0, 0, 0, 0, 0, 0, 0};                     // Tabla de notas de Unidades del curso
        float pesorelativo[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};         // Tabla de porcentajes de peso relativo de cada RA
            pesorelativo[0] = (float) 5 / 100;
            pesorelativo[1] = (float) 20 / 100;
            pesorelativo[2] = (float) 20 / 100;
            pesorelativo[3] = (float) 10 / 100;
            pesorelativo[4] = (float) 10 / 100;
            pesorelativo[5] = (float) 10 / 100;
            pesorelativo[6] = (float) 10 / 100;
            pesorelativo[7] = (float) 10 / 100;
            pesorelativo[8] = (float) 5 / 100;
        float notaRA[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};               // Tabla de notas de RA según Unidad correspondiente
        float notaRArel[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};            // Tabla de notas de RA ajustadas por porcentaje de peso relativo
        float parcialaprobado[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};      // Tabla que contiene notaRA[] * 0,1
        float trim1, trim2, trim3;                                  // Media de cada trimestre
        float mediacurso, sumaRAs = 0;                              // Media de los tres trimestres, sumatorio de notaRArel[]
        boolean aprueba;                                            // Condición de aprobado

        // Introducción de datos
        out.println("Introduzca notas de las Unidades: ");
        for (i = 0; i < 7; i++)
        {

            do
            {
                out.print("Unidad " + (i + 1) + "? ");
                try
                {
                    entradanotas = new Scanner(System.in).nextFloat();
                    if (entradanotas < 0 || entradanotas > 10)
                    {
                        out.println("Fuera de rango (0-10). Repita entrada");
                    }                    
                } catch (InputMismatchException ime)
                {
                    out.println("Se necesita un valor numérico");
                    entradanotas = -1;
                }
            } while (entradanotas < 0 || entradanotas > 10);        // Repetimos la entrada de valor mientras no esté dentro del rango (0-10)

            unidad[i] = entradanotas;
        }
        // Media de cada trimestre
        trim1 = media3(unidad[0], unidad[1], unidad[2]);
        trim2 = media2(unidad[3], unidad[4]);
        trim3 = media2(unidad[5], unidad[6]);

        // Media del curso
        mediacurso = ((trim1*3) + (trim2*2) + (trim3*2))/7;

        // Asignación de notas de RA según Unidad correspondiente
        notaRA[0] = unidad[0];
        notaRA[1] = unidad[1];
        notaRA[2] = unidad[2];
        notaRA[3] = unidad[4];
        notaRA[4] = (unidad[0] / 2) + (unidad[1] / 2);
        notaRA[5] = unidad[2];
        notaRA[6] = unidad[4];
        notaRA[7] = unidad[5];
        notaRA[8] = unidad[6];

        // Cálculo de notas de RA ajustadas por porcentaje de peso relativo
        for (i = 0; i < 9; i++)
        {
            notaRArel[i] = pesorelativo[i] * notaRA[i];
        }

        // Cálculo de notaRA[] * 10
        for (i = 0; i < 9; i++)
        {
            parcialaprobado[i] = notaRA[i] * 10;
        }

        // Sumatorio
        for (i = 0; i < 9; i++)
        {
            sumaRAs = sumaRAs + notaRArel[i];
        }

        // Resultados con dos decimales: Clase DecimalFormat, método setMaximumFractionDigits()
        DecimalFormat frmt = new DecimalFormat();
        frmt.setMaximumFractionDigits(2);

        // Tabla 1         
        out.println("\nUnidades del curso:");
        out.println("1er trimestre:\t\t\t\t\tMedia Trimestre");
        out.println("Unidad 1\tUnidad 2\tUnidad 3\tTrim1");
        out.println(frmt.format(unidad[0]) + "\t\t" + frmt.format(unidad[1]) + "\t\t" + frmt.format(unidad[2]) + "\t\t" + frmt.format(trim1));
        out.println("2do trimestre:");
        out.println("Unidad 4\tUnidad 5\t\t\tTrim2");
        out.println(frmt.format(unidad[3]) + "\t\t" + frmt.format(unidad[4]) + "\t\t\t\t" + frmt.format(trim2));
        out.println("3er trimestre:");
        out.println("Unidad 6\tUnidad 7\t\t\tTrim3");
        out.println(frmt.format(unidad[5]) + "\t\t" + frmt.format(unidad[6]) + "\t\t\t\t" + frmt.format(trim3));
        out.println("\t\t\t\tMedia del curso:" + frmt.format(mediacurso));

        // Tabla 2
        out.println("\nResultados de aprendizaje totales del curso:");
        out.println("Resultados de\tPeso relativo\tNota/RA\t\tPeso RA/nota\t%aprobado/RA");
        out.println("aprendizaje");
        for (i = 0; i < 9; i++)
        {
            out.println("RA" + (i + 1) //+ ": " + frmt.format(ra[i])
                    + "  \t\t" + (pesorelativo[i] * 100)
                    + "%\t\t" + frmt.format(notaRA[i])
                    + "\t\t" + frmt.format(notaRArel[i])
                    + "\t\t" + frmt.format(parcialaprobado[i]) + " %");
        }
        out.println("\t\t\t\tTOTAL suma RAs:\t" + frmt.format(sumaRAs));

        // Condición de aprobado
        out.print("\nPara aprobar, necesario aprobar cada RA al 50% -> ");
        aprueba = true;
        for (i = 0; i < 9; i++)
        {
            if (notaRA[i] < 5)          // Imprime cada RA que no supere el 50% junto con su valor
            {
                out.print("RA" + (i + 1) + "=" + notaRA[i] + "; ");
                aprueba = false;
            }
        }
        String resultado = aprueba == true ? "Aprobado" : "Suspenso";
        out.println(resultado);   // Imprime si aprueba o suspende
    }
}
