/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.exceptions.CampoNaoExistenteException;
import dao.exceptions.CodigoCampoEmUsoException;
import dao.exceptions.PesquisaNaoExistenteException;
import service.exceptions.CampoInvalidoException;
import service.exceptions.PesquisaInvalidaException;
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
