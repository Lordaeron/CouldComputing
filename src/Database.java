import java.sql.*;
public class Database {

//检查登陆密码
//正确返回true
public boolean checkPassword(String email,String password){
	boolean flag=false;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("succes loading driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("fail loading driver");
		e.printStackTrace();
	}
	
	try {
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudcomputing","root","Lordaeron");
		System.out.println("success connect");
		Statement stmt = connect.createStatement();
		String sql = "select password from users where email="+"'"+email+"'";
		ResultSet rs = stmt.executeQuery(sql);
		String password1 = rs.getString(1);
		System.out.println(password1);
		if(password1.equals(password))
			flag = true;
		else 
			flag = false;
		connect.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("fail connect");
		e.printStackTrace();
	}
		return flag;
	
}

//新用户注册，信息记录进数据库
//永远返回true，检查主键返回后面再加
public boolean signup(String email,String password, String firstname, String lastname, String displayname ){
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("succes loading driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("fail loading driver");
		e.printStackTrace();
	}
	
	try {
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudcomputing","root","Lordaeron");
		System.out.println("success connect");
		Statement stmt = connect.createStatement();
		String sql = "insert into users "
					+ "(email,password,firstname,lastname,displayname) "
					+ "values("
					+email+","+password+","+firstname+","+lastname+","+displayname+");";
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("flag");
		String sql2 = "insert into bank (email,current) values("+email+","+"0"+")";
		ResultSet rs2 = stmt.executeQuery(sql2);
//		String sql = "select * from users";
//		ResultSet rs = stmt.executeQuery(sql);
//		System.out.println("flag");
		connect.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("fail connect");
		e.printStackTrace();
	}
	return true;
}

//获取用户信息接口，返回用户first name
public String getFirstName(String email){
	String first_name;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("succes loading driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("fail loading driver");
		e.printStackTrace();
	}
	
	try {
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudcomputing","root","Lordaeron");
		System.out.println("success connect");
		Statement stmt = connect.createStatement();
		String sql = "select first_name from users where email="+email;
		ResultSet rs = stmt.executeQuery(sql);
		
		//取出first_name并返回
		first_name = rs.toString();
		connect.close();
		return first_name;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("fail connect");
		e.printStackTrace();
	}
	return "fail";
}

//获取用户信息接口，返回用户last name
public String getLastName(String email){
	String last_name;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("succes loading driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("fail loading driver");
		e.printStackTrace();
	}
	
	try {
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudcomputing","root","Lordaeron");
		System.out.println("success connect");
		Statement stmt = connect.createStatement();
		String sql = "select last_name from users where email="+email;
		ResultSet rs = stmt.executeQuery(sql);
		
		//取出first_name并返回
		last_name = rs.toString();
		connect.close();
		return last_name;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("fail connect");
		e.printStackTrace();
	}
	return "fail";
}

//获取用户昵称，返回字符串
public String getDisplayName(String email){
	String displayname;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("succes loading driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("fail loading driver");
		e.printStackTrace();
	}
	
	try {
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudcomputing","root","Lordaeron");
		System.out.println("success connect");
		Statement stmt = connect.createStatement();
		String sql = "select displayname from users where email="+email;
		ResultSet rs = stmt.executeQuery(sql);
		
		//取出first_name并返回
		displayname = rs.toString();
		connect.close();
		return displayname;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("fail connect");
		e.printStackTrace();
	}
	return "fail";
}


//获取用户当前余额，失败返回－1
public int getCurrent(String email){
	int current;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("succes loading driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("fail loading driver");
		e.printStackTrace();
	}
	
	try {
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudcomputing","root","Lordaeron");
		System.out.println("success connect");
		Statement stmt = connect.createStatement();
		String sql = "select current from bank where email="+email;
		ResultSet rs = stmt.executeQuery(sql);
		
		//取出first_name并返回
		current = rs.getInt(1);
		connect.close();
		return current;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("fail connect");
		e.printStackTrace();
	}
	return -1;
}


//改变账户余额，change为正表示增加
public boolean setCurrent(String email,int change){
	int current;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("succes loading driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("fail loading driver");
		e.printStackTrace();
	}
	
	try {
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudcomputing","root","Lordaeron");
		System.out.println("success connect");
		Statement stmt = connect.createStatement();
		String sql = "select current from bank where email="+email;
		ResultSet rs = stmt.executeQuery(sql);
		
		//取出CURRENT并返回
		current = rs.getInt(1);
		
		//改变当前值
		current = current + change;
		if(current>=0){
			String sql2 = "update bank set current="+current+"+ where email="+email;
			ResultSet rs2 = stmt.executeQuery(sql2);
		}
		else{
			return false;
		}
		connect.close();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("fail connect");
		e.printStackTrace();
	}
	return false;
}
  
}