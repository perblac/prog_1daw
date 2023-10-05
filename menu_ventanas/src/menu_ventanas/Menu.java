
package menu_ventanas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * Menú de aplicaciones en ventanas
 * @author rperblac
 */
public class Menu extends JFrame implements ActionListener{
    // Ancho y alto de botón, y espacio
    private int bAncho = 240;
    private int bAlto = 50;
    private int gap = 25;
    
    // Ancho y alto de la ventana de menú
    private int ancho = gap*3 + bAlto + bAncho;
    private int alto = gap*5 + bAlto*5;
    
    // Contenedor y botones
    private Container menu;
    private JButton figuras, efectos, reloj, altavoz;
    private JButton h1,      h2,      h3,    h4;
    
    // Diálogos modales de ayuda
    private JDialog     helpFig,  helpEfe,  helpRel,  helpAlt; 
    private JTextPane   t1,       t2,       t3,       t4;
    
    // Texto de información sobre Figuras geométricas
    private String t1text1 = """                            
                            FIGURAS GEOM\u00c9TRICAS
                            Esta es una versi\u00f3n del ejercicio 30 del Tema 5.
                            Su enunciado es el siguiente:""";
    
    private String t1text2 = """                             
                            Realiza un programa que utilice las clases del diagrama Figuras geom\u00e9tricas para hacer un programa que cree un List<FiguraGeometrica> y a continuaci\u00f3n muestre al usuario este men\u00fa:
                            
                                A\u00f1adir un rect\u00e1ngulo
                                A\u00f1adir un cuadrado
                                A\u00f1adir un c\u00edrculo
                                A\u00f1adir un tri\u00e1ngulo
                                Dibujar todo
                            
                            \u2003\u2003Por cada cosa que elija el usuario el programa preguntar\u00e1 los datos necesarios para crearlo (coordenadas del centro y radio para c\u00edrculo, etc). Entonces, crear\u00e1 la figura correspondiente y la a\u00f1adir\u00e1 a la lista de figuras. Cuando el usuario pulse la opci\u00f3n 5), el ordenador preguntar\u00e1 si desea dibujarlo en un PDF o en la ConsolaDAW. Por \u00faltimo, el programa dibujar\u00e1 todas las figuras en el lugar donde haya seleccionado el usuario.""";
                            
    private String t1text3 = """
                             
                            En esta implementación se omite el uso de la lista y la salida por consolaDAW o pdf, y en su lugar se utiliza una ventana de lienzo en la que se iran viendo los resultados segun se vayan creando las figuras.""";
    
    // Texto de información sobre Efectos de texto
    private String t2text1 = """
                             EFECTOS DE TEXTO
                             Esta es una versi\u00f3n del ejercicio 31 del Tema 5.
                             Su enunciado es el siguiente:""";
    private String t2text2 = """
                             Crea un paquete llamado efectos.clases y programa en \u00e9l el diagrama de clases Efectos especiales.
                             
                                 EfectoEspecial: Clase que representa un efecto especial que puede aplicarse sobre una frase. En realidad el efecto lo que hace es transformar la frase en otra.
                                     La propiedad \u201cnombre\u201d es el nombre del efecto especial.
                                     El m\u00e9todo aplicarEfecto se implementar\u00e1 en las clases hijas y lo que hace es transformar la frase recibida en otra, que ser\u00e1 la \u201caplicaci\u00f3n del efecto\u201d.
                                     La clase EfectoEspecial tendr\u00e1 un bloque inicializador est\u00e1tico en el que rellenar\u00e1 la propiedad \u201cEFECTOS\u201d con un objeto de cada uno de los efectos especiales (una vez vayan siendo creados).
                                 Sim\u00e9trico: Es una interfaz sin m\u00e9todos que indica que un efecto especial es sim\u00e9trico, es decir, si se aplica dos veces se vuelve a obtener el mismo texto de partida.
                                 Los efectos especiales se programan de la forma que indica la tabla, teniendo adem\u00e1s en cuenta que en su constructor, se deber\u00e1 mostrar por pantalla el mensaje \u201cCreado el efecto especial (nombre)\u201d. Ten adem\u00e1s en cuenta que los efectos tienen el modificador de acceso por defecto.
                             
                             EfectoMay\u00fasculas:
                             \tPasa a may\u00fasculas la frase.
                             \t\u201ca jugar\u201d -> \u201cA JUGAR\u201d
                             EfectoInverso:
                             \tDevuelve la frase al rev\u00e9s.
                             \t\u201ca jugar\u201d -> \u201craguj a\u201d
                             EfectoGuiones:
                             \tCambia los espacios por guiones bajos.
                             \t\u201ca jugar\u201d -> \u201ca_jugar\u201d
                             EfectoCorchetes:
                             \tEncierra la frase entre [ y ], pero si el texto empieza y termina por ellos, los elimina.
                             \t\u201ca jugar\u201d -> \u201c[a jugar]\u201d
                             \t\u201c[a jugar]\u201d -> \u201ca jugar\u201d """;
    private String t2text3 = """
                             
                             En esta implementación se accede a la aplicación de los efectos sobre una sentencia introducida mediante el uso de checkboxes, y se omite la salida por consola a la hora de crear los efectos""";
    
