
package reloj;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Ventana para el reloj
 * @author rperblac
 */
public class Ventana extends JFrame implements ActionListener {
    private Reloj reloj = new Reloj();
    private JButton añadir,parar;
    private JLabel lahora, iconoDN, error, seg1, seg2;
    private JTextField segundos;
    private JTextField pausa;
    private ImageIcon iconoSol, iconoLuna;
    
    private final int ancho = 740;
    private final int alto = 300;
    
    private Container contenedor;
    
    public Ventana() {
        initComp();
        setTitle("Reloj");
        setSize(ancho,alto);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void update() {
        lahora.setText(reloj.toString());
        iconoDN.setIcon((reloj.esNoche())?iconoLuna:iconoSol);
    }
    
    private void initComp() {
        contenedor=getContentPane();
        contenedor.setLayout(null);
        
        error = new JLabel("");
        error.setBounds(20, alto - 70, ancho - 40, 30);
        error.setForeground(Color.red);
        error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        lahora = new JLabel();
        lahora.setBounds(100, 10, 500, 100);
        lahora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lahora.setFont(new java.awt.Font("Tahoma", 0, 72));
        lahora.setText(reloj.toString());
        
        iconoSol = new ImageIcon("sun.png");
        iconoLuna = new ImageIcon("moon.png");
        
        iconoDN = new JLabel(iconoSol);
        iconoDN.setBounds(ancho - 100, 20, 64, 64);
        
        añadir = new JButton();
        añadir.setBounds(160, 140, 200, 80);
        añadir.setText("Añadir segundos");
        añadir.addActionListener(this);
        
        segundos = new JTextField();
        segundos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        segundos.setBounds(40, 140, 80, 80);
        
        seg1 = new JLabel("segundos");
        seg1.setFont(new java.awt.Font ("Verdana", java.awt.Font.PLAIN, 8));
        seg1.setBounds(40,220,80,10);
        seg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);        
        
        parar = new JButton();
        parar.setBounds(510, 140, 200, 80);
        parar.setText("Detener");
        parar.addActionListener(this);        
        
        pausa = new JTextField();
        pausa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pausa.setBounds(390, 140, 80, 80);
        
        seg2 = new JLabel("segundos");
        seg2.setFont(new java.awt.Font ("Verdana", java.awt.Font.PLAIN, 8));
        seg2.setBounds(390,220,80,10);
        seg2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); 
        
        contenedor.add(lahora);
        contenedor.add(añadir);
        contenedor.add(segundos);
        contenedor.add(seg1);
        contenedor.add(parar);
        contenedor.add(pausa);
        contenedor.add(seg2);
        contenedor.add(iconoDN);
        contenedor.add(error);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int segs, pausaSeg;
        if (e.getSource()==añadir)
        {
            error.setText("");
            try {
                segs = Integer.parseInt(segundos.getText());
                reloj.añadir(segs);                
            } catch (NumberFormatException ex)
            {
                error.setText("El número introducido no es válido");                
                segundos.setText("");
            }
            
        }
        if (e.getSource()==parar)
        {
            error.setText("");
            try
            {
                pausaSeg = (pausa.getText().equals(""))?0:Integer.parseInt(pausa.getText());
                reloj.esperar(pausaSeg);
            } catch (NumberFormatException ex)
            {
                error.setText("El número introducido no es válido");
                segundos.setText("");
            }            
        }
    }
    
    
}
