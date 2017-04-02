package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	    sql = "CREATE TABLE todoList(event CHAR(20), time CHAR(10), place CHAR(30), people CHAR(30), weekday CHAR(10))";
	    statement.execute(sql);    
		statement.close();
		connection.close();
	}
	
	public void wirteInSchedule(SinglyLinkedList a) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String password = "0";
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
		Statement statement = (Statement) connection.createStatement();
		Node p = a.first();
		while(p != a.last()){
			String i = (String) p.element();
			String sql = "INSERT INTO schedule VALUES ("+ i +")";
			statement.executeQuery(sql);
			p = p.next;
		}
		statement.close();
		connection.close();
	}
	
	public void wirteInTask(SinglyLinkedList a) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String password = "0";
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
		Statement statement = (Statement) connection.createStatement();
		Node p = a.first();
		while(p != a.last()){
			String i = (String) p.element();
			String sql = "INSERT INTO todoList VALUES ("+ i +")";
			statement.executeQuery(sql);
			p = p.next;
		}
		statement.close();
		connection.close();
	}
	
	public String[] search(String c) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String password = "0";
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
		Statement statement = (Statement) connection.createStatement();
		String sql = "SELECT " + c + " from schedule";
		ResultSet result = null;
		try{
			result = statement.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		String[] array = new String[100];
		int i = 0;
		try{
			while(result.next()){
				array[i] = result.getString(c);
				i++;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return array;
	}
	
	

}

