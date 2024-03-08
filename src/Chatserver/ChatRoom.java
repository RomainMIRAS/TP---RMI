package Chatserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatRoom extends UnicastRemoteObject implements IChatRoom{

	protected ChatRoom() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String name() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connect(IParticipant p) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leave(IParticipant p) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] who() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void send(IParticipant p, String msg) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
