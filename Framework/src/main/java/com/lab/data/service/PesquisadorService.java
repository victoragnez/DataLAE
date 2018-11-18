package com.lab.data.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lab.data.model.Pesquisador;

public class PesquisadorService {
	private HashMap<Integer, Pesquisador> pesqs;
	private Integer count_id;
	
	public PesquisadorService() {
		pesqs = new HashMap<>();
		count_id = 1;
	}
	
	public void inserir(Pesquisador p) throws Exception {
		if(pesqs.containsKey(p.getId()))
			throw new Exception("Falha ao inserir pesquisador: ID já existente!");
		pesqs.put(count_id, p);
		p.setId(count_id);
		count_id++;
	}
	
	public void atualizar(Pesquisador p) throws Exception {
		if(!pesqs.containsKey(p.getId()))
			throw new Exception("Falha ao editar pesquisador: Pesquisador não existe!");
		pesqs.put(p.getId(), p);
	}
	
	public void removerPorId(Integer id) throws Exception {
		if(!pesqs.containsKey(id))
			throw new Exception("Falha ao apagar pesquisador: Pesquisador não existe!");
		pesqs.remove(id);
	}
	
	public Pesquisador buscarPorId(Integer id) {
		return pesqs.get(id);
	}
	
	public List<Pesquisador> listar() {
		ArrayList<Pesquisador> list = new ArrayList<>();
		for(Map.Entry<Integer, Pesquisador> e : pesqs.entrySet()) {
			list.add(e.getValue());
		}
		return list;
	}
}
