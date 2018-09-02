/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;

/** 
 * 
 * @author gabriel
 * Representa a classe Pesquisa com os atributos necessários.
 * Uma pesquisa contém diversos campos realizados
 */
public final class Pesquisa {
    
    /**
     * Atributos básicos
     */
    // @TODO gerar criação automática de código
    private final String codigo;
    private String denomicacao; // Denominação da pesquisa (título)
    private String sigla; // Sigla da pesquisa (como é mais conhecido)
    private String financiador; // financiador do projeto (pode virar uma nova classe)
    private String coordenador; // Coordenador do projeto
    private ArrayList<String> pesquisador; // Pesquisadores envovidos com a pesquisa
    
    private ArrayList<Campo> campos; // Campos realizados na pesquisa

    /**
     * Construtor básico
     * @param codigo o codigo da pesquisa
     * @param denominacao o título do projeto
     * @param sigla a sigla do projeto
     * @param financiador o financiador da pesquisa
     * @param coordenador o coordenador da pesquisa
     * @param pesquisador os pesquisadores 
     * @param campos os campos já realizados
     */
    public Pesquisa (String codigo, String denominacao, String sigla, 
            String financiador, String coordenador, 
            ArrayList<String> pesquisador,ArrayList<Campo> campos)
    {
        this.codigo = codigo;
        this.denomicacao = denominacao;
        this.sigla = sigla;
        this.financiador = financiador;
        this.coordenador = coordenador;
        this.pesquisador = pesquisador;
        this.campos = campos;
    }
    
    /**
     * Construtor sem o campo e com inserção de um único pesquisador
     * @param codigo o codigo da pesquisa
     * @param denominacao o título do projeto
     * @param sigla a sigla do projeto
     * @param financiador o financiador da pesquisa
     * @param coordenador o coordenador da pesquisa
     * @param pesquisador o pesquisador 
     */
    public Pesquisa ( String codigo, String denominacao, String sigla,
            String financiador, String coordenador, String pesquisador)
    {
        this.codigo = codigo;
        this.denomicacao = denominacao;
        this.sigla = sigla;
        this.financiador = financiador;
        this.coordenador = coordenador;
        this.pesquisador = new ArrayList<>();
        this.inserirPesquisador(pesquisador);
        
    }    
    
    public void inserirPesquisador ( String pesquisador )
    { this.pesquisador.add(pesquisador); }
    
    public void inserirCampo ( Campo campo )
    { this.campos.add(campo);}        
    
    // Getters and Setters
    
    /**
     * @return the denomicacao
     */
    public String getDenomicacao() {
        return denomicacao;
    }

    /**
     * @param denomicacao the denomicacao to set
     */
    public void setDenomicacao(String denomicacao) {
        this.denomicacao = denomicacao;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the financiador
     */
    public String getFinanciador() {
        return financiador;
    }

    /**
     * @param financiador the financiador to set
     */
    public void setFinanciador(String financiador) {
        this.financiador = financiador;
    }

    /**
     * @return the coordenador
     */
    public String getCoordenador() {
        return coordenador;
    }

    /**
     * @param coordenador the coordenador to set
     */
    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    /**
     * @return the pesquisador
     */
    public ArrayList<String> getPesquisador() {
        return pesquisador;
    }

    /**
     * @param pesquisador the pesquisador to set
     */
    public void setPesquisador(ArrayList<String> pesquisador) {
        this.pesquisador = pesquisador;
    }

    /**
     * @return the campos
     */
    public ArrayList<Campo> getCampos() {
        return campos;
    }

    /**
     * @param campos the campos to set
     */
    public void setCampos(ArrayList<Campo> campos) {
        this.campos = campos;
    }
    
    
}
