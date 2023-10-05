
package figurasgeometricas;

import ventanas.*;

/*  --- imports del original ---
import bpc.daw.consola.*;
import gnu.jpdf.*;
import java.awt.print.PageFormat;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.print.Paper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ventanas.*;
*/

/**
 * Programa para dibujar figuras geométricas en ventanas
 * 
 * @author rperblac
 * @version 2.0
 */
public class Programa {
/*  --- Código original ---
    private static List<FiguraGeometrica> lista = new ArrayList<>();
    private static Consola cons = new Consola();
    private static Teclado t = cons.getTeclado();
    private static CapaTexto ct = cons.getCapaTexto();
    private static CapaCanvas cc = cons.getCapaCanvas();
    private static Graphics g = cc.getGraphics();
    private static int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    private static String l0 = "Tamaño de la pantalla: " + ancho + "x" + alto;
            
    private static Color eligeColor() {
        int ty = ct.getPosicion().y;
        int tx = ct.getPosicion().x;
        String l5 = "Color (1-8): ";
        int color = 0;
        muestraColores();
        ct.print(ty + 1,tx,l5);
        color = leeValor(3);
        Color col = null;
        switch (color)
        {
            case 1:
                col = Color.WHITE;
                break;
            case 2:
                col = Color.RED;
                break;
            case 3:
                col = Color.YELLOW;
                break;
            case 4:
                col = Color.BLUE;
                break;
            case 5:
                col = Color.ORANGE;
                break;
            case 6:
                col = Color.GREEN;
                break;
            case 7:
                col = Color.MAGENTA;
                break;
            case 8:
                col = Color.LIGHT_GRAY;
                break;                
        }
        return col;
    }
    
    private static void muestraColores() {
        ct.println("");
        ct.setColorTexto(Color.BLACK);        
        ct.setColorFondo(Color.WHITE);
        ct.print(10,10, " 1 ");
        ct.setColorFondo(Color.RED);
        ct.print(10,14, " 2 ");
        ct.setColorFondo(Color.YELLOW);
        ct.print(10,18, " 3 ");
        ct.setColorFondo(Color.BLUE);
        ct.print(10,22, " 4 ");
        ct.setColorFondo(Color.ORANGE);
        ct.print(12,10, " 5 ");
        ct.setColorFondo(Color.GREEN);
        ct.print(12,14, " 6 ");
        ct.setColorFondo(Color.MAGENTA);
        ct.print(12,18, " 7 ");
        ct.setColorFondo(Color.LIGHT_GRAY);
        ct.print(12,22, " 8 ");
        
        ct.setColorTexto(Color.WHITE);        
        ct.setColorFondo(Color.BLACK);  
    }
    
    private static void lanzaError(String e) {
        int ty = ct.getPosicion().y;
        int tx = ct.getPosicion().x;
        t.setVisible(false);
        ct.setColorFondo(Color.red);
        int fil = ct.getNumeroFilas();
        int col = ct.getNumeroColumnas();
        ct.print(fil - 2, (col / 2) - (e.length() / 2), e);
        ct.situarCursor(ty, tx);
        t.leerCaracter();
        ct.setColorFondo(Color.black);
        String spaces = " ".repeat(e.length());
        ct.print(fil - 2, (col / 2) - (e.length() / 2), spaces);
        t.setVisible(true);        
        ct.situarCursor(ty, tx);
    }
    
    private static int leeValor(int orient) {
        int valor;
        int ty = ct.getPosicion().y;
        int tx = ct.getPosicion().x;
        int limS = (orient == 0)?ancho:(orient == 1)?alto:(orient == 2)?2:(orient == 3)?8:6;
        int limI = (orient >= 2)?1:0;
        do
        {
            ct.situarCursor(ty, tx);
            ct.print(" ".repeat(ct.getNumeroColumnas()/2));
            ct.situarCursor(ty, tx);            
            String entrada = t.leerCadenaCaracteres();
            try 
            {
                valor = Integer.parseInt(entrada);
                if (valor < limI || valor > limS) lanzaError(" Introduzca un valor entre " + limI + " y " + limS + " ");
            } catch (Exception e)
            {
                valor = -1;
                lanzaError(" Entrada incorrecta ");                
            }            
        } while (valor < limI || valor > limS);
        return valor;
    }
    
    private static void rectangulo() {        
        String l1 = "Esquina superior izquierda ";
        String l2 = "x: ";
        String l3 = "y: ";
        String l4 = "Esquina inferior derecha ";
        
        ct.cls();
        ct.println(l0);
        
        ct.println(l1);
        ct.print(l2);
        int xs = leeValor(0);
        ct.print(l3);
        int ys = leeValor(1);
        ct.println("");
        ct.println(l4);
        ct.print(l2);
        int xi = leeValor(0);
        ct.print(l3);
        int yi = leeValor(1);
        Color c = eligeColor();
        
        lista.add(new Rectangulo(new Point(xs,ys), new Point(xi, yi), c));
    }
    
    private static void cuadrado() {
        String l1 = "Esquina superior izquierda ";
        String l2 = "x: ";
        String l3 = "y: ";
        String l4 = "Longitud del lado: ";
        
        ct.cls();
        ct.println(l0);
        
        ct.println(l1);
        ct.print(l2);
        int xs = leeValor(0);
        ct.print(l3);
        int ys = leeValor(1);
        ct.println("");        
        ct.print(l4);
        int lado = leeValor(1);
        Color c = eligeColor();
        
        lista.add(new Cuadrado(new Point(xs,ys), lado, c));
    }
    
    private static void circulo() {
        String l1 = "Centro ";
        String l2 = "x: ";
        String l3 = "y: ";
        String l4 = "Radio: ";
        
        ct.cls();
        ct.println(l0);
        
        ct.println(l1);
        ct.print(l2);
        int xs = leeValor(0);
        ct.print(l3);
        int ys = leeValor(1);
        ct.println("");        
        ct.print(l4);
        int radio = leeValor(1);
        Color c = eligeColor();
        
        lista.add(new Circulo(new Point(xs,ys), radio, c));
    }
    
    private static void triangulo() {
        String l1 = "Punto ";
        String l2 = "x: ";
        String l3 = "y: ";
                
        ct.cls();
        ct.println(l0);
        
        int[] x = new int[3], y = new int[3];
        
        for (int i = 0; i < 3; i++)
        {
            ct.println(l1 + "" + i);
            ct.print(l2);
            x[i] = leeValor(0);
            ct.print(l3);
            y[i] = leeValor(1);
        }
                
        lista.add(new Triangulo(new Point(x[0],y[0]), new Point(x[1], y[1]), new Point(x[2], y[2])));
    }
    
    private static void dibujar() {
        String l1 = "1. Por pantalla";
        String l2 = "2. PDF";
        String l3 = "Introduzca el nombre del archivo: ";
        ct.cls();
        ct.println(l1);
        ct.println(l2);
        ct.println("");
        int opcion = leeValor(2);
        switch(opcion) {
            case 1:
                porPantalla();
                break;
            case 2:
                ct.println(l3);
                porPdf();
                break;
        }        
    }
    
    private static void porPantalla() {
        ct.cls();
        for (FiguraGeometrica fg:lista) {
            fg.dibujar(g);
        }
        ct.setVisible(false);
        t.leerCaracter();
        ct.setVisible(true);
        cc.cls();
    }
        
    private static void porPdf() {
        String archivo;
        int ty = ct.getPosicion().y;
        int tx = ct.getPosicion().x;
        PDFJob pdf = null;
        boolean pasa = false;
        do
        {
            ct.situarCursor(ty, tx);
            ct.print(" ".repeat(ct.getNumeroColumnas()/2));
            ct.situarCursor(ty, tx);            
            archivo = t.leerCadenaCaracteres();
            if (archivo.length()>3&&(archivo.substring(archivo.length() - 4, archivo.length()).equals(".pdf") 
                                    || archivo.substring(archivo.length() - 4, archivo.length()).equals(".PDF")))
            {
                try
                {
                    pdf = new PDFJob(archivo);
                    Paper hoja = new Paper();
                    int margen = 25;
                    hoja.setSize(ancho + 25*2, alto + 25*2);
                    hoja.setImageableArea(margen, margen, (double) ancho, (double) alto);
                    PageFormat pf = new PageFormat();
                    pf.setPaper(hoja);
                    g = pdf.getGraphics(pf);                
                    for (FiguraGeometrica fg:lista)
                    {
                        fg.dibujar(g);
                    }
                    pdf.end();
                    pasa = true;
                } catch (IOException e)  
                {
                    lanzaError(" Archivo no válido ");
                }                
            }
            else
            {
                lanzaError(" El archivo debe terminar en .pdf");
            }
        } while (!pasa);        
    }
    
    private static void menu() {
        String op1 = "1) Añadir un rectángulo";
        String op2 = "2) Añadir un cuadrado";
        String op3 = "3) Añadir un círculo";
        String op4 = "4) Añadir un triángulo";
        String op5 = "5) Dibujar todo";
        String op6 = "6) Salir";
        ct.println(op1);
        ct.println(op2);
        ct.println(op3);
        ct.println(op4);
        ct.println(op5);
        ct.println(op6);
    }
    */
    public static void main(String[] args) {
        VentanaPrincipal miventana = new VentanaPrincipal();
        miventana.setVisible(true);
        
        /*  --- Main original ---
        t.setVisible(true);
        int opcion = 0;
        do
        {
            ct.cls();
            menu();
            opcion = leeValor(4);
            switch(opcion)
                    {
                case 1:
                    rectangulo();
                    break;
                case 2:
                    cuadrado();
                    break;
                case 3:
                    circulo();
                    break;
                case 4:
                    triangulo();
                    break;
                case 5:   
                    dibujar();
                    break;
            }            
        } while ((opcion>0) && (opcion<6));
        */
    }

}
