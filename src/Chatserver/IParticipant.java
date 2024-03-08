package Chatserver;

public interface IParticipant {
	String name();
	void receive(String name, String msg);
}
