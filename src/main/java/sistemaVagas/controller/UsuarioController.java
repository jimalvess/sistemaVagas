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
				String fone = request.getParameter("fone");
				String logradouro = request.getParameter("logradouro");
				String numero = request.getParameter("numero");
				String complemento = request.getParameter("complemento");
				String bairro = request.getParameter("bairro");
				String localidade = request.getParameter("localidade");
				String uf = request.getParameter("uf");
				String cep = request.getParameter("cep");
				String descricao = request.getParameter("descricao");
				String foto = request.getParameter("foto");
				Boolean status = Boolean.parseBoolean(request.getParameter("status"));
				String login = request.getParameter("login");
				String senha = request.getParameter("senha");
				String permissoes = request.getParameter("permissoes");
				int vagas = Integer.parseInt(request.getParameter("vagas"));
				String redesSociais = request.getParameter("redesSociais");
				int denuncias = Integer.parseInt(request.getParameter("denuncias"));
				int mensagens = Integer.parseInt(request.getParameter("mensagens"));
				String cpf = request.getParameter("cpf");
				String dataNasc = request.getParameter("dataNasc");
				String escolaridade = request.getParameter("escolaridade");
				String idiomas = request.getParameter("idiomas");
				String competencias = request.getParameter("competencias");
				Boolean fornecedor = Boolean.parseBoolean(request.getParameter("fornecedor"));
				String cnpj = request.getParameter("cnpj");
				String site = request.getParameter("site");
				
				UsuarioDTO newUsuario= new UsuarioDTO(
						nome,
						email,
						fone,
						logradouro,
						numero,
						complemento,
						bairro,
						localidade,
						uf,
						cep,
						descricao,
						foto,
						status,
						login,
						senha,
						permissoes,
						vagas,
						redesSociais,
						denuncias,
						mensagens,
						cpf,
						dataNasc,
						escolaridade,
						idiomas,
						competencias,
						fornecedor,
						cnpj,
						site);
				
				this.usuarioService.addNewUsuario(newUsuario);
				response.sendRedirect("usuario");
				break;
				
			case "delete":
				Integer id = Integer.parseInt(request.getParameter("id"));

				UsuarioDTO userToDel = new UsuarioDTO(
						id,
						nome = request.getParameter("nome"),
						email = request.getParameter("email"),
						fone = request.getParameter("fone"),
						logradouro = request.getParameter("logradouro"),
						numero = request.getParameter("numero"),
						complemento = request.getParameter("complemento"),
						bairro = request.getParameter("bairro"),
						localidade = request.getParameter("localidade"),
						uf = request.getParameter("uf"),
						cep = request.getParameter("cep"),
						descricao = request.getParameter("descricao"),
						foto = request.getParameter("foto"),
						status = Boolean.getBoolean(request.getParameter("status")),
						login = request.getParameter("login"),
						senha = request.getParameter("senha"),
						permissoes = request.getParameter("permissoes"),
						vagas = Integer.parseInt(request.getParameter("vagas")),
						redesSociais = request.getParameter("redesSociais"),
						denuncias = Integer.parseInt(request.getParameter("denuncias")),
						mensagens = Integer.parseInt(request.getParameter("mensagens")),
						cpf = request.getParameter("cpf"),
						dataNasc = request.getParameter("dataNasc"),
						escolaridade = request.getParameter("escolaridade"),
						idiomas = request.getParameter("idiomas"),
						competencias = request.getParameter("competencias"),
						fornecedor = Boolean.getBoolean(request.getParameter("fornecedor")),
						cnpj = request.getParameter("cnpj"),
						site = request.getParameter("site"));
				
				this.usuarioService.deleteUsuario(userToDel);
				response.sendRedirect("usuario");
				
				break;
				
			case "update":
				
				this.usuarioService.getUsuarioById(Integer.parseInt(request.getParameter("id")));
				
				
				dispatcher = request.getRequestDispatcher("updtUsuarioForm.jsp");
				dispatcher.forward(request, response);

				/*
				 Integer id = Integer.parseInt(request.getParameter("id"));

				UsuarioDTO userToDel = new UsuarioDTO(
						id,
						nome = request.getParameter("nome"),
						email = request.getParameter("email"),
						fone = request.getParameter("fone"),
						logradouro = request.getParameter("logradouro"),
						numero = request.getParameter("numero"),
						complemento = request.getParameter("complemento"),
						bairro = request.getParameter("bairro"),
						localidade = request.getParameter("localidade"),
						uf = request.getParameter("uf"),
						cep = request.getParameter("cep"),
						descricao = request.getParameter("descricao"),
						foto = request.getParameter("foto"),
						status = Boolean.getBoolean(request.getParameter("status")),
						login = request.getParameter("login"),
						senha = request.getParameter("senha"),
						permissoes = request.getParameter("permissoes"),
						vagas = request.getParameter("vagas"),
						redesSociais = request.getParameter("redesSociais"),
						denuncias = request.getParameter("denuncias"),
						mensagens = request.getParameter("mensagens"),
						cpf = request.getParameter("cpf"),
						dataNasc = request.getParameter("dataNasc"),
						escolaridade = request.getParameter("escolaridade"),
						idiomas = request.getParameter("idiomas"),
						competencias = request.getParameter("competencias"),
						fornecedor = Boolean.getBoolean(request.getParameter("fornecedor")),
						cnpj = request.getParameter("cnpj"),
						site = request.getParameter("site"));
				
				this.usuarioService.deleteUsuario(userToDel);
				response.sendRedirect("usuario");
				 */
				
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
	
}