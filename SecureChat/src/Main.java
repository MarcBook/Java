import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
	public static void main(String[] args) {
				
		Crypt cr = new Crypt();
		
		try {
			Database.sendMessage("marcbook", cr.getKeyPair().getPublic(), "Hello World");
			System.out.println(Database.getNewMessages("marcbook")[0]);
			System.out.println(cr.decrypt(Database.getNewMessages("marcbook")[0], cr.getKeyPair().getPrivate()));	
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
				
		
		try {
			update();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void update() throws Exception {
		
		while (true) {			
			System.out.println("Update");
			try {
				System.out.println(Database.getNewMessages("marcbook")[0]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread.sleep(1000);
		}
	}
}
