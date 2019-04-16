package common;

import java.time.format.DateTimeFormatter;

public interface AppConstants {

	public final String SERVER_NAME_1 = "localhost";
	public final int SERVER_PORT_1 = 1500;
	
	public final String SERVER_NAME_2 = "localhost";
	public final int SERVER_PORT_2 = 1501;
	
	public final String SERVER_NAME_3 = "localhost";
	public final int SERVER_PORT_3 = 1502;
	
	public final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
}
