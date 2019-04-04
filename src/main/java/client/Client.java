package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;

import common.AppConstants;
import server.HorarioServidor;

/**
 * Client-Side
 * 
 * @author Marcelo Wippel
 */
public class Client {

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Date horarioLocal = sdf.parse("05:10:05");
			System.out.println("Hor�rio Local: " + sdf.format(horarioLocal));

			// Conex�o Servidor 1
			Registry registry1 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_1, AppConstants.SERVER_PORT_1);
			HorarioServidor hs1 = (HorarioServidor) registry1.lookup("HorarioServidorImpl");
			System.out.println("Conex�o com Servidor 1 estabelecida com sucesso.");
			Date horarioServidor1 = hs1.getHorario();
			System.out.println("Hor�rio Servidor 1: " + sdf.format(horarioServidor1));

			// Conex�o Servidor 2
			Registry registry2 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_2, AppConstants.SERVER_PORT_2);
			HorarioServidor hs2 = (HorarioServidor) registry2.lookup("HorarioServidorImpl");
			System.out.println("Conex�o com Servidor 2 estabelecida com sucesso.");
			Date horarioServidor2 = hs2.getHorario();
			System.out.println("Hor�rio Servidor 2: " + sdf.format(horarioServidor2));

			// M�dia (Berkeley)
			long minutosHorarioLocal = horarioLocal.getTime();
			long minutosHorarioServidor1 = horarioServidor1.getTime();
			long minutosHorarioServidor2 = horarioServidor2.getTime();
			long media = (minutosHorarioLocal + minutosHorarioServidor1 + minutosHorarioServidor2) / 3;
			Date horarioNovo = new Date(media);
			System.out.println("M�dia: " + sdf.format(horarioNovo));

			// Atribuir Data Nova
			hs1.setHorario(horarioNovo);
			hs2.setHorario(horarioNovo);
			horarioLocal = horarioNovo;
			System.out.println("Hor�rios atualizados");

			// Verificar horario em todas as inst�ncias
			System.out.println("Horario Local: " + sdf.format(horarioLocal));
			System.out.println("Horario Servidor 1: " + sdf.format(hs1.getHorario()));
			System.out.println("Horario Servidor 2: " + sdf.format(hs2.getHorario()));

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}