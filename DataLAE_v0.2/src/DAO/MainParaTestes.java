package DAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Categoria;
import Model.Local;
import Model.Pesquisador;
import Model.Projeto;

class MainParaTestes {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		LocalDAO localDao = new LocalDAO();
		
		try {
			localDao.inserir(new Local("arara", "br", "estado", "natown", 30., 60., (Integer)null));
			for(Local l : localDao.listarLocais()) {
				System.out.println(l.getNome() + " " + l.getPais() + " " + 
						l.getCidade() + " " + l.getLatitude() + " " + l.getLongitude());
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		Projeto p;
		ProjetoDAO dao = new ProjetoDAO();
		
		p = new Projeto("ProjDeGilney", "testando", "sigla", "gilneyjr", 
				new Date(2018-1900, 9, 20), new Date(2090-1900, 9, 20), null);
		try {
			dao.inserir(p);
		} catch(Exception e) {
			e.printStackTrace();
		}

		p = new Projeto("ProjDeAgnez", "estou testando novamente", "sigla", "victoragnez", 
				new Date(2015-1900, 9, 20), new Date(2020-1900, 9, 20), null);
		
		PesquisadorDAO pesqDAO = new PesquisadorDAO();
		Pesquisador pesq = new Pesquisador("ufrn", "victor", "0000000111", Categoria.IC);
		try {
			pesqDAO.inserir(pesq);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		p.inserirPesquisador(pesq);
		
		try {
			dao.inserir(p);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		p = new Projeto("ProjDeGabriel", null, null, "GabrielAraujo", 
				new Date(2016-1900, 9, 20), null, null);
		try {
			dao.inserir(p);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		p = new Projeto("nome", "...", null, "outro coordenador", 
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
