package babystep;

import java.rmi.Remote;

public interface IPrinter extends Remote{
	void print(String s);
}
