package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Interfaces.IDiretorDAO;
import Model.Diretor;

public class DiretorDAO implements IDiretorDAO {

	public void inserir(Diretor d) throws SQLException {
		
		ArrayList<String> campos = new ArrayList<String>();
		
		if(d.getCodigo() != null)
				campos.add("codigoDiretor=" + d.getCodigo());
		
		if(d.getNome() != null && d.getNome().length() != 0)
			campos.add("nome='" + d.getNome() + "'");
		
		if(d.getEmail() != null && d.getEmail().length() != 0)
			campos.add("email='" + d.getEmail() + "'");
		
		if(d.getTelefone() != null && d.getTelefone().length() != 0)
			campos.add("telefone='" + d.getTelefone()+"'");
		
		if(d.getCargo() != null && d.getCargo().length() != 0)
			campos.add("cargo='" + d.getCargo()+"'");
		
		String sql = "insert into Diretor set ";
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		sql += ";";
		
		int id = JDBC.runInsert(sql);
		
		if(id == -1) {
			id = d.getCodigo();
		} else {
			d.setCodigo(id);
		}
		
	}

	@Override
	public void remover(Diretor d) throws SQLException {
		JDBC.runRemove("delete from Diretor where codigoDiretor=" + d.getCodigo() + ";");		
	}
	
	@Override
	public ArrayList<Diretor> listarDiretores() throws SQLException {
		
		ArrayList<Diretor> retorno = new ArrayList<Diretor>();
		String sql = "select * from Diretor;";
		ResultSet resultSet = JDBC.runQuery(sql);

		while(resultSet.next()) {

			Integer codigo = (Integer)resultSet.getObject("codigoDiretor");
			String nome = resultSet.getString("nome");
			String email = resultSet.getString("email");
			String telefone = resultSet.getString("telefone");
			String cargo = resultSet.getString("cargo");
			
			retorno.add(new Diretor(nome, email, telefone, cargo, codigo));
			
		}
		return retorno;
	}
	
	@Override
	public void alterar(Diretor d) {
		// TODO Auto-generated method stub
		
	}

}
