package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Implementation of {@link HorarioServidor}
 * @author Marcelo Wippel
 */
public class HorarioServidorImpl extends UnicastRemoteObject implements HorarioServidor {

	private static final long serialVersionUID = -6810169856453308607L;
	
    private Date horario;
    
    public HorarioServidorImpl(Date horario) throws RemoteException {
        this.horario = horario;
    }

    @Override
    public Date getHorario() throws RemoteException {
        return horario;
    }

    @Override
    public void setHorario(Date horario) throws RemoteException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Horário atualizado: " + sdf.format(horario));
        this.horario = horario;
    }
    
}