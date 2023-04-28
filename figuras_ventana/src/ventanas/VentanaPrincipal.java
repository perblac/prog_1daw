
package ventanas;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import figurasgeometricas.*;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Ventana para Figuras geométricas
 * @author rperblac
 */
public class VentanaPrincipal extends JFrame implements ActionListener {
    // Contenedor de la ventana
    private Container caja;
    
    // Tamaño de la ventana
    private int ancho = 400;
    private int alto = 400;
    
    // Variable para la figura a dibujar:
    //   1 -> rectágulo
    //   2 -> cuadrado
    //   3 -> círculo
    //   4 -> triángulo
    private int figura;
    
    // Botones
    protected JToggleButton abreLienzo;
    private JButton crear, rectangulo, cuadrado, circulo, triangulo;
    private JButton cBlanco, cRojo, cAmarillo, cAzul, cNaranja, cVerde, cMagenta, cGris;
    
    // Lienzo
    private VentanaSecundaria canvas;
    
    // Etiquetas
    private JLabel etValor1, etValor2, etValor3, etValor4, etValor5, etValor6, etColor, error;
    
    // Campos de entrada
    private JTextField Valor1, Valor2, Valor3, Valor4, Valor5, Valor6;
    
    
    public VentanaPrincipal() {
        iniciarComps();
        setSize(ancho,alto);
        setLocationRelativeTo(null);
	setResizable(false);
        setTitle("Dibujar figuras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void iniciarComps() {
        caja = getContentPane();
        caja.setLayout(null);
        
//        JButton a = new JButton();
//        a.setBounds(2, 2, 5, 5);
//        a.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                canvas.grabar();
//            }
//            
//        });
//        caja.add(a);
        
        // Boton para abrir y cerrar el lienzo
        abreLienzo = new JToggleButton();
        abreLienzo.setText("Ver lienzo");
        abreLienzo.setBounds(10,10,100,40);
        abreLienzo.addActionListener(this);
        
        // Botones para las figuras
        rectangulo = new JButton();
        rectangulo.setText("Rectángulo");
        rectangulo.setBounds(10,80,120, 30);
        rectangulo.addActionListener(this);
        
        cuadrado = new JButton();
        cuadrado.setText("Cuadrado");
        cuadrado.setBounds(10,120,120, 30);
        cuadrado.addActionListener(this);
        
        circulo = new JButton();
        circulo.setText("Círculo");
        circulo.setBounds(10,160,120, 30);
        circulo.addActionListener(this);
        
        triangulo = new JButton();
        triangulo.setText("Triángulo");
        triangulo.setBounds(10,200,120, 30);
        triangulo.addActionListener(this);
        
        // Boton para dibujar con los parametros dados
        crear = new JButton();
        crear.setText("Crear");
        crear.setBounds(50,300,100,40);
        crear.setVisible(false);
        crear.addActionListener(this);
        
        // Campos para los valores        
        etValor1 = new JLabel();
        etValor1.setText("Valor1");
        etValor1.setBounds(200, 20, 100,30);
        etValor1.setVisible(false);
        
        Valor1 = new JTextField();
        Valor1.setBounds(310,20,40,30);
        Valor1.setVisible(false);
        
        etValor2 = new JLabel();
        etValor2.setText("Valor2");
        etValor2.setBounds(200, 60, 100,30);
        etValor2.setVisible(false);
        
        Valor2 = new JTextField();
        Valor2.setBounds(310,60,40,30);
        Valor2.setVisible(false);
        
        etValor3 = new JLabel();
        etValor3.setText("Valor3");
        etValor3.setBounds(200, 100, 100,30);
        etValor3.setVisible(false);
        
        Valor3 = new JTextField();
        Valor3.setBounds(310,100,40,30);
        Valor3.setVisible(false);
        
        etValor4 = new JLabel();
        etValor4.setText("Valor4");
        etValor4.setBounds(200, 140, 100,30);
        etValor4.setVisible(false);
        
        Valor4 = new JTextField();
        Valor4.setBounds(310,140,40,30);
        Valor4.setVisible(false);
        
        etValor5 = new JLabel();
        etValor5.setText("Valor5");
        etValor5.setBounds(200, 180, 100,30);
        etValor5.setVisible(false);
        
        Valor5 = new JTextField();
        Valor5.setBounds(310,180,40,30);
        Valor5.setVisible(false);
        
        etValor6 = new JLabel();
        etValor6.setText("Valor6");
        etValor6.setBounds(200, 220, 100,30);
        etValor6.setVisible(false);
        
        Valor6 = new JTextField();
        Valor6.setBounds(310,220,40,30);
        Valor6.setVisible(false);
        
        // Selección de color
        etColor = new JLabel();
        etColor.setText("Color:");
        etColor.setBounds(200,250,100,30);
        etColor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etColor.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        etColor.setOpaque(true);
        etColor.setBackground(Color.white);
        etColor.setVisible(false);
        
        cBlanco = new JButton();
        cBlanco.setBounds(200,300,30,20);
        cBlanco.setBackground(Color.white);
        cBlanco.setVisible(false);
        cBlanco.addActionListener(this);
        
        cRojo = new JButton();
        cRojo.setBounds(230,300,30,20);
        cRojo.setBackground(Color.red);
        cRojo.setVisible(false);
        cRojo.addActionListener(this);
        
        cAmarillo = new JButton();
        cAmarillo.setBounds(260,300,30,20);
        cAmarillo.setBackground(Color.yellow);
        cAmarillo.setVisible(false);
        cAmarillo.addActionListener(this);
        
        cAzul = new JButton();
        cAzul.setBounds(290,300,30,20);
        cAzul.setBackground(Color.blue);
        cAzul.setVisible(false);
        cAzul.addActionListener(this);
        
        cNaranja = new JButton();
        cNaranja.setBounds(200,320,30,20);
        cNaranja.setBackground(Color.orange);
        cNaranja.setVisible(false);
        cNaranja.addActionListener(this);
        
        cVerde = new JButton();
        cVerde.setBounds(230,320,30,20);
        cVerde.setBackground(Color.green);
        cVerde.setVisible(false);
        cVerde.addActionListener(this);
        
        cMagenta = new JButton();
        cMagenta.setBounds(260,320,30,20);
        cMagenta.setBackground(Color.magenta);
        cMagenta.setVisible(false);
        cMagenta.addActionListener(this);
        
        cGris = new JButton();
        cGris.setBounds(290,320,30,20);
        cGris.setBackground(Color.LIGHT_GRAY);
        cGris.setVisible(false);
        cGris.addActionListener(this);
        
        // Salida de errores
        error = new JLabel();
        error.setBounds(10, 340, 360, 20);
        error.setForeground(Color.red);
        error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        // Lienzo
        canvas = new VentanaSecundaria(this);
        
        caja.add(abreLienzo);
        caja.add(rectangulo);
        caja.add(cuadrado);
        caja.add(circulo);
        caja.add(triangulo);
        caja.add(crear);
        caja.add(etValor1);
        caja.add(Valor1);
        caja.add(etValor1);
        caja.add(Valor2);
        caja.add(etValor2);
        caja.add(Valor3);
        caja.add(etValor3);
        caja.add(Valor4);
        caja.add(etValor4);
        caja.add(Valor5);
        caja.add(etValor5);
        caja.add(Valor6);
        caja.add(etValor6);
        caja.add(etColor);
        caja.add(cBlanco);
        caja.add(cRojo);
        caja.add(cAmarillo);
        caja.add(cAzul);
        caja.add(cNaranja);
        caja.add(cVerde);
        caja.add(cMagenta);
        caja.add(cGris);
        caja.add(error);
    }
    
    // Método que pone a blanco el fondo de los campos de valores
    private void limpiaBordes() {
        Valor1.setBackground(Color.white);
        Valor2.setBackground(Color.white);
        Valor3.setBackground(Color.white);
        Valor4.setBackground(Color.white);
        Valor5.setBackground(Color.white);
        Valor6.setBackground(Color.white);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Si se pulsó algo, limpiamos la salida de error
        limpiaBordes();
        error.setText("");
        
        // Abrir / cerrar lienzo
        if (e.getSource()==abreLienzo) 
        {
            if (canvas.isVisible())
            {                
                canvas.setVisible(false);
            }
            else
            {                
                canvas.setVisible(true);
            }
        }
        
        // Abrir entrada de datos de de figuras
        if (e.getSource()==rectangulo)
        {
            // Se dibujará un rectángulo (= 1)
            figura = 1;
            
            // Ponemos nombre apropiado a los campos
            etValor1.setText("x1");
            etValor2.setText("y1");
            etValor3.setText("x2");
            etValor4.setText("y2");
            
            // Hacemos visibles los componentes necesarios
            crear.setVisible(true);
            etValor1.setVisible(true);
            Valor1.setVisible(true);
            etValor2.setVisible(true);
            Valor2.setVisible(true);
            etValor3.setVisible(true);
            Valor3.setVisible(true);
            etValor4.setVisible(true);
            Valor4.setVisible(true);
            etValor5.setVisible(false);
            Valor5.setVisible(false);
            etValor6.setVisible(false);
            Valor6.setVisible(false);
            etColor.setVisible(true);            
            cBlanco.setVisible(true);
            cRojo.setVisible(true);
            cAmarillo.setVisible(true);
            cAzul.setVisible(true);
            cNaranja.setVisible(true);
            cVerde.setVisible(true);
            cMagenta.setVisible(true);
            cGris.setVisible(true);
        }
        
        if (e.getSource()==cuadrado)
        {
            figura = 2;
            etValor1.setText("x1");
            etValor2.setText("y1");
            etValor3.setText("lado");
            etValor4.setText("");
            crear.setVisible(true);
            etValor1.setVisible(true);
            Valor1.setVisible(true);
            etValor2.setVisible(true);
            Valor2.setVisible(true);
            etValor3.setVisible(true);
            Valor3.setVisible(true);
            etValor4.setVisible(false);
            Valor4.setVisible(false);
            etValor5.setVisible(false);
            Valor5.setVisible(false);
            etValor6.setVisible(false);
            Valor6.setVisible(false);
            etColor.setVisible(true);
            cBlanco.setVisible(true);
            cRojo.setVisible(true);
            cAmarillo.setVisible(true);
            cAzul.setVisible(true);
            cNaranja.setVisible(true);
            cVerde.setVisible(true);
            cMagenta.setVisible(true);
            cGris.setVisible(true);
        }
        
        if (e.getSource()==circulo)
        {
            figura = 3;
            etValor1.setText("x centro");
            etValor2.setText("y centro");
            etValor3.setText("radio");
            etValor4.setText("");
            crear.setVisible(true);
            etValor1.setVisible(true);
            Valor1.setVisible(true);
            etValor2.setVisible(true);
            Valor2.setVisible(true);
            etValor3.setVisible(true);
            Valor3.setVisible(true);
            etValor4.setVisible(false);
            Valor4.setVisible(false);
            etValor5.setVisible(false);
            Valor5.setVisible(false);
            etValor6.setVisible(false);
            Valor6.setVisible(false);
            etColor.setVisible(true);
            cBlanco.setVisible(true);
            cRojo.setVisible(true);
            cAmarillo.setVisible(true);
            cAzul.setVisible(true);
            cNaranja.setVisible(true);
            cVerde.setVisible(true);
            cMagenta.setVisible(true);
            cGris.setVisible(true);
        }
        
        if (e.getSource()==triangulo)
        {
            figura = 4;
            etValor1.setText("x1");
            etValor2.setText("y1");
            etValor3.setText("x2");
            etValor4.setText("y2");
            etValor5.setText("x3");
            etValor6.setText("y3");
            crear.setVisible(true);
            etValor1.setVisible(true);
            Valor1.setVisible(true);
            etValor2.setVisible(true);
            Valor2.setVisible(true);
            etValor3.setVisible(true);
            Valor3.setVisible(true);
            etValor4.setVisible(true);
            Valor4.setVisible(true);
            etValor5.setVisible(true);
            Valor5.setVisible(true);
            etValor6.setVisible(true);
            Valor6.setVisible(true);
            etColor.setVisible(false);
            cBlanco.setVisible(false);
            cRojo.setVisible(false);
            cAmarillo.setVisible(false);
            cAzul.setVisible(false);
            cNaranja.setVisible(false);
            cVerde.setVisible(false);
            cMagenta.setVisible(false);
            cGris.setVisible(false);
        }
        
        // Dibujado de las figuras
        if (e.getSource()==crear)
        {
            // Flag para detectar que no haya errores y proceder al dibujado
            boolean correcto = true;
            
            // Inicializamos las variables a -1
            int val1 = -1;
            int val2 = -1;
            int val3 = -1;
            int val4 = -1;
            int val5 = -1;
            int val6 = -1;
            
            // Comprobamos que los valores de los campos sean válidos
            // En caso contrario marcamos los que dan error, ponemos correcto a 
            // false y escribimos el error en la ventana
            try {
                // Si el campo está vacío pasamos el valor 0, en caso contrario
                // intentamos parsear un número entero
                val1 = (Valor1.getText().equals(""))?0:Integer.parseInt(Valor1.getText());
            } catch (NumberFormatException ex)
            {
                // Si no se pudo parsear el entero ...
                correcto = false;
                error.setText("Error en los campos marcados");
                Valor1.setBackground(Color.red);
            }
            try {
                val2 = (Valor2.getText().equals(""))?0:Integer.parseInt(Valor2.getText());
            } catch (NumberFormatException ex)
            {
                correcto = false;
                error.setText("Error en los campos marcados");
                Valor2.setBackground(Color.red);
            }
            try {
                val3 = (Valor3.getText().equals(""))?0:Integer.parseInt(Valor3.getText());
            } catch (NumberFormatException ex)
            {
                correcto = false;
                error.setText("Error en los campos marcados");
                Valor3.setBackground(Color.red);
            }
            try {
                val4 = (Valor4.getText().equals(""))?0:Integer.parseInt(Valor4.getText());
            } catch (NumberFormatException ex)
            {
                correcto = false;
                error.setText("Error en los campos marcados");
                Valor4.setBackground(Color.red);
            }
            try {
                val5 = (Valor5.getText().equals(""))?0:Integer.parseInt(Valor5.getText());
            } catch (NumberFormatException ex)
            {
                correcto = false;
                error.setText("Error en los campos marcados");
                Valor5.setBackground(Color.red);
            }
            try {
                val6 = (Valor6.getText().equals(""))?0:Integer.parseInt(Valor6.getText());
            } catch (NumberFormatException ex)
            {
                correcto = false;
                error.setText("Error en los campos marcados");
                Valor6.setBackground(Color.red);
            }
            
            // Si los valores son válidos continuamos
            if (correcto)
            {
                //error.setText("");
                // Seleccionamos el color del fondo de la etiqueta etColor
                Color c = etColor.getBackground();
                // Cogemos el Graphics de la ventana de lienzo
                Graphics g = canvas.lienzo.getGraphics();
                // Sólo intentamos dibujar si el lienzo está visible
                if (canvas.isVisible())
                {
                    // Según la variable figura, procedemos a dibujar cada forma
                    switch(figura) {
                        case 1:
                            Rectangulo rect = new Rectangulo(new Point(val1,val2), new Point(val3, val4), c);
                            rect.dibujar(g);
                            break;
                        case 2:
                            Cuadrado cuad = new Cuadrado(new Point(val1,val2), val3, c);
                            cuad.dibujar(g);
                            break;
                        case 3:
                            Circulo circ = new Circulo(new Point(val1,val2), val3, c);
                            circ.dibujar(g);
                            break;
                        case 4:
                            Triangulo tria = new Triangulo(new Point(val1,val2), new Point(val3, val4), new Point(val5, val6));
                            tria.dibujar(g);
                            break;
                    }
                    
                    // Una vez dibujada la figura ocultamos los campos ...
                    crear.setVisible(false);
                    etValor1.setVisible(false);
                    Valor1.setVisible(false);
                    etValor2.setVisible(false);
                    Valor2.setVisible(false);
                    etValor3.setVisible(false);
                    Valor3.setVisible(false);
                    etValor4.setVisible(false);
                    Valor4.setVisible(false);
                    etValor5.setVisible(false);
                    Valor5.setVisible(false);
                    etValor6.setVisible(false);
                    Valor6.setVisible(false);
                    etColor.setVisible(false);
                    cBlanco.setVisible(false);
                    cRojo.setVisible(false);
                    cAmarillo.setVisible(false);
                    cAzul.setVisible(false);
                    cNaranja.setVisible(false);
                    cVerde.setVisible(false);
                    cMagenta.setVisible(false);
                    cGris.setVisible(false);
                    
                    // ... y vaciamos su contenido
                    Valor1.setText("");
                    Valor2.setText("");
                    Valor3.setText("");
                    Valor4.setText("");
                    Valor5.setText("");
                    Valor6.setText("");
                }
                else
                {
                    // Si el lienzo no está visible avisamos
                    error.setText("Abra el lienzo para poder crear la figura");
                }
            }
            
            
        }
        
        // Selección de colores. Se guarda en el color de fondo de la etiqueta etColor
        if (e.getSource()==cBlanco)
        {
            etColor.setBackground(Color.white);
            etColor.repaint();
        }
        
        if (e.getSource()==cRojo)
        {
            etColor.setBackground(Color.red);
            etColor.repaint();
        }
        
        if (e.getSource()==cAmarillo)
        {
            etColor.setBackground(Color.yellow);
            etColor.repaint();
        }
        
        if (e.getSource()==cAzul)
        {
            etColor.setBackground(Color.blue);
            etColor.repaint();
        }
        
        if (e.getSource()==cNaranja)
        {
            etColor.setBackground(Color.orange);
            etColor.repaint();
        }
        
        if (e.getSource()==cVerde)
        {
            etColor.setBackground(Color.green);
            etColor.repaint();
        }
        
        if (e.getSource()==cMagenta)
        {
            etColor.setBackground(Color.magenta);
            etColor.repaint();
        }
        
        if (e.getSource()==cGris)
        {
            etColor.setBackground(Color.LIGHT_GRAY);
            etColor.repaint();
        }
        
    }

}
