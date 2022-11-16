package sistemaVagas.dto;

public class CurriculoDTO {

	private int id;
	private String nome;
	private String email;
	private String fone;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String cep;
	private String descricao;
	private String foto;
	private String cpf;
	private String dataNasc;
	private String escolaridade;
	private String instituicao;
	private String tempoAtuacao;
	private String tecnologias;
	private String redesSociais;
	private String competencias;
	private String cnh;
	private boolean viagem;
	private String idiomas;

	public CurriculoDTO(int id, String nome, String email, String fone, String logradouro, String numero,
			String complemento, String bairro, String localidade, String uf, String cep, String descricao, String foto,
			String cpf, String dataNasc, String escolaridade, String instituicao, String tempoAtuacao,
			String tecnologias, String redesSociais, String competencias, String cnh, boolean viagem, String idiomas) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.fone = fone;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.cep = cep;
		this.descricao = descricao;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.escolaridade = escolaridade;
		this.instituicao = instituicao;
		this.tempoAtuacao = tempoAtuacao;
		this.tecnologias = tecnologias;
		this.redesSociais = redesSociais;
		this.competencias = competencias;
		this.cnh = cnh;
		this.viagem = viagem;
		this.idiomas = idiomas;
	}

	public CurriculoDTO(String nome, String email, String fone, String logradouro, String numero, String complemento,
			String bairro, String localidade, String uf, String cep, String descricao, String foto, String cpf,
			String dataNasc, String escolaridade, String instituicao, String tempoAtuacao, String tecnologias,
			String redesSociais, String competencias, String cnh, boolean viagem, String idiomas) {
		super();
		this.nome = nome;
		this.email = email;
		this.fone = fone;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.cep = cep;
		this.descricao = descricao;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.escolaridade = escolaridade;
		this.instituicao = instituicao;
		this.tempoAtuacao = tempoAtuacao;
		this.tecnologias = tecnologias;
		this.redesSociais = redesSociais;
		this.competencias = competencias;
		this.cnh = cnh;
		this.viagem = viagem;
		this.idiomas = idiomas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getTempoAtuacao() {
		return tempoAtuacao;
	}

	public void setTempoAtuacao(String tempoAtuacao) {
		this.tempoAtuacao = tempoAtuacao;
	}

	public String getCompetencias() {
		return competencias;
	}

	public void setCompetencias(String string) {
		this.competencias = string;
	}

	public String getTecnologias() {
		return tecnologias;
	}

	public void setTecnologias(String tecnologias) {
		this.tecnologias = tecnologias;
	}

	public String getRedesSociais() {
		return redesSociais;
	}

	public void setRedesSociais(String redesSociais) {
		this.redesSociais = redesSociais;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public boolean getViagem() {
		return viagem;
	}

	public void setViagem(boolean viagem) {
		this.viagem = viagem;
	}

	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

}