package babystep;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) {
		Registry registry = LocateRegistry.createRegistry(9999);
		registry.bind("WS", ws);	
	}
}
