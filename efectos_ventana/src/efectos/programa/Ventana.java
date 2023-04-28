
package efectos.programa;

import efectos.clases.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Ventana de efectos de texto
 * @author rperblac
 */
public class Ventana extends JFrame implements ActionListener {
    // Creamos los efectos
    private EfectoMayusculas fxem = new EfectoMayusculas();
    private EfectoInverso fxei = new EfectoInverso();
    private EfectoGuiones fxeg = new EfectoGuiones();
    private EfectoCorchetes fxec = new EfectoCorchetes();
    
    // Tamaño de ventana
    private final int ancho = 600;
    private final int alto = 400;

    String frase;
	
    private Container contenedor;
    private JLabel salida, etiqueta;
    private JTextField entrada;
    private JCheckBox em, ei, eg, ec;
    private JButton aplicar;
    
    public Ventana() {
        initComps();
        setTitle("Efectos De Texto");
        setSize(ancho, alto);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initComps() {
        contenedor=getContentPane();
        contenedor.setLayout(null);
        
        etiqueta = new JLabel();
        etiqueta.setText("Introduzca la frase:");
        etiqueta.setBounds(20, 5, 560, 35);
        etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiqueta.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                
        entrada = new JTextField();
        entrada.setBounds(20, 45, 560, 35);
        entrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        salida = new JLabel();
        salida.setBounds(20, 100, 560, 35);
        salida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salida.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        
        em = new JCheckBox("Efecto Mayúsculas");
        em.setBounds(40, 140, 200, 40);
        ei = new JCheckBox("Efecto Inverso");
        ei.setBounds(280, 140, 200, 40);
        eg = new JCheckBox("Efecto Guiones");
        eg.setBounds(40, 200, 200, 40);
        ec = new JCheckBox("Efecto Corchetes");        
        ec.setBounds(280, 200, 200, 40);
        
        aplicar = new JButton();
        aplicar.setText("Aplicar");
        aplicar.setBounds(250, 300, 100, 40);
        aplicar.addActionListener(this);
        
        contenedor.add(etiqueta);
        contenedor.add(entrada);
        contenedor.add(salida);
        contenedor.add(em);
        contenedor.add(ei);
        contenedor.add(eg);
        contenedor.add(ec);
        contenedor.add(aplicar);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource()==aplicar)
        {
            // Pasamos el contenido de entrada a la variable frase
            frase = entrada.getText();
            // Y aplicamos los efectos
            aplicarEfecto(frase);
        }
    }
    
    public void aplicarEfecto(String frase) {
        // Usamos los checkboxs para aplicar cada efecto
        if (em.isSelected()) {
            frase = fxem.aplicarEfecto(frase);
        }
        if (ei.isSelected()) {
            frase = fxei.aplicarEfecto(frase);
        }
        if (eg.isSelected()) {
            frase = fxeg.aplicarEfecto(frase);
        }
        if (ec.isSelected()) {
            frase = fxec.aplicarEfecto(frase);
        }
        // Mostramos el resultado
        salida.setText(frase);
    }
}
