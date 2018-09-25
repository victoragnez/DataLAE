/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.exceptions;

/**
 *
 * @author gabriel
 */
public class AtributoInvalidoException extends Exception {
    private static final long serialVersionUID = 1L;

    public AtributoInvalidoException(String msg) {
    	super(msg);
    }
}
