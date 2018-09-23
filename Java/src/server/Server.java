package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import remote.Row;
import remote.iDAOServer;

public class Server extends UnicastRemoteObject implements iDAOServer {
	private static final long serialVersionUID = 87952108653686467L;

	protected Server() throws RemoteException { 
		super(); 
	}
	
	synchronized public void runUpdate(String user, String password, String sql) throws RemoteException, ClassNotFoundException, SQLException{
		Connection connect = null;
		Statement statement = null;
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager
				.getConnection("jdbc:mysql://localhost/datalae?"
						+ "user=" + user + "&password=" + password);
		statement = connect.createStatement();
		statement.executeUpdate(sql);
	}
	
	synchronized public ArrayList<Row> runQuery(String user, String password, String sql) throws RemoteException, ClassNotFoundException, SQLException{
		Connection connect = null;
		Statement statement = null;
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager
				.getConnection("jdbc:mysql://localhost/datalae?"
						+ "user=" + user + "&password=" + password);
		statement = connect.createStatement();
		ArrayList<Row> ret = new ArrayList<Row>();
		formTable(statement.executeQuery(sql), ret);
		return ret;
	}
	
	synchronized public void runUpdate(String user, String password, ArrayList<String> sql) throws RemoteException, ClassNotFoundException, SQLException{
		Connection connect = null;
		Statement[] statements = new Statement[sql.size()];
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager
				.getConnection("jdbc:mysql://localhost/datalae?"
						+ "user=" + user + "&password=" + password);
		connect.setAutoCommit(false);
		for(int i = 0; i < sql.size(); i++) {
			statements[i] = connect.createStatement();
			statements[i].executeQuery(sql.get(i));
		}
		connect.commit();
	}
	
	public static void formTable (ResultSet rs, ArrayList<Row> table) throws SQLException {
        if (rs == null) return;

        ResultSetMetaData rsmd = rs.getMetaData();

        int NumOfCol = rsmd.getColumnCount();

        while (rs.next()) {
            Row row = new Row ();

            for(int i = 1; i <= NumOfCol; i++) {
                row.add(rsmd.getColumnName(i), rs.getObject(i), rsmd.getColumnTypeName(i));
            }

            table.add(row);
        }
    }
}
