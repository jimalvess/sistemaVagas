package sistemaVagas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistemaVagas.dao.CurriculoDAO;
import sistemaVagas.dao.DenunciaDAO;
import sistemaVagas.dao.MensagemDAO;
import sistemaVagas.dao.UsuarioDAO;
import sistemaVagas.dao.VagaDAO;


@RestController
@RequestMapping("/api")
public class Usuarios {
	
    
    @Autowired
    UsuarioDAO usuarioDAO;
    
    @Autowired
    CurriculoDAO curriculoDAO;
    
    @Autowired
    DenunciaDAO denunciaDAO;
    
    @Autowired
    MensagemDAO mensagemDAO;
    
    @Autowired
    VagaDAO vagaDAO;

/*
    //////////////////// LISTA USUARIOS /////////////////////////
    
    @RequestMapping(path = "/usuarios/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<UsuarioDTO> listar() {
        return usuarioDAO.findAll();    
    }
    
//////////////////// LISTA USUARIO PELA ID /////////////////////////
    
    @RequestMapping(path = "/usuarios/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO buscarUsuario(@PathVariable int id) {
        final Optional<UsuarioDTO> findById = usuarioDAO.findById(id);
        if(findById.isPresent()) {
            return findById.get();
        } else {
            throw new NaoEncontrado("ID não encontrada!");
        }
    }
    
////////////////////// APAGA USUARIO PELA ID - SOMENTE ADMINISTRADOR /////////////////////////    
    
    @RequestMapping(path="/usuarios/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagar(@PathVariable int id) {
        if(usuarioDAO.existsById(id)) {
            usuarioDAO.deleteById(id);
        } else {
            throw new NaoEncontrado("ID não encontrada!");
        }
                        
    }
    
    ////////////////////// ATUALIZA USUARIO PELA ID /////////////////////////    
    
    @RequestMapping(path="/usuarios/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id, @RequestBody UsuarioDTO usuario) throws Exception {
        final UsuarioDTO usuarioBanco = this.buscarUsuario(id);
        
        //buscando CEP que o cara digitou:
    	URL url = new URL("https://viacep.com.br/ws/"+usuario.getCep()+"/json/"); 
    	URLConnection connection = url.openConnection();
    	InputStream is = connection.getInputStream();
    	BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
    	String cep = "";
    	StringBuilder jsonCep = new StringBuilder();
    	while((cep = br.readLine()) != null) {
    		jsonCep.append(cep);
    	}
    	
    	//Metendo num user auxiliar:
    	UsuarioDTO userAux = new Gson().fromJson(jsonCep.toString(), UsuarioDTO.class);
        
    	//Montando o objeto:
        usuarioBanco.setNome(usuario.getNome());
        usuarioBanco.setEmail(usuario.getEmail());
        usuarioBanco.setTel1(usuario.getTel1());
        usuarioBanco.setTel2(usuario.getTel2());
        usuarioBanco.setLogradouro(userAux.getLogradouro());
        usuarioBanco.setNumero(userAux.getNumero());
        usuarioBanco.setComplemento(userAux.getComplemento());
        usuarioBanco.setBairro(userAux.getBairro());
        usuarioBanco.setUf(userAux.getUf());
        usuarioBanco.setCep(usuario.getCep());
        
        //Se for candidato:
        usuarioBanco.setDescricao(usuario.getDescricao());
        usuarioBanco.setCpf(usuario.getCpf());
        usuarioBanco.setDataNasc(usuario.getDataNasc());
        usuarioBanco.setEscolaridade(usuario.getEscolaridade());
        usuarioBanco.setTempoAtuacao(usuario.getTempoAtuacao());
        usuarioBanco.setCompetencias(usuario.getCompetencias());
        usuarioBanco.setIdiomas(usuario.getIdiomas());
        usuarioBanco.setTecnologias(usuario.getTecnologias());
        usuarioBanco.setRedesSociais(usuario.getRedesSociais());
        usuarioBanco.setFornecedor(usuario.isFornecedor());
        
        //Se for empresa:
        usuarioBanco.setCnpj(usuario.getCnpj());
        usuarioBanco.setRedesSociais(usuario.getRedesSociais());
        usuarioBanco.setSite(usuario.getSite());
        usuarioBanco.setIsRepresentante(usuario.getIsRepresentante());

    	usuarioDAO.save(usuarioBanco);
    }
    
////////////////////// INSERE USUARIO /////////////////////////
    
    @RequestMapping(path = "/usuarios/", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO cadastrar(@RequestBody UsuarioDTO usuario) throws Exception {
    	
    	//buscando CEP que o cara digitou:
    	URL url = new URL("https://viacep.com.br/ws/"+usuario.getCep()+"/json/"); 
    	URLConnection connection = url.openConnection();
    	InputStream is = connection.getInputStream();
    	BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
    	String cep = "";
    	StringBuilder jsonCep = new StringBuilder();
    	while((cep = br.readLine()) != null) {
    		jsonCep.append(cep);
    	}
    	
    	//Metendo num user auxiliar:
    	UsuarioDTO userAux = new Gson().fromJson(jsonCep.toString(), UsuarioDTO.class); 
    	
        //Montando o objeto:
        usuario.setNome(usuario.getNome());
        usuario.setEmail(usuario.getEmail());
        usuario.setTel1(usuario.getTel1());
        usuario.setTel2(usuario.getTel2());
        usuario.setLogradouro(userAux.getLogradouro());
        usuario.setNumero(userAux.getNumero());
        usuario.setComplemento(userAux.getComplemento());
        usuario.setBairro(userAux.getBairro());
        usuario.setLocalidade(userAux.getLocalidade());
        usuario.setUf(userAux.getUf());
        usuario.setCep(usuario.getCep());
        
        UsuarioDTO usuarioBanco = usuarioDAO.save(usuario);
            
        return usuarioBanco;
    }
    
    ////////////////////// GERA CURRICULO - SOMENTE CANDIDATO /////////////////////////
    
    @RequestMapping(path="/usuarios/{idUsuario}/curriculos/{idCurriculo}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public CurriculoDTO geraCurriculo(@PathVariable int idUsuario, @PathVariable int idCurriculo, @RequestBody CurriculoDTO curriculo) {
        
    	final UsuarioDTO usuarioBanco = this.buscarUsuario(idUsuario);
        
        curriculo.setNome(usuarioBanco.getNome());
        curriculo.setTel1(usuarioBanco.getTel1());
        curriculo.setTel2(usuarioBanco.getTel2());
        curriculo.setLogradouro(usuarioBanco.getLogradouro());
        curriculo.setNumero(String.valueOf(usuarioBanco.getNumero()));
        curriculo.setComplemento(usuarioBanco.getComplemento());
        curriculo.setBairro(usuarioBanco.getBairro());
        curriculo.setLocalidade(usuarioBanco.getLocalidade());
        curriculo.setUf(usuarioBanco.getUf());
        curriculo.setCep(usuarioBanco.getCep());
        curriculo.setDescricao(usuarioBanco.getDescricao());
        curriculo.setCpf(usuarioBanco.getCpf());
        curriculo.setDataNasc(usuarioBanco.getDataNasc());
        curriculo.setEscolaridade(usuarioBanco.getEscolaridade());
        curriculo.setTempoAtuacao(usuarioBanco.getTempoAtuacao());
        curriculo.setCompetencias(usuarioBanco.getCompetencias());
        curriculo.setIdiomas(usuarioBanco.getIdiomas());
        curriculo.setTecnologias(usuarioBanco.getTecnologias());
        curriculo.setRedesSociais(usuarioBanco.getRedesSociais());
        
        curriculoDAO.save(curriculo);
        
        return curriculo;
    }
    
	//////////////////////ATUALIZA CURRICULO - SOMENTE CANDIDATO /////////////////////////
    
	@RequestMapping(path="/usuarios/{idUsuario}/curriculos/{idCurriculo}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarCurriculo(@PathVariable int idUsuario, @PathVariable int idCurriculo, @RequestBody CurriculoDTO curriculo) {
	final CurriculoDTO curriculoBanco = this.buscarCurriculo(idUsuario, idCurriculo);
	
	curriculoBanco.setTel1(curriculo.getTel1());
	curriculoBanco.setTel2(curriculo.getTel2());
	curriculoBanco.setLogradouro(curriculo.getLogradouro());
	curriculoBanco.setNumero(curriculo.getNumero());
	curriculoBanco.setComplemento(curriculo.getComplemento());
	curriculoBanco.setBairro(curriculo.getBairro());
	curriculoBanco.setLocalidade(curriculo.getLocalidade());
	curriculoBanco.setUf(curriculo.getUf());
	curriculoBanco.setCep(curriculo.getCep());
	curriculoBanco.setDescricao(curriculo.getDescricao());
	curriculoBanco.setEscolaridade(curriculo.getEscolaridade());
	curriculoBanco.setInstituicao(curriculo.getInstituicao());
	curriculoBanco.setTempoAtuacao(curriculo.getTempoAtuacao());
	curriculoBanco.setCompetencias(curriculo.getCompetencias());
	curriculoBanco.setIdiomas(curriculo.getIdiomas());
	curriculoBanco.setTecnologias(curriculo.getTecnologias());
	curriculoBanco.setRedesSociais(curriculo.getRedesSociais());
	curriculoBanco.setViagem(curriculo.isViagem());
	
	curriculoDAO.save(curriculoBanco);
	}
	
	//////////////////////BUSCA CURRICULO PELA ID /////////////////////////
			    
	@RequestMapping(path = "/usuarios/{idUsuario}/curriculos/{idCurriculo}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public CurriculoDTO buscarCurriculo(@PathVariable int idUsuario, @PathVariable int idCurriculo) {
		final Optional<CurriculoDTO> findById = curriculoDAO.findById(idCurriculo);
		if(findById.isPresent()) {
			return findById.get();
		} else {
			throw new NaoEncontrado("Currículo inexistente!");
		}
	}
	
	//////////////////// LISTA DENUNCIAS //////////////////////
	
	@RequestMapping(path= "/usuarios/{idUsuario}/denuncias/", method = RequestMethod.GET)
	public String recuperarDenuncia(@PathVariable int idUsuario) {
		return this.buscarUsuario(idUsuario).getDenuncias();
	}

	//////////////////// INSERE DENUNCIA ///////////////////////
	
	@RequestMapping(path = "/usuarios/{idUsuario}/denuncias/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public DenunciaDTO criarDenuncia(@PathVariable int idUsuario, @RequestBody DenunciaDTO denuncia) {
		UsuarioDTO usuarioBanco = this.buscarUsuario(idUsuario);
		denuncia.setId(0);
		DenunciaDTO denunciaBanco = denunciaDAO.save(denuncia);
		usuarioDAO.save(usuarioBanco);
		return denunciaBanco;
	}
	
	//////////////////// APAGA DENUNCIA ///////////////////////
	/*
	
	@RequestMapping(path= "/usuarios/{idUsuario}/denuncias/{idDenuncia}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void apagarDenuncia(@PathVariable int idUsuario, @PathVariable int idDenuncia) {
	
		Denuncia denunciaAchada=null;
		Usuario usuario = this.buscarUsuario(idUsuario);
		String denuncias= usuario.getDenuncias();
		for (Denuncia denunciaLista : denuncias) {
			if(idDenuncia == denunciaLista.getId())
				denunciaAchada = denunciaLista;
		}
		if(denunciaAchada != null) {
			usuario.getDenuncias().remove(denunciaAchada);
			usuarioDAO.save(usuario);
		} else 
			throw new NaoEncontrado("Denúncia não encontrada");
		}
	*/
	//////////////////// ATUALIZA DENUNCIA /////////////////////////
	/*
	@RequestMapping(path = "/usuarios/{idUsuario}/denuncias/{idDenuncia}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
		public void atualizarDenuncia(@PathVariable int idUsuario, @PathVariable int idDenuncia, @RequestBody DenunciaDTO denuncia){
		if(denunciaDAO.existsById(idDenuncia)){
			denuncia.setId(idDenuncia);
			denunciaDAO.save(denuncia);
		} else 
			throw new NaoEncontrado("Denúncia não encontrada");
		}	
	
	//////////////////// LISTA MENSAGENS //////////////////////
	
	@RequestMapping(path= "/usuarios/{idUsuario}/mensagens/", method = RequestMethod.GET)
	public String recuperarMensagem(@PathVariable int idUsuario) {
		return this.buscarUsuario(idUsuario).getMensagens();
	}
	
	//////////////////// INSERE MENSAGEM ///////////////////////
	
	@RequestMapping(path = "/usuarios/{idUsuario}/mensagens/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public MensagemDTO criarMensagem(@PathVariable int idUsuario, @RequestBody MensagemDTO mensagem) {
		UsuarioDTO usuarioBanco = this.buscarUsuario(idUsuario);
		mensagem.setId(0);
		MensagemDTO mensagemBanco = mensagemDAO.save(mensagem);
		usuarioDAO.save(usuarioBanco);
		return mensagemBanco;
	}
	
	//////////////////// APAGA MENSAGEM ///////////////////////
	/*
	
	@RequestMapping(path= "/usuarios/{idUsuario}/mensagens/{idMensagem}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void apagarMensagem(@PathVariable int idUsuario, @PathVariable int idMensagem) {
	
		Mensagem mensagemAchada=null;
		Usuario usuario = this.buscarUsuario(idUsuario);
		String mensagens = usuario.getMensagens();
		for (Mensagem mensagemLista : mensagens) {
			if(idMensagem == mensagemLista.getId())
				mensagemAchada = mensagemLista;
		}
		if(mensagemAchada != null) {
			usuario.getMensagens().remove(mensagemAchada);
			usuarioDAO.save(usuario);
		} else 
			throw new NaoEncontrado("Mensagem não encontrada");
	}
	*/
	
