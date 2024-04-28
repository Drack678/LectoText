package Cliente.Model;

import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public class ClienteConexion {

    private ServerSocket fromServer;
    private DataOutputStream dataOutputStreamCliente;
    private Socket socketClienteOut, socketClienteIn;
    private DataInputStream dataInputStreamCliente;
    private int puerto1;
    private boolean activo = true;
    private static String IP_SERVER;
    private String mensaje;

    public ClienteConexion(int puerto1, int puerto2) {
        this.puerto1 = puerto1;
        //this.puerto2 = puerto2;
    }

    public void conectar() {
        try {
            socketClienteOut = new Socket(ClienteConexion.IP_SERVER , puerto1);
            //socketClienteIn = new Socket(ClienteConexion.IP_SERVER, puerto2);
            dataOutputStreamCliente = new DataOutputStream(socketClienteOut.getOutputStream());
            //dataInputStreamCliente = new DataInputStream(socketClienteIn.getInputStream());
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Error: no se encontro el servidor");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: no se pudo conectar con el servidor");
        }
        enviarCadenas();
    }
    private void enviarCadenas() {
        try {
            do{
                dataOutputStreamCliente.writeUTF(mensaje);   
            }while(activo);
            cerrarSockets();
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, "Error: no se pudo crear los flujos");
        }
    }

    private void cerrarSockets() {
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
    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }
    public void setActivo(boolean activo){
        this.activo = activo;
    }
}