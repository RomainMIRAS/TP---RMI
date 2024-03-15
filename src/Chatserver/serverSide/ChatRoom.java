package Chatserver.serverSide;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Chatserver.clientSide.IParticipant;

public class ChatRoom extends UnicastRemoteObject implements IChatRoom{

	String chatRoomName;
	ArrayList<IParticipant> users;
	HashMap<String, ArrayList<SimpleEntry<String,String>>> previousUsers;
	IChatRoomGenerator myParent;
	
	protected ChatRoom(String chatRoomName, IChatRoomGenerator myParent) throws RemoteException {
		super();
		users = new ArrayList<>();
		this.chatRoomName = chatRoomName;
		previousUsers = new HashMap<String, ArrayList<SimpleEntry<String, String>>>();
		this.myParent = myParent;
	}

	@Override
	public String name() throws RemoteException {
		return chatRoomName;
	}

	public void connectToChatRoom(IParticipant p) throws RemoteException {
		users.add(p);
		System.out.println("Participant "+p.name()+" has joined the chatroom " + chatRoomName);
		//Affichage cote serveur de la conversation de la chatroom
		
		// Get previous message if he already connect to this room
		for (String previoususer : previousUsers.keySet()) {
			if (previoususer.equals(p.name())) {
				p.receive(" ayant envoyé des messages pendant votre absence ", "");
				for (SimpleEntry<String, String> previousMessage : previousUsers.get(previoususer)) {
					p.receive(previousMessage.getKey(), previousMessage.getValue());
				}
				previousUsers.remove(previoususer);
			}
		}
	}

	@Override
	public void leave(IParticipant p) throws RemoteException {
		users.remove(p);
		System.out.println("ChatRoom " + name() + " - Participant "+p.name()+" has left the chatroom "+chatRoomName);
		//Affichage cote serveur de la conversation de la chatrooms
		
		// Si plus de user -> On supprime la room
		if (users.size() == 0) {
			myParent.delete(this);
			return ;
		}
		
		previousUsers.put(p.name(), new ArrayList<SimpleEntry<String, String>>());
		
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
		System.out.println("ChatRoom " + name() + " - Participant "+p.name()+": "+msg);
		
		ArrayList<IParticipant> usersToRemove = new ArrayList();
		for (IParticipant user : users) {
			if (!p.equals(user)) {
				try {
					user.receive(p.name(), msg);
				} catch (RemoteException e) {
					usersToRemove.add(user);
				}
			}
		}
		
		// If Exception Remove User Disconnected
		for (IParticipant userToRemove : usersToRemove) {
			users.remove(userToRemove);
		}
		
		//Store the previous message
		for (ArrayList<SimpleEntry<String, String>> previousMessageListe : previousUsers.values()) {
			previousMessageListe.add(new SimpleEntry<>(p.name(), msg));
		}
	}

}
