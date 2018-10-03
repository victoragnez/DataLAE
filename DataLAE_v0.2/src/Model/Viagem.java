package Model;

import java.util.Date;
import java.util.HashMap;

public class Viagem {

	private Date dataInico;
	private Date dataTermino;
	private Integer codigo;
	private Local local;
	private Projeto projeto;
	private HashMap<Integer, Pesquisador> participantes;
	
	public Viagem(Date dataInico, Date dataTermino, Integer codigo,
			Local local, Projeto projeto,
			HashMap<Integer, Pesquisador> participantes) 
	{
		this.dataInico = dataInico;
		this.dataTermino = dataTermino;
		this.codigo = codigo;
		this.setLocal(local);
		this.setProjeto(projeto);
		this.participantes = participantes;
	}

	public Viagem(Date dataInico, Date dataTermino, Integer codigo,
			Local local, Projeto projeto) 
	{
		this.dataInico = dataInico;
		this.dataTermino = dataTermino;
		this.codigo = codigo;
		this.setLocal(local);
		this.setProjeto(projeto);
	}
	
	/**
	 * insere um novo participante a viagem
	 * @param pesquisador o participante
	 */
	public void inserirParticapante (Pesquisador pesquisador) {
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

	public Date getDataInico() {
		return dataInico;
	}

	public void setDataInico(Date dataInico) {
		this.dataInico = dataInico;
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
	
}
