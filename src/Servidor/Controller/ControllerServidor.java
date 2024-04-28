package Servidor.Controller;

import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JFileChooser;
import Servidor.Model.ServidorConexion;

public class ControllerServidor {
    private ServidorConexion servidor;
    private Properties properties;
    private JFileChooser fileChooser = new JFileChooser();
    private FileInputStream fileInputStream;
    private int p1;
    
    public ControllerServidor(){
        this.servidor = new ServidorConexion(p1);
        this.properties = new Properties();
        getProperties();
        charlar();
    }
    public void getProperties(){
        try{
            this.fileChooser.showOpenDialog(null);
            this.fileInputStream = new FileInputStream(this.fileChooser.getSelectedFile());
            this.properties.load(this.fileInputStream);
            this.p1 = Integer.parseInt(this.properties.getProperty("port.1"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void charlar(){
        servidor.conectar();
    }
}
