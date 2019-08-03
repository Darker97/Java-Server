import java.io.File;
import java.io.IOException;
import java.util.*;

import com.sun.jdi.Method;

public class ExtendetUser{

	private static ArrayList<String> files;

    public static void main() throws IOException {
    	load();
    	String auswahl = "";
    	while (true){

    		Aufgaben.senden(menue(files.iterator()));
    		auswahl = Aufgaben.empfangen();

    		aufruf( Integer.parseInt(auswahl));
    	}
    }

    //Lädt alle Dateien aus dem Verzeichnis
    private static void load() {
    	File f = new File("/Addons/");
    	File[] fileArray = f.listFiles();

            for (int i = 0; i < fileArray.length; i++) {
                //System.out.print(fileArray[i].getAbsolutePath());
                files.add(fileArray[i].getName());
            }
    }


    public static String menue(Iterator<String> file){
    	String send ="Was möchtest du tun?\n";
    	//System.out.println("Was möchtest du tun?");
    	for (int i= 1; file.hasNext(); i++) {
    		send = send +(i+") "+file.next()).toString();
    		file.remove();
    	}
    	//System.out.println("99) Server abschalten");
    	send = send + "99) Server abschalten";
    	return send;
    }


    @SuppressWarnings("rawtypes")
	public static void aufruf(int Eingabe) {
    	if (Eingabe == 99) System.exit(0);

    	String temp = files.get(Eingabe);
    	temp = temp.substring(temp.indexOf(".java"), temp.length());

    	//TODO: Methode.Klasse aus einem String ausführen
    	Class tempKlasse = Class.forName(temp);
    	Method newMethod = tempKlasse.start();
    	return;
    }
}
