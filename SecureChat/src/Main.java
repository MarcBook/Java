import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
	public static void main(String[] args) {
		
		javafx.application.Application.launch(Gui.class);
		
		try {
			Database.test();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Crypt cr = new Crypt();
		
		try {
			Database.sendMessage("marcbook", cr.getKeyPair().getPublic(), "Hallo Welt");
			System.out.println(":" + cr.decrypt(Database.getNewMessages("marcbook"), cr.getKeyPair().getPrivate()) + ":");
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
//				System.out.println(Database.getNewMessages("marcbook")[0]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread.sleep(1000);
		}
	}
}
