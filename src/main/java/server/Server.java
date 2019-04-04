package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;

/**
 * Server of the application.
 * Initializes 2 instances.
 * 
 * @author Marcelo Wippel
 */
public class Server {
    
    public static final int PORTA_SERVIDOR_1 = 1234;
    public static final int PORTA_SERVIDOR_2 = 12345;

    /**
     * Main
     * @param args 
     */
    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            
            // Servidor 1
            HorarioServidor hs1 = new HorarioServidorImpl(sdf.parse("07:30:10"));
            Registry registry1 = LocateRegistry.createRegistry(PORTA_SERVIDOR_1);
            registry1.rebind("HorarioServidorImpl", hs1);
            System.out.println("Servidor 1 iniciado...");
            
            // Servidor 2
            HorarioServidor hs2 = new HorarioServidorImpl(sdf.parse("09:20:15"));
            Registry registry2 = LocateRegistry.createRegistry(PORTA_SERVIDOR_2);
            registry2.rebind("HorarioServidorImpl", hs2);
            System.out.println("Servidor 2 iniciado...");
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}