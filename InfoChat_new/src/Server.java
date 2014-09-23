import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(30);
		
		ServerSocket server;
		try {
			server = new ServerSocket(5555);
			System.out.println("Server gestartet!");
			
			while(true){
				
				try {
					
					Socket client = server.accept();
					
//					Thread t =  new Thread(new Handler(client));
//					t.start();
					
					executor.execute(new Handler(client));
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
