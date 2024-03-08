package Chatserver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import babystep.Printer;

public class Server {
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		Registry registry = LocateRegistry.createRegistry(9999);
		ChatRoom printer = new ChatRoom();
		registry.rebind("LinePrinter", printer);	
	}
}
