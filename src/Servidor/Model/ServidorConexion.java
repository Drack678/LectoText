package Servidor.Model;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServidorConexion {
    private ServerSocket ServerSocketServidor;
    private Socket socketClienteIn;
    private DataInputStream dataInputStreamCliente;
    private int puerto1;
    private boolean activo = true;
    private String mensaje;

    public ServidorConexion(int puerto1) {
        this.puerto1 = puerto1;
    }

    public void conectar() {
        try {
            ServerSocketServidor = new ServerSocket(puerto1);
            System.out.println("Esperando coneccion:");
            socketClienteIn = ServerSocketServidor.accept();
            System.out.println("Cliente conectado");
            dataInputStreamCliente = new DataInputStream(socketClienteIn.getInputStream());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: no se pudo conectar con el servidor");
        }
        recibirCadenas();
    }
    private void recibirCadenas() {
        try {
            while(activo){
                mensaje = dataInputStreamCliente.readUTF();
                System.out.println(mensaje); 
            }
            cerrarSockets();
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, "Error: no se pudo crear los flujos");
        }
    }

    private void cerrarSockets() {
        try {
            dataInputStreamCliente.close();
            socketClienteIn.close();
            ServerSocketServidor.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: no se pudo cerrar los sockets");
        }
    }
    public void setActivo(boolean activo){
        this.activo = activo;
    }
}
