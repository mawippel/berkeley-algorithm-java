package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;

import common.AppConstants;

/**
 * Implementation of {@link HorarioServidor}
 * 
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
	public void ajustarHora(LocalTime horaClient, long diffNanos) throws RemoteException {
		long horarioLocalNanos = horaClient.toNanoOfDay();
		long thisNanos = this.getHorario().toNanoOfDay();
		var newNanos = thisNanos - horarioLocalNanos;
		newNanos = newNanos * -1 + diffNanos + thisNanos;
		LocalTime newLocalTime = LocalTime.ofNanoOfDay(newNanos);
		System.out.println("Hor�rio atualizado: " + AppConstants.formatter.format(newLocalTime));
		this.horario = newLocalTime;
	}

}