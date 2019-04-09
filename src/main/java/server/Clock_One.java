package server;

import static common.AppConstants.formatter;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;

import common.AppConstants;

public class Clock_One {

	public static void main(String[] args) {
		try {
			// Servidor 1
			HorarioServidor hs1 = new HorarioServidorImpl(LocalTime.parse("12:24:30", formatter));
			Registry registry1 = LocateRegistry.createRegistry(AppConstants.SERVER_PORT_1);
			registry1.rebind(HorarioServidorImpl.class.getSimpleName(), hs1);
			System.out.println(String.format("Servidor 1 iniciado na porta %s", AppConstants.SERVER_PORT_1));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
