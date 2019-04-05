package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Implementation of {@link HorarioServidor}
 * @author Marcelo Wippel
 */
public class HorarioServidorImpl extends UnicastRemoteObject implements HorarioServidor {

	private static final long serialVersionUID = -6810169856453308607L;
	
    private LocalTime horario;
    
    public HorarioServidorImpl(LocalTime horario) throws RemoteException {
        this.horario = horario;
    }

    @Override
    public LocalTime getHorario() throws RemoteException {
        return horario;
    }

    @Override
    public void setHorario(LocalTime horario) throws RemoteException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("Horário atualizado: " + dtf.format(horario));
        this.horario = horario;
    }
    
}