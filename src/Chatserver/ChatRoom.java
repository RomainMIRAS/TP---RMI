package Chatserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ChatRoom extends UnicastRemoteObject implements IChatRoom{

	protected ChatRoom() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leave() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void say(String msgToSay) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> who() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
