package client;

import java.rmi.registry.*;

import server.CalculadoraServerInterface;

public class Main {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 1231);
			CalculadoraServerInterface c = (CalculadoraServerInterface) registry
					.lookup("CalculadoraServerInterfaceImpl");
			System.out.println("O objeto servidor " + c + " foi encontrado com sucesso.\n");

			System.out.println("A soma de 2 + 5 é: " + c.somar(2, 5));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
