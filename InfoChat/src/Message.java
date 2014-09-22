import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Message {
	public static void send (String message, String ip, int port){
//		Scanner input = new Scanner(System.in);
		
		try {
			
			Socket client = new Socket(ip, port);
			System.out.println("Client gestartet!");
			
			//Streams
			
			OutputStream out = client.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			
			InputStream in = client.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			//------------------------------------------------------------------\\
			
//			System.out.print("Eingabe: ");
//			String toServer = input.nextLine();
			
			writer.write(message + "\n");
			writer.flush();
			
			String s = null;
			
			while ((s = reader.readLine()) != null) {
				System.out.println("Empfangen vom Server: " + s);
			}
			
			writer.close();
			reader.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
