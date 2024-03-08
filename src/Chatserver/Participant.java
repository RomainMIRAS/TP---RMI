package Chatserver;

public class Participant implements IParticipant{
	
	String name;
	
	
	public Participant(String name) {
		this.name = name;
	}
	
	@Override
	public String name() {
		return this.name;
	}

	@Override
	public void receive(String name, String msg) {
		System.out.println("Participant "+name+": "+msg);
	}

}
