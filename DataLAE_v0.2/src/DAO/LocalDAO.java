package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Interfaces.ILocalDAO;
import Model.Local;

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
			campos.add("coordenadas=point(" + String.format("%.8f", l.getLatitude()) + ", " + 
				String.format("%.8f", l.getLongitude()) + ")");
		
		String sql = "insert into LocalPesquisa set ";
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		sql += ";";
		
		JDBC.runInsert(sql);
	}

	@Override
	public void remover(Local l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Local consultar(String codigoLocal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Local l) {
		// TODO Auto-generated method stub
		
	}

}
