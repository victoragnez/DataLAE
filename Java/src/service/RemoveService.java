package service;

import dao.IRemoveDAO;
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

public class RemoveService implements IRemoveService {
    private IRemoveDAO removeDAO;

    public RemoveService(IRemoveDAO removeDAO) {
            this.removeDAO = removeDAO;
    }
	
    // ATENÇÃO: Ajeitar regras de negócio para os métodos abaixo depois:

    @Override
    public void removeProjeto(Projeto p) 
            throws AtributoInvalidoException 
    {
        if (p == null)
            throw new AtributoInvalidoException("Projeto inválido!");
        removeDAO.removeProjeto(p);
    }

    @Override
    public void removeArea(Projeto p, Area a) 
            throws AtributoInvalidoException 
    {
        if (p == null || a == null)
            throw new AtributoInvalidoException("Projeto ou área inválidos!");
        removeDAO.removeArea(p, a);
    }

    @Override
    public void removeViagem(Projeto p, Area a, Viagem v) 
            throws AtributoInvalidoException 
    {
        if (p == null || a == null || v == null)
            throw new AtributoInvalidoException("Alguns dos argumentos são "
                    + "inválidos, por favor, reveja a operação");
        removeDAO.removeViagem(p, a, v);
    }

    @Override
    public void removePublicacao(Projeto p, Publicacao pb) 
            throws AtributoInvalidoException 
    {
        if (p == null || pb == null)
            throw new AtributoInvalidoException("Projeto ou publicação "
                    + "inválidos ");
        removeDAO.removePublicacao(p, pb);
    }

    @Override
    public void removeRelatorio(Projeto p, Boolean Final, Relatorio r) 
            throws AtributoInvalidoException 
    {
        if (p == null || r == null )
            throw new AtributoInvalidoException("Projeto ou relatório "
                    + "inválidos");
        removeDAO.removeRelatorio(p, Final, r);
    }

    @Override
    public void removeArquivosAmbiental(Viagem v, AmbientalTipo t, Arquivo arq) 
            throws AtributoInvalidoException 
    {
        if (v == null || t == null || arq == null)
            throw new AtributoInvalidoException("Alguns dos argumentos são "
                    + "inválidos, por favor, reveja a operação");
        removeDAO.removeArquivosAmbiental(v, t, arq);
    }

    @Override
    public void removeArquivosFotos(Viagem v, Arquivo arq) 
            throws AtributoInvalidoException 
    {
        if (v == null || arq == null)
            throw new AtributoInvalidoException("Viagem ou arquivo inválidos");
        removeDAO.removeArquivosFotos(v, arq);
    }

    @Override
    public void removeArquivosGeofisica(Viagem v, Geofisica.Metodo m,
            Geofisica.Tipo t, Arquivo arq) throws AtributoInvalidoException 
    {
        if (v == null || m == null || t == null || arq == null)
            throw new AtributoInvalidoException("Alguns dos argumentos são "
                    + "inválidos, por favor, reveja a operação");
        removeDAO.removeArquivosGeofisica(v, m, t, arq);
    }

    @Override
    public void removeArquivosGPS(Viagem v, Arquivo arq) 
            throws AtributoInvalidoException 
    {
        if (v == null || arq == null)
            throw new AtributoInvalidoException("Viagem ou arquivo inválidos");
        removeDAO.removeArquivosGPS(v, arq);
    }

    @Override
    public void removeArquivosLaserScanner(Viagem v, LaserScannerTipo t, 
            Arquivo arq) throws AtributoInvalidoException 
    {
        if (v == null || t == null || arq == null )
            throw new AtributoInvalidoException("Alguns dos argumentos são "
                    + "inválidos, por favor, reveja a operação");
        removeDAO.removeArquivosLaserScanner(v, t, arq);
    }

    @Override
    public void removeArquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t,
            Arquivo arq) throws AtributoInvalidoException 
    {
        if (p == null || t == null || arq == null)
            throw new AtributoInvalidoException("Alguns dos argumentos são "
                    + "inválidos, por favor, reveja a operação");
        removeDAO.removeArquivosModelagem(p, t, arq);
    }

    @Override
    public void removeArquivosModeloIntegrado(Projeto p, 
            ModelagemOuModeloIntegrado t, Arquivo arq) 
            throws AtributoInvalidoException 
    {
        if (p == null || t == null || arq == null)
            throw new AtributoInvalidoException("Alguns dos argumentos são "
                    + "inválidos, por favor, reveja a operação");
        removeDAO.removeArquivosModeloIntegrado(p, t, arq);
    }

    @Override
    public void removeArquivosSIGArea(Area a, Arquivo arq) 
            throws AtributoInvalidoException 
    {
        if (a == null || arq == null)
            throw new AtributoInvalidoException("Área ou arquivos inválidos");
        removeDAO.removeArquivosSIGArea(a, arq);
    }

    @Override
    public void removeArquivosSIGDados(Projeto p, SIGDadoTipo t, Arquivo arq) 
            throws AtributoInvalidoException 
    {
        if (p == null || t == null || arq == null)
            throw new AtributoInvalidoException("Alguns dos argumentos são "
                    + "inválidos, por favor, reveja a operação");
        removeDAO.removeArquivosSIGDados(p, t, arq);
    }

	
}
