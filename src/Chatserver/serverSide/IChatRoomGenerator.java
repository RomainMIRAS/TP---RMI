package Chatserver.serverSide;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Chatserver.clientSide.IParticipant;

public interface IChatRoomGenerator extends Remote {
	
	IChatRoom connect(IParticipant p, int idChatRoom) throws RemoteException;

	void delete(IChatRoom chatRoomToDelete) throws RemoteException;
	
}
