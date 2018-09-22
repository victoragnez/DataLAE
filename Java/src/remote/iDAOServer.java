package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface iDAOServer extends Remote {
	
	public final String ip = "localhost"; //Server IP address
	
	public final int port = 26847;
	
	public final String objectName = "DAOServer";
	
	public void runUpdate(String user, String password, String sql) throws RemoteException, ClassNotFoundException, SQLException;
	public ArrayList<Row> runQuery(String user, String password, String sql) throws RemoteException, ClassNotFoundException, SQLException;

}
