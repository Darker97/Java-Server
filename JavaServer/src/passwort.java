import java.nio.charset.StandardCharsets;
import java.security.*;

public class passwort {
	//Alle Funktionen die eine UserErkennung möglich machen. User werden als verschlüsselte datei in einer INI hinterlegt.
	public static boolean passwortAbfrage(String Username, String password) throws NoSuchAlgorithmException {

			//Salt hinzufügen
			Username = Username + Konstanten.Salt;
			password = password + Konstanten.Salt;
		
			//Umwandlung des Passwortes
			 MessageDigest md = MessageDigest.getInstance("SHA-256");
			 byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

			 // bytes to hex
			 StringBuilder sb = new StringBuilder();
			 for (byte b : hashInBytes) {
					 sb.append(String.format("%02x", b));
			 }
			 System.out.println(sb.toString());
			 password=sb.toString();


			 //Umwandlung des Usernames
			 md = MessageDigest.getInstance("SHA-256");
			 hashInBytes = md.digest(Username.getBytes(StandardCharsets.UTF_8));

	 // bytes to hex
			 sb = new StringBuilder();
			 for (byte b : hashInBytes) {
					 sb.append(String.format("%02x", b));
			 }
			 System.out.println(sb.toString());
			 Username = sb.toString();

		//Test ob Passwort und Username da sind
		if(DatenLader.User.get(Username) == password) return true;
		//if(User.DatenLader.contains(Username)&&User.DatenLader.)

		return false;
	}


}