	//////////////////// LISTA VAGAS POR NOME DA EMPRESA - SOMENTE CANDIDATO //////////////////////
	/*
	public String recuperarVagas(@PathVariable String contem, @PathVariable String comeca) {
		UsuarioDTO empresa = (UsuarioDTO) this.pesquisaUsuarioPorNome(contem, comeca);

		if (!empresa.getVagas().isEmpty()) {
			return empresa.getVagas();
		}
		else 
            throw new RequisicaoInvalida("Empresa sem vagas no momento");
	}
	
	//////////////////// LISTA VAGAS GERAL //////////////////////
	
	@RequestMapping(value="/vagas", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<VagaDTO> listarVagas() {
        return vagaDAO.findAll();    
    }
		
	//////////////////// INSERE VAGA - SOMENTE EMPRESAS ///////////////////////
    
	@RequestMapping(path = "/usuarios/{idUsuario}/vagas/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
		public VagaDTO criarVaga(@PathVariable int idUsuario, @RequestBody VagaDTO vaga) {
		UsuarioDTO usuarioBanco = this.buscarUsuario(idUsuario);
		vaga.setId(0);
		VagaDTO vagaBanco = vagaDAO.save(vaga);
		usuarioDAO.save(usuarioBanco);
		return vagaBanco;
	}
	
	//////////////////// APAGA VAGA - SOMENTE EMPRESAS ///////////////////////
	/*
	
    @RequestMapping(path= "/usuarios/{idUsuario}/vagas/{idVaga}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void apagarVaga(@PathVariable int idUsuario, @PathVariable int idVaga) {
        
        Vaga vagaAchada=null;
        Usuario usuario= this.buscarUsuario(idUsuario);
        String vagas= usuario.getVagas();
        for (Vaga vagaLista : vagas) {
            if(idVaga == vagaLista.getId())
                vagaAchada = vagaLista;
        }
        if(vagaAchada != null) {
            usuario.getVagas().remove(vagaAchada);
            usuarioDAO.save(usuario);
        } else 
            throw new NaoEncontrado("Vaga não encontrada");
    }
    */	

