package sistemaVagas.dto;

public class VagaDTO {

	private int id;
	private int candidato;
	private int empresa;
	private String cargo;
	private String localidade;
	private String uf;
	private String dataInclusao;
	private int prazoCampo;
	private String prazoPagto;
	private float valor;
	private String experienciaDesejada;
	private String descricao;

	public VagaDTO(int id, int candidato, int empresa, String cargo, String localidade, String uf, String dataInclusao,
			int prazoCampo, String prazoPagto, float valor, String experienciaDesejada, String descricao) {
		super();
		this.id = id;
		this.candidato = candidato;
		this.empresa = empresa;
		this.cargo = cargo;
		this.localidade = localidade;
		this.uf = uf;
		this.dataInclusao = dataInclusao;
		this.prazoCampo = prazoCampo;
		this.prazoPagto = prazoPagto;
		this.valor = valor;
		this.experienciaDesejada = experienciaDesejada;
		this.descricao = descricao;
	}

	public VagaDTO(int candidato, int empresa, String cargo, String localidade, String uf, String dataInclusao,
			int prazoCampo, String prazoPagto, float valor, String experienciaDesejada, String descricao) {
		super();
		this.candidato = candidato;
		this.empresa = empresa;
		this.cargo = cargo;
		this.localidade = localidade;
		this.uf = uf;
		this.dataInclusao = dataInclusao;
		this.prazoCampo = prazoCampo;
		this.prazoPagto = prazoPagto;
		this.valor = valor;
		this.experienciaDesejada = experienciaDesejada;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(String dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public int getPrazoCampo() {
		return prazoCampo;
	}

	public void setPrazoCampo(int prazoCampo) {
		this.prazoCampo = prazoCampo;
	}

	public String getPrazoPagto() {
		return prazoPagto;
	}

	public void setPrazoPagto(String prazoPagto) {
		this.prazoPagto = prazoPagto;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getExperienciaDesejada() {
		return experienciaDesejada;
	}

	public void setExperienciaDesejada(String experienciaDesejada) {
		this.experienciaDesejada = experienciaDesejada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCandidato() {
		return candidato;
	}

	public void setCandidato(int candidato) {
		this.candidato = candidato;
	}

	public int getEmpresa() {
		return empresa;
	}

	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}

}