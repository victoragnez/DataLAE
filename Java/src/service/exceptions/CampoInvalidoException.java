/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.exceptions;

/**
 * Exceção para Campo Inválido
 * @author gabriel
 */
public class CampoInvalidoException extends Exception {
    
    private static final long serialVersionUID = 1L;

    public CampoInvalidoException(String msg) {
	super(msg);
    }
    
}
