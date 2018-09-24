package service.model;

import java.util.ArrayList;

/** 
 * 
 * @author gabriel
 * Representa a classe Pesquisa com os atributos necessários.
 * Uma pesquisa contém diversos campos realizados
 */
public final class Projeto {
    
    /**
     * Atributos básicos
     */
    private final String codigo;
    private String denomicacao; // Denominação da pesquisa (título)
    private String sigla; // Sigla da pesquisa (como é mais conhecido)
    private String financiador; // financiador do projeto (pode virar uma nova classe)
    private String coordenador; // Coordenador do projeto
    private ArrayList<Pesquisador> pesquisador; // Pesquisadores envovidos com a pesquisa

    
    /**
     * Construtor básico
     * @param codigo o codigo da pesquisa
     * @param denominacao o título do projeto
     * @param sigla a sigla do projeto
     * @param financiador o financiador da pesquisa
     * @param coordenador o coordenador da pesquisa
     * @param pesquisador os pesquisadores 
     */
    public Projeto (String codigo, String denominacao, String sigla, 
            String financiador, String coordenador, 
            ArrayList<Pesquisador> pesquisador)
    {
        this.codigo = codigo;
        this.denomicacao = denominacao;
        this.sigla = sigla;
        this.financiador = financiador;
        this.coordenador = coordenador;
        this.pesquisador = pesquisador;
    }
    
    public Projeto ()
    {
        this.codigo = null;
        this.denomicacao = null;
        this.sigla = null;
        this.financiador = null;
        this.coordenador = null;
        this.pesquisador = null;
        //this.campos = null;
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
    public Projeto ( String codigo, String denominacao, String sigla,
            String financiador, String coordenador, Pesquisador pesquisador)
    {
        this.codigo = codigo;
        this.denomicacao = denominacao;
        this.sigla = sigla;
        this.financiador = financiador;
        this.coordenador = coordenador;
        this.pesquisador = new ArrayList<>();
        this.inserirPesquisador(pesquisador);
        
    }    
    
    public void inserirPesquisador ( Pesquisador pesquisador )
    { this.pesquisador.add(pesquisador); }     
    
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
    public ArrayList<Pesquisador> getPesquisador() {
        return pesquisador;
    }

    /**
     * @param pesquisador the pesquisador to set
     */
    public void setPesquisador(ArrayList<Pesquisador> pesquisador) {
        this.pesquisador = pesquisador;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }
    
    /*
    public Campo getCampo(String codigoCampo) throws CodigoInvalidoException{
        if (codigoCampo == null) 
            throw new CodigoInvalidoException("Código do campo inválido!");
        
        for (Campo c: campos) {
            if (c.getCodigo().equals(codigoCampo))
                return c;
        }
        
        throw new CodigoInvalidoException("Código do campo inválido!");
    }
    */
}