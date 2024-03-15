package Chatserver.clientSide;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import Chatserver.serverSide.IChatRoom;
import Chatserver.serverSide.IChatRoomGenerator;

public class Client {
	public static void main(String[] args) throws RemoteException  {
		Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9999);
		while (true) { // Always Trying to connect to the server
			IChatRoomGenerator chatroomGenerator = null;
			while(true) {
				try {
					chatroomGenerator = (IChatRoomGenerator) registry.lookup("ChatRoomGenerator");
					break;
				} catch ( NotBoundException e) {
					//Can't reach Server So Loop
				} catch (RemoteException e) {
					//Can't reach Server So Loop
				}
			}

			System.out.println("Connected To the Server");
			Scanner in = new Scanner(System.in);

			System.out.println("Le nom de la chatroom :");
			String sChatroom = in.nextLine();

			System.out.println("Votre nom dans la chatroom :");
			String sUser = in.nextLine();

			IParticipant moi = new Participant(sUser);
			IChatRoom chatroom = chatroomGenerator.connect(moi, sChatroom);

			System.out.println("Bienvenue sur la chatroom : " + chatroom.name());
			String s = null;
			boolean ServerRunning = true;
			while(ServerRunning) {
				try {
					s = in.nextLine();
					switch (s) {
					case "/who":
						String[] who = chatroom.who();
						System.out.println("Participants :");
						for (String string : who) {
							System.out.println("- " + string);
						}
						break;
					case "/help":
						System.out.println("Commandes disponibles :");
						System.out.println("/who : liste les participants");
						System.out.println("/quit : quitte la chatroom");
						break;
					case "/quit":
						chatroom.leave(moi);
						System.out.println("Merci d'avoir participé !");
						System.exit(0);
						break;
					default:
						chatroom.send(moi, s);
						break;
					}
				} catch (RemoteException e) {
					// Le server c'est fermé.
					System.out.println("Serveur is down...");
					ServerRunning = false;
					System.out.println("Trying to reconnect");
				}
			}
		}
	}
}
