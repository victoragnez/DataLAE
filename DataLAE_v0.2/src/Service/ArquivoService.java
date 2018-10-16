package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.ArquivoDAO;
import DAO.Interfaces.IArquivoDAO;
import Model.Arquivo;
import Service.Interfaces.IArquivoService;

public final class ArquivoService implements IArquivoService {

	private final IArquivoDAO dao = new ArquivoDAO();
	
	private ArquivoService(){}
	
	private static Wrapper<ArquivoService> wrapper;
	
	public static ArquivoService getInstance () {
		Wrapper<ArquivoService> w = wrapper;
        if (w == null) { // check 1
        	synchronized (ArquivoService.class)
        	{
        		w = wrapper;
        		if (w == null) 
        		{ // check2
        			w = new Wrapper<ArquivoService>(new ArquivoService());
        			wrapper = w;
        		}
        	}
        }
        
        return w.getInstancia();
	}

	@Override
	public void inserir(Arquivo arquivo) throws SQLException {
		if (arquivo == null)
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (arquivo.getNome() == null)
			throw new IllegalArgumentException("Campo obrigatório nulo!");
		
		dao.inserir(arquivo);
	}

	@Override
	public void remover(Arquivo arquivo) throws SQLException {
		if (arquivo == null)
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (arquivo.getCodigo() == null)
			throw new IllegalArgumentException("Impossível encontrar o arquivo informado"); 
		
		dao.remover(arquivo);
	}

	@Override
	public ArrayList<Arquivo> listarArquivos() throws SQLException {
		return dao.listarArquivos();
	}

	@Override
	public ArrayList<Arquivo> buscar() throws SQLException {
		return dao.buscar();
	}

	@Override
	public void alterar(Arquivo arquivo) throws SQLException {
		if (arquivo == null)
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (arquivo.getCodigo() == null)
			throw new IllegalArgumentException("Impossível encontrar o arquivo informado"); 
		
		dao.alterar(arquivo);
	}
	
}
