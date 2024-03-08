package babystep;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) {
		Registry registry = LocateRegistry.getRegistry("myweekendhost.xxx.yy", 9999);
		IWeatherStation ws = (IWeatherStation) registry.lookup("WS");
		int temp=ws.getTemperature(..);
		String dir=ws.getWindDirection();
		int speed=ws.getWindSpeed();
		System.out.println("Temp="+temp+" Wind speed="+speed+" Direction="+dir);
	}
}
