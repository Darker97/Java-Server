import java.util.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.text.*;

public class LogData {
	//alle aufzeichnungen der Logdateien

  public static void LogdataWriting(String WasWurdeGemacht, Socket Client){
    try{

    FileWriter Writer;

    Writer = new FileWriter("Logdata.txt", true);

    BufferedWriter bw = new BufferedWriter(Writer);

    DateFormat df = new SimpleDateFormat("dd/MM/yy - hh-mm-ss");
    Date today = Calendar.getInstance().getTime();

    String reportDate = df.format(today);

    bw.write(reportDate);
    bw.write("-------Adress: ");
    
    String temp = Client.getInetAddress().toString();
    bw.write(temp);
    bw.write("------- port: ");
    bw.write(Client.getPort());

    bw.newLine();
    bw.close();
  } catch (IOException e){

  }
  }
}
