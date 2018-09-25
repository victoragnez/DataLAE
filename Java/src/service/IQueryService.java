package service;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import service.model.Area;
import service.model.Diretorio;
import service.model.Projeto;
import service.model.Viagem;

public interface IQueryService {
	public ArrayList<Projeto> queryProjetos() throws MalformedURLException, RemoteException, ClassNotFoundException, NotBoundException, SQLException;
	public ArrayList<Area> queryArea(Projeto p) throws MalformedURLException, RemoteException, ClassNotFoundException, NotBoundException, SQLException;
	public ArrayList<Viagem> queryViagem(Area a) throws MalformedURLException, RemoteException, ClassNotFoundException, NotBoundException, SQLException;
	
	public ArrayList<Diretorio> pastasProjetos(Projeto p);
	public ArrayList<Diretorio> pastasViagem(Viagem v);
}
