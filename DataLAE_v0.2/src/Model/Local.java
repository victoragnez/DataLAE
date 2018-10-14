package Model;

public class Local {

	private String nome;
	private String pais;
	private String estado;
	private String cidade;
	private Double latitude;
	private Double longitude;
	private Integer codigo;

	public Local(String nome, String pais, String estado, String cidade, 
			Double latitude, Double longitude, Integer codigo) 
	{
		this.nome = nome;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.latitude = latitude;
		this.longitude = longitude;
		this.codigo = codigo;
	}
	
	public Local(String nome, String pais, String estado, String cidade, 
			Double latitude, Double longitude)
	{
		this(nome, pais, estado, cidade, latitude, longitude, (Integer)null);
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

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return this.nome +
				(this.cidade != null && this.cidade != "" ? ", " + this.cidade : "") +
				(this.estado != null && this.estado != "" ? ", " + this.estado : "") +
				(this.pais != null && this.pais != "" ? ", " + this.pais : "");
	}
	
}
