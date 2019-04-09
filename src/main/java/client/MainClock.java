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

			LocalTime horarioLocal = LocalTime.parse("06:04:05", AppConstants.formatter);
			times.add(horarioLocal);
			System.out.println("Horário Local: " + formatter.format(horarioLocal));

			// Conexão Servidor 1
			Registry registry1 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_1, AppConstants.SERVER_PORT_1);
			HorarioServidor hs1 = (HorarioServidor) registry1.lookup(HorarioServidorImpl.class.getSimpleName());
			System.out.println("Conexão com Servidor 1 estabelecida com sucesso.");
			LocalTime horarioServidor1 = hs1.getHorario();
			times.add(horarioServidor1);
			System.out.println("Horário Servidor 1: " + formatter.format(horarioServidor1));

			// Conexão Servidor 2
			Registry registry2 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_2, AppConstants.SERVER_PORT_2);
			HorarioServidor hs2 = (HorarioServidor) registry2.lookup(HorarioServidorImpl.class.getSimpleName());
			System.out.println("Conexão com Servidor 2 estabelecida com sucesso.");
			LocalTime horarioServidor2 = hs2.getHorario();
			times.add(horarioServidor2);
			System.out.println("Horário Servidor 2: " + formatter.format(horarioServidor2));

			// Conexão Servidor 3
			Registry registry3 = LocateRegistry.getRegistry(AppConstants.SERVER_NAME_3, AppConstants.SERVER_PORT_3);
			HorarioServidor hs3 = (HorarioServidor) registry3.lookup(HorarioServidorImpl.class.getSimpleName());
			System.out.println("Conexão com Servidor 3 estabelecida com sucesso.");
			LocalTime horarioServidor3 = hs3.getHorario();
			times.add(horarioServidor3);
			System.out.println("Horário Servidor 3: " + formatter.format(horarioServidor3));

			// Média (Berkeley)
			long nanosSum = horarioLocal.toNanoOfDay();
			for (LocalTime t : times) {
				nanosSum += t.toNanoOfDay();
			}
			LocalTime horarioNovo = LocalTime.ofNanoOfDay(nanosSum / (times.size() + 1));
			System.out.println("Média: " + formatter.format(horarioNovo));

			// Atribuir Data Nova
			hs1.setHorario(horarioNovo);
			hs2.setHorario(horarioNovo);
			horarioLocal = horarioNovo;
			System.out.println("Horários atualizados");

			// Verificar horario em todas as instâncias
			System.out.println("Horario Local: " + formatter.format(horarioLocal));
			System.out.println("Horario Servidor 1: " + formatter.format(hs1.getHorario()));
			System.out.println("Horario Servidor 2: " + formatter.format(hs2.getHorario()));
			System.out.println("Horario Servidor 2: " + formatter.format(hs2.getHorario()));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}