    // Texto de información sobre Reloj
    private String t3text1 ="""
                            RELOJ
                            Esta es una versi\u00f3n del ejercicio 31 del Tema 4.
                            Su enunciado es el siguiente:""";
    private String t3text2="""
                            Programa la siguiente clase, que es un reloj:
                            Reloj
                            - LocalTime hora
                            --------------------------------
                            + Reloj()
                            + void a\u00f1adir(int segundos)
                            + boolean esNoche()
                            + void esperar(int segundos)
                            + String toString()
                            
                                El constructor crea un reloj que guarda la hora del momento actual.
                                El m\u00e9todo a\u00f1adir sirve para a\u00f1adir la cantidad de segundos indicada a la hora del reloj.
                                El m\u00e9todo esNoche devuelve true si la hora est\u00e1 entre las 20:00 y las 8:00.
                                El m\u00e9todo esperar hace una pausa de la cantidad de segundos pasada como par\u00e1metro y despu\u00e9s actualizar\u00e1 la propiedad \u201chora\u201d.
                                toString: devuelve la hora escrita en el siguiente formato: hora:minutos:segundos.""";
    private String t3text3="""
                            
                            En esta implementaci\u00f3n se ha modificado el m\u00e9todo toString() para que actualize el valor de la hora y poder verla en tiempo real. Se ha usado el m\u00e9todo esNoche() para representar un icono de sol o luna segun corresponda. Por \u00faltimo se introdujo un acumulador a los segundos a\u00f1adidos para hacer el cambio permanente.""";
    
    // Texto de información sobre Altavoz
    private String t4text1 ="""
                            ALTAVOZ
                            Esta es una versi\u00f3n del ejercicio 26 del Tema 4.
                            Su enunciado es el siguiente:""";
    private String t4text2 ="""
                            Programa la siguiente clase, que es un altavoz:
                            Altavoz
                            + static final int VOL_MAX
                            + static final int VOL_MIN
                            - int volumen
                            ---------------------------
                            + Altavoz()
                            + void ponerVolumenMaximo()
                            + void setVolumen(int v)
                            + int getVolumen()
                            + String toString()
                            
                                Las constantes VOL_MIN y VOL_MAX indican los valores m\u00ednimo y m\u00e1ximo que puede tener cualquier altavoz. Estos valores se deber\u00e1n inicializar a 0 y 255 respectivamente.
                                La propiedad de instancia volumen indica el volumen del altavoz.
                                El constructor crea un altavoz apagado (su volumen es 0).
                                El m\u00e9todo ponerVolumenMaximo pone el altavoz al m\u00e1ximo de su volumen.
                                El m\u00e9todo setVolumen pone el altavoz al nivel pasado como par\u00e1metro.
                                El m\u00e9todo getVolumen devuelve el volumen del altavoz.
                                El m\u00e9todo toString devuelve un String con este formato: entre corchetes se ve el volumen, y luego se ve una barra formada por un total de 10 asteriscos y guiones que indican de forma gr\u00e1fica el tanto por ciento del volumen del altavoz sobre su m\u00e1ximo. Ejemplo: [127] *****-----""";
    private String t4text3 ="""
                            
                            En esta implementaci\u00f3n se controla el m\u00e9todo setVolumen mediante un slider""";
    
    
    // Icono para los botones de información
    private ImageIcon info;
    
