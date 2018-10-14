package DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Interfaces.IViagemDAO;
import Model.Local;
import Model.Pesquisador;
import Model.Projeto;
import Model.Viagem;

public class ViagemDAO implements IViagemDAO{

	@Override
	public void inserir(Viagem v) throws SQLException {
		
		ArrayList<String> campos = new ArrayList<String>();
		
		if(v.getCodigo() != null)
				campos.add("codigoViagem=" + v.getCodigo());
		
		if(v.getLocal() != null)
			campos.add("codigoLocal='" + v.getLocal().getCodigo() + "'");
		
		if(v.getProjeto() != null)
			campos.add("codigoProjeto='" + v.getProjeto().getCodigo() + "'");
		
		if(v.getDataInicio() != null)
			campos.add("dataInicio='" + v.getDataInicio().toString() + "'");
		
		if(v.getDataTermino() != null)
			campos.add("dataTermino='" + v.getDataTermino().toString() + "'");
		
		String sql = "insert into Viagem set ";
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		sql += ";";
		
		int id = JDBC.runInsert(sql);
		
		if(id == -1) {
			id = v.getCodigo();
		} else {
			v.setCodigo(id);
		}
		
		try {
			ArrayList<String> commands = new ArrayList<String>();
			
			if(v.getParticipantes() != null) {
				for(Pesquisador pesq : v.getParticipantes().values()) {
					campos = new ArrayList<String>();
					campos.add("codigoViagem=" + v.getCodigo());
					campos.add("codigoPesquisador=" + pesq.getCodigo());
					campos.add("categoria='" + pesq.getCategoria() + "'");
					
					sql = "insert into PesquisadorViagem set ";
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
			JDBC.runRemove("delete from Viagem where codigoViagem=" + v.getCodigo() + ";");
			throw e;
		}
		
	}

	@Override
	public void remover(Viagem v) throws SQLException {
		JDBC.runRemove("delete from Viagem where codigoViagem=" + v.getCodigo() + ";");
	}

	@Override
	public ArrayList<Viagem> listarViagens() throws SQLException {
		String sql = "select * from Viagem;";
		return getViagemFromResult(JDBC.runQuery(sql));
	}

	@Override
	public void alterar(Viagem v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Viagem> buscar(Viagem v, Pesquisador p, Projeto proj, Local l) throws SQLException {
		String sql = "select v.* from Viagem as v";
		
		if(proj != null && proj.getCodigo() != null) {
			sql += " inner join Projeto as proj on v.codigoProjeto = proj.codigoProjeto and"
					+ " proj.codigoProjeto = " + proj.getCodigo();
		}
		
		if(l != null && l.getCodigo() != null) {
			sql += " inner join LocalPesquisa as l on v.codigoLocal = l.codigoLocal and"
					+ " l.codigoLocal = " + l.getCodigo();
		}
		
		if(p != null && p.getCodigo() != null) {
			sql += " inner join PesquisadorViagem as p on v.codigoViagem = p.codigoViagem and"
					+ " p.codigoPesquisador = " + p.getCodigo();
		}
		
		if(v != null && v.getDataInicio() != null && v.getCodigo() != null) {
			sql += " where v.dataInicio <= '" + v.getDataInicio().toString() + 
				"' and v.dataTermino >= '" + v.getDataInicio().toString() + 
				"' and v.codigoViagem = " + v.getCodigo();
		} else if(v != null && v.getDataInicio() != null) {
			sql += " where v.dataInicio <= '" + v.getDataInicio().toString() + 
					"' and v.dataTermino >= '" + v.getDataInicio().toString() + "'";
		} else if(v != null && v.getCodigo() != null) {
			sql += " where v.codigoViagem = " + v.getCodigo();
		}
		
		sql += ";";
		return getViagemFromResult(JDBC.runQuery(sql));
	}
	
	private ArrayList<Viagem> getViagemFromResult(ResultSet resultSet) throws SQLException{
		ArrayList<Viagem> retorno = new ArrayList<Viagem>();

		while(resultSet.next()) {
			
			Integer codigo = (Integer)resultSet.getObject("codigoViagem");
			Date inicio = resultSet.getDate("dataInicio");
			Date termino = resultSet.getDate("dataTermino");
			
			retorno.add(new Viagem(inicio, termino, null, null, codigo));
			
		}
		
		return retorno;
	}
}
