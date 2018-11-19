package com.lab.data.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lab.data.model.Viagem;

@Deprecated
public class ViagemService {
	private HashMap<Integer, Viagem> viagens;
	private Integer count_id;
	
	public ViagemService() {
		viagens = new HashMap<>();
		count_id = 1;
	}
	
	public void inserir(Viagem v) throws Exception {
		if(viagens.containsKey(v.getId()))
			throw new Exception("Falha ao inserir viagem: ID já existente!");
		viagens.put(count_id, v);
		v.setId(count_id);
		count_id++;
	}
	
	public void atualizar(Viagem v) throws Exception {
		if(!viagens.containsKey(v.getId()))
			throw new Exception("Falha ao editar viagem: viagem não existe!");
		viagens.put(v.getId(), v);
	}
	
	public void removerPorId(Integer id) throws Exception {
		if(!viagens.containsKey(id))
			throw new Exception("Falha ao apagar Viagem: Viagem não existe!");
		viagens.remove(id);
	}
	
	public Viagem buscarPorId(Integer id) {
		return viagens.get(id);
	}
	
	public List<Viagem> listar() {
		ArrayList<Viagem> list = new ArrayList<>();
		for(Map.Entry<Integer, Viagem> e : viagens.entrySet()) {
			list.add(e.getValue());
		}
		return list;
	}
}