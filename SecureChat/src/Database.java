import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





public class Database {
	
	public static ResultSet conn(String db_name, String db_acceptor_id) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn;
		ResultSet result = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.2.117:3306/" + db_name, "root", "Sicher12");
			PreparedStatement statement = conn.prepareStatement("SELECT * from " + db_acceptor_id);
			
			result = statement.executeQuery();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static String getNewMessages() {
		Database db = new Database();
		
		try {
			ResultSet result = db.conn("secureChat", "marcbook");
			
			while (result.next()) {
				return result.getString(1);
				
			}
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
