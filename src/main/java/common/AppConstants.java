package common;

import java.time.format.DateTimeFormatter;

public interface AppConstants {

	public final String SERVER_NAME_1 = "10.13.25.30";
	public final int SERVER_PORT_1 = 1500;
	
	public final String SERVER_NAME_2 = "201.54.201.52";
	public final int SERVER_PORT_2 = 1501;
	
	public final String SERVER_NAME_3 = "201.54.201.47";
	public final int SERVER_PORT_3 = 1502;
	
	public final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
}
