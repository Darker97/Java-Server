import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class DatenLader{

  public static Hashtable<String, String> User= new Hashtable<String, String>();


  public static void UserLaden() throws FileNotFoundException{
	  File f = new File("Users.txt");
	  Scanner sc = new Scanner(f);
	  while(sc.hasNext()) {
		  User.put(sc.nextLine(),sc.nextLine());
	  }
  }
}
