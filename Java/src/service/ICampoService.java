/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 * Interface para serviço de acesso ao Campo
 * @author gabriel
 */
public interface ICampoService {
    
    public void inserirCampo (Campo campo);
    public void alterarCampo (Campo campo);
    public void removerCampo (String codigo);
    public Campo consultarCampo (String codigo);

}
