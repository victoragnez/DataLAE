package framework.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import framework.model.Arquivo;
import framework.model.DatabaseException;

class ArquivoNoSistema<A extends Arquivo<?, ?> > implements EstrategiaArquivo<A> {

	@Override
	public int inserir(A a) throws DatabaseException{
		String path = String.format("%s/src/main/java/", System.getProperty("user.dir")) + 
				a.getNome() + UUID.randomUUID().toString() //+ 
/*				(a.getTipo() != null ? "." + a.getTipo() : "")*/;
		
		OutputStream os = null;
		
		try {
			os = new FileOutputStream(new File(path));
			os.write(a.getDados());
		} catch(IOException e) {
			e.printStackTrace();
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		} finally {
			try {
				os.close();
			} catch (Exception e) { }
		}
		
		String sql = "insert into DadosArquivo set path = '" + path + "';";
		try {
			return JDBC.runInsert(sql);
		} catch(SQLException e) {
			new File(path).delete();
			e.printStackTrace();
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
	}

	@Override
	public byte[] ler(A a) throws DatabaseException {
		String sql = "select path from DadosArquivo inner join Arquivo" + 
				" on DadosArquivo.codigoDados = Arquivo.codigoDados where "
				+ "Arquivo.codigoArquivo=" + a.getCodigo() + ";";
		try {
			ResultSet resultSet = JDBC.runQuery(sql);
			resultSet.next();
			return Files.readAllBytes(new File(resultSet.getString("path")).toPath());
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
	}

}
