package Cliente.View;

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
        label1 = new JLabel("MENSAJE:");
        textField1 = new JTextField();
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
}