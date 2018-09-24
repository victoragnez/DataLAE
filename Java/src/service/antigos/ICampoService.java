package service.antigos;

import service.model.Viagem;

/**
 * Interface para serviço de acesso ao Campo
 * @author gabriel
 */
public interface ICampoService {
    
    public void inserirCampo (Viagem campo);
    public void alterarCampo (Viagem campo);
    public void removerCampo (String codigo);
    public Viagem consultarCampo (String codigo);

}