	//////////////////// EDITA VAGA - SOMENTE EMPRESAS /////////////////////////
	/*
	@RequestMapping(path = "/usuarios/{idUsuario}/vagas/{idVaga}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void atualizarVaga(@PathVariable Long idUsuario, @PathVariable int idVaga, @RequestBody VagaDTO vaga){
        if(vagaDAO.existsById(idVaga)){
            vaga.setId(idVaga);
            vagaDAO.save(vaga);
        } else 
            throw new NaoEncontrado("Vaga não encontrada");
    }
	

	
//**************************************
	//PESQUISAS: 
//**************************************
	
    //////////////////// PESQUISA DE USU�?RIO POR NOME /////////////////////////
    
    @RequestMapping(path = "/usuarios/pesquisar/nome", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<UsuarioDTO> pesquisaUsuarioPorNome(
            @RequestParam(required = false) String contem,
            @RequestParam(required = false) String comeca
            ) {
        if(contem!=null)
            return usuarioDAO.findByNomeContaining(contem);
        else if(comeca!=null)
            return usuarioDAO.findByNomeStartingWith(comeca);
        else 
            throw new RequisicaoInvalida("Indique se contém ou começa");
    }
    
	////////////////////// PESQUISAR USUARIO POR ESTADO ///////////////////////
	
	@RequestMapping(path = "/usuarios/pesquisar/uf", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Iterable<UsuarioDTO> pesquisaUsuarioPorEstado(
	  @RequestParam(required = false) String contem,
	  @RequestParam(required = false) String comeca
	  ) {
		if(contem!=null)
			return usuarioDAO.findByUfContaining(contem) ;
		else if(comeca!=null)
			return usuarioDAO.findByUfStartingWith(comeca);
		else 
			throw new RequisicaoInvalida("Indicar contem ou comeca");
	}
	
	//////////////////////PESQUISAR USUARIO POR LOCALIDADE ///////////////////////
		
	@RequestMapping(path = "/usuarios/pesquisar/localidade", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Iterable<UsuarioDTO> pesquisaUsuarioPorLocalidade(
		@RequestParam(required = false) String contem,
		@RequestParam(required = false) String comeca
	) {
		if(contem!=null)
			return usuarioDAO.findByLocalidadeContaining(contem) ;
		else if(comeca!=null)
			return usuarioDAO.findByLocalidadeStartingWith(comeca);
		else 
			throw new RequisicaoInvalida("Indicar contem ou comeca");
	}
	
	////////////////////// PESQUISAR VAGA POR LOCALIDADE - SOMENTE CANDIDATO ///////////////////////
	
	@RequestMapping(path = "/vagas/pesquisar/localidade", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Iterable<VagaDTO> pesquisaVagaPorLocalidade(
	@RequestParam(required = false) String contem,
	@RequestParam(required = false) String comeca
	) {
	if(contem!=null)
		return vagaDAO.findByLocalidadeContaining(contem) ;
	else if(comeca!=null)
		return vagaDAO.findByLocalidadeStartingWith(comeca);
	else 
		throw new RequisicaoInvalida("Indicar contem ou comeca");
	}
	
	////////////////////// PESQUISAR VAGA POR ESTADO - SOMENTE CANDIDATO ///////////////////////
	
	@RequestMapping(path = "/vagas/pesquisar/uf", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Iterable<VagaDTO> pesquisaVagaPorUf(
	  @RequestParam(required = false) String contem,
	  @RequestParam(required = false) String comeca
	  ) {
		if(contem!=null)
			return vagaDAO.findByUfContaining(contem);
		else if(comeca!=null)
			return vagaDAO.findByUfStartingWith(comeca);
		else 
			throw new RequisicaoInvalida("Indicar contem ou comeca");
	}
	
	////////////////////// PESQUISAR VAGA POR CARGO - SOMENTE CANDIDATO ///////////////////////
	
	@RequestMapping(path = "/vagas/pesquisar/cargo", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Iterable<VagaDTO> pesquisaVagaPorCargo(
	  @RequestParam(required = false) String contem,
	  @RequestParam(required = false) String comeca
	  ) {
		if(contem!=null)
			return vagaDAO.findByCargoContaining(contem) ;
		else if(comeca!=null)
			return vagaDAO.findByCargoStartingWith(comeca);
		else 
			throw new RequisicaoInvalida("Indicar contem ou comeca");
	}
	
	////////////////////// PESQUISAR CURRICULO POR ESTADO - SOMENTE EMPRESAS ///////////////////////
	
	@RequestMapping(path = "/curriculos/pesquisar/estado", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<CurriculoDTO> pesquisaCurriculoPorEstado(
      @RequestParam(required = false) String contem,
      @RequestParam(required = false) String comeca
            ) {
        if(contem!=null)
            return curriculoDAO.findByUfContaining(contem) ;
        else if(comeca!=null)
            return curriculoDAO.findByUfStartingWith(comeca);
        else 
            throw new RequisicaoInvalida("Indicar contem ou comeca");
    }
	
	//////////////////////PESQUISAR CURRICULO POR LOCALIDADE ///////////////////////
	
	@RequestMapping(path = "/curriculos/pesquisar/cidade", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Iterable<CurriculoDTO> pesquisaCurriculoPorCidade(
	  @RequestParam(required = false) String contem,
	  @RequestParam(required = false) String comeca
	  ) {
		if(contem!=null)
			return curriculoDAO.findByLocalidadeContaining(contem) ;
		else if(comeca!=null)
			return curriculoDAO.findByLocalidadeStartingWith(comeca);
		else 
			throw new RequisicaoInvalida("Indicar contem ou comeca");
	}
	
	//////////////////////PESQUISAR CURRICULO POR TEMPO DE ATUAÇÃO ///////////////////////
	
	@RequestMapping(path = "/curriculos/pesquisar/tempoAtuacao", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Iterable<CurriculoDTO> pesquisaCurriculoPorTempoAtuacao(
	  @RequestParam(required = false) String contem,
	  @RequestParam(required = false) String comeca
	  ) {
		if(contem!=null)
			return curriculoDAO.findByTempoAtuacaoContaining(contem) ;
		else if(comeca!=null)
			return curriculoDAO.findByTempoAtuacaoStartingWith(comeca);
		else 
			throw new RequisicaoInvalida("Indicar contem ou comeca");
	}
	
	
	*/
}