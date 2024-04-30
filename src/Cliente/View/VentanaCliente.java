package Cliente.View;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaCliente {
    private JLabel label1;
    private JTextField textField1;
    private JButton button1,button2;
    private JPanel panel1;
    private JFrame frame1;

    public VentanaCliente(){
        frame1 = new JFrame("VENTANA CLIENTE");
        panel1 = new JPanel();
        label1 = new JLabel("MENSAJE:");
        textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(200,300));
        button1 = new JButton("OK");
        button2 = new JButton("SALIR");
        initComponents();
    }
    public void initComponents(){
        panel1.setSize(300, 300);
        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(button1);
        panel1.add(button2);
        frame1.add(panel1);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
        frame1.pack();
    }
    public JButton getButton1(){
        return button1;
    }
    public JButton getButton2(){
        return button2;
    }
    public JTextField getTextField1(){
        return textField1;
    }
    public JFrame getFrame1(){
        return frame1;
    }
}