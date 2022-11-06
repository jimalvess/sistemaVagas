package sistemaVagas.dto;

public class UsuarioDTO {
	
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
    private Boolean status;
    private String login;
    private String senha;
    private String permissoes;
	private String vagas;
    private String redesSociais;
    private String denuncias;
    private String mensagens;
    
	//Atribs de Candidato:
    
    private String cpf;
	private String dataNasc;
	private String escolaridade;
	private String idiomas;
	private String competencias;
	private Boolean fornecedor;
	
	//Atribs de Empresa:
	
	private String cnpj;
	private String site;
	
	public UsuarioDTO(int id, String nome, String email, String fone, String logradouro, String numero,
			String complemento, String bairro, String localidade, String uf, String cep, String descricao,
			String foto, Boolean status, String login, String senha, String permissoes,
			String vagas, String redesSociais, String denuncias, String mensagens, String cpf, String dataNasc,
			String escolaridade, String idiomas, String competencias,
			boolean fornecedor, String cnpj, String site) {
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
		this.foto = foto;
		this.status = status;
		this.login = login;
		this.senha = senha;
		this.permissoes = permissoes;
		this.vagas = vagas;
		this.redesSociais = redesSociais;
		this.denuncias = denuncias;
		this.mensagens = mensagens;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.escolaridade = escolaridade;
		this.idiomas = idiomas;
		this.competencias = competencias;
		this.fornecedor = fornecedor;
		this.cnpj = cnpj;
		this.site = site;
	}
	
	public UsuarioDTO(String nome, String email, String fone, String logradouro, String numero,
			String complemento, String bairro, String localidade, String uf, String cep, String descricao,
			String foto, Boolean status, String login, String senha, String permissoes,
			String vagas, String redesSociais, String denuncias, String mensagens, String cpf, String dataNasc,
			String escolaridade, String idiomas, String competencias,
			boolean fornecedor, String cnpj, String site) {
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
		this.foto = foto;
		this.status = status;
		this.login = login;
		this.senha = senha;
		this.permissoes = permissoes;
		this.vagas = vagas;
		this.redesSociais = redesSociais;
		this.denuncias = denuncias;
		this.mensagens = mensagens;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.escolaridade = escolaridade;
		this.idiomas = idiomas;
		this.competencias = competencias;
		this.fornecedor = fornecedor;
		this.cnpj = cnpj;
		this.site = site;
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(String permissoes) {
		this.permissoes = permissoes;
	}

	public String getVagas() {
		return vagas;
	}
	public void setVagas(String vagas) {
		this.vagas = vagas;
	}
	public String getRedesSociais() {
		return redesSociais;
	}
	public void setRedesSociais(String redesSociais) {
		this.redesSociais = redesSociais;
	}
	public String getDenuncias() {
		return denuncias;
	}
	public void setDenuncias(String denuncias) {
		this.denuncias = denuncias;
	}
	public String getMensagens() {
		return mensagens;
	}
	public void setMensagens(String mensagens) {
		this.mensagens = mensagens;
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

	public String getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

	public String getCompetencias() {
		return competencias;
	}
	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}
	public boolean getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(boolean fornecedor) {
		this.fornecedor = fornecedor;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}

	
}