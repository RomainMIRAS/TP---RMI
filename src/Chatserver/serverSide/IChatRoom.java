package Chatserver.serverSide;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Chatserver.clientSide.IParticipant;

public interface IChatRoom extends Remote {
	String name() throws RemoteException;

	void connect(IParticipant p) throws RemoteException;

	void leave(IParticipant p) throws RemoteException;

	String[] who() throws RemoteException;

	void send(IParticipant p, String msg) throws RemoteException;
}
