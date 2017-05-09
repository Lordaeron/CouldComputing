package appdatabase;
import java.util.ArrayList;
import java.sql.*;
public class readappdb {
	private ArrayList<appdb> app = new ArrayList<appdb>();
	
	public void readapp(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("succes loading driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("fail loading driver");
			e.printStackTrace();
		}
		
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/CloudComputing","root","Lordaeron");
			System.out.println("success connect");
			PreparedStatement pstmt;
			String sql = "select * from uploadedapps";
			pstmt = (PreparedStatement)connect.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			 while (rs.next()) {
				appdb app1 = new appdb();
				app1.setAppdb(String.valueOf(rs.getInt(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				 System.out.println(app1.getName());
				 app.add(app1);
		     }
			 connect.close();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("fail connect");
		e.printStackTrace();
	}
	
	}// readappdb
	public ArrayList<appdb> returnList(){
		return this.app;
	}//return
}//end class
