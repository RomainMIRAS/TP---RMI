package Chatserver.serverSide;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Chatserver.clientSide.IParticipant;

public class ChatRoom extends UnicastRemoteObject implements IChatRoom{

	String chatRoomName;
	ArrayList<IParticipant> users;
	
	protected ChatRoom(String chatRoomName) throws RemoteException {
		super();
		users = new ArrayList<>();
		this.chatRoomName = chatRoomName;
	}

	@Override
	public String name() throws RemoteException {
		return chatRoomName;
	}

	@Override
	public void connect(IParticipant p) throws RemoteException {
		users.add(p);
		System.out.println("Participant "+p.name()+" has joined the chatroom "+chatRoomName);
		//Affichage cote serveur de la conversation de la chatroom
	}

	@Override
	public void leave(IParticipant p) throws RemoteException {
		users.remove(p);
		System.out.println("Participant "+p.name()+" has left the chatroom "+chatRoomName);
		//Affichage cote serveur de la conversation de la chatrooms
	}

	@Override
	public String[] who() throws RemoteException {
		String[] usersName = new String[users.size()];
		for (int i = 0; i < usersName.length; i++) {
			usersName[i] = users.get(i).name();
		}
		return usersName;
	}

	@Override
	public void send(IParticipant p, String msg) throws RemoteException {
		//Affichage cote serveur de la conversation de la chatroom
		System.out.println("Participant "+p.name()+": "+msg);

		for (IParticipant user : users) {
			if (!p.equals(user)) {
				user.receive(p.name(), msg);
			}
		}
	}

}