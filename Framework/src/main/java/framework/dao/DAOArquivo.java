package framework.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOArquivo;
import framework.model.Arquivo;
import framework.model.Pratica;
import framework.model.Projeto;

public class DAOArquivo<Proj extends Projeto<?>, Prat extends Pratica<?, ?, Proj>> implements IDAOArquivo<Proj, Prat> {
	
	private final EstrategiaArquivo<Arquivo<Proj, Prat>> estrategia;
	private final Class<Proj> classeProjeto;
	private final Class<Prat> classePratica;
		
	public DAOArquivo(Class<Proj> classeProjeto, Class<Prat> classePratica, boolean salvarEmBanco) {
		if(salvarEmBanco) {
			estrategia = new ArquivoEmBanco<Arquivo<Proj, Prat>>();
		}
		else
			estrategia = new ArquivoNoSistema<Arquivo<Proj,Prat>>();
		this.classeProjeto = classeProjeto;
		this.classePratica = classePratica;
	}
	
	@Override
	public void inserir(Arquivo<Proj,Prat> a) throws DatabaseException {
		
		int id  = estrategia.inserir(a);
		
		ArrayList<String> campos = new ArrayList<String>();
		
		if(a.getCodigo() != null)
			campos.add("codigoArquivo=" + a.getCodigo());
		
		if(a.getNome() != null)
			campos.add("nome='" + a.getNome() + "'");
		
		if(a.getTipo() != null)
			campos.add("tipo='" + a.getTipo() + "'");
		
		if(a.getProjeto() != null && a.getProjeto().getCodigo() != null)
			campos.add("codigoProjeto=" + a.getProjeto().getCodigo());
		
		if(a.getPratica() != null && a.getPratica().getCodigo() != null)
			campos.add("codigoPratica=" + a.getPratica().getCodigo());
		
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
	public void remover(Arquivo<Proj,Prat> a) throws DatabaseException {
		String sql = "delete from Arquivo where codigoArquivo= " + a.getCodigo() + ";";
		try {
			JDBC.runRemove(sql);
		} catch(Exception e) {
			e.printStackTrace();
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
	}

	@Override
	public void atualizar(Arquivo<Proj,Prat> a) throws DatabaseException {
		
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
			campos.add("nome='" + a.getNome() + "'");
		
		if(a.getProjeto() != null && a.getProjeto().getCodigo() != null)
			campos.add("codigoProjeto=" + a.getProjeto().getCodigo());
		
		if(a.getPratica() != null && a.getPratica().getCodigo() != null)
			campos.add("codigoPratica=" + a.getPratica().getCodigo());
		
		if(a.getTamanho() != null)
			campos.add("tamanho=" + a.getTamanho());
		
		if(a.getTipo() != null)
			campos.add("tipo='" + a.getTipo() + "'");
		
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
	public List<Arquivo<Proj,Prat>> consultar(Arquivo<Proj,Prat> a) throws DatabaseException {
		String sql = "select * from Arquivo ";
		
		ArrayList<String> cond = new ArrayList<String>();
		
		if(a.getCodigo() != null) {
			cond.add("codigoArquivo = " + a.getCodigo());
		}
		if(a.getNome() != null) {
			cond.add("nome like '%" + a.getNome() + "%'");
		}
		if(a.getTipo() != null) {
			cond.add("tipo like '% " + a.getTipo() + "%'");
		}
		if(a.getTamanho() != null) {
			cond.add("tamanho = " + a.getTamanho());
		}
		if(a.getProjeto() != null && a.getProjeto().getCodigo() != null) {
			cond.add("codigoProjeto = " + a.getProjeto().getCodigo());
		}
		if(a.getPratica() != null && a.getPratica().getCodigo() != null) {
			cond.add("codigoPratica = " + a.getPratica().getCodigo());
		}
		
		if (!cond.isEmpty()) {
			sql += "where ";
			for(int i = 0; i < cond.size(); i++) {
				sql += " " + cond.get(i);
				if(i + 1 < cond.size())
					sql += " and";
			}
		}
		
		sql += ";";
		
		System.out.println(sql);
		try {
			return getFromResult(JDBC.runQuery(sql));
		} catch (Exception e) {
			throw new DatabaseException("Erro durante a consulta");
		}
	}

	@Override
	public List<Arquivo<Proj,Prat>> listar() throws DatabaseException {
		String sql = "select * from Arquivo;";
		System.out.println(sql);
		try {
			return getFromResult(JDBC.runQuery(sql));
		} catch (SQLException e) {
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
	}

	@Override
	public Arquivo<Proj,Prat> ler(Arquivo<Proj,Prat> a) throws DatabaseException {
		a.setDados(estrategia.ler(a));
		return a;
	}
	
	private ArrayList<Arquivo<Proj,Prat>> getFromResult(ResultSet resultSet) throws DatabaseException {
		ArrayList<Arquivo<Proj,Prat>> retorno = new ArrayList<>();

		try {
			while(resultSet.next()) {
				
				Integer codigo = (Integer)resultSet.getObject("codigoArquivo");
				String nome = (String)resultSet.getObject("nome");
				Long tamanho = (Long)resultSet.getObject("tamanho");
				String tipo = resultSet.getString("tipo");
				Integer codigoProjeto = (Integer)resultSet.getObject("codigoProjeto");
				Integer codigoPratica = (Integer)resultSet.getObject("codigoPratica");
//				Integer codigoDados = (Integer)resultSet.getObject("codigoDados");
				
				Arquivo<Proj,Prat> arq = new Arquivo<>();
										
				arq.setCodigo(codigo);
				arq.setNome(nome);
				arq.setTipo(tipo);
				arq.setTamanho(tamanho);
				arq.setDados(null);
				
				if(codigoProjeto != null) {
					try {
						arq.setProjeto(classeProjeto.getDeclaredConstructor().newInstance());
						arq.getProjeto().setCodigo(codigoProjeto);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException e) {
						throw new DatabaseException(e);
					}
				}
				
				if(codigoPratica != null) {
					try {
						arq.setPratica(classePratica.getDeclaredConstructor().newInstance());
						arq.getPratica().setCodigo(codigoPratica);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException e) {
						throw new DatabaseException(e);
					}
				}
				
				retorno.add(arq);
			}
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
		return retorno;
	}

}
