package Servidor.Controller;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class  HiloServidor implements Runnable {
    private Socket socketCliente;
    private ServerSocket aux;
    private DataInputStream inputStream;
    private ControllerServidor control;

    public HiloServidor(ServerSocket serverSocket, ControllerServidor control) {
        try {
            this.aux = serverSocket;
            this.control = control;
        } catch (Exception e) {
           System.out.println("Inesperado");
        }
    }

    public void run() {
        try {
            while (control.getConexion().getActivo()) {
                // Leer mensaje del cliente
                this.socketCliente = aux.accept();
                this.inputStream = new DataInputStream(socketCliente.getInputStream());
                String mensaje = inputStream.readUTF();
                System.out.println("Mensaje recibido de " + socketCliente.getInetAddress() + ": " + mensaje);
            }
        } catch (IOException e) {
            System.out.println("Inesperado");
            e.printStackTrace();
        }
    }
}
