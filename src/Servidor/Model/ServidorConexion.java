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

    public void conectar()throws IOException{
        ServerSocketServidor = new ServerSocket(puerto1);
        socketClienteIn = ServerSocketServidor.accept();
        dataInputStreamCliente = new DataInputStream(socketClienteIn.getInputStream());
        recibirCadenas();
    }
    private void recibirCadenas()throws IOException{
        while(activo){
            mensaje = dataInputStreamCliente.readUTF();
            System.out.println(mensaje); 
        }
        cerrarSockets();
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
