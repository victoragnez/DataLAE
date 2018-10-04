package DAO;

import java.sql.Date;
import java.util.ArrayList;

import Model.Projeto;

class MainParaTestes {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Projeto p;
		ProjetoDAO dao = new ProjetoDAO();
		
		p = new Projeto("gilney", "testando", "sigla", "coordenador", 
				new Date(2018-1900, 9, 20), new Date(2090-1900, 9, 20), null);
		try {
			dao.inserir(p);
		} catch(Exception e) {
			e.printStackTrace();
		}

		p = new Projeto("agnez", "estou testando novamente", "sigla", "Coordenador", 
				new Date(2015-1900, 9, 20), new Date(2020-1900, 9, 20), null);
		try {
			dao.inserir(p);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		p = new Projeto("gabriel", null, "sigla", null, 
				new Date(2016-1900, 9, 20), null, null);
		try {
			dao.inserir(p);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		p = new Projeto("nome", "...", "sigla", "coordenador", 
				null, new Date(2090-1900, 9, 20), null);
		try {
			dao.inserir(p);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		p = new Projeto("nome", "...", null, "coordenador", 
				new Date(2018-1900, 9, 20), new Date(2090-1900, 9, 20), null);
		try {
			dao.inserir(p);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			ArrayList<Projeto> vet = dao.listarProjetos();
			
			for(Projeto proj : vet) {
				System.out.println(proj.getCodigo() + " " + proj.getNome() + 
						" " + proj.getCoordenador() + " " + proj.getDataTermino());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
