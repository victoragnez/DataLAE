package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import DAO.Interfaces.ILocalDAO;
import Model.Local;
import Model.Pesquisador;
import Model.Projeto;

public class LocalDAO implements ILocalDAO {

	@Override
	public void inserir(Local l) throws SQLException {
		ArrayList<String> campos = new ArrayList<String>();
		
		if(l.getCodigo() != null)
				campos.add("codigoLocal=" + l.getCodigo());
		
		if(l.getNome() != null && l.getNome().length() != 0)
			campos.add("nome='" + l.getNome()+"'");
		
		if(l.getCidade() != null && l.getCidade().length() != 0)
			campos.add("cidade='" + l.getCidade()+"'");
		
		if(l.getEstado() != null && l.getEstado().length() != 0)
			campos.add("estado='" + l.getEstado()+"'");
		
		if(l.getPais() != null && l.getPais().length() != 0)
			campos.add("pais='" + l.getPais()+"'");
		
		if(l.getLatitude() != null && l.getLongitude() != null && 
				Double.isFinite(l.getLatitude()) && Double.isFinite(l.getLongitude()))
			campos.add("coordenadas=point(" + 
				String.format(Locale.US, "%.8f", l.getLatitude()) + ", " + 
				String.format(Locale.US, "%.8f", l.getLongitude()) + ")");
		
		String sql = "insert into LocalPesquisa set ";
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		sql += ";";
		
		int id = JDBC.runInsert(sql);
		
		if(id == -1) {
			id = l.getCodigo();
		} else {
			l.setCodigo(id);
		}
	}

	@Override
	public void remover(Local l) throws SQLException {
		JDBC.runRemove("delete from LocalPesquisa where codigoLocal=" + l.getCodigo() + ";");		
	}

	@Override
	public ArrayList<Local> listarLocais() throws SQLException {
		String sql = "select l.codigoLocal, l.nome, l.cidade, "
				+ "l.estado, l.pais, x(l.coordenadas), y(l.coordenadas) from LocalPesquisa as l;";
		return getLocalFromResult(JDBC.runQuery(sql));

	}

	@Override
	public void alterar(Local l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Local> buscar(Local l, Pesquisador p, Projeto proj) throws SQLException {
		String sql = "select l.codigoLocal, l.nome, l.cidade, " 
				+ "l.estado, l.pais, x(l.coordenadas), y(l.coordenadas) from LocalPesquisa as l";
		
		if(proj != null && proj.getCodigo() != null) {
			sql += " inner join LocalProjeto as proj on "
					+ "l.codigoLocal = proj.codigoLocal and"
					+ " proj.codigoProjeto = " + proj.getCodigo();
		}
		
		if(p != null && p.getCodigo() != null) {
			sql += " inner join Viagem as v on v.codigoLocal = l.codigoLocal";
			sql += " inner join PesquisadorViagem as pesqV on pesqV.codigoViagem = v.codigoViagem"
					+ " and pesqV.codigoPesquisador = " + p.getCodigo();
		}
		
		if(l != null && (l.getCodigo() != null || l.getNome() != null ||
				l.getCidade() != null || l.getEstado() != null || l.getPais() != null)) {
			sql += " where";
			
			ArrayList<String> cond = new ArrayList<String>();
			
			if(l.getCodigo() != null) {
				cond.add("l.codigoLocal = " + l.getCodigo());
			}
			
			if(l.getNome() != null) {
				cond.add("l.nome like '%" + l.getNome() + "%'");
			}
			
			if(l.getCidade() != null) {
				cond.add("l.cidade like '%" + l.getCidade() + "%'");
			}
			
			if(l.getEstado() != null) {
				cond.add("l.estado = '" + l.getEstado() + "'");
			}
			
			if(l.getPais() != null) {
				cond.add("l.pais = '" + l.getPais() + "'");
			}
			
			for(int i = 0; i < cond.size(); i++) {
				sql += " " + cond.get(i);
				if(i + 1 < cond.size())
					sql += " and";
			}
		}
		
		sql += ";";
		
		return getLocalFromResult(JDBC.runQuery(sql));
	}
	
	private ArrayList<Local> getLocalFromResult(ResultSet resultSet) throws SQLException {
		
		ArrayList<Local> retorno = new ArrayList<Local>();

		while(resultSet.next()) {

			Integer codigo = (Integer)resultSet.getObject("l.codigoLocal");
			String nome = resultSet.getString("l.nome");
			String cidade = resultSet.getString("l.cidade");
			String estado = resultSet.getString("l.estado");
			String pais = resultSet.getString("l.pais");
			Double latitude = resultSet.getDouble("x(l.coordenadas)");
			Double longitude = resultSet.getDouble("y(l.coordenadas)");
			
			retorno.add(new Local(nome, pais, estado, cidade, latitude, longitude, codigo));
			
		}
		return retorno;
	}

}
