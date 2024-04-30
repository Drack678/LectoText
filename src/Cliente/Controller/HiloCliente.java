package Cliente.Controller;

import java.io.IOException;

public class HiloCliente extends Thread {
    private ControllerCliente controllerCliente;

    public HiloCliente(ControllerCliente controllerCliente){
        this.controllerCliente = controllerCliente;
    }

    public void run (){
        try{
            controllerCliente.getClienteConexion().getOutputStream().writeUTF(controllerCliente.getMessage());
        }catch(IOException e){
            controllerCliente.getAviso().verExcepcionFlujos(e);
        }
    }
}
