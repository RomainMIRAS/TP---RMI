package Chatserver;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IChatRoom extends Remote{
	void connect()  throws RemoteException;
	void leave()  throws RemoteException;
	void say(String msgToSay)  throws RemoteException;
	List<String> who()  throws RemoteException;
}
