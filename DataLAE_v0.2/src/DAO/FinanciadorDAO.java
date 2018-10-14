package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Interfaces.IFinanciadorDAO;
import Model.Financiador;
import Model.Projeto;

public class FinanciadorDAO implements IFinanciadorDAO{

	@Override
	public void inserir(Financiador f) throws SQLException {
		
		ArrayList<String> campos = new ArrayList<String>();
		
		if(f.getCodigo() != null)
				campos.add("codigoFinanciador=" + f.getCodigo());
		
		if(f.getNome() != null && f.getNome().length() != 0)
			campos.add("nome='" + f.getNome() + "'");
		
		if(f.getCnpj() != null && f.getCnpj().length() != 0)
			campos.add("cnpj='" + f.getCnpj() + "'");
		
		String sql = "insert into Financiador set ";
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		sql += ";";
		
		int id = JDBC.runInsert(sql);
		
		if(id == -1) {
			id = f.getCodigo();
		} else {
			f.setCodigo(id);
		}
		
	}

	@Override
	public void remover(Financiador f) throws SQLException {
		JDBC.runRemove("delete from Financiador where codigoFinanciador=" + f.getCodigo() + ";");		
	}

	@Override
	public ArrayList<Financiador> listarFinanciadores() throws SQLException {
		String sql = "select * from Financiador;";
		return getFinanciadorFromResult(JDBC.runQuery(sql));
	}

	@Override
	public void alterar(Financiador f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Financiador> buscar(Financiador f, Projeto p) throws SQLException {
		String sql = "select f.* from Financiador as f";
		
		if(p != null && p.getCodigo() != null) {
			sql += " inner join FinanciamentoProjeto as proj on "
					+ "f.codigoFinanciador = proj.codigoFinanciador and"
					+ " proj.codigoProjeto = " + p.getCodigo();
		}
		
		if(f != null && (f.getCodigo() != null || f.getNome() != null || f.getCnpj() != null)) {
			sql += " where";
			
			ArrayList<String> cond = new ArrayList<String>();
			
			if(f.getCodigo() != null) {
				cond.add("f.codigoFinanciador = " + f.getCodigo());
			}
			
			if(f.getNome() != null) {
				cond.add("f.nome like '%" + f.getNome() + "%'");
			}
			
			if(f.getCnpj() != null) {
				cond.add("f.cnpj = '" + f.getCnpj() + "'");
			}
			
			for(int i = 0; i < cond.size(); i++) {
				sql += " " + cond.get(i);
				if(i + 1 < cond.size())
					sql += " and";
			}
		}
		
		sql += ";";
		
		return getFinanciadorFromResult(JDBC.runQuery(sql));
	}
	
	private ArrayList<Financiador> getFinanciadorFromResult(ResultSet resultSet) throws SQLException {
		ArrayList<Financiador> retorno = new ArrayList<Financiador>();

		while(resultSet.next()) {

			Integer codigo = (Integer)resultSet.getObject("codigoFinanciador");
			String nome = resultSet.getString("nome");
			String cnpj = resultSet.getString("cnpj");
			
			retorno.add(new Financiador(nome, cnpj, codigo));
			
		}
		return retorno;
	}
}
