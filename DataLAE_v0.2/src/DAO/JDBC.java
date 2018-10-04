package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class responsible to access the database
 * and run SQL commands
 * 
 * Visible only inside DAO packet
 *
 */

final class JDBC {
	
	/**
	 * Private constructor - use the static methods.
	 */
	private JDBC() {}
	
	/**
	 * Runs insert command
	 * @param sql the SQL command to insert
	 * @return the auto-generated id of the inserted line or -1 if there's no generated id or its not int 
	 * @throws SQLException 
	 */
	public static int runInsert(String sql) throws SQLException {
		
		if(!sql.startsWith("insert into "))
			throw new IllegalArgumentException("invalid insert command");
		
		Connection connect = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/dataLae?user=root&password=abc123&useSSL=false");
			statement = connect.createStatement();
			statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		} catch(SQLException e) {
			System.err.println(sql);
			throw e;
		}
		
		try {
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if(!generatedKeys.next())
				return -1;
			return generatedKeys.getInt(1);
		} catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * Runs multiple insert commands atomically
	 * @param commands the ArrayList of sql insert commands
	 * @throws SQLException 
	 */
	public static void runMultipleInserts(ArrayList<String> commands) throws SQLException {
		for(String sql : commands) {
			if(!sql.startsWith("insert into "))
				throw new IllegalArgumentException("invalid insert command: " + sql);
		}
		
		runCommands(commands);
		
	}
	
	/**
	 * Runs remove command
	 * @param sql the SQL command to remove
	 * @throws SQLException
	 */
	public static void runRemove(String sql) throws SQLException {
		
		if(!sql.startsWith("delete from "))
			throw new IllegalArgumentException("invalid remove command");
		
		runCommand(sql);
	}
	
	/**
	 * Runs query command
	 * @param sql
	 * @return the query result
	 * @throws SQLException 
	 */
	public static ResultSet runQuery(String sql) throws SQLException {
		
		Connection connect = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/dataLae?user=root&password=abc123&useSSL=false");
			statement = connect.createStatement();
			return statement.executeQuery(sql);
		} catch(SQLException e) {
			System.err.println(sql);
			throw e;
		}
	}
	
	public static void runUpdate(String sql) throws SQLException {
		//TODO
		runCommand(sql);
	}
	
	/**
	 * runs a SQL command with no return
	 * @param sql the SQL command to run
	 * @throws SQLException 
	 */
	private static void runCommand(String sql) throws SQLException {
		
		Connection connect = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/dataLae?user=root&password=abc123&useSSL=false");
			statement = connect.createStatement();
			statement.executeUpdate(sql);
		} catch(SQLException e) {
			System.err.println(sql);
			throw e;
		}
	}
	
	/**
	 * Runs a set of SQL commands atomically with no result
	 * @param commands the list of sql commands to run
	 * @throws SQLException 
	 */
	private static void runCommands(ArrayList<String> commands) throws SQLException {
		Connection connect = null;
		Statement[] statements = new Statement[commands.size()];
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		connect = DriverManager
				.getConnection("jdbc:mysql://localhost/dataLae?user=root&password=abc123&useSSL=false");
		connect.setAutoCommit(false);
		for(int i = 0; i < commands.size(); i++) {
			statements[i] = connect.createStatement();
			statements[i].executeUpdate(commands.get(i));
		}
		connect.commit();
	}
}
