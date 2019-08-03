import java.security.PrivateKey;
import java.security.PublicKey;

public class User {

	private PublicKey UserPublikKey;
	private PublicKey ServerPublikKey;
	private PrivateKey ServerPrivateKey;
	private String Name;
	private String Passwort;

	User(){
	}



	public PublicKey getUserPublikKey() {
		return UserPublikKey;
	}



	public void setUserPublikKey(PublicKey userPublikKey) {
		UserPublikKey = userPublikKey;
	}



	public PublicKey getServerPublikKey() {
		return ServerPublikKey;
	}



	public void setServerPublikKey(PublicKey serverPublikKey) {
		ServerPublikKey = serverPublikKey;
	}



	public PrivateKey getServerPrivateKey() {
		return ServerPrivateKey;
	}



	public void setServerPrivateKey(PrivateKey serverPrivateKey) {
		ServerPrivateKey = serverPrivateKey;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public String getPasswort() {
		return Passwort;
	}



	public void setPasswort(String passwort) {
		Passwort = passwort;
	}



	//____________________________________________
	public String entschluesseln(String nextLine) {
		// TODO Auto-generated method stub
		return null;
	}

	public String verschluesseln(String message) {
		// TODO Auto-generated method stub
		return null;
	}


}
