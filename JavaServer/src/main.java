import java.io.*;
import java.net.*;
import java.util.*;

import Addons.test;

import java.nio.*;

//Die Main stellt NUR eine Verbindung her und gibt dann an "Aufgaben" weiter
public class main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("1) Server starten\n2) Status Test \n99)Quit\n");
		int temp = 0;
		
		//test.doStuff();
		
		while(true){
			temp = sc.nextInt();
		switch (temp){
			case 1: startServer();
							break;
			case 2: testServer();
							break;
			case 99:System.exit(0);
			default:continue;
			}
		}
	}

	//startet den Server und wartet auf eine Verbindung
	public static void startServer()throws IOException{
		int port = 12345;

		ServerSocket server = new ServerSocket(port);

		while (true) {
			Socket client = null;
			server.setSoTimeout(60000); // Timeout nach 1 Minute, dann neue Verbindung
			try {
				System.out.println("Bereit");
				client = server.accept();
				LogData.LogdataWriting("connected", client);
				Aufgaben.ConversationStart(client);
			} catch (IOException e) {
				System.out.println("Timeout");
				e.printStackTrace();
			} finally {
				if (client != null)
					try {
						client.close();
					} catch (IOException e) {
					}
			}
		}
	}

	public static void testServer(){
		System.out.println("Status \t" + "ONLINE");
		System.out.println("Files \t" + checkFiles());
		System.out.println("READY TO START\n----------------------------------------------\n\n");
	}

	public static String checkFiles(){
		if (new File("Users.txt").exists()){
			return "CONFIRMED";
		}
		return "NOT CONFIRMED";
	}
}
