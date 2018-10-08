package DAO;

import java.sql.Date;
import java.util.ArrayList;

import Model.Categoria;
import Model.Diretor;
import Model.Financiador;
import Model.Local;
import Model.Pesquisador;
import Model.Projeto;
import Model.Viagem;

class MainParaTestes {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		FinanciadorDAO finDao = new FinanciadorDAO();
		
		LocalDAO localDao = new LocalDAO();
		
		ViagemDAO viagemDao = new ViagemDAO();
		
		DiretorDAO dirDao = new DiretorDAO();
		
		Local l1 = new Local("arara", "br", "estado", "natown", 30., 60.);
		
		Local l2 = new Local("bbbbb", "bbr", "bestado", "batown", 10., 30.);
		
		try {
			localDao.inserir(l1);
			localDao.inserir(l2);
//			for(Local l : localDao.listarLocais()) {
//				System.out.println(l.getNome() + " " + l.getPais() + " " + 
//						l.getCidade() + " " + l.getLatitude() + " " + l.getLongitude());
//			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		Projeto p, p1, p2, p3;
		ProjetoDAO projDao = new ProjetoDAO();
		
		p1 = p = new Projeto("ProjDeGilney", "testando", "sigla", "gilneyjr", 
				new Date(2018-1900, 9, 20), new Date(2090-1900, 9, 20));
		try {
			p1.inserirLocal(l1);
			projDao.inserir(p);
		} catch(Exception e) {
			e.printStackTrace();
		}

		p2 = p = new Projeto("ProjDeAgnez", "estou testando novamente", "sigla", "victoragnez", 
				new Date(2015-1900, 9, 20), new Date(2020-1900, 9, 20));
		
		PesquisadorDAO pesqDAO = new PesquisadorDAO();
		Pesquisador pesq = new Pesquisador("ufrn", "victor", "0000000111", Categoria.IC);
		try {
			pesqDAO.inserir(pesq);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		p.inserirPesquisador(pesq);
		
		try {
			projDao.inserir(p);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		p3 = p = new Projeto("ProjDeGabriel", null, null, "GabrielAraujo", 
				new Date(2016-1900, 9, 20), null);
		
		Financiador f = new Financiador("petrobras", "3768378264");
		
		
		try {
			Diretor d = new Diretor("dir", "a@b", null, "contato");
			dirDao.inserir(d);
			f.setDiretor(d);
			finDao.inserir(f);
			p.inserirFinanciador(f);
			p.inserirPesquisador(pesq);
			projDao.inserir(p);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		p = new Projeto("nome", "...", null, "outro coordenador", 
				new Date(2018-1900, 9, 20), new Date(2090-1900, 9, 20));
		try {
			projDao.inserir(p);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
//			ArrayList<Projeto> vet;
			
//			vet = projDao.buscar(null, null, pesq, null);
//			for(Projeto proj : vet) {
//				System.out.println(proj.getCodigo() + " " + proj.getNome() + 
//						" " + proj.getCoordenador() + " " + proj.getDataTermino());
//			}
			
//			vet = projDao.buscar(null, f, null, null);
//			for(Projeto proj : vet) {
//				System.out.println(proj.getCodigo() + " " + proj.getNome() + 
//						" " + proj.getCoordenador() + " " + proj.getDataTermino());
//			}
			
//			vet = projDao.buscar(p3, null, null, null);
//			for(Projeto proj : vet) {
//				System.out.println(proj.getCodigo() + " " + proj.getNome() + 
//						" " + proj.getCoordenador() + " " + proj.getDataTermino());
//			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
//			ArrayList<Financiador> vet;
			
//			vet = finDao.buscar(new Financiador("p", "3768378264"), null);
//			
//			for(Financiador fin : vet) {
//				System.out.println(fin.getCodigo() + " " + fin.getNome());
//			}
			
//			vet = finDao.buscar(f, null);
//			
//			for(Financiador fin : vet) {
//				System.out.println(fin.getCodigo() + " " + fin.getNome());
//			}
			
//			vet = finDao.buscar(null, p3);
//			
//			for(Financiador fin : vet) {
//				System.out.println(fin.getCodigo() + " " + fin.getNome());
//			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			Viagem v1 = new Viagem(new Date(2090-1900, 9, 11), 
					new Date(2090-1900, 9, 20), l1, p1);
			
			v1.inserirParticapante(pesq);
			
			viagemDao.inserir(v1);
			
			
			viagemDao.inserir(new Viagem(new Date(2090-1900, 9, 12), 
					new Date(2090-1900, 9, 20), l1, p2));
			
			viagemDao.inserir(new Viagem(new Date(2090-1900, 9, 13), 
					new Date(2090-1900, 9, 20), l2, p1));
			
			viagemDao.inserir(new Viagem(new Date(2090-1900, 9, 14), 
					new Date(2090-1900, 9, 20), l1, p3));
			
//			for(Viagem v : viagemDao.buscar(null, null, p2, l2)){
//				System.out.println(v.getDataInicio());
//			}
//			
//			for(Viagem v : viagemDao.buscar(null, null, p2, null)){
//				System.out.println(v.getDataInicio());
//			}
//			
//			for(Viagem v : viagemDao.buscar(null, null, p1, null)){
//				System.out.println(v.getDataInicio());
//			}
//			
//			for(Viagem v : viagemDao.buscar(null, null, p3, l1)){
//				System.out.println(v.getDataInicio());
//			}
//			
//			for(Viagem v : viagemDao.buscar(null, pesq, null, null)){
//				System.out.println(v.getDataInicio());
//			}

//			Viagem vv = new Viagem(new Date(2090-1900, 9, 12), null, null, null);
//			
//			vv.setCodigo(1);
//			
//			for(Viagem v : viagemDao.buscar(vv, null, null, null)){
//				System.out.println(v.getDataInicio());
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			ArrayList<Local> vet;
			
//			vet = localDao.listarLocais();
//			
//			for(Local l : vet) {
//				System.out.println(l.getNome() + " " + l.getPais() + " " + 
//						l.getCidade() + " " + l.getLatitude() + " " + l.getLongitude());
//			}
			
//			vet = localDao.buscar(l2, null, null);
//			
//			for(Local l : vet) {
//				System.out.println(l.getNome() + " " + l.getPais() + " " + 
//						l.getCidade() + " " + l.getLatitude() + " " + l.getLongitude());
//			}
			
//			vet = localDao.buscar(new Local(null, null, null, "atown", null, null), null, null);
//			
//			for(Local l : vet) {
//				System.out.println(l.getNome() + " " + l.getPais() + " " + 
//						l.getCidade() + " " + l.getLatitude() + " " + l.getLongitude());
//			}
			
//			vet = localDao.buscar(null, pesq, null);
//			
//			for(Local l : vet) {
//				System.out.println(l.getNome() + " " + l.getPais() + " " + 
//						l.getCidade() + " " + l.getLatitude() + " " + l.getLongitude());
//			}
			
//			vet = localDao.buscar(l1, pesq, p1);
//			
//			for(Local l : vet) {
//				System.out.println(l.getNome() + " " + l.getPais() + " " + 
//						l.getCidade() + " " + l.getLatitude() + " " + l.getLongitude());
//			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

}
