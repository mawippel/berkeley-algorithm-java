package server;

import static common.AppConstants.formatter;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;

import common.AppConstants;

public class Clock_Two {

	public static void main(String[] args) {
		try {
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
