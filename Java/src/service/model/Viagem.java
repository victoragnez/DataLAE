package service.model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Representa as visitas de campo realizadas.
 * @author gabriel
 */
public final class Viagem {
    /**
     * Atributos básicos
     */
    private final String codigo;
    private Calendar data; //data da visita
    private ArrayList<String> pesquisador; // pesquisadores que foram no campo
    private Double gastos;

    /**
     * Construtor básico
     * @param codigo o código do campo
     * @param data a data que foi realizado o campo
     * @param pesquisador os pesquisadores que foram ao campo
     * @param gastos o total de gastos com o campo
     */
    public Viagem(String codigo, Calendar data, ArrayList<String> pesquisador, Double gastos) {
        this.codigo = codigo;
        this.data = data;
        this.pesquisador = pesquisador;
        this.gastos = gastos;
    }
    
    /**
     * Construtor básico
     * @param codigo o codigo do campo
     * @param data a data que o campo foi realizado
     * @param pesquisador um pesquisador que foi ao campo
     * @param gastos O total de gastos com o campo
     */
    public Viagem(String codigo, Calendar data, String pesquisador, Double gastos ) {
        this.codigo = codigo;
        this.data = data;
        this.pesquisador = new ArrayList<>();
        this.inserirPesquisador(pesquisador);
        this.gastos = gastos;
    }

    /**
     * Adiciona um novo pesquisador a lista de pesquisadores existentes
     * @param novoPesquisador O novo pesquisador
     */
    public void inserirPesquisador(String novoPesquisador) {
    	this.getPesquisador().add(novoPesquisador);
    }

    /**
     * Incrementa mais um gasto nos gastos totais
     * @param gasto 
     */
    public void incrementaGastos(Double gasto) {
    	this.setGastos((Double) (this.getGastos() + gasto));
    }

    // Getters and Setters
    
    /**
     * @return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
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
     * @return the gastos
     */
    public Double getGastos() {
        return gastos;
    }

    /**
     * @param gastos the gastos to set
     */
    public void setGastos(Double gastos) {
        this.gastos = gastos;
    }
    
    public String getCodigo() {
    	return this.codigo;
    }
}