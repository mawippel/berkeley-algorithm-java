package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;

/**
 * Interface to the Client-Side access the methods
 * 
 * @author Marcelo Wippel
 */
public interface HorarioServidor extends Remote {
    
    LocalTime getHorario() throws RemoteException;
    
    void setHorario(LocalTime horario) throws RemoteException;
    
}