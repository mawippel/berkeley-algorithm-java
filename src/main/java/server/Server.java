package server;

import static common.AppConstants.formatter;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;

import common.AppConstants;

/**
 * Server of the application. Initializes 2 instances.
 * 
 * @author Marcelo Wippel
 */
public class Server {

	public static void main(String[] args) {
		try {
			// Servidor 1
			HorarioServidor hs1 = new HorarioServidorImpl(LocalTime.parse("10:24:30", formatter));
			Registry registry1 = LocateRegistry.createRegistry(AppConstants.SERVER_PORT_1);
			registry1.rebind(HorarioServidorImpl.class.getSimpleName(), hs1);
			System.out.println(String.format("Servidor 1 iniciado na porta %s", AppConstants.SERVER_PORT_1));

			// Servidor 2
			HorarioServidor hs2 = new HorarioServidorImpl(LocalTime.parse("07:30:13", formatter));
			Registry registry2 = LocateRegistry.createRegistry(AppConstants.SERVER_PORT_2);
			registry2.rebind(HorarioServidorImpl.class.getSimpleName(), hs2);
			System.out.println(String.format("Servidor 2 iniciado na porta %s", AppConstants.SERVER_PORT_2));

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}