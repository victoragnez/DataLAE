/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.exceptions;

/**
 *
 * @author gabriel
 */
public class CodigoInvalidoException extends Exception {
    
    public CodigoInvalidoException (String msg){
        super(msg);
    }
}
