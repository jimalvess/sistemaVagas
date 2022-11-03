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
			Integer id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			String email = resultSet.getString("email");
			String fone = resultSet.getString("fone");
			String logradouro = resultSet.getString("logradouro");
			Integer numero = resultSet.getInt("numero");
			String complemento = resultSet.getString("complemento");
			String bairro = resultSet.getString("bairro");
			String localidade = resultSet.getString("localidade");
			String uf = resultSet.getString("uf");
			String cep = resultSet.getString("cep");
			String descricao = resultSet.getString("descricao");
			String foto = resultSet.getString("foto");
			Boolean status = resultSet.getBoolean("status");
			String login = resultSet.getString("login");
			String senha = resultSet.getString("senha");
			String permissoes = resultSet.getString("permissoes");
			String vagas = resultSet.getString("vagas");
			String redesSociais = resultSet.getString("redesSociais");
			String denuncias = resultSet.getString("denuncias");
			String mensagens = resultSet.getString("mensagens");
			String cpf = resultSet.getString("cpf");
			String dataNasc = resultSet.getString("dataNasc");
			String escolaridade = resultSet.getString("escolaridade");
			String idiomas = resultSet.getString("idiomas");
			String competencias = resultSet.getString("competencias");
			Boolean fornecedor = resultSet.getBoolean("fornecedor");
			String cnpj = resultSet.getString("cnpj");
			String site = resultSet.getString("site");
			
			UsuarioDTO usuario = new UsuarioDTO(
					id,
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
					site
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
				+ "fone, "
				+ "logradouro, "
				+ "numero, "
				+ "complemento, "
				+ "bairro, "
				+ "localidade, "
				+ "uf, "
				+ "cep, "
				+ "descricao, "
				+ "foto, "
				+ "status, "
				+ "login, "
				+ "senha, "
				+ "permissoes, "
				+ "vagas, "
				+ "redesSociais, "
				+ "denuncias, "
				+ "mensagens, "
				+ "cpf, "
				+ "dataNasc, "
				+ "escolaridade, "
				+ "idiomas, "
				+ "competencias, "
				+ "fornecedor, "
				+ "cnpj, "
				+ "site "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlInsert);
		statement.setString(1, newUsuario.getNome());
		statement.setString(2, newUsuario.getEmail());
		statement.setString(3, newUsuario.getFone());
		statement.setString(5, newUsuario.getLogradouro());
		statement.setInt(6, newUsuario.getNumero());
		statement.setString(7, newUsuario.getComplemento());
		statement.setString(8, newUsuario.getBairro());
		statement.setString(9, newUsuario.getLocalidade());
		statement.setString(10, newUsuario.getUf());
		statement.setString(11, newUsuario.getCep());
		statement.setString(13, newUsuario.getDescricao());
		statement.setString(14, newUsuario.getFoto());
		statement.setBoolean(15, newUsuario.getStatus());
		statement.setString(16, newUsuario.getLogin());
		statement.setString(17, newUsuario.getSenha());
		statement.setString(19, newUsuario.getPermissoes());
		statement.setString(21, newUsuario.getVagas());
		statement.setString(22, newUsuario.getRedesSociais());
		statement.setString(23, newUsuario.getDenuncias());
		statement.setString(24, newUsuario.getMensagens());
		statement.setString(25, newUsuario.getCpf());
		statement.setString(26, newUsuario.getDataNasc());
		statement.setString(27, newUsuario.getEscolaridade());
		statement.setString(29, newUsuario.getIdiomas());
		statement.setString(31, newUsuario.getCompetencias());
		statement.setBoolean(32, newUsuario.getFornecedor());
		statement.setString(33, newUsuario.getCnpj());
		statement.setString(34, newUsuario.getSite());
		
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
				+ "fone = ?, "
				+ "logradouro = ?, "
				+ "numero = ?, "
				+ "complemento = ?, "
				+ "bairro = ?, "
				+ "localidade = ?, "
				+ "uf = ?, "
				+ "cep = ?, "
				+ "descricao = ?, "
				+ "foto = ?, "
				+ "status = ?, "
				+ "login = ?, "
				+ "senha = ?, "
				+ "permissoes = ?, "
				+ "vagas = ?, "
				+ "redesSociais = ?, "
				+ "denuncias = ?, "
				+ "mensagens = ?, "
				+ "cpf = ?, "
				+ "dataNasc = ?, "
				+ "escolaridade = ?, "
				+ "idiomas = ?, "
				+ "competencias = ?, "
				+ "fornecedor = ?, "
				+ "cnpj = ?, "
				+ "site = ? "
				+ " WHERE id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getEmail());
		statement.setString(3, usuario.getFone());
		statement.setString(5, usuario.getLogradouro());
		statement.setInt(6, usuario.getNumero());
		statement.setString(7, usuario.getComplemento());
		statement.setString(8, usuario.getBairro());
		statement.setString(9, usuario.getLocalidade());
		statement.setString(10, usuario.getUf());
		statement.setString(11, usuario.getCep());
		statement.setString(13, usuario.getDescricao());
		statement.setString(14, usuario.getFoto());
		statement.setBoolean(15, usuario.getStatus());
		statement.setString(16, usuario.getLogin());
		statement.setString(17, usuario.getSenha());
		statement.setString(19, usuario.getPermissoes());
		statement.setString(21, usuario.getVagas());
		statement.setString(22, usuario.getRedesSociais());
		statement.setString(23, usuario.getDenuncias());
		statement.setString(24, usuario.getMensagens());
		statement.setString(25, usuario.getCpf());
		statement.setString(26, usuario.getDataNasc());
		statement.setString(27, usuario.getEscolaridade());
		statement.setString(29, usuario.getIdiomas());
		statement.setString(31, usuario.getCompetencias());
		statement.setBoolean(32, usuario.getFornecedor());
		statement.setString(33, usuario.getCnpj());
		statement.setString(34, usuario.getSite());
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
			String fone = resultSet.getString("fone");
			String logradouro = resultSet.getString("logradouro");
			Integer numero = resultSet.getInt("numero");
			String complemento = resultSet.getString("complemento");
			String bairro = resultSet.getString("bairro");
			String localidade = resultSet.getString("localidade");
			String uf = resultSet.getString("uf");
			String cep = resultSet.getString("cep");
			String descricao = resultSet.getString("descricao");
			String foto = resultSet.getString("foto");
			Boolean status = resultSet.getBoolean("status");
			String login = resultSet.getString("login");
			String senha = resultSet.getString("senha");
			String permissoes = resultSet.getString("permissoes");
			String vagas = resultSet.getString("vagas");
			String redesSociais = resultSet.getString("redesSociais");
			String denuncias = resultSet.getString("denuncias");
			String mensagens = resultSet.getString("mensagens");
			String cpf = resultSet.getString("cpf");
			String dataNasc = resultSet.getString("dataNasc");
			String escolaridade = resultSet.getString("escolaridade");
			String idiomas = resultSet.getString("idiomas");
			String competencias = resultSet.getString("competencias");
			Boolean fornecedor = resultSet.getBoolean("fornecedor");
			String cnpj = resultSet.getString("cnpj");
			String site = resultSet.getString("site");
			
			usuario = new UsuarioDTO(
					id,
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
		}
		
		resultSet.close();
		statement.close();
		
		return usuario;
	}
	
	
}
