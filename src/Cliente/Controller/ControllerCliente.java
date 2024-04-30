package Cliente.Controller;

import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

import Cliente.Model.ClienteConexion;
import Cliente.View.Aviso;
import Cliente.View.FileChooser;
import Cliente.View.VentanaCliente;

public class ControllerCliente implements ActionListener{
    private ClienteConexion cliente;
    private VentanaCliente ventanaCliente;
    private Properties properties;
    private int p1;
    private String mensaje = "HOLA";
    private FileChooser fileChooser;
    private Aviso aviso;
    private HiloCliente hilo;
    
    public ControllerCliente(){
        this.properties = new Properties();
        this.fileChooser = new FileChooser();
        this.aviso = new Aviso();
        cargarProperties();
        try {
            this.cliente = new ClienteConexion(p1);
        } catch (UnknownHostException e) {
            aviso.verExcepcionHost(e);
        } catch (Exception e) {
            aviso.verExcepcionConexion(e);
        }
        hilo = new HiloCliente(this);
        this.ventanaCliente = new VentanaCliente();
        hilo.start();
        ventanaCliente.getButton1().addActionListener(this);
        ventanaCliente.getButton2().addActionListener(this);
    }
    public void cargarProperties(){
        try{
            this.properties.load(this.fileChooser.getProperties());
            this.p1 = Integer.parseInt(this.properties.getProperty("port.1"));
        }catch(Exception e){
            aviso.verExcepcionProperties(e);
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == ventanaCliente.getButton1()){
            this.mensaje = ventanaCliente.getTextField1().getText();
            hilo.run();
            //System.out.println(mensaje);
        }
        if(e.getSource() == ventanaCliente.getButton2()){
            try{
            cliente.cerrarSockets(true);
            }catch(Exception ex){
                aviso.verExcepcionCerrar(ex);
            }
            ventanaCliente.getFrame1().dispose();
            aviso.verMensaje("Desconectado");
        }
    }
    /*public void charlar( String mensaje){
        try{
            cliente.enviarCadenas(mensaje);
        }catch(Exception ex){
            aviso.verExcepcionFlujos(ex);
        }
        ventanaCliente.getTextField1().setText("");
    }*/
    public String getMessage(){
        return this.mensaje;
    }
    public ClienteConexion getClienteConexion(){
        return this.cliente;
    }
    public Aviso getAviso(){
        return this.aviso;
    }
}
