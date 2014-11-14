import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Database {
			
	public static byte[][] getNewMessages(String db_acceptor_id) throws Exception {
		
		Crypt cr = new Crypt();
		byte[][] messages = null;
		int counter = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.2.117:3306/secureChat", "secureChat", "YHLRRjURGZX2hEM2");
			PreparedStatement statement = conn.prepareStatement("SELECT * from " + db_acceptor_id);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				messages[counter] = result.getBytes(2);
				counter++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messages;
	}
	
	public static void sendMessage(String acceptor, PublicKey publicKey, String message) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Crypt cr = new Crypt();
		byte[] encryptedMessage = cr.encrypt(message, publicKey);
				
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.2.117:3306/secureChat", "secureChat", "YHLRRjURGZX2hEM2");
		Statement statement = conn.createStatement();
		statement.executeUpdate("INSERT INTO `" + acceptor +"`(`message`, `date_time`) VALUES ('" + encryptedMessage +"', now())");
	}
}
