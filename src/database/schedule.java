package database;
import java.sql.*;

public class schedule {
	
	public static void main(String[] args) throws Exception{
		schedule one = new schedule();
		one.setdatabase();
	}
	
	public void setdatabase() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String password = "0";
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
		Statement statement = (Statement) connection.createStatement();
	    String sql = "CREATE TABLE schedule(weekday CHAR(10) PRIMARY KEY,course CHAR(20),time CHAR(10),things CHAR(30))";       
	    statement.executeUpdate(sql);
		statement.close();
		connection.close();
	}
	
	public void wirteIn() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String password = "0";
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
		Statement statement = (Statement) connection.createStatement();
		String sql = "INSERT INTO schedule VALUES ()";
		statement.executeQuery(sql);
		statement.close();
		connection.close();
	}
}

