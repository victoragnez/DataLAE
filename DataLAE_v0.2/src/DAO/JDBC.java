package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class responsible to access the database
 * and run sql commands
 *
 */

final class JDBC {
	
	/**
	 * Runs insert command
	 * @param sql the sql command to insert
	 * @throws SQLException 
	 */
	public static void runInsert(String sql) throws SQLException {
		
		if(!sql.startsWith("insert into "))
			throw new IllegalArgumentException("invalid insert command");
		
		runCommand(sql);
	}
	
	/**
	 * Runs remove command
	 * @param sql the sql command to remove
	 * @throws SQLException
	 */
	public static void runRemove(String sql) throws SQLException {
		runCommand(sql);
	}
	
	/**
	 * Runs query command
	 * @param sql
	 * @return the query result
	 */
	public static ResultSet runQuery(String sql) {
		return null;
	}
	
	public static void runUpdate(String sql) throws SQLException {
		runCommand(sql);
	}
	
	/**
	 * runs a sql command with no return
	 * 
	 * @param sql the sql command to run
	 * @throws SQLException 
	 */
	private static void runCommand(String sql) throws SQLException {
		
		Connection connect = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/dataLae?user=root&password=gabriel2010");
			statement = connect.createStatement();
			statement.executeUpdate(sql);
		} catch(SQLException e) {
			System.err.println(sql);
			throw e;
		}
	}
}
