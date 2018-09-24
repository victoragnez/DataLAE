package service.antigos;

import java.util.ArrayList;

import service.model.Pesquisa;

/**
 *
 * @author gabriel
 */
public interface IPesquisaService {
    
    public void inserirPesquisa (Pesquisa pesquisa);
    public void alterarPesquisa (Pesquisa pesquisa);
    public void removerPesquisa (String codigo);

    /**
     * Busca uma pesquisa 
     * @param codigo o codigo da pesquisa
     * @return A pesquisa que corresponde ao código
     */
    public Pesquisa consultarPesquisa (String codigo);
    
    public ArrayList<Pesquisa> consultarPesquisa(Pesquisa pesquisa);
}
