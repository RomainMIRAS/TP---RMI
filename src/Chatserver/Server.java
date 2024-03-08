package Chatserver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		Registry registry = LocateRegistry.createRegistry(9999);
		ChatRoom chatroom = new ChatRoom("ChatRoom 1");
		registry.rebind("ChatRoom", chatroom);	
	}
}
