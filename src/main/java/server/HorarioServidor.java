package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Interface to the Client-Side access the methods
 * 
 * @author Marcelo Wippel
 */
public interface HorarioServidor extends Remote {
    
    public Date getHorario() throws RemoteException;
    
    public void setHorario(Date horario) throws RemoteException;
    
}