import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tysql","root","");
			
			Statement stmt = conn.createStatement();
			
			String sql = "select * from customers";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("Customer ID" + "\t" + "Name" + "\t\t" + "Address"  + "\t\t" + "State"  + "\t\t" + "zipcode" + "\t" + "Country" + "\t\t" + "Email\n");
			while(rs.next()){
				
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + 
						rs.getString(6) + "\t" + rs.getString(7) + "\t" + rs.getString(8) + rs.getString(9));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
