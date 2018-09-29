package Model;

import java.util.HashMap;

public class Local {

	private String nome;
	private String pais;
	private String estado;
	private String cidade;
	private String codigo;
	private HashMap<String, Viagem> viagens;
	
	
	public Local(String nome, String pais, String estado, String cidade, 
			String codigo) 
	{
		this.nome = nome;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.codigo = codigo;
	}
	
	/**
	 * Insere uma nova viagem na lista de viagem
	 * @param viagem  a nova viagem
	 */
	public void inserirViagem (Viagem viagem) {
		viagens.put(viagem.getCodigo(), viagem);
	}
	
	/**
	 * Remove uma viagem da lista de viagens
	 * @param viagem  a viagem 
	 */
	public void removeViagem (Viagem viagem) {
		viagens.remove(viagem.getCodigo());
	}

	/**
	 * Busca uma viagem na lista de vaigens 
	 * @param codViagem  o código da viagem buscada
 	 * @return  a viagem correspondente
	 */
	public Viagem getViagem (String codViagem) {
		return viagens.get(codViagem);
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getCodigo() {
		return codigo;
	}


	public HashMap<String, Viagem> getViagens() {
		return viagens;
	}


	public void setViagens(HashMap<String, Viagem> viagens) {
		this.viagens = viagens;
	}
	
	
}
