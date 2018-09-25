package dao;

import static service.model.User.getPassword;
import static service.model.User.getUsername;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import remote.Row;
import remote.iDAOServer;

public abstract class Connect {
	public static ArrayList<Row> query(String sql) throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, SQLException{
		iDAOServer stub = (iDAOServer) Naming.lookup("rmi://" + iDAOServer.ip + ":" + iDAOServer.port + "/" + iDAOServer.objectName);
		return stub.runQuery(getUsername(), getPassword(), sql);
	}
	
	public static void upd(String sql) throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, SQLException{
		iDAOServer stub = (iDAOServer) Naming.lookup("rmi://" + iDAOServer.ip + ":" + iDAOServer.port + "/" + iDAOServer.objectName);
		stub.runUpdate(getUsername(), getPassword(), sql);
	}
	
	public static void upd(ArrayList<String> sql) throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, SQLException{
		iDAOServer stub = (iDAOServer) Naming.lookup("rmi://" + iDAOServer.ip + ":" + iDAOServer.port + "/" + iDAOServer.objectName);
		stub.runUpdate(getUsername(), getPassword(), sql);
	}
}
