/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.CodigoPesquisaEmUsoException;
import dao.exceptions.PesquisaNaoExistenteException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import service.Pesquisa;

/**
 *
 * @author gabriel
 */
public abstract class PesquisaDAOMemoria implements IPesquisaDAO {
    
    private Map<String, Pesquisa> listaPesquisa = new HashMap<String, Pesquisa>(); 

    @Override
    public void inserirPesquisa(Pesquisa pesquisa) {
        if (!listaPesquisa.containsKey(pesquisa.getCodigo())){ 
            listaPesquisa.put(pesquisa.getCodigo(), pesquisa);
        } else {
            try {
                throw new CodigoPesquisaEmUsoException("Código de Pesquisa em uso");
            } catch (CodigoPesquisaEmUsoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void alterarPesquisa(Pesquisa pesquisa) {
        if (listaPesquisa.containsKey(pesquisa.getCodigo())){ 
            listaPesquisa.put(pesquisa.getCodigo(), pesquisa);
        } else {
            try {
                throw new PesquisaNaoExistenteException("Pesquisa não encontrada");
            } catch (PesquisaNaoExistenteException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
	}
    }

    @Override
    public void removerPesquisa(String codigo) {
        if (listaPesquisa.containsKey(codigo )){
            listaPesquisa.remove(codigo);
        }else {
            try {
                throw new PesquisaNaoExistenteException("Pesquisa não encontrada");
            } catch (PesquisaNaoExistenteException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    @Override
    public Pesquisa consultarAluno(String codigo) throws PesquisaNaoExistenteException {
        Pesquisa resultado = null;
        
        if (listaPesquisa.containsKey(codigo)){
            resultado = listaPesquisa.get(codigo);
        } else {
            try {
                throw new PesquisaNaoExistenteException("Pesquisa não encontrada");
            } catch (PesquisaNaoExistenteException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }    
        return resultado;
    }
}
