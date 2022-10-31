package sistemaVagas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistemaVagas.dto.UsuarioDTO;

public class UsuarioDAOImpl implements UsuarioDAO{
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public UsuarioDAOImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
	
	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(
										jdbcURL, jdbcUsername, jdbcPassword);
		}
	}
	
	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	@Override
	public List<UsuarioDTO> getAllUsuarios() throws SQLException {
		List<UsuarioDTO> listUsuario = new ArrayList<UsuarioDTO>();
		
		String sql = "SELECT * FROM usuario";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			String email = resultSet.getString("email");
			String tel1 = resultSet.getString("tel1");
			String tel2 = resultSet.getString("tel2");
			String logradouro = resultSet.getString("logradouro");
			int numero = resultSet.getInt("numero");
			String complemento = resultSet.getString("complemento");
			String bairro = resultSet.getString("bairro");
			String localidade = resultSet.getString("localidade");
			String uf = resultSet.getString("uf");
			String cep = resultSet.getString("cep");
			int nivel = resultSet.getInt("nivel");
			String descricao = resultSet.getString("descricao");
			String foto = resultSet.getString("foto");
			boolean status = resultSet.getBoolean("status");
			String login = resultSet.getString("login");
			String senha = resultSet.getString("senha");
			String novaSenha = resultSet.getString("novaSenha");
			String permissoes = resultSet.getString("permissoes");
			String token = resultSet.getString("token");
			String vagas = resultSet.getString("vagas");
			String redesSociais = resultSet.getString("redesSociais");
			String denuncias = resultSet.getString("denuncias");
			String mensagens = resultSet.getString("mensagens");
			String cpf = resultSet.getString("cpf");
			String dataNasc = resultSet.getString("dataNasc");
			String escolaridade = resultSet.getString("escolaridade");
			String tempoAtuacao = resultSet.getString("tempoAtuacao");
			String idiomas = resultSet.getString("idiomas");
			String tecnologias = resultSet.getString("tecnologias");
			String competencias = resultSet.getString("competencias");
			boolean fornecedor = resultSet.getBoolean("fornecedor");
			String cnpj = resultSet.getString("cnpj");
			String site = resultSet.getString("site");
			boolean representante = resultSet.getBoolean("representante");
			
			UsuarioDTO usuario = new UsuarioDTO(
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
					representante
					);
			
			listUsuario.add(usuario);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listUsuario;
	}

	@Override
	public boolean addNewUsuario(UsuarioDTO newUsuario) throws SQLException {
		String sqlInsert = "INSERT INTO usuario ("
				+ "nome, "
				+ "email, "
				+ "tel1, "
				+ "tel2, "
				+ "logradouro, "
				+ "numero, "
				+ "complemento, "
				+ "bairro, "
				+ "localidade, "
				+ "uf, "
				+ "cep, "
				+ "nivel, "
				+ "descricao, "
				+ "foto, "
				+ "status, "
				+ "login, "
				+ "senha, "
				+ "novaSenha, "
				+ "permissoes, "
				+ "token, "
				+ "vagas, "
				+ "redesSociais, "
				+ "denuncias, "
				+ "mensagens, "
				+ "cpf, "
				+ "dataNasc, "
				+ "escolaridade, "
				+ "tempoAtuacao, "
				+ "idiomas, "
				+ "tecnologias, "
				+ "competencias, "
				+ "fornecedor, "
				+ "cnpj, "
				+ "site, "
				+ "representante"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, )";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlInsert);
		statement.setString(1, newUsuario.getNome());
		statement.setString(2, newUsuario.getEmail());
		statement.setString(3, newUsuario.getTel1());
		statement.setString(4, newUsuario.getTel2());
		statement.setString(5, newUsuario.getLogradouro());
		statement.setInt(6, newUsuario.getNumero());
		statement.setString(7, newUsuario.getComplemento());
		statement.setString(8, newUsuario.getBairro());
		statement.setString(9, newUsuario.getLocalidade());
		statement.setString(10, newUsuario.getUf());
		statement.setString(11, newUsuario.getCep());
		statement.setInt(12, newUsuario.getNivel());
		statement.setString(13, newUsuario.getDescricao());
		statement.setString(14, newUsuario.getFoto());
		statement.setBoolean(15, newUsuario.getStatus());
		statement.setString(16, newUsuario.getLogin());
		statement.setString(17, newUsuario.getSenha());
		statement.setString(18, newUsuario.getNovaSenha());
		statement.setString(19, newUsuario.getPermissoes());
		statement.setString(20, newUsuario.getToken());
		statement.setString(21, newUsuario.getVagas());
		statement.setString(22, newUsuario.getRedesSociais());
		statement.setString(23, newUsuario.getDenuncias());
		statement.setString(24, newUsuario.getMensagens());
		statement.setString(25, newUsuario.getCpf());
		statement.setString(26, newUsuario.getDataNasc());
		statement.setString(27, newUsuario.getEscolaridade());
		statement.setString(28, newUsuario.getTempoAtuacao());
		statement.setString(29, newUsuario.getIdiomas());
		statement.setString(30, newUsuario.getTecnologias());
		statement.setString(31, newUsuario.getCompetencias());
		statement.setBoolean(32, newUsuario.getFornecedor());
		statement.setString(33, newUsuario.getCnpj());
		statement.setString(34, newUsuario.getSite());
		statement.setBoolean(35, newUsuario.getRepresentante());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}

	@Override
	public boolean updateUsuario(UsuarioDTO usuario) throws SQLException {
		String sql = "UPDATE usuario SET "
				+ "nome = ?, "
				+ "email = ?, "
				+ "tel1 = ?, "
				+ "tel2 = ?, "
				+ "logradouro = ?, "
				+ "numero = ?, "
				+ "complemento = ?, "
				+ "bairro = ?, "
				+ "localidade = ?, "
				+ "uf = ?, "
				+ "cep = ?, "
				+ "nivel = ?, "
				+ "descricao = ?, "
				+ "foto = ?, "
				+ "status = ?, "
				+ "login = ?, "
				+ "senha = ?, "
				+ "novaSenha = ?, "
				+ "permissoes = ?, "
				+ "token = ?, "
				+ "vagas = ?, "
				+ "redesSociais = ?, "
				+ "denuncias = ?, "
				+ "mensagens = ?, "
				+ "cpf = ?, "
				+ "dataNasc = ?, "
				+ "escolaridade = ?, "
				+ "tempoAtuacao = ?, "
				+ "idiomas = ?, "
				+ "tecnologias = ?, "
				+ "competencias = ?, "
				+ "fornecedor = ?, "
				+ "cnpj = ?, "
				+ "site = ?, "
				+ "representante = ?"
				+ " WHERE id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getEmail());
		statement.setString(3, usuario.getTel1());
		statement.setString(4, usuario.getTel2());
		statement.setString(5, usuario.getLogradouro());
		statement.setInt(6, usuario.getNumero());
		statement.setString(7, usuario.getComplemento());
		statement.setString(8, usuario.getBairro());
		statement.setString(9, usuario.getLocalidade());
		statement.setString(10, usuario.getUf());
		statement.setString(11, usuario.getCep());
		statement.setInt(12, usuario.getNivel());
		statement.setString(13, usuario.getDescricao());
		statement.setString(14, usuario.getFoto());
		statement.setBoolean(15, usuario.getStatus());
		statement.setString(16, usuario.getLogin());
		statement.setString(17, usuario.getSenha());
		statement.setString(18, usuario.getNovaSenha());
		statement.setString(19, usuario.getPermissoes());
		statement.setString(20, usuario.getToken());
		statement.setString(21, usuario.getVagas());
		statement.setString(22, usuario.getRedesSociais());
		statement.setString(23, usuario.getDenuncias());
		statement.setString(24, usuario.getMensagens());
		statement.setString(25, usuario.getCpf());
		statement.setString(26, usuario.getDataNasc());
		statement.setString(27, usuario.getEscolaridade());
		statement.setString(28, usuario.getTempoAtuacao());
		statement.setString(29, usuario.getIdiomas());
		statement.setString(30, usuario.getTecnologias());
		statement.setString(31, usuario.getCompetencias());
		statement.setBoolean(32, usuario.getFornecedor());
		statement.setString(33, usuario.getCnpj());
		statement.setString(34, usuario.getSite());
		statement.setBoolean(35, usuario.getRepresentante());
		statement.setInt(36, usuario.getId());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}

	@Override
	public boolean deleteUsuario(UsuarioDTO usuario) throws SQLException {
		String sql = "DELETE FROM usuario where id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, usuario.getId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}

	@Override
	public UsuarioDTO getUsuarioById(int id) throws SQLException {
		UsuarioDTO usuario = null;
		String sql = "SELECT * FROM usuario WHERE id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String nome = resultSet.getString("nome");
			String email = resultSet.getString("email");
			String tel1 = resultSet.getString("tel1");
			String tel2 = resultSet.getString("tel2");
			String logradouro = resultSet.getString("logradouro");
			int numero = resultSet.getInt("numero");
			String complemento = resultSet.getString("complemento");
			String bairro = resultSet.getString("bairro");
			String localidade = resultSet.getString("localidade");
			String uf = resultSet.getString("uf");
			String cep = resultSet.getString("cep");
			int nivel = resultSet.getInt("nivel");
			String descricao = resultSet.getString("descricao");
			String foto = resultSet.getString("foto");
			boolean status = resultSet.getBoolean("status");
			String login = resultSet.getString("login");
			String senha = resultSet.getString("senha");
			String novaSenha = resultSet.getString("novaSenha");
			String permissoes = resultSet.getString("permissoes");
			String token = resultSet.getString("token");
			String vagas = resultSet.getString("vagas");
			String redesSociais = resultSet.getString("redesSociais");
			String denuncias = resultSet.getString("denuncias");
			String mensagens = resultSet.getString("mensagens");
			String cpf = resultSet.getString("cpf");
			String dataNasc = resultSet.getString("dataNasc");
			String escolaridade = resultSet.getString("escolaridade");
			String tempoAtuacao = resultSet.getString("tempoAtuacao");
			String idiomas = resultSet.getString("idiomas");
			String tecnologias = resultSet.getString("tecnologias");
			String competencias = resultSet.getString("competencias");
			boolean fornecedor = resultSet.getBoolean("fornecedor");
			String cnpj = resultSet.getString("cnpj");
			String site = resultSet.getString("site");
			boolean representante = resultSet.getBoolean("representante");
			
			usuario = new UsuarioDTO(
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
		}
		
		resultSet.close();
		statement.close();
		
		return usuario;
	}
	
	
}
