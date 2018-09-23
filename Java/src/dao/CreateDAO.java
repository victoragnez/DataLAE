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
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

import service.Area;
import service.Pesquisa;
import service.Viagem;

public class CreateDAO implements ICreateDAO {

	@Override
	public void criaPesquisa(Pesquisa p) {
		
	}

	@Override
	public void criaArea(Pesquisa p, Area a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaViagem(Pesquisa p, Area a, Viagem v) {
		// TODO Auto-generated method stub
		
	}
}
