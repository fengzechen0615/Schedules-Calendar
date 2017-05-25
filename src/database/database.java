package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class database {
	public static void main(String[] args) throws Exception{
		database a = new database();
		a.setUp(getuser(), getpassword());
	}
	private static String user;
	private static String password;
	
	public void setuandp(String u,String p){
		this.user = u;
		this.password = p;
	}
	
	public static String getuser(){
		return user;
	}
	
	public static String getpassword(){
		return password;
	}
	
	public void setUp(String u,String p) throws Exception{
		setuandp(u,p);
		setdatabase();
		for(int i = 1; i <= 42;i++){
			String number = Integer.toString(i);
			SetUpWriteIn(number);
		}
	}
	
	public void setdatabase() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mysql";
		String user = getuser();
		String password = getpassword();
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
		Statement statement = (Statement) connection.createStatement();
	    String sql = "CREATE TABLE if not exists schedule(date CHAR(10), time time unique, course CHAR(30), things CHAR(30))";       
	    statement.executeUpdate(sql);
	    sql = "CREATE TABLE if not exists todoList(date CHAR(10), time time unique, course CHAR(30), things CHAR(30))";
	    statement.execute(sql); 
		statement.close();
		connection.close();
	}
	
	public void wirteIn(String[] a,String b) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mysql";
		String user = getuser();
		String password = getpassword();
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
	    String sql = "INSERT INTO "+ b +" (date, time, course, things) VALUES(?,?,?,?)";
	    PreparedStatement pstmt;
	    @SuppressWarnings("unused")
		int i = 0;
	    try {
	    	pstmt = (PreparedStatement) connection.prepareStatement(sql);
	    	pstmt.setString(1, a[0]);
	    	pstmt.setString(2, a[1]);
	    	pstmt.setString(3, a[2]);
	        pstmt.setString(4, a[3]);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        	
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
        connection.close();
	}
	
	public void SetUpWriteIn(String a) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mysql";
		String user = getuser();
		String password = getpassword();
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
	    String sql = "INSERT INTO schedule (time) SELECT ? FROM dual WHERE not exists (select * from schedule where time  = ?);";
	    PreparedStatement pstmt;
		int i = 0;
	    try {
	    	pstmt = (PreparedStatement) connection.prepareStatement(sql);
	    	pstmt.setString(1, a);
	    	pstmt.setString(2, a);
	        i = pstmt.executeUpdate();
	        pstmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
        connection.close();
	}
	
	public void updateTime(String[] a,String b) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mysql";
		String user = getuser();
		String password = getpassword();
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);	
		Statement statement = (Statement) connection.createStatement();
		String sql = " update " +b+ " set time ='"+ a[1] +"' where course = '"+a[2]+"'";
		statement.executeUpdate(sql);
		statement.close();
		connection.close();
	}
	
	public void update(String[] a,String b)throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mysql";
		String user = getuser();
		String password = getpassword();
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
		Statement statement = (Statement) connection.createStatement();
		String sql = " update " +b+ " set course ='"+ a[2] +"' where time = '"+a[1]+"'";
		statement.executeUpdate(sql);
		sql =" update " +b+ " set date ='"+ a[0] +"' where time = "+a[1]+"";
		statement.executeUpdate(sql);
		sql =" update " +b+ " set things ='"+ a[3] +"' where time = "+a[1]+"";
		statement.executeUpdate(sql);
		statement.close();
		connection.close();
	}
	
	public void wirteInSingle(String[][] a,String b) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mysql";
		String user = getuser();
		String password = getpassword();
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
	    String sql = "INSERT INTO "+ b +" (date, time, course, things) VALUES(?,?,?,?)";
	    PreparedStatement pstmt;
	    @SuppressWarnings("unused")
		int i = 0;
	    try {
	    	int k = count(b);
	    	while(a[k][1] != null){
	    		pstmt = (PreparedStatement) connection.prepareStatement(sql);
	    		pstmt.setString(1, a[k][0]);
	    		pstmt.setString(2, a[k][1]);
	    		pstmt.setString(3, a[k][2]);
	        	pstmt.setString(4, a[k][3]);
	        	i = pstmt.executeUpdate();
	        	pstmt.close();
	        	k++;
	    	}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
        connection.close();
	}

	public void delete(String a,String b) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mysql";
		String user = getuser();
		String password = getpassword();
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
		String sql = "DELETE from "+ b +" where time = "+ a;
		PreparedStatement pstmt;
		@SuppressWarnings("unused")
		int i = 0;
		try{
			pstmt = (PreparedStatement) connection.prepareStatement(sql);
			i = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public String[][] search(String b) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mysql";
		String user = getuser();
		String password = getpassword();
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
		Statement statement = (Statement) connection.createStatement();
		String sql = "SELECT * from "+ b;
		ResultSet result = null;
		try{
			result = statement.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		String[][] array = new String[100][100];
		int i = 0;
		try{
			while(result.next()){
				for(int j = 0;j < 4;j++){
				array[i][0] = result.getString(1);
				array[i][1] = result.getString(2);
				array[i][2] = result.getString(3);
				array[i][3] = result.getString(4);
				}
				i++;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		result.close();
		statement.close();
		connection.close();
		return array;
	}
	
	public String[][] searchDate(String b,String date) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/employee";
		String user = getuser();
		String password = getpassword();
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
		Statement statement = (Statement) connection.createStatement();
		String sql = "SELECT * from "+ b+" WHERE date = '"+date+"'";
		ResultSet result = null;
		try{
			result = statement.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		String[][] array = new String[100][100];
		int i = 0;
		try{
			while(result.next()){
				for(int j = 0;j < 4;j++){
				array[i][0] = result.getString(1);
				array[i][1] = result.getString(2);
				array[i][2] = result.getString(3);
				array[i][3] = result.getString(4);
				}
				i++;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		result.close();
		statement.close();
		connection.close();
		return array;
	}
	
	public String[] searchTime(String b,String time) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mysql";
		String user = getuser();
		String password = getpassword();
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
		Statement statement = (Statement) connection.createStatement();
		String sql = "SELECT * from "+ b +" WHERE time = '"+time+"'";
		ResultSet result = null;
		try{
			result = statement.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		String[] array = new String[4];
		try{
			while(result.next()){
			array[0] = result.getString(1);
			array[1] = result.getString(2);
			array[2] = result.getString(3);
			array[3] = result.getString(4);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		result.close();
		statement.close();
		connection.close();
		return array;
	}
	
	public int count(String b) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mysql";
		String user = getuser();
		String password = getpassword();
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
		Statement statement = (Statement) connection.createStatement();
		String sql = "SELECT count(time) from "+ b;
		ResultSet result = null;
		result = statement.executeQuery(sql);
		int i = 0;
		if (result.next()) {
			i = result.getInt(1); 
	    }
		result.close();
		statement.close();
		connection.close();
		return i;
	}
	
}

