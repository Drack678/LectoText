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
    private JFileChooser fileChooser = new JFileChooser();
    private FileInputStream fileInputStream;
    private int p1, p2;
    private String mensaje;
    
    public ControllerCliente(){
        this.properties = new Properties();
        getProperties();
        this.cliente = new ClienteConexion(p1,p2);
        this.ventanaCliente = new VentanaCliente();
        ventanaCliente.getButton1().addActionListener(this);
        ventanaCliente.getButton2().addActionListener(this);
    }
    public void getProperties(){
        try{
            this.fileChooser.showOpenDialog(null);
            this.fileInputStream = new FileInputStream(this.fileChooser.getSelectedFile());
            this.properties.load(this.fileInputStream);
            this.p1 = Integer.parseInt(this.properties.getProperty("port.1"));
            this.p2 = Integer.parseInt(this.properties.getProperty("port.2"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == ventanaCliente.getButton1()){
            mensaje = ventanaCliente.getTextField1().getText();
            cliente.enviarCadenas(mensaje);
        }
        if(e.getSource() == ventanaCliente.getButton2()){
            cliente.cerrarSockets(true);
            System.out.println("Desconectado");
        }
    }
}
