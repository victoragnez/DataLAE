package service;

import dao.ICreateDAO;
import service.exceptions.AtributoInvalidoException;
import service.model.AmbientalTipo;
import service.model.Area;
import service.model.Arquivo;
import service.model.Geofisica;
import service.model.LaserScannerTipo;
import service.model.ModelagemOuModeloIntegrado;
import service.model.Projeto;
import service.model.Publicacao;
import service.model.Relatorio;
import service.model.SIGDadoTipo;
import service.model.Viagem;

public class CreateService implements ICreateService {
	private ICreateDAO createDAO;
	
	public CreateService(ICreateDAO createDAO) {
            this.createDAO = createDAO;
	}

	// ATENÇÃO: Ajeitar regras de negócio para os métodos abaixo depois: 

    @Override
    public void criaProjeto(Projeto p) throws AtributoInvalidoException {
        if ( p == null ) 
            throw new AtributoInvalidoException("Projeto inválido! por favor,"
                    + " especifique um projeto");
        createDAO.criaProjeto( p );
    }

    @Override
    public void criaArea(Projeto p, Area a) throws AtributoInvalidoException {
        if (p == null || a == null)
            throw new AtributoInvalidoException("Projeto ou Área inválidos!");
        createDAO.criaArea(p, a);
    }

    @Override
    public void criaViagem(Projeto p, Area a, Viagem v) 
            throws AtributoInvalidoException 
    {
        if (p == null || a == null || v == null)
            throw new AtributoInvalidoException("Um dos campos preenchidos não "
                    + "é válido, por favor, reveja a operação");
        createDAO.criaViagem(p, a, v);
    }

    @Override
    public void criaPublicacao(Projeto p, Publicacao pb) 
            throws AtributoInvalidoException 
    {
        if (p == null || pb == null)
            throw new AtributoInvalidoException("Projeto ou Publicação "
                    + "inválidos!");
        createDAO.criaPublicacao(p, pb);
    }

    @Override
    public void criaRelatorio(Projeto p, Boolean Final, Relatorio r)
            throws AtributoInvalidoException 
    {
        if (p == null || r == null )
            throw new AtributoInvalidoException("Projeto ou relatório "
                    + "inválidos!");
        createDAO.criaRelatorio(p, Final, r);
    }

    @Override
    public void criaArquivosAmbiental(Viagem v, AmbientalTipo t, Arquivo arq) 
            throws AtributoInvalidoException 
    {
        if (v == null || t == null || arq == null)
            throw new AtributoInvalidoException("Um dos campos preenchidos não "
                    + "é válido, por favor, reveja a operação");
        createDAO.criaArquivosAmbiental(v, t, arq);
    }

    @Override
    public void criaArquivosFotos(Viagem v, Arquivo arq) 
            throws AtributoInvalidoException
    {
        if (v == null || arq == null )
            throw new AtributoInvalidoException("Viagem ou arquivo inválidos!");
        createDAO.criaArquivosFotos(v, arq);
    }

    @Override
    public void criaArquivosGeofisica(Viagem v, Geofisica.Metodo m, 
            Geofisica.Tipo t, Arquivo arq) throws AtributoInvalidoException 
    {
        if (v == null || m == null || t == null || arq == null)
            throw new AtributoInvalidoException("Um dos campos preenchidos não "
                    + "é válido, por favor, reveja a operação");
    
        createDAO.criaArquivosGeofisica(v, m, t, arq);
    }

    @Override
    public void criaArquivosGPS(Viagem v, Arquivo arq) 
            throws AtributoInvalidoException 
    {
        if (v == null || arq == null)
            throw new AtributoInvalidoException("Viagem ou arquivo inválido!");
        createDAO.criaArquivosGPS(v, arq);
    }

    @Override
    public void criaArquivosLaserScanner(Viagem v, LaserScannerTipo t,
            Arquivo arq) throws AtributoInvalidoException 
    {
        if (v == null || t == null || arq == null)
            throw new AtributoInvalidoException("Um dos campos preenchidos não "
                    + "é válido, por favor, reveja a operação");
        
        createDAO.criaArquivosLaserScanner(v, t, arq);
    }

    @Override
    public void criaArquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t, 
            Arquivo arq) throws AtributoInvalidoException 
    {
        if (p == null || t == null || arq == null)
            throw new AtributoInvalidoException("Um dos campos preenchidos não "
                    + "é válido, por favor, reveja a operação");
        createDAO.criaArquivosModelagem(p, t, arq);
    }

    @Override
    public void criaArquivosModeloIntegrado(Projeto p, 
            ModelagemOuModeloIntegrado t, Arquivo arq) 
            throws AtributoInvalidoException 
    {
        if (p == null || t == null || arq == null)
            throw new AtributoInvalidoException("Um dos campos preenchidos não "
                    + "é válido, por favor, reveja a operação");
        createDAO.criaArquivosModeloIntegrado(p, t, arq);
    }

    @Override
    public void criaArquivosSIGArea(Area a, Arquivo arq) 
            throws AtributoInvalidoException 
    {
        if (a == null || arq == null)
            throw new AtributoInvalidoException("Área ou arquivo inválidos!");
        createDAO.criaArquivosSIGArea(a, arq);
    }

    @Override
    public void criaArquivosSIGDados(Projeto p, SIGDadoTipo t, Arquivo arq) 
            throws AtributoInvalidoException 
    {
        if(p == null || t == null || arq == null)
            throw new AtributoInvalidoException("Um dos campos preenchidos não "
                    + "é válido, por favor, reveja a operação");
        createDAO.criaArquivosSIGDados(p, t, arq);
    }
	
	
}
