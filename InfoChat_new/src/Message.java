import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;


public class Message {
	
	Socket client;
	PrintWriter writer;
	static BufferedReader reader;
	
	public boolean conntectToServer (String ip, int port){
		try {
			client = new Socket(ip, port);
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new PrintWriter(client.getOutputStream());
			
			System.out.println("Client gestartet!");

			return true;
		} catch (UnknownHostException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}
	
	public void sendMessageToServer (String message){
		writer.println(message);
		writer.flush();
	}
	
	public static Thread createThread (){
		Thread t = new Thread(new MessagesFromServerListener());
		t.start();
		
		return t;
	}
	
	public static class MessagesFromServerListener implements Runnable {

		@Override
		public void run() {
			String message;
			
			try{
				while ((message = reader.readLine()) != null) {
					System.out.println(message);
					Gui.getMessage(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
