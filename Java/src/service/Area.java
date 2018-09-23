/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author gabriel
 * Representa as visitas de campo realizadas
 */
public final class Area {
    /**
     * Atributos básicos
     */
    // @TODO gerar criação automática de código
    private final String codigo;
    private String local;

    public Area ( String codigo, String local)
    {
        this.codigo = codigo;
        this.local = local;
    }
    
    public String getLocal() {
    	return this.local;
    }
    
    public void setLocal(String s) {
    	this.local = s;
    }
    
    public String getCodigo() {
    	return this.codigo;
    }
}
