import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
	public static void main(String[] args) {
				
		Crypt cr = new Crypt();
		
		try {
			String m = cr.encryptMessage("sdfsjdf", cr.getKeyPair().getPublic());
			System.out.println(m);
			System.out.println(cr.decryptMessage(m, cr.getKeyPair().getPrivate()));
		} catch (Exception e1) {
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
			System.out.println(Database.getNewMessages());
			Thread.sleep(1000);
		}
	}
}
