package babystep;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) throws RemoteException  {
		Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9999);
		IPrinter print = null;
		try {
			print = (IPrinter) registry.lookup("LinePrinter");
		} catch ( NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print.print("hello");
	}
}
