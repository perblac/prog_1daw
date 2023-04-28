
package altavoz;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author rperblac
 */
public class Ventana extends JFrame implements ActionListener,ChangeListener {
    // Contenedor
    private Container contenedor;
    
    // Tamaño
    private int ancho = 630;
    private int alto = 250;
    
    // Etiqueta de salida
    JLabel salida;
    
    // Slider de volumen
    JSlider deslizador;    
    
    Altavoz a = new Altavoz();
    
    public Ventana() {
        iniciarComponentes();
        setTitle("Altavoz");
        setSize(ancho, alto);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void iniciarComponentes() {
        contenedor=getContentPane();
        
        contenedor.setLayout(null);
        
        salida = new JLabel();
        salida.setBounds(10, 5, ancho - 30, 140);
        salida.setText("Altavoz");
        salida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salida.setFont(new java.awt.Font("Courier New", 0, 60));
        
        deslizador = new JSlider(JSlider.HORIZONTAL, 0, 255,127);
        deslizador.setBounds(30, 180, ancho - 80, 30);
        deslizador.setPaintTicks(true);
        deslizador.setMajorTickSpacing(25);
        deslizador.setMinorTickSpacing(5);
        deslizador.addChangeListener(this);
        
        contenedor.add(salida);
        contenedor.add(deslizador);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void stateChanged(ChangeEvent evento) {
        int valor;
        if (evento.getSource() == deslizador) {
			valor = deslizador.getValue();
                        a.setVolumen(valor);
                        salida.setText(a.toString());
		}
    }
    
}
