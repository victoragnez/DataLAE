package Model;

import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;

public class Projeto {

	private String nome;
	private String descricao;
	private String sigla;
	private String coordenador;
	private Date dataInicio;
	private Date dataTermino;
	private Integer codigo;
	private HashMap<Integer, Financiador> financiadores;
	private HashMap<Integer, Local> locais;
	private HashMap<Integer, Pesquisador> pesquisadores;
	
	public Projeto(String nome, String descricao, String sigla, String coordenador, 
			Date dataInicio, Date dataTermino, Integer codigo) 
	{
		this.nome = nome;
		this.descricao = descricao;
		this.sigla = sigla;
		this.coordenador = coordenador;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.codigo = codigo;
	}
	
	public Projeto(String nome, String descricao, String sigla, String coordenador, 
			Date dataInicio, Date dataTermino) 
	{
		this(nome, descricao, sigla, coordenador, dataInicio, dataTermino, (Integer)null);
	}
	
	// TODO adicionar lançamento de exceções para os métodos que precisam
	
	/**
	 * Adiciona um novo financiador na lista de financiadores
	 * @param financiador  O novo Financiador
	 */
	public void inserirFinanciador ( Financiador financiador )	{
		if(financiadores == null)
			financiadores = new HashMap<Integer, Financiador>();
		financiadores.put(financiador.getCodigo(), financiador);
	}

	/**
	 * remove um financiador
	 * @param financiador  o financiador para ser removido
	 */
	public void removerFinanciador ( Financiador financiador ) {
		financiadores.remove(financiador.getCodigo());
	}
	
	/**
	 * Retorna um financiador da lista de financiadores
	 * @param codFinanciador  O código do financiador buscado
	 * @return O financiador correspondente
	 */
	public Financiador getFinanciador ( Integer codFinanciador ) {
		return financiadores.get(codFinanciador);
	}
	
	/**
	 * Insere uma lista de financiadores ao projeto
	 * @param financiadores  A lista com os financiadores
	 */
	public void InserirListaFinanciadores (ArrayList<Financiador> financiadores) {
		for (Financiador l : financiadores)
			inserirFinanciador(l);
	}
	
	/**
	 * Adiciona um novo local na lista de locais
	 * @param local  O novo Local
	 */
	public void inserirLocal ( Local local ) {
		if(locais == null)
			locais = new HashMap<Integer, Local>();
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
	public Local getLocal ( Integer codLocal ) {
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
		if(pesquisadores == null)
			pesquisadores = new HashMap<Integer, Pesquisador>();
		pesquisadores.put(pesquisador.getCodigo(), pesquisador);
	}
	
	/**
	 * Remove um pesquisador da lista de pesquisadores
	 * @param pesquisador  o pesquisador a ser removido
	 */
	public void removerPesquisador (Pesquisador pesquisador) {
		pesquisadores.remove(pesquisador.getCodigo());
	}
	
	/**
	 * Busca um pesquisador da lista de pesquisadores 
	 * @param codigoPesquisador  o codigo do pesquisador buscado
	 * @return o pesquisador correspondente
	 */
	public Pesquisador getPesquisador ( Integer codigoPesquisador ) {
		return pesquisadores.get(codigoPesquisador);
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
	
	public HashMap<Integer, Local> getLocais() {
		return locais;
	}

	public void setLocais(HashMap<Integer, Local> locais) {
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

	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public HashMap<Integer, Pesquisador> getPesquisadores() {
		return pesquisadores;
	}

	public void setPesquisadores(HashMap<Integer, Pesquisador> pesquisadores) {
		this.pesquisadores = pesquisadores;
	}

	public HashMap<Integer, Financiador> getFinanciadores() {
		return financiadores;
	}

	public void setFinanciadores(HashMap<Integer, Financiador> financiadores) {
		this.financiadores = financiadores;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
