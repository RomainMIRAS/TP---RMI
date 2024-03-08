package babystep;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Printer extends UnicastRemoteObject implements IPrinter {
	
	protected Printer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print(String s) {
		System.out.println(s);
	}

}
