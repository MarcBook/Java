import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
	public static void main(String[] args) {
		
		System.out.println(Database.getNewMessages());
		
		Crypt cr = new Crypt();
		
		try {
			System.out.println(cr.createKeyPair().getPrivate());
			System.out.println(cr.createKeyPair().getPublic());
		} catch (NoSuchAlgorithmException e1) {
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
