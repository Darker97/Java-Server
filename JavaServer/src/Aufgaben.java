import java.net.*;
import java.security.PublicKey;
import java.util.*;
import java.io.*;

public class Aufgaben {
	// Alle grundelgenden Aufgaben die der Server verrichten kann

	public static Socket clientInUse;
	public static User userInUse;

	/* Start der Conversation mit dem Client und vermittlung auf die einzelnen Funktionen
	 *
	 */
	public static void ConversationStart(Socket client) throws IOException {
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		Scanner in = new Scanner(client.getInputStream());
		clientInUse = client;

		//erstellt neue Keys
		User user = new User();
		userInUse = user;
		security.generateKey(user);

		//erhält publik keys vom Client
		user.setUserPublikKey((PublicKey)in.next());

		LogData.LogdataWriting("sichere Verbindung aufgebaut", client);

		//Laden aller notwendigen Files, hier Die hashes vom Username + passwort
		DatenLader.UserLaden();


		user.setName(user.entschluesseln(in.nextLine()));
		user.setPasswort(user.entschluesseln(in.nextLine()));


		//Nächsten zwei Nachrichten sind Username und Passwort
		if(!passwort.passwortAbfrage(user.getName(), user.getPasswort())) {
			client.close();
			return;
			}

		System.out.println("verbunden");



		out.println("succes");
		ExtendetUser.main();

	}

	//sendet alle Nachrichten
	public static void senden(String zuSenden) throws IOException{
		PrintWriter out = new PrintWriter(clientInUse.getOutputStream(), true);

	}

	public static String empfangen() throws IOException {
		Scanner in = new Scanner(clientInUse.getInputStream());
		return userInUse.entschluesseln(in.nextLine());
	}

}
