package Servidor.View;

import javax.swing.JOptionPane;

public class Aviso {
    public void verExcepcionConexion(Exception e) {
        JOptionPane.showMessageDialog(null, "Error al enviar el mensaje al servidor");
    }
    public void verExcepcionEnvio(Exception e) {
        JOptionPane.showMessageDialog(null, "Error: no se pudo recibir cadena");
    }
    public void verMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
