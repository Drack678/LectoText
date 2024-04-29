package Cliente.Model;

import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public class ClienteConexion {

    private ServerSocket fromServer;
    private DataOutputStream dataOutputStreamCliente;
    private Socket socketClienteOut, socketClienteIn;
    private DataInputStream dataInputStreamCliente;
    private int puerto;
    //private boolean activo = true;
    private static String IP_SERVER;
    private String mensaje = "HOLA";
    public void cerrarSockets(boolean activo) {
        if(activo){
            try {
                dataInputStreamCliente.close();
                socketClienteIn.close();
                socketClienteOut.close();
                dataOutputStreamCliente.close();
                fromServer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error: no se pudo cerrar los sockets");
            }
        }
    }
    public ClienteConexion(int puerto1, int puerto2) {
        this.puerto = puerto1;
        try {
            socketClienteOut = new Socket(ClienteConexion.IP_SERVER , puerto);
            //socketClienteIn = new Socket(ClienteConexion.IP_SERVER, puerto2);
            dataOutputStreamCliente = new DataOutputStream(socketClienteOut.getOutputStream());
            //dataInputStreamCliente = new DataInputStream(socketClienteIn.getInputStream());
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Error: no se encontro el servidor");
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: no se pudo conectar con el servidor");
            System.out.println(ex.getMessage());
        }
        enviarCadenas(mensaje);
    }
    public void enviarCadenas(String mensaje) {
        try {
            dataOutputStreamCliente.writeUTF(mensaje);   
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, "Error: no se pudo crear los flujos");
        }
    }

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }
    /*public void setActivo(boolean activo){
        this.activo = activo;
    }*/
}