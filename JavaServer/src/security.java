import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.*;
import java.security.PublicKey;
import java.util.Scanner;

import javax.crypto.KeyGenerator;

public class security {
	public static void generateKey(User user) {
		KeyPairGenerator keyGen = null;
		KeyPair pair = keyGen.generateKeyPair();
		
		user.setServerPublikKey(pair.getPublic());
		user.setServerPrivateKey(pair.getPrivate());
	}
	
	private static String verschluesseln(String message) {
		
		return null;
	}

	
	public static void SendeVerschluesselt(Socket client, User user, String message) throws IOException {
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		out.println(verschluesseln(message));
	}



	public static void SendeUnVerschluesselt(Socket client, String message) throws IOException {
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		out.println(message);
	}
	
	public static String EmpfangeVerschluesselt(Socket client, User user) throws IOException {
		
		Scanner in = new Scanner(client.getInputStream());
		
		String erg = user.entschluesseln(in.nextLine());
		return erg;
	}
	public static String EmpfangeUnVerschluesselt(Socket client) throws IOException {
		Scanner in = new Scanner(client.getInputStream());
		return in.nextLine();
	}
	
}
