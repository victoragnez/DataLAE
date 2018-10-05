package DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Interfaces.IProjetoDAO;
import Model.Financiador;
import Model.Local;
import Model.Pesquisador;
import Model.Projeto;

public class ProjetoDAO  implements IProjetoDAO{

	@Override
	public void inserir(Projeto p) throws SQLException {
		
		ArrayList<String> campos = new ArrayList<String>();
		
		if(p.getCodigo() != null)
			campos.add("codigoProjeto=" + p.getCodigo());
		
		if(p.getNome() != null && p.getNome().length() != 0)
			campos.add("nome='" + p.getNome()+"'");
		
		if(p.getDescricao() != null && p.getDescricao().length() != 0)
			campos.add("descricao='" + p.getDescricao() + "'");
		
		if(p.getSigla() != null && p.getSigla().length() != 0)
			campos.add("sigla='" + p.getSigla()+"'");
		
		if(p.getCoordenador() != null && p.getCoordenador().length() != 0)
			campos.add("nomeCoordenador='" + p.getCoordenador() + "'");
		
		if(p.getDataInicio() != null)
			campos.add("dataInicio='" + p.getDataInicio().toString() + "'");
		
		if(p.getDataTermino() != null)
			campos.add("dataTermino='" + p.getDataTermino().toString() + "'");
		
		String sql = "insert into Projeto set ";
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		sql += ";";
		
		int id = JDBC.runInsert(sql);
		
		if(id == -1) {
			id = p.getCodigo();
		} else {
			p.setCodigo(id);
		}
		
		try {
			ArrayList<String> commands = new ArrayList<String>();
			
			if(p.getFinanciadores() != null) {
				for(Financiador f : p.getFinanciadores().values()) {
					campos = new ArrayList<String>();
					campos.add("codigoProjeto=" + p.getCodigo());
					campos.add("codigoFinanciador=" + f.getCodigo());
					campos.add("codigoDiretor=" + f.getDiretor().getCodigo());
					
					sql = "insert into FinanciamentoProjeto set ";
					for(int i = 0; i < campos.size(); i++) {
						sql += campos.get(i);
						if(i+1 < campos.size())
							sql += ", ";
					}
					sql += ";";
					commands.add(sql);
				}
			}
			
			if(p.getPesquisadores() != null) {
				for(Pesquisador pesq : p.getPesquisadores().values()) {
					campos = new ArrayList<String>();
					campos.add("codigoProjeto=" + p.getCodigo());
					campos.add("codigoPesquisador=" + pesq.getCodigo());
					campos.add("categoria='" + pesq.getCategoria() + "'");
					
					sql = "insert into PesquisadorProjeto set ";
					for(int i = 0; i < campos.size(); i++) {
						sql += campos.get(i);
						if(i+1 < campos.size())
							sql += ", ";
					}
					sql += ";";
					commands.add(sql);
				}
			}
			
			if(p.getLocais() != null) {
				for(Local l : p.getLocais().values()) {
					campos = new ArrayList<String>();
					campos.add("codigoProjeto=" + p.getCodigo());
					campos.add("codigoLocal=" + l.getCodigo());
					
					sql = "insert into LocalPesquisa set ";
					for(int i = 0; i < campos.size(); i++) {
						sql += campos.get(i);
						if(i+1 < campos.size())
							sql += ", ";
					}
					sql += ";";
					commands.add(sql);
				}
			}
			
			if(commands.size() > 0) {
				JDBC.runMultipleInserts(commands);
			}
		}
		catch(Exception e) {
			JDBC.runRemove("delete from Projeto where codigoProjeto=" + p.getCodigo() + ";");
			throw e;
		}
	}

	@Override
	public void remover(Projeto p) throws SQLException {
		JDBC.runRemove("delete from Projeto where codigoProjeto=" + p.getCodigo() + ";");		
	}

	@Override
	public ArrayList<Projeto> listarProjetos() throws SQLException {
		
		ArrayList<Projeto> retorno = new ArrayList<Projeto>();
		String sql = "select * from Projeto;";
		ResultSet resultSet = JDBC.runQuery(sql);

		while(resultSet.next()) {
			
			Integer codigo = (Integer)resultSet.getObject("codigoProjeto");
			String nome = resultSet.getString("nome");
			String descricao = resultSet.getString("descricao");
			String sigla = resultSet.getString("sigla");
			String nomeCoordenador = resultSet.getString("nomeCoordenador");
			Date inicio = resultSet.getDate("dataInicio");
			Date termino = resultSet.getDate("dataTermino");
			
			retorno.add(new Projeto(nome, descricao, sigla, 
					nomeCoordenador, inicio, termino, codigo));
			
		}
		return retorno;
	}

	@Override
	public void alterar(Projeto p) {
		// TODO Auto-generated method stub
		
	}

}
