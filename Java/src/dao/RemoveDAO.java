/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import remote.Row;
import remote.iDAOServer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static service.User.getPassword;
import static service.User.getUsername;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

import service.Area;
import service.Pesquisa;
import service.Viagem;

public class RemoveDAO implements IRemoveDAO {

	@Override
	public void removePesquisa(Pesquisa p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArea(Pesquisa p, Area a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeViagem(Pesquisa p, Area a, Viagem v) {
		// TODO Auto-generated method stub
		
	}
}
