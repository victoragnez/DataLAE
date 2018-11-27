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
		
	public DAOArquivo(Class<Proj> classeProjeto, Class<Prat> classePratica){
		this(classeProjeto, classePratica, true);
	}
	
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
	public List<Arquivo<Proj,Prat>> consultar(Arquivo<Proj,Prat> a) throws DatabaseException {
		// TODO Auto-generated method stub
		return listar();
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
				Integer codigoProjeto = (Integer)resultSet.getObject("codigoProjeto");
				Integer codigoPratica = (Integer)resultSet.getObject("codigoPratica");
//				Integer codigoDados = (Integer)resultSet.getObject("codigoDados");
				
				Arquivo<Proj,Prat> arq = new Arquivo<>();
										
				arq.setCodigo(codigo);
				arq.setNome(nome);
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
						arq.setAtividade(classePratica.getDeclaredConstructor().newInstance());
						arq.getAtividade().setCodigo(codigoPratica);
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
