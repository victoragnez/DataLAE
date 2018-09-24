package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import remote.iDAOServer;

public class Main {
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		//Criando registro para objetos remotos serem acessados pela porta Compute.port
		LocateRegistry.createRegistry(iDAOServer.port);
		
		//Instancia a classe do servidor
		Server compute = new Server();
		
		//(Re)binding
		Naming.rebind("rmi://" + iDAOServer.ip + ":" + iDAOServer.port + "/" + iDAOServer.objectName, compute);
		
		System.out.println("Servidor instanciado e registrado no RMI Registry.");
	}
}
