package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraServerInterfaceImpl extends UnicastRemoteObject implements CalculadoraServerInterface {

	private static final long serialVersionUID = -1814295622770594066L;

	public CalculadoraServerInterfaceImpl() throws RemoteException {
		// construtor padrão
	}

	// método público que recebe dois valores inteiros e
	// retorna sua soma
	public int somar(int a, int b) throws RemoteException {
		System.out.println("Somar: A " + a + " B " + b);
		return a + b;
	}
}
