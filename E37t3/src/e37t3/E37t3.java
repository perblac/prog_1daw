package e37t3;

/** Enunciado: Realiza un programa que genere un documento PDF en el que se muestren todas
las tablas de multiplicar del 1 al 10, cada una en una página diferente.
 *
 * @author rperblac
 */
import gnu.jpdf.PDFJob;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.print.PageFormat;
import java.io.IOException;


public class E37t3 {

    public static void main(String[] args) {
        PDFJob documento = null;
        PageFormat a4 = new PageFormat();
        try
        {
            documento = new PDFJob("tablas.pdf");
        } catch (IOException ioe)
        {
            System.out.println("No se pudo crear el documento. "+ioe);
        }       
        
        Color mio = new Color(0,0,0);
        
        for (int i = 1; i <= 10; i++)
        {
            Graphics graficos = documento.getGraphics(a4);
            graficos.setColor(mio);
            for (int j = 1; j <=10; j++)
            {
                graficos.drawString(i + " x " + j + " = " + i*j, 200, 200 + (j*20));
            }
        }
        documento.end();  
    }
    
}
