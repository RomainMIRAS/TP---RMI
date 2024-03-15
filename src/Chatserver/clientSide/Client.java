package Chatserver.clientSide;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import Chatserver.serverSide.IChatRoom;

public class Client {
	public static void main(String[] args) throws RemoteException  {
		Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9999);
		IChatRoom chatroom = null;
		try {
			chatroom = (IChatRoom) registry.lookup("ChatRoom");
		} catch ( NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner in = new Scanner(System.in);
		System.out.println("Votre nom de chatroom :");
		String s = in.nextLine();
		
		IParticipant moi = new Participant(s);
		chatroom.connect(moi);
		
		System.out.println("Bienvenue sur la chatroom : " + chatroom.name());
		while(true) {
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
		}
	}
}
