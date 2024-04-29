package Servidor.Controller;

import java.io.IOException;
import java.util.Properties;
import Servidor.Model.ServidorConexion;
import Servidor.View.*;

public class ControllerServidor {
    private ServidorConexion servidor;
    private Properties properties;
    private FileChooser fileChooser;
    private int p1;
    private Aviso aviso;
    
    public ControllerServidor(){
        this.aviso = new Aviso();
        this.properties = new Properties();
        this.fileChooser = new FileChooser();
        cargarProperties();
        this.servidor = new ServidorConexion(p1);
        aviso.verMensaje("Servidor lanzado");
        try{
            servidor.conectar();
        }catch(IOException e){
            aviso.verExcepcionConexion(e);
        }
    }
    public void cargarProperties(){
        try{
            this.properties.load(this.fileChooser.getProperties());
            this.p1 = Integer.parseInt(this.properties.getProperty("port.1"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
