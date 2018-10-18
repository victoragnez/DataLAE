package Model;

import java.sql.Date;
import java.util.HashMap;

public class Viagem {

	private Date dataInicio;
	private Date dataTermino;
	private Local local;
	private Projeto projeto;
	private Integer codigo;
	private HashMap<Integer, Pesquisador> participantes;

	public Viagem(Date dataInicio, Date dataTermino, Local local, Projeto projeto,
			Integer codigo, HashMap<Integer, Pesquisador> participantes) 
	{
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.local = local;
		this.projeto = projeto;
		this.codigo = codigo;
		this.participantes = participantes;
	}
	
	public Viagem(Date dataInicio, Date dataTermino, Local local, Projeto projeto,
			HashMap<Integer, Pesquisador> participantes)
	{
		this(dataInicio, dataTermino, local, projeto, (Integer)null, participantes);
	}
	
	public Viagem(Date dataInicio, Date dataTermino, Local local, 
			Projeto projeto, Integer codigo)
	{
		this(dataInicio, dataTermino, local, projeto, 
				codigo, (HashMap<Integer, Pesquisador>) null);
	}
	
	public Viagem(Date dataInicio, Date dataTermino, Local local, Projeto projeto)
	{
		this(dataInicio, dataTermino, local, projeto, 
				(Integer)null, (HashMap<Integer, Pesquisador>) null);
	}
	
	/**
	 * insere um novo participante a viagem
	 * @param pesquisador o participante
	 */
	public void inserirParticapante (Pesquisador pesquisador) {
		if(participantes == null)
			participantes = new HashMap<Integer,Pesquisador>();
		participantes.put(pesquisador.getCodigo(), pesquisador);
	}
	
	/**
	 * remove um participante da viagem
	 * @param pesquisador  o participante
	 */
	public void removeParticipante (Pesquisador pesquisador) {
		participantes.remove(pesquisador.getCodigo());
	}
	
	/**
	 * busca um pesquisador na lista de participantes da viagem
	 * @param codigoPesquisador  o codigo do pesquisado que deseja-se buscar
	 * @return  o pesquisador correspondente
	 */
	public Pesquisador getPesquisador (Integer codigoPesquisador) {
		return participantes.get(codigoPesquisador);
	}
	
	
	//Getters and Setters

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

	public Local getLocal() {
		return local;
	}
	
	public void setLocal(Local local) {
		this.local = local;
	}
	
	public Projeto getProjeto() {
		return projeto;
	}
	
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	public HashMap<Integer, Pesquisador> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(HashMap<Integer, Pesquisador> participantes) {
		this.participantes = participantes;
	}
	
	public String toString() {
		return "(" + dataInicio.toString() + " - "
				+ dataTermino.toString() + ") " + (local == null ? "" : local.getNome());
	}
	
}
