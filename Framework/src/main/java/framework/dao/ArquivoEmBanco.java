package framework.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import framework.dao.interfaces.DatabaseException;
import framework.model.Arquivo;

class ArquivoEmBanco<A extends Arquivo<?, ?> > implements EstrategiaArquivo<A> {

	private static final String hexaDigits = "0123456789ABCDEF";
	
	@Override
	public int inserir(A a) throws DatabaseException {
		String sql = "insert into DadosArquivo set dados = 0x" + toHexa(a.getDados()) + ";";
		try{
			return JDBC.runInsert(sql);
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
	}

	private String toHexa(byte[] dados) {
		String ret = "";
		for(byte b : dados) {
			ret += hexaDigits.charAt(b&15);
			ret += hexaDigits.charAt((b>>4)&15);
		}
		return ret;
	}

	@Override
	public byte[] ler(A a) throws DatabaseException {
		String sql = "select dados from DadosArquivo inner join Arquivo" + 
				" on DadosArquivo.codigoDados = Arquivo.codigoDados where "
				+ "Arquivo.codigoArquivo=" + a.getCodigo() + ";";
		try {
			ResultSet resultSet = JDBC.runQuery(sql);
			return resultSet.getBlob("dados").getBytes(1, (int)(long)a.getTamanho());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
	}

}
