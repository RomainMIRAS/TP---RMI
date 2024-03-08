package Chatserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatRoom extends UnicastRemoteObject implements IChatRoom{

	protected ChatRoom() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
