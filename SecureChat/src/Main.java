import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
	public static void main(String[] args) {
		
		System.out.println(Database.getNewMessages());
		
		Crypt cr = new Crypt();
		
		try {
			cr.saveKeyPair();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			update();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void update() throws InterruptedException {
		while (true) {			
			System.out.println("Update");
			Thread.sleep(1000);
		}
	}
}
