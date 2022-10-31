package sistemaVagas.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sistemaVagas.dto.UsuarioDTO;
import sistemaVagas.service.UsuarioService;
import sistemaVagas.service.UsuarioServiceImpl;


@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("dbURL");
		String jdbcUsername = getServletContext().getInitParameter("dbUsername");
		String jdbcPassword = getServletContext().getInitParameter("dbPassword");
		
		this.usuarioService = new UsuarioServiceImpl(jdbcURL, jdbcUsername, jdbcPassword);

	}
	
    public UsuarioController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
		try {
			switch (action) {
			case "new":
				RequestDispatcher dispatcher = request.getRequestDispatcher("newUsuarioForm.jsp");
				dispatcher.forward(request, response);
				break;
			case "insert":
				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
				String tel1 = request.getParameter("tel1");
				String tel2 = request.getParameter("tel2");
				String logradouro = request.getParameter("logradouro");
				int numero = Integer.parseInt(request.getParameter("numero"));
				String complemento = request.getParameter("complemento");
				String bairro = request.getParameter("bairro");
				String localidade = request.getParameter("localidade");
				String uf = request.getParameter("uf");
				String cep = request.getParameter("cep");
				int nivel = Integer.parseInt(request.getParameter("nivel"));
				String descricao = request.getParameter("descricao");
				String foto = request.getParameter("foto");
				boolean status = Boolean.parseBoolean(request.getParameter("status"));
				String login = request.getParameter("login");
				String senha = request.getParameter("senha");
				String novaSenha = request.getParameter("novaSenha");
				String permissoes = request.getParameter("permissoes");
				String token = request.getParameter("token");
				String vagas = request.getParameter("vagas");
				String redesSociais = request.getParameter("redesSociais");
				String denuncias = request.getParameter("denuncias");
				String mensagens = request.getParameter("mensagens");
				String cpf = request.getParameter("cpf");
				String dataNasc = request.getParameter("dataNasc");
				String escolaridade = request.getParameter("escolaridade");
				String tempoAtuacao = request.getParameter("tempoAtuacao");
				String idiomas = request.getParameter("idiomas");
				String tecnologias = request.getParameter("tecnologias");
				String competencias = request.getParameter("competencias");
				boolean fornecedor = Boolean.parseBoolean(request.getParameter("fornecedor"));
				String cnpj = request.getParameter("cnpj");
				String site = request.getParameter("site");
				boolean representante = Boolean.parseBoolean(request.getParameter("representante"));
				
				UsuarioDTO newUsuario= new UsuarioDTO(
						nome,
						email,
						tel1,
						tel2,
						logradouro,
						numero,
						complemento,
						bairro,
						localidade,
						uf,
						cep,
						nivel,
						descricao,
						foto,
						status,
						login,
						senha,
						novaSenha,
						permissoes,
						token,
						vagas,
						redesSociais,
						denuncias,
						mensagens,
						cpf,
						dataNasc,
						escolaridade,
						tempoAtuacao,
						idiomas,
						tecnologias,
						competencias,
						fornecedor,
						cnpj,
						site,
						representante);
				
				this.usuarioService.addNewUsuario(newUsuario);
				response.sendRedirect("usuario");
				break;
			case "delete":
				break;
			case "edit":
				this.showEditForm(request, response);
				break;
			case "update":
				this.updateUsuario(request, response);
				break;
			default:
				this.getListUsuario(request, response);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void getListUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		List<UsuarioDTO> listUsuario = this.usuarioService.getAllUsuarios();
		request.setAttribute("listUsuario", listUsuario);
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuarioList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		UsuarioDTO existingUsuario = this.usuarioService.getUsuarioById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("newUsuarioForm.jsp");
		request.setAttribute("usuario", existingUsuario);
		dispatcher.forward(request, response);

	}
	private void updateUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String localidade = request.getParameter("localidade");
		String uf = request.getParameter("uf");
		String cep = request.getParameter("cep");
		int nivel = Integer.parseInt(request.getParameter("nivel"));
		String descricao = request.getParameter("descricao");
		String foto = request.getParameter("foto");
		boolean status = Boolean.parseBoolean(request.getParameter("status"));
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String novaSenha = request.getParameter("novaSenha");
		String permissoes = request.getParameter("permissoes");
		String token = request.getParameter("token");
		String vagas = request.getParameter("vagas");
		String redesSociais = request.getParameter("redesSociais");
		String denuncias = request.getParameter("denuncias");
		String mensagens = request.getParameter("mensagens");
		String cpf = request.getParameter("cpf");
		String dataNasc = request.getParameter("dataNasc");
		String escolaridade = request.getParameter("escolaridade");
		String tempoAtuacao = request.getParameter("tempoAtuacao");
		String idiomas = request.getParameter("idiomas");
		String tecnologias = request.getParameter("tecnologias");
		String competencias = request.getParameter("competencias");
		boolean fornecedor = Boolean.parseBoolean(request.getParameter("fornecedor"));
		String cnpj = request.getParameter("cnpj");
		String site = request.getParameter("site");
		boolean representante = Boolean.parseBoolean(request.getParameter("representante"));

		UsuarioDTO newUsuario = new UsuarioDTO(
				id,
				nome,
				email,
				tel1,
				tel2,
				logradouro,
				numero,
				complemento,
				bairro,
				localidade,
				uf,
				cep,
				nivel,
				descricao,
				foto,
				status,
				login,
				senha,
				novaSenha,
				permissoes,
				token,
				vagas,
				redesSociais,
				denuncias,
				mensagens,
				cpf,
				dataNasc,
				escolaridade,
				tempoAtuacao,
				idiomas,
				tecnologias,
				competencias,
				fornecedor,
				cnpj,
				site,
				representante);
		this.usuarioService.updateUsuario(newUsuario);
		response.sendRedirect("usuario");
	}
}