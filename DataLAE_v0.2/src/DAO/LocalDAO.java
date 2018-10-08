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
		
		ArrayList<Local> retorno = new ArrayList<Local>();
		String sql = "select codigoLocal, nome, cidade, " + 
				"estado, pais, x(coordenadas), y(coordenadas) from LocalPesquisa;";
		ResultSet resultSet = JDBC.runQuery(sql);

		while(resultSet.next()) {

			Integer codigo = (Integer)resultSet.getObject("codigoLocal");
			String nome = resultSet.getString("nome");
			String cidade = resultSet.getString("cidade");
			String estado = resultSet.getString("estado");
			String pais = resultSet.getString("pais");
			Double latitude = resultSet.getDouble("x(coordenadas)");
			Double longitude = resultSet.getDouble("y(coordenadas)");
			
			retorno.add(new Local(nome, cidade, estado, pais, latitude, longitude, codigo));
			
		}
		return retorno;
	}

	@Override
	public void alterar(Local l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Local> buscar(Local l, Pesquisador p, Projeto proj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
