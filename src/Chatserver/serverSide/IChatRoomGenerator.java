package Chatserver.serverSide;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Chatserver.clientSide.IParticipant;

public interface IChatRoomGenerator extends Remote {
	
	void delete(IChatRoom chatRoomToDelete) throws RemoteException;

	IChatRoom connect(IParticipant p, String ChatRoomName) throws RemoteException;
	
}
