/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.CodigoPesquisaEmUsoException;
import dao.exceptions.PesquisaNaoExistenteException;
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

import service.Pesquisa;

public class PesquisaDAOMemoria implements IPesquisaDAO {
	
	private Map<String, Pesquisa> listaPesquisa = new HashMap<String, Pesquisa>(); 

	@Override
	public void inserirPesquisa(Pesquisa pesquisa) throws CodigoPesquisaEmUsoException {
		if(pesquisa == null) {
			throw new NullPointerException();
		}
		
		if (!listaPesquisa.containsKey(pesquisa.getCodigo())){ 
			listaPesquisa.put(pesquisa.getCodigo(), pesquisa);
		} else {
			throw new CodigoPesquisaEmUsoException("Código de Pesquisa em uso");
		}
	}

	@Override
	public void alterarPesquisa(Pesquisa pesquisa) throws PesquisaNaoExistenteException {
		if(pesquisa == null) {
			throw new NullPointerException();
		}
		
		if (listaPesquisa.containsKey(pesquisa.getCodigo())){ 
			listaPesquisa.put(pesquisa.getCodigo(), pesquisa);
		} else {
			throw new PesquisaNaoExistenteException("Pesquisa não encontrada");
		}
	}

	@Override
	public void removerPesquisa(String codigo) throws PesquisaNaoExistenteException {
		if(codigo == null) {
			throw new NullPointerException();
		}
		
		if (listaPesquisa.containsKey(codigo )){
			listaPesquisa.remove(codigo);
		}else {
			throw new PesquisaNaoExistenteException("Pesquisa não encontrada");
		}
	}
	
	@Override
	public Pesquisa consultarPesquisa(String codigo) throws PesquisaNaoExistenteException {
		if(codigo == null) {
			throw new NullPointerException();
		}
		
		Pesquisa resultado = null;
		
		if (listaPesquisa.containsKey(codigo)){
			resultado = listaPesquisa.get(codigo);
		} else {
			throw new PesquisaNaoExistenteException("Pesquisa não encontrada");
		}	
		return resultado;
	}
	
	private boolean matches(String opt, String res) {
		return opt == null || opt.equals(res);
	}
	
	private boolean matches(Pesquisa opt, Pesquisa res) {
		return  matches(opt.getCodigo(), res.getCodigo()) &&
				matches(opt.getCoordenador(), res.getCoordenador()) &&
				matches(opt.getDenomicacao(), res.getDenomicacao()) &&
				matches(opt.getFinanciador(), res.getFinanciador()) &&
				matches(opt.getPesquisador(), res.getPesquisador()) &&
				matches(opt.getSigla(), res.getSigla());
	}
	
	private boolean matches(ArrayList<String> opt, ArrayList<String> res) {
		if(opt == null) {
			return true;
		}
		Collections.sort(opt);
		Collections.sort(res);
		int ptr = 0;
		for(int i = 0; i < opt.size(); i++) {
			while(ptr < res.size() && res.get(ptr).compareTo(res.get(i)) < 0) {
				ptr++;
			}
			if(ptr == res.size() || res.get(ptr).compareTo(res.get(i)) != 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ArrayList<Pesquisa> consultarPesquisa(Pesquisa pesquisa) {
		if(pesquisa == null) {
			throw new NullPointerException();
		}
		ArrayList<Pesquisa> results = new ArrayList<Pesquisa>();
		for(Pesquisa cur : listaPesquisa.values()) {
			if(matches(pesquisa, cur)) {
				results.add(cur);
			}
		}
		return results;
	}
	
	public String getQuery(Pesquisa p) {
		return "select * from projetos;";
	}
	
	public String getUpd(Pesquisa p) {
		return "add ...;";
	}
	
	public ArrayList<Row> query(String user, String password, Pesquisa p) throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, SQLException{
		iDAOServer stub = (iDAOServer) Naming.lookup("rmi://" + iDAOServer.ip + ":" + iDAOServer.port + "/" + iDAOServer.objectName);
		return stub.runQuery(user, password, getQuery(p));
	}
	
	public void upd(String user, String password, Pesquisa p) throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, SQLException{
		iDAOServer stub = (iDAOServer) Naming.lookup("rmi://" + iDAOServer.ip + ":" + iDAOServer.port + "/" + iDAOServer.objectName);
		stub.runUpdate(user, password, getUpd(p));
	}
}
