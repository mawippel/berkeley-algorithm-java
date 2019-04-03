package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
	public static void main(String[] args) {
		try {
			CalculadoraServerInterface sdrmi = new CalculadoraServerInterfaceImpl();
			//Registry registry = LocateRegistry.getRegistry();
			Registry registry = LocateRegistry.createRegistry(1231);
			registry.rebind("CalculadoraServerInterfaceImpl", sdrmi);
			System.out.println("Servidor Calculadora " + sdrmi + " registrado e pronto para aceitar solicitações.");
		} catch (Exception ex) {
			System.out.println("Houve um erro: " + ex.getMessage());
		}
	}
}
