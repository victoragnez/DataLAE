package Model;

import java.util.Date;
import java.util.HashMap;

public class Viagem {

	private Date dataInico;
	private Date dataTermino;
	private String codigo;
	private HashMap<String, Pesquisador> participantes;
	
	public Viagem(Date dataInico, Date dataTermino, String codigo, 
			HashMap<String, Pesquisador> participantes) 
	{
		this.dataInico = dataInico;
		this.dataTermino = dataTermino;
		this.codigo = codigo;
		this.participantes = participantes;
	}

	public Viagem(Date dataInico, Date dataTermino, String codigo) 
	{
		this.dataInico = dataInico;
		this.dataTermino = dataTermino;
		this.codigo = codigo;
	}
	
	/**
	 * insere um novo participante a viagem
	 * @param pesquisador o participante
	 */
	public void inserirParticapante (Pesquisador pesquisador) {
		participantes.put(pesquisador.getCpf(), pesquisador);
	}
	
	/**
	 * remove um participante da viagem
	 * @param pesquisador  o participante
	 */
	public void removeParticipante (Pesquisador pesquisador) {
		participantes.remove(pesquisador.getCpf());
	}
	
	/**
	 * busca um pesquisador na lista de participantes da viagem
	 * @param cpfPesquisador  o cpf do pesquisado que deseja-se buscar
	 * @return  o pesquisador correspondente
	 */
	public Pesquisador getPesquisador (String cpfPesquisador) {
		return participantes.get(cpfPesquisador);
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

	public String getCodigo() {
		return codigo;
	}

	public HashMap<String, Pesquisador> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(HashMap<String, Pesquisador> participantes) {
		this.participantes = participantes;
	}
	
	
	
	
	
}
