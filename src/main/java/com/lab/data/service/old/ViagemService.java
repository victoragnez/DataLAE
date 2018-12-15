package com.lab.data.service.old;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lab.data.model.old.Viagem;

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
	
	public List<Viagem> buscar(Viagem filtro) {
		ArrayList<Viagem> list = new ArrayList<>();
		for(Map.Entry<Integer, Viagem> e : viagens.entrySet()) {
			Viagem curr = e.getValue();
			if((filtro.getId() == null || curr.getId().equals(filtro.getId())) &&
					(filtro.getLocal() == null || (curr.getLocal() != null && curr.getLocal().getId().equals(filtro.getLocal().getId()))) &&
					(filtro.getProjeto() == null || (curr.getProjeto() != null && curr.getProjeto().getId().equals(filtro.getProjeto().getId()))) && 
					(filtro.getInicio() == null || curr.getInicio().equals(filtro.getInicio())) &&
					(filtro.getFim() == null || curr.getFim().equals(filtro.getFim())))
					
			{
				list.add(e.getValue());
			}
		}
		return list;
	}
	
	public List<Viagem> listar() {
		ArrayList<Viagem> list = new ArrayList<>();
		for(Map.Entry<Integer, Viagem> e : viagens.entrySet()) {
			list.add(e.getValue());
		}
		return list;
	}
}