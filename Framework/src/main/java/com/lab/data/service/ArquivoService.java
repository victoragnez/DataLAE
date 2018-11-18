package com.lab.data.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lab.data.model.Arquivo;

public class ArquivoService {
	private HashMap<Integer, Arquivo> arquivos;
	private Integer count_id;
	
	public ArquivoService() {
		arquivos = new HashMap<>();
		count_id = 1;
	}
	
	public void inserir(Arquivo a) throws Exception {
		if(arquivos.containsKey(a.getId()))
			throw new Exception("Falha ao inserir arquivo: ID já existente!");
		arquivos.put(count_id, a);
		a.setId(count_id);
		count_id++;
	}
	
	public void atualizar(Arquivo a) throws Exception {
		if(!arquivos.containsKey(a.getId()))
			throw new Exception("Falha ao editar arquivo: Arquivo não existe!");
		arquivos.put(a.getId(), a);
	}
	
	public void removerPorId(Integer id) throws Exception {
		if(!arquivos.containsKey(id))
			throw new Exception("Falha ao apagar arquivo: Arquivo não existe!");
		arquivos.remove(id);
	}
	
	public Arquivo buscarPorId(Integer id) {
		return arquivos.get(id);
	}
	
	public List<Arquivo> listar() {
		ArrayList<Arquivo> list = new ArrayList<>();
		for(Map.Entry<Integer, Arquivo> e : arquivos.entrySet()) {
			list.add(e.getValue());
		}
		
		return list;
	}
}
