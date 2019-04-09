package client;

import static common.AppConstants.formatter;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;
import java.util.ArrayList;

import common.AppConstants;
import server.HorarioServidor;
import server.HorarioServidorImpl;

/**
 * Client-Side
 * 
 * @author Marcelo Wippel
 */
public class MainClock {

	public static void main(String[] args) {
		try {
			var times = new ArrayList<LocalTime>();

			LocalTime horarioLocal = LocalTime.parse("07:00:00", AppConstants.formatter);
			times.add(horarioLocal);
			System.out.println("Hor�rio Local: " + formatter.format(horarioLocal));

			// Conex�o Servidor 1
			Registry registry1 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_1, AppConstants.SERVER_PORT_1);
			HorarioServidor hs1 = (HorarioServidor) registry1.lookup(HorarioServidorImpl.class.getSimpleName());
			System.out.println("Conex�o com Servidor 1 estabelecida com sucesso.");
			LocalTime horarioServidor1 = hs1.getHorario();
			times.add(horarioServidor1);
			System.out.println("Hor�rio Servidor 1: " + formatter.format(horarioServidor1));

			// Conex�o Servidor 2
			Registry registry2 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_2, AppConstants.SERVER_PORT_2);
			HorarioServidor hs2 = (HorarioServidor) registry2.lookup(HorarioServidorImpl.class.getSimpleName());
			System.out.println("Conex�o com Servidor 2 estabelecida com sucesso.");
			LocalTime horarioServidor2 = hs2.getHorario();
			times.add(horarioServidor2);
			System.out.println("Hor�rio Servidor 2: " + formatter.format(horarioServidor2));

			// Conex�o Servidor 3
			Registry registry3 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_3, AppConstants.SERVER_PORT_3);
			HorarioServidor hs3 = (HorarioServidor) registry3.lookup(HorarioServidorImpl.class.getSimpleName());
			System.out.println("Conex�o com Servidor 3 estabelecida com sucesso.");
			LocalTime horarioServidor3 = hs3.getHorario();
			times.add(horarioServidor3);
			System.out.println("Hor�rio Servidor 3: " + formatter.format(horarioServidor3));

			var nanoLocal = horarioLocal.toNanoOfDay();
			var diffSerber1 = horarioServidor1.toNanoOfDay() - nanoLocal;
			var diffSerber2 = horarioServidor2.toNanoOfDay() - nanoLocal;
			var diffSerber3 = horarioServidor3.toNanoOfDay() - nanoLocal;
			var avgDiff = (diffSerber1 + diffSerber2 + diffSerber3) / 3; 

			// Atribuir Data Nova
			hs1.ajustarHora(horarioLocal, avgDiff);
			hs2.ajustarHora(horarioLocal, avgDiff);
			hs3.ajustarHora(horarioLocal, avgDiff);
			horarioLocal = horarioLocal.plusNanos(avgDiff);
			//horarioLocal = horarioNovo;
			System.out.println("Hor�rios atualizados");

			// Verificar horario em todas as inst�ncias
			System.out.println("Horario Local: " + formatter.format(horarioLocal));
			System.out.println("Horario Servidor 1: " + formatter.format(hs1.getHorario()));
			System.out.println("Horario Servidor 2: " + formatter.format(hs2.getHorario()));
			System.out.println("Horario Servidor 3: " + formatter.format(hs3.getHorario()));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}