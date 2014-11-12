import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Database {
			
	public static String getNewMessages(String db_acceptor_id) throws Exception {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.2.117:3306/secureChat", "secureChat", "YHLRRjURGZX2hEM2");
			PreparedStatement statement = conn.prepareStatement("SELECT * from " + db_acceptor_id);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				return result.getString(1);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void sendMessage(String acceptor, PublicKey acceptorKey, String message) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.2.117:3306/secureChat", "secureChat", "YHLRRjURGZX2hEM2");
		Statement statement = conn.createStatement();
		statement.executeUpdate("INSERT INTO `" + acceptor +"`(`message`, `date_time`) VALUES ('" + message +"', now())");
	}
}
