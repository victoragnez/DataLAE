package com.lab.data.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lab.data.model.Local;

public class LocalService {
	private HashMap<Integer, Local> locais;
	private Integer count_id;
	
	public LocalService() {
		locais = new HashMap<>();
		count_id = 1;
	}
	
	public void inserir(Local l) throws Exception {
		if(locais.containsKey(l.getId()))
			throw new Exception("Falha ao inserir local: ID já existente!");
		locais.put(count_id, l);
		l.setId(count_id);
		count_id++;
	}
	
	public void atualizar(Local l) throws Exception {
		if(!locais.containsKey(l.getId()))
			throw new Exception("Falha ao editar local: Local não existe!");
		locais.put(l.getId(), l);
	}
	
	public void removerPorId(Integer id) throws Exception {
		if(!locais.containsKey(id))
			throw new Exception("Falha ao apagar local: Local não existe!");
		locais.remove(id);
	}
	
	public Local buscarPorId(Integer id) {
		return locais.get(id);
	}
	
	public List<Local> listar() {
		ArrayList<Local> list = new ArrayList<>();
		for(Map.Entry<Integer, Local> e : locais.entrySet()) {
			list.add(e.getValue());
		}
		
		return list;
	}
}
