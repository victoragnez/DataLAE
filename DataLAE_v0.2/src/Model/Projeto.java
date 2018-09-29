package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Projeto {

	private String nome;
	private String sigla;
	private String coordenador;
	private Financiador financiador;
	private Date dataInicio;
	private Date dataTermino;
	private String codigo;
	private HashMap<String, Local> locais;
	private HashMap<String, Pesquisador> pesquisadores;
	
	public Projeto(String nome, String sigla, String coordenador, Financiador financiador, 
			Date dataInicio, Date dataTermino, String codigo) 
	{
		this.nome = nome;
		this.sigla = sigla;
		this.coordenador = coordenador;
		this.financiador = financiador;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.codigo = codigo;
	}
	
	// TODO adicionar lançamento de exceções para os métodos que precisam
	
	/**
	 * Adiciona um novo local na lista de locais
	 * @param local  O novo Local
	 */
	public void inserirLocal ( Local local )	{
		locais.put(local.getCodigo(), local);
	}

	/**
	 * remove um local
	 * @param local  o local para ser removido
	 */
	public void removerLocal ( Local local ) {
		locais.remove(local.getCodigo());
	}
	
	/**
	 * Retorna um local da lista de locais
	 * @param codLocal  O código do local buscado
	 * @return O local correspondente
	 */
	public Local getLocal ( String codLocal ) {
		return locais.get(codLocal);
	}
	
	/**
	 * Insere uma lista de locais ao projeto
	 * @param locais  A lista com os locais
	 */
	public void InserirListaLocais (ArrayList<Local> locais) {
		for (Local l : locais)
			inserirLocal(l);
	}
	
	/**
	 * Insere um novo pesquisador ao projeto
	 * @param pesquisador  o novo pesquisador
	 */
	public void inserirPesquisador ( Pesquisador pesquisador ) {
		pesquisadores.put(pesquisador.getCpf(), pesquisador);
	}
	
	/**
	 * Remove um pesquisador da lista de pesquisadores
	 * @param pesquisador  o pesquisador a ser removido
	 */
	public void removerPesquisador (Pesquisador pesquisador) {
		pesquisadores.remove(pesquisador.getCpf());
	}
	
	/**
	 * Busca um pesquisador da lista de pesquisadores 
	 * @param cpfPesquisador  o cpf do pesquisador buscado
	 * @return o pesquisador correspondente
	 */
	public Pesquisador getPesquisador ( String cpfPesquisador ) {
		return pesquisadores.get(cpfPesquisador);
	}
	
	/**
	 * Insere uma lista de pesquisadores ao projeto
	 * @param pesquisadores  a lista de pesquisadores 
	 */
	public void inserirListaPesquisadores (ArrayList<Pesquisador> pesquisadores) {
		for (Pesquisador p : pesquisadores)
			inserirPesquisador(p);
	}
	
	// Getters and Setters
	
	public HashMap<String, Local> getLocais() {
		return locais;
	}

	public void setLocais(HashMap<String, Local> locais) {
		this.locais = locais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}

	public Financiador getFinanciador() {
		return financiador;
	}

	public void setFinanciador(Financiador financiador) {
		this.financiador = financiador;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public HashMap<String, Pesquisador> getPesquisadores() {
		return pesquisadores;
	}

	public void setPesquisadores(HashMap<String, Pesquisador> pesquisadores) {
		this.pesquisadores = pesquisadores;
	}
	
	
}
