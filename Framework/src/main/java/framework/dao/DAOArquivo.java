package framework.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOArquivo;
import framework.model.Arquivo;

public class DAOArquivo<A extends Arquivo<?, ?> > implements IDAOArquivo<A> {
	
	private final EstrategiaArquivo<A> estrategia;
	
	public DAOArquivo(){
		this(true);
	}
	
	public DAOArquivo(boolean salvarEmBanco) {
		if(salvarEmBanco) {
			estrategia = new ArquivoEmBanco<A>();
		}
		else
			estrategia = new ArquivoNoSistema<A>();
	}
	
	@Override
	public void inserir(A a) throws DatabaseException {
		
		int id  = estrategia.inserir(a);
		
		ArrayList<String> campos = new ArrayList<String>();
		
		if(a.getCodigo() != null)
			campos.add("codigoArquivo=" + a.getCodigo());
		
		if(a.getNome() != null)
			campos.add("nome='" + a.getNome() + "'");
		
		if(a.getProjeto() != null && a.getProjeto().getCodigo() != null)
			campos.add("codigoProjeto=" + a.getProjeto().getCodigo());
		
		if(a.getAtividade() != null && a.getAtividade().getCodigo() != null)
			campos.add("codigoPratica=" + a.getAtividade().getCodigo());
		
		campos.add("codigoDados=" + id);
		
		campos.add("tamanho=" + a.getDados().length);
		
		String sql = "insert into Arquivo set ";
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		sql += ";";
		
		try {
			JDBC.runInsert(sql);
			try {
				JDBC.runRemove("delete from DadosArquivo where codigoDados= " + id + ";");
			} catch (SQLException e) { }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
	}

	@Override
	public void remover(A a) throws DatabaseException {
		String sql = "delete from Arquivo where codigoArquivo= " + a.getCodigo() + ";";
		try {
			JDBC.runRemove(sql);
		} catch(Exception e) {
			e.printStackTrace();
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
	}

	@Override
	public void atualizar(A a) throws DatabaseException {
		
		int id;
		
		try {
			ResultSet resultSet = JDBC.runQuery("select codigoDados from Arquivo where codigoArquivo = " + a.getCodigo());
			id = resultSet.findColumn("codigoDados");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
		
		ArrayList<String> campos = new ArrayList<String>();
		
		if(a.getNome() != null)
			campos.add("nome=" + a.getNome());
		
		if(a.getProjeto() != null && a.getProjeto().getCodigo() != null)
			campos.add("codigoProjeto=" + a.getProjeto().getCodigo());
		
		if(a.getAtividade() != null && a.getAtividade().getCodigo() != null)
			campos.add("codigoPratica=" + a.getAtividade().getCodigo());
		
		if(a.getTamanho() != null)
			campos.add("tamanho=" + a.getTamanho());
		
		campos.add("codigoDados=" + id);
		
		String sql = "update Arquivo set ";
		
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		
		sql += " where codigoArquivo = " + a.getCodigo() + ";";
		
		try {
			JDBC.runUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
		
	}

	@Override
	public List<A> consultar(A a) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<A> listar() throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public A ler(A a) throws DatabaseException {
		a.setDados(estrategia.ler(a));
		return a;
	}

}
