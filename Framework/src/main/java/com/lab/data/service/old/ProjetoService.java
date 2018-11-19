package com.lab.data.service.old;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lab.data.model.old.Projeto;

@Deprecated
public class ProjetoService {
	private HashMap<Integer, Projeto> projs;
	private Integer count_id;
	
	public ProjetoService() {
		projs = new HashMap<>();
		count_id = 1;
	}
	
	public void inserir(Projeto p) throws Exception {
		if(projs.containsKey(p.getId()))
			throw new Exception("Falha ao inserir projeto: ID já existente!");
		projs.put(count_id, p);
		p.setId(count_id);
		count_id++;
	}
	
	public void atualizar(Projeto p) throws Exception {
		if(!projs.containsKey(p.getId()))
			throw new Exception("Falha ao editar projeto: Projeto não existe!");
		projs.put(p.getId(), p);
	}
	
	public void removerPorId(Integer id) throws Exception {
		if(!projs.containsKey(id))
			throw new Exception("Falha ao apagar projeto: Projeto não existe!");
		projs.remove(id);
	}
	
	public Projeto buscarPorId(Integer id) {
		return projs.get(id);
	}

	public List<Projeto> listar() {
		ArrayList<Projeto> list = new ArrayList<>();
		for(Map.Entry<Integer, Projeto> e : projs.entrySet()) {
			list.add(e.getValue());
		}
		
		return list;
	}
}
