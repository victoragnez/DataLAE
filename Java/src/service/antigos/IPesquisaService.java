package service.antigos;

import java.util.ArrayList;

import service.model.Projeto;

/**
 *
 * @author gabriel
 */
public interface IPesquisaService {
    
    public void inserirPesquisa (Projeto projeto);
    public void alterarPesquisa (Projeto projeto);
    public void removerPesquisa (String codigo);

    /**
     * Busca uma pesquisa 
     * @param codigo o codigo da pesquisa
     * @return A pesquisa que corresponde ao código
     */
    public Projeto consultarPesquisa (String codigo);
    
    public ArrayList<Projeto> consultarPesquisa(Projeto projeto);
}
