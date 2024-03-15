package Chatserver.serverSide;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Chatserver.clientSide.IParticipant;

public class ChatRoomGenerator  extends UnicastRemoteObject implements IChatRoomGenerator {
	
	ArrayList<IChatRoom> chatrooms;
	
	public ChatRoomGenerator() throws RemoteException {
		super();
		chatrooms = new ArrayList();
	}
	
	/**
	 * Method Used to create a chatroom if not already creater or to connect to it.
	 */
	@Override
	public IChatRoom connect(IParticipant p, String chatRoomName) throws RemoteException {
		for (IChatRoom chatroom : chatrooms) {
			if (chatroom.name().equals(chatRoomName)) {
				((ChatRoom) chatroom).connectToChatRoom(p);
				return chatroom;
			}
		}
		ChatRoom newChatRoom = new ChatRoom(chatRoomName,this);
		chatrooms.add(newChatRoom);
		newChatRoom.connectToChatRoom(p);
		return newChatRoom;
	}

	/**
	 * Deleted a chatroom from the list of chatroom
	 */
	@Override
	public void delete(IChatRoom chatRoomToDelete) throws RemoteException {
		chatrooms.remove(chatRoomToDelete);
	}
}
