package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculadoraServerInterface extends Remote {

	public int somar(int a, int b) throws RemoteException;
	
}
