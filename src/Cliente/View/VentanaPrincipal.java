package Cliente.View;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VentanaPrincipal {
    private JLabel label1;
    private JTextArea TextArea;
    private JButton btnLeer,btnSalir;
    private JPanel panel1;
    private JFrame frame1;

    public VentanaPrincipal(){
        frame1 = new JFrame("VENTANA CLIENTE");
        panel1 = new JPanel();
        label1 = new JLabel("MENSAJE:");
        TextArea = new JTextArea();
        TextArea.setPreferredSize(new Dimension(200,300));
        btnLeer = new JButton("OK");
        btnSalir = new JButton("SALIR");
        initComponents();
    }
    public void initComponents(){
        panel1.setSize(300, 300);
        panel1.add(label1);
        panel1.add(TextArea);
        panel1.add(btnLeer);
        panel1.add(btnSalir);
        frame1.add(panel1);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
        frame1.pack();
    }
    public JButton getBtnLeer(){
        return this.btnLeer;
    }
    public JButton getBtnSalir(){
        return this.btnSalir;
    }
    public JTextArea getTextArea(){
        return this.TextArea;
    }
    public JFrame getJFrame1(){
        return this.frame1;
    }
}
