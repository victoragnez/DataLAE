package framework.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOAtividade;
import framework.model.Atividade;

public abstract class DAOAtividade<A extends Atividade> implements IDAOAtividade<A> {

	private final Class<A> classe;
	
	public DAOAtividade(Class<A> classe) {
		this.classe = classe;
	}
	
	@Override
	public void inserir(A a) throws DatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(A a) throws DatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(A a) throws DatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<A> consultar(A a) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<A> listar() throws DatabaseException {
		String sql = "select * from Pratica;";
		
		try {
			return getFromResult(JDBC.runQuery(sql));
		}catch (SQLException e) {
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
	}
	
	private ArrayList<A> getFromResult(ResultSet resultSet) throws DatabaseException {
		ArrayList<A> retorno = new ArrayList<A>();

		try {
			while(resultSet.next()) {
				
				Integer codigo = (Integer)resultSet.getObject("codigoPratica");
				Date inicio = resultSet.getDate("dataInicio");
								
				A a;
				
				try {
					a = classe.getDeclaredConstructor().newInstance();
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException 
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					throw new DatabaseException(e);
				}
				
				getProjectWithFlexibleAttributes(resultSet, a);
				
				a.setCodigo(codigo);
				a.setData(inicio);
				
				retorno.add(a);
				
			}
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
		return retorno;
	}
	
	/** Metodos que devem ser implementados*/
	
	protected abstract ArrayList<String> compInserir(ArrayList<String> sql, A a);
	protected abstract ArrayList<String> compRemover(ArrayList<String> sql, A a);
	protected abstract ArrayList<String> compAtualizar(ArrayList<String> sql, A a);
	protected abstract ArrayList<String> compConsultar(ArrayList<String> sql, A a);
	
	protected abstract void getProjectWithFlexibleAttributes(ResultSet resultSet, A p) throws SQLException;
}
