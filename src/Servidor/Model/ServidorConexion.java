package Servidor.Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorConexion {
    private ServerSocket ServerSocketServidor;
    private Socket socketClienteIn;
    private int puerto1;
    private boolean activo = true;
    private String mensaje;

    public ServidorConexion(int puerto1) {
        this.puerto1 = puerto1;
    }

    public void conectar()throws IOException{
        ServerSocketServidor = new ServerSocket(puerto1);
    }

    public void cerrarSockets()throws IOException{ 
        socketClienteIn.close();
        ServerSocketServidor.close();
    }
    public void setActivo(boolean activo){
        this.activo = activo;
    }
    public boolean getActivo(){
        return this.activo;
    }
    public String getMensaje(){
        return this.mensaje;
    }
    public ServerSocket getServerSocket(){
        return this.ServerSocketServidor;
    }
}
