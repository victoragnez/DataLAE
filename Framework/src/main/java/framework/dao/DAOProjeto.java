package framework.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOProjeto;
import framework.model.Participante;
import framework.model.Projeto;

public abstract class DAOProjeto<P extends Projeto> implements IDAOProjeto<P> {
	
	@Override
	public void inserir(P p) throws DatabaseException
	{

		ArrayList<String> campos = new ArrayList<String>();
		
		if(p.getCodigo() != null)
			campos.add("codigoP=" + p.getCodigo());
		
		if(p.getNome() != null && p.getNome().length() != 0)
			campos.add("nome='" + p.getNome()+"'");
		
		if(p.getDataInicio() != null)
			campos.add("dataInicio='" + p.getDataInicio().toString() + "'");
		
		if(p.getDataFim() != null)
			campos.add("dataTermino='" + p.getDataFim().toString() + "'");
		
		String sql = "insert into P set ";
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		sql += ";";
		
		int id;
		try {
			id = JDBC.runInsert(sql);
		}catch (SQLException e) {
			//lançar nova exceção
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
		
		if(id == -1) {
			id = p.getCodigo();
		} else {
			p.setCodigo(id);
		}
		
		try {
			ArrayList<String> commands = new ArrayList<String>();
			
			if(p.getParticipantes() != null) {
				for(Participante pesq : p.getParticipantes()) {
					campos = new ArrayList<String>();
					campos.add("codigoP=" + p.getCodigo());
					campos.add("codigoParticipante=" + pesq.getCodigo());
					
					sql = "insert into ParticipanteP set ";
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
		catch(SQLException e) {
			try {
				JDBC.runRemove("delete from P where codigoP=" + p.getCodigo() + ";");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new DatabaseException(e);
		}
		
	}
	
	@Override
	public void remover(P p) throws DatabaseException
	{
		
	}
	
	@Override
	public void atualizar(P p) throws DatabaseException
	{
		
	}
	
	@Override
	public List<P> consultar(P pj) throws DatabaseException
	{
		return null;
		
	}
	
	@Override
	public List<P> listar() throws DatabaseException
	{
		String sql = "select * from P;";
		
		try {
			return getPFromResult(JDBC.runQuery(sql));
		}catch (SQLException e) {
			//lançar nova exceção
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
		
	}

	private ArrayList<P> getPFromResult(ResultSet resultSet) throws SQLException {
		ArrayList<P> retorno = new ArrayList<P>();

		while(resultSet.next()) {
			
			Integer codigo = (Integer)resultSet.getObject("codigoP");
			String nome = resultSet.getString("nome");
			Date inicio = resultSet.getDate("dataInicio");
			Date termino = resultSet.getDate("dataTermino");
			
			P p = getProjectWithFlexibleAttributes(resultSet);
			
			p.setCodigo(codigo);
			p.setNome(nome);
			p.setDataInicio(inicio);
			p.setDataFim(termino);
			
			retorno.add(p);
			
		}
		return retorno;
	}
	
	/** Metodos que devem ser implementados*/
	
	protected abstract String compInserir(String comando);
	protected abstract String compRemover(String comando);
	protected abstract String compAtualizar(String comando);
	protected abstract String compConsultar(String comando);

	protected abstract P getProjectWithFlexibleAttributes(ResultSet resultSet);

}
