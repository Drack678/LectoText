package Cliente.Controller;

import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import Cliente.Model.ClienteConexion;
import Cliente.View.VentanaCliente;
import java.io.FileInputStream;
public class ControllerCliente implements ActionListener{
    private ClienteConexion cliente;
    private VentanaCliente ventanaCliente;
    private Properties properties;
    private JFileChooser fileChooser;
    private FileInputStream fileInputStream;
    private int p1, p2;
    private String mensaje;
    
    public ControllerCliente(){
        this.cliente = new ClienteConexion(p1,p2);
        this.ventanaCliente = new VentanaCliente();
        this.properties = new Properties();
        this.fileChooser = new JFileChooser();
        this.fileInputStream = null;
        ventanaCliente.getButton1().addActionListener(this);
        ventanaCliente.getButton2().addActionListener(this);
        getProperties();
    }
    public void getProperties(){
        try{
            this.fileChooser.showOpenDialog(null);
            this.fileInputStream = new FileInputStream(this.fileChooser.getSelectedFile());
            this.properties.load(this.fileInputStream);
            this.p1 = Integer.parseInt(this.properties.getProperty("p1"));
            this.p2 = Integer.parseInt(this.properties.getProperty("p2"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void charlar(){
        cliente.setMensaje(mensaje);
        cliente.conectar();
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == ventanaCliente.getButton1()){
            mensaje = ventanaCliente.getTextField1().getText();
            charlar();
        }
        if(e.getSource() == ventanaCliente.getButton2()){
            cliente.setActivo(false);
            System.out.println("Desconectado");
        }
    }
}
