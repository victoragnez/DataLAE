package service.model;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Representa as visitas de campo realizadas.
 * @author gabriel
 */
public final class Viagem {
    /**
     * Atributos básicos
     */
    private final String codigo;
    private Date data; //data da visita
    private ArrayList<PesquisadorViagem> pesquisador; // pesquisadores que foram no campo

    /**
     * Construtor básico
     * @param codigo o código do campo
     * @param data a data que foi realizado o campo
     * @param pesquisador os pesquisadores que foram ao campo
     */
    public Viagem(String codigo, Date data, ArrayList<PesquisadorViagem> pesquisador) {
        this.codigo = codigo;
        this.data = data;
        this.pesquisador = pesquisador;
    }
    
    /**
     * Construtor básico
     * @param codigo o codigo do campo
     * @param data a data que o campo foi realizado
     * @param pesquisador um pesquisador que foi ao campo
     */
    public Viagem(String codigo, Date data, PesquisadorViagem pesquisador) {
        this.codigo = codigo;
        this.data = data;
        this.pesquisador = new ArrayList<>();
        this.inserirPesquisador(pesquisador);
    }

    /**
     * Adiciona um novo pesquisador a lista de pesquisadores existentes
     * @param novoPesquisador O novo pesquisador
     */
    public void inserirPesquisador(PesquisadorViagem novoPesquisador) {
    	this.getPesquisador().add(novoPesquisador);
    }

    // Getters and Setters
    
    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the pesquisador
     */
    public ArrayList<PesquisadorViagem> getPesquisador() {
        return pesquisador;
    }

    /**
     * @param pesquisador the pesquisador to set
     */
    public void setPesquisador(ArrayList<PesquisadorViagem> pesquisador) {
        this.pesquisador = pesquisador;
    }
    
    public String getCodigo() {
    	return this.codigo;
    }
}
