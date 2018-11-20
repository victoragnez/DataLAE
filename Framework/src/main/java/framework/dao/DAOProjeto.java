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

public abstract class DAOProjeto implements IDAOProjeto {
	
	@Override
	public void inserir(Projeto p) throws DatabaseException
	{

		ArrayList<String> campos = new ArrayList<String>();
		
		if(p.getCodigo() != null)
			campos.add("codigoProjeto=" + p.getCodigo());
		
		if(p.getNome() != null && p.getNome().length() != 0)
			campos.add("nome='" + p.getNome()+"'");
		
		if(p.getDataInicio() != null)
			campos.add("dataInicio='" + p.getDataInicio().toString() + "'");
		
		if(p.getDataFim() != null)
			campos.add("dataTermino='" + p.getDataFim().toString() + "'");
		
		String sql = "insert into Projeto set ";
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
					campos.add("codigoProjeto=" + p.getCodigo());
					campos.add("codigoParticipante=" + pesq.getCodigo());
					
					sql = "insert into ParticipanteProjeto set ";
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
				JDBC.runRemove("delete from Projeto where codigoProjeto=" + p.getCodigo() + ";");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new DatabaseException(e);
		}
		
	}
	
	@Override
	public void remover(Projeto p) throws DatabaseException
	{
		
	}
	
	@Override
	public void atualizar(Projeto p) throws DatabaseException
	{
		
	}
	
	@Override
	public List<Projeto> consultar(Projeto pj) throws DatabaseException
	{
		return null;
		
	}
	
	@Override
	public List<Projeto> listar() throws DatabaseException
	{
		String sql = "select * from Projeto;";
		
		try {
			return getProjetoFromResult(JDBC.runQuery(sql));
		}catch (SQLException e) {
			//lançar nova exceção
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
		
	}

	private ArrayList<Projeto> getProjetoFromResult(ResultSet resultSet) throws SQLException {
		ArrayList<Projeto> retorno = new ArrayList<Projeto>();

		while(resultSet.next()) {
			
			Integer codigo = (Integer)resultSet.getObject("codigoProjeto");
			String nome = resultSet.getString("nome");
			Date inicio = resultSet.getDate("dataInicio");
			Date termino = resultSet.getDate("dataTermino");
			
			Projeto p = getProjectWithFlexibleAttributes(resultSet);
			
			p.setCodigo(codigo);
			p.setNome(nome);
			p.setDataInicio(inicio);
			p.setDataFim(termino);
			
			retorno.add(p);
			
		}
		return retorno;
	}
	
	/** classes que devem ser implementadas*/
	
	protected abstract String compInserir(String comando);
	protected abstract String compRemover(String comando);
	protected abstract String compAtualizar(String comando);
	protected abstract String compConsultar(String comando);

	protected abstract Projeto getProjectWithFlexibleAttributes(ResultSet resultSet);

}