    public Menu() {
        componentes();
        // asignar tamaño
        setSize(ancho,alto);
        // centrado
        setLocationRelativeTo(null);
        // no se puede cambiar el tamaño de la ventana
	setResizable(false);
        // título del menú
        setTitle("Menú programas");
        // salimos al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
    // Inicializa componentes
    public void componentes() {
        // Asignamos el contenido del panel al contenedor y ponemos el layout null (valores absolutos de posición)
        menu = getContentPane();
        menu.setLayout(null);
        
        // Botones para lanzar los programas
        figuras = new JButton();
        figuras.setText("Figuras Geométricas");
        figuras.setBounds(ancho/2 - bAncho/2 + gap, gap, bAncho, bAlto);
        figuras.addActionListener(this);        
        
        efectos = new JButton();
        efectos.setText("Efectos de texto");
        efectos.setBounds(ancho/2 - bAncho/2 + gap, gap*2 + bAlto, bAncho, bAlto);
        efectos.addActionListener(this);        
        
        reloj = new JButton();
        reloj.setText("Clase Reloj");
        reloj.setBounds(ancho/2 - bAncho/2 + gap, gap*3 + bAlto*2, bAncho, bAlto);
        reloj.addActionListener(this);        
        
        altavoz = new JButton();
        altavoz.setText("Clase Altavoz");
        altavoz.setBounds(ancho/2 - bAncho/2 + gap, gap*4 + bAlto*3, bAncho, bAlto);
        altavoz.addActionListener(this);
        
        info = new ImageIcon("interrogacion.gif");
        
        //// Estilos para el texto de las ventanas de ayuda        
        SimpleAttributeSet normal = new SimpleAttributeSet();
        StyleConstants.setBackground(normal, Color.white);
        StyleConstants.setFontFamily(normal, "SansSerif");
        StyleConstants.setFontSize(normal, 12);        
        StyleConstants.setAlignment(normal, StyleConstants.ALIGN_JUSTIFIED);

        SimpleAttributeSet cursiva = new SimpleAttributeSet(normal);
        StyleConstants.setItalic(cursiva, true);
        StyleConstants.setForeground(cursiva, Color.gray);
        
        
        //// Sección figuras
        h1 = new JButton(info);        
        h1.setBounds(gap, gap, bAlto, bAlto);
            // Añadimos la funcion del ActionListener directamente. Abrirá la ventana modal
        h1.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                      helpFig.setLocationRelativeTo(null);    
                                      helpFig.setVisible(true);
                                    }
                                });
            // Ventana modal
        helpFig = new JDialog();
        helpFig.setModal(true);
        helpFig.setSize(new java.awt.Dimension(ancho, alto));
        helpFig.setTitle("Información");
        
            // Texto de la ventana modal
        t1 = new JTextPane();        
        t1.setEditable(false);
            
            // Aplicación de los estilos al texto
        StyledDocument doc1 = (StyledDocument) t1.getDocument();
        
        try {
            doc1.insertString(doc1.getLength(), t1text1 + "\n", normal);
            doc1.insertString(doc1.getLength(), t1text2 + "\n", cursiva);
            doc1.insertString(doc1.getLength(), t1text3 + "\n", normal);
        } catch (BadLocationException ex) {
            System.out.println("Error: " + ex);
        }
            // Añadimos el texto
        helpFig.add(t1);
        
            // Scroll para la ventana modal
        JScrollPane areaScrollPane1 = new JScrollPane(t1);
        areaScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane1.setPreferredSize(new Dimension(250, 250));
            // Borde del área del scroll
        areaScrollPane1.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Figuras Gemétricas"),
                                BorderFactory.createEmptyBorder(2,0,2,0)),
                areaScrollPane1.getBorder()));
            
            // Añadimos el scroll
        helpFig.add(areaScrollPane1);        
        
        
        //// Sección efectos de texto
        h2 = new JButton(info);
        h2.setBounds(gap, gap*2 + bAlto, bAlto, bAlto);
        h2.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                      helpEfe.setLocationRelativeTo(null);    
                                      helpEfe.setVisible(true);
                                    }
                                });
        
        helpEfe = new JDialog();
        helpEfe.setModal(true);
        helpEfe.setSize(new java.awt.Dimension(ancho, alto));
        
        t2 = new JTextPane();
        
        t2.setEditable(false);
                
        StyledDocument doc2 = (StyledDocument) t2.getDocument();
        
        try {
            doc2.insertString(doc2.getLength(), t2text1 + "\n", normal);
            doc2.insertString(doc2.getLength(), t2text2 + "\n", cursiva);
            doc2.insertString(doc2.getLength(), t2text3 + "\n", normal);
        } catch (BadLocationException ex) {
            System.out.println("Error: " + ex);
        }
        
        helpEfe.add(t2);
        
        JScrollPane areaScrollPane2 = new JScrollPane(t2);
        areaScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane2.setPreferredSize(new Dimension(250, 250));
        areaScrollPane2.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Efectos de texto"),
                                BorderFactory.createEmptyBorder(2,0,2,0)),
                areaScrollPane2.getBorder()));

        helpEfe.add(areaScrollPane2);
        
        //// Sección reloj
        h3 = new JButton(info);
        h3.setBounds(gap, gap*3 + bAlto*2, bAlto, bAlto);
        h3.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                      helpRel.setLocationRelativeTo(null);    
                                      helpRel.setVisible(true);
                                    }
                                });
        
        helpRel = new JDialog();
        helpRel.setModal(true);
        helpRel.setSize(new java.awt.Dimension(ancho, alto));
        
        t3 = new JTextPane();
        
        t3.setEditable(false);
        
        StyledDocument doc3 = (StyledDocument) t3.getDocument();
        
        try {
            doc3.insertString(doc3.getLength(), t3text1 + "\n", normal);
            doc3.insertString(doc3.getLength(), t3text2 + "\n", cursiva);
            doc3.insertString(doc3.getLength(), t3text3 + "\n", normal);
        } catch (BadLocationException ex) {
            System.out.println("Error: " + ex);
        }
        
        helpRel.add(t3);
        
        JScrollPane areaScrollPane3 = new JScrollPane(t3);
        areaScrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane3.setPreferredSize(new Dimension(250, 250));
        areaScrollPane3.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Reloj"),
                                BorderFactory.createEmptyBorder(2,0,2,0)),
                areaScrollPane3.getBorder()));

        helpRel.add(areaScrollPane3);
        
        //// Sección altavoz
        h4 = new JButton(info);
        h4.setBounds(gap, gap*4 + bAlto*3, bAlto, bAlto);
        h4.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                      helpAlt.setLocationRelativeTo(null);    
                                      helpAlt.setVisible(true);
                                    }
                                });
        
        helpAlt = new JDialog();
        helpAlt.setModal(true);
        helpAlt.setSize(new java.awt.Dimension(ancho, alto));
        
        t4 = new JTextPane();
        
        t4.setEditable(false);
        
        StyledDocument doc4 = (StyledDocument) t4.getDocument();
        
        try {
            doc4.insertString(doc4.getLength(), t4text1 + "\n", normal);
            doc4.insertString(doc4.getLength(), t4text2 + "\n", cursiva);
            doc4.insertString(doc4.getLength(), t4text3 + "\n", normal);
        } catch (BadLocationException ex) {
            System.out.println("Error: " + ex);
        }
        
        helpAlt.add(t4);
        
        JScrollPane areaScrollPane4 = new JScrollPane(t4);
        areaScrollPane4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane4.setPreferredSize(new Dimension(250, 250));
        areaScrollPane4.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Altavoz"),
                                BorderFactory.createEmptyBorder(2,0,2,0)),
                areaScrollPane4.getBorder()));

        helpAlt.add(areaScrollPane4);
        
        // Añadir componentes        
        menu.add(figuras);
        menu.add(efectos);
        menu.add(reloj);
        menu.add(altavoz);
        
        menu.add(h1);
        menu.add(h2);
        menu.add(h3);
        menu.add(h4);
    }

    // Si hay evento en algún botón lanzamos el programa que corresponda
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==figuras)
        {
            try {
                Runtime.getRuntime().exec("java -jar jars\\figuras_ventana.jar");
            } catch (IOException ex) {
                System.out.println("Error " + ex);
            }
        }
        
        if (e.getSource()==efectos)
        {
            try {
                Runtime.getRuntime().exec("java -jar jars\\efectos_ventana.jar");
            } catch (IOException ex) {
                System.out.println("Error " + ex);
            }
        }
        
        if (e.getSource()==reloj)
        {
            try {
                Runtime.getRuntime().exec("java -jar jars\\reloj_ventana.jar");
            } catch (IOException ex) {
                System.out.println("Error " + ex);
            }
        }
        
        if (e.getSource()==altavoz)
        {
            try {
                Runtime.getRuntime().exec("java -jar jars\\altavoz_ventana.jar");
            } catch (IOException ex) {
                System.out.println("Error " + ex);
            }
        }
        
    }

}
