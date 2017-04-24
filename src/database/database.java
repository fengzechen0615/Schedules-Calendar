package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import UI.CalendarDay;

import com.mysql.jdbc.PreparedStatement;

public class database {
	
	/*public static void main(String[] args) throws Exception{
		database one = new database();
		String[][] a = CalendarDay.Store();
		one.wirteInSingle(a, "todolist");
	}*/
	
	public void setdatabase() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String password = "0";
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
		Statement statement = (Statement) connection.createStatement();
	    String sql = "CREATE TABLE schedule(date CHAR(10) PRIMARY KEY, event CHAR(20), place CHAR(30), time CHAR(10))";       
	    statement.executeUpdate(sql);
	    sql = "CREATE TABLE todoList(date CHAR(10), event CHAR(20), place CHAR(30), time CHAR(10))";
	    statement.execute(sql);    
		statement.close();
		connection.close();
	}
	
	public void wirteIn(SinglyLinkedList a,String b) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String password = "0";
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
		Statement statement = (Statement) connection.createStatement();
		Node p = a.first();
		while(p != a.last()){
			String[] i =  p.element();
			String sql = "INSERT INTO "+ b +" (date, event, place, time) VALUES(?,?,?,?)";
			PreparedStatement pstmt;
			int n = 0;
			try {
				pstmt = (PreparedStatement) connection.prepareStatement(sql);
			    pstmt.setString(1, i[0]);
			    pstmt.setString(2, i[1]);
			    pstmt.setString(3, i[2]);
			    pstmt.setString(4, i[3]);
			    n = pstmt.executeUpdate();
			    pstmt.close();
			} catch (SQLException e) {
			    e.printStackTrace();
			}
			p = p.next;
		}
		statement.close();
		connection.close();
	}
	
	public void wirteInSingle(String[][] a,String b) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String password = "0";
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
	    String sql = "INSERT INTO "+ b +" (date, event, place, time) VALUES(?,?,?,?)";
	    PreparedStatement pstmt;
	    int i = 0;
	    try {
	    	int k = 0;
	    	while(a[k][0] != null){
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
		String url = "jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String password = "0";
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
		String sql = "DELETE from "+ b +" where time = "+ a;
		PreparedStatement pstmt;
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
	
	public String[] search(String c,String b) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String password = "0";
		Connection connection = (Connection) DriverManager.getConnection(url,user,password);
		Statement statement = (Statement) connection.createStatement();
		String sql = "SELECT " + c + " from "+ b;
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

