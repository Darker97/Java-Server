import java.net.*;
import java.io.*;
import java.util.*;

//Simpler Client der nur eine Verbindung aufbaut und eien einfachen String sendet und empfängt/ausgibt
public class main {

	public static void main(String[] args) {
		Socket server = null;

		try {
			server = new Socket("127.0.0.1", 12345);
			Scanner in = new Scanner(server.getInputStream());
			PrintWriter out = new PrintWriter(server.getOutputStream(), true);

			out.println("Connection");
			System.out.println(in.nextLine());


		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
