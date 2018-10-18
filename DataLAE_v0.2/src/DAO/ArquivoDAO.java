package DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Interfaces.IArquivoDAO;
import Model.Arquivo;
import Model.Projeto;
import Model.Viagem;

public class ArquivoDAO implements IArquivoDAO {

	@Override
	public void inserir(Arquivo a) throws SQLException {
		ArrayList<String> campos = new ArrayList<String>();
		
		if(a.getCodigo() != null)
			campos.add("codigoArquivo=" + a.getCodigo());
		
		if(a.getNome() != null)
			campos.add("nome='" + a.getNome()+"'");
		
		campos.add("dataInsercao='" + java.time.LocalDate.now().toString() + "'" );
		
		if(a.getTamanho() != null)
			campos.add("tamanho="+a.getTamanho());
		
		if(a.getTipo() != null)
			campos.add("tipo='" + a.getTipo() +"'");
		
		if(a.getMetodo() != null)
			campos.add("metodo='"+a.getMetodo()+"'");
		
		if(a.getProjeto() != null && a.getProjeto().getCodigo() != null)
			campos.add("codigoProjeto=" + a.getProjeto().getCodigo());
		
		if(a.getViagem() != null && a.getViagem().getCodigo() != null)
			campos.add("codigoViagem=" + a.getViagem().getCodigo());
		
		if(a.getDados() != null) {
			try {
				campos.add("conteudo=x'" + bytesToHex(a.getDados().readAllBytes()) + "'");
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Erro na leitura do arquivo");
			}
		}
		
		String sql = "insert into Arquivo set ";
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		sql += ";";
		
		int id = JDBC.runInsert(sql);
		
		if(id == -1) {
			id = a.getCodigo();
		} else {
			a.setCodigo(id);
		}
	}

	@Override
	public void remover(Arquivo a) {
		System.out.println("Arquivo removido!");		
	}

	@Override
	public void alterar(Arquivo a) {
		System.out.println("Arquivo editado!");
	}

	@Override
	public ArrayList<Arquivo> listarArquivos() throws SQLException {
		return new ArrayList<Arquivo>();
	}

	@Override
	public ArrayList<Arquivo> buscar(Arquivo a, Projeto proj, Viagem v) throws SQLException {
		return new ArrayList<Arquivo>();
	}
	
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
}