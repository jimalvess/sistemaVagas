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
			String numero = resultSet.getString("numero");
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
			int vagas = resultSet.getInt("vagas");
			String redesSociais = resultSet.getString("redesSociais");
			int denuncias = resultSet.getInt("denuncias");
			int mensagens = resultSet.getInt("mensagens");
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
				+ "site) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlInsert);
		statement.setString(1, newUsuario.getNome());
		statement.setString(2, newUsuario.getEmail());
		statement.setString(3, newUsuario.getFone());
		statement.setString(4, newUsuario.getLogradouro());
		statement.setString(5, newUsuario.getNumero());
		statement.setString(6, newUsuario.getComplemento());
		statement.setString(7, newUsuario.getBairro());
		statement.setString(8, newUsuario.getLocalidade());
		statement.setString(9, newUsuario.getUf());
		statement.setString(10, newUsuario.getCep());
		statement.setString(11, newUsuario.getDescricao());
		statement.setString(12, newUsuario.getFoto());
		statement.setBoolean(13, newUsuario.getStatus());
		statement.setString(14, newUsuario.getLogin());
		statement.setString(15, newUsuario.getSenha());
		statement.setString(16, newUsuario.getPermissoes());
		statement.setInt(17, newUsuario.getVagas());
		statement.setString(18, newUsuario.getRedesSociais());
		statement.setInt(19, newUsuario.getDenuncias());
		statement.setInt(20, newUsuario.getMensagens());
		statement.setString(21, newUsuario.getCpf());
		statement.setString(22, newUsuario.getDataNasc());
		statement.setString(23, newUsuario.getEscolaridade());
		statement.setString(24, newUsuario.getIdiomas());
		statement.setString(25, newUsuario.getCompetencias());
		statement.setBoolean(26, newUsuario.getFornecedor());
		statement.setString(27, newUsuario.getCnpj());
		statement.setString(28, newUsuario.getSite());
		
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
		statement.setString(4, usuario.getLogradouro());
		statement.setString(5, usuario.getNumero());
		statement.setString(6, usuario.getComplemento());
		statement.setString(7, usuario.getBairro());
		statement.setString(8, usuario.getLocalidade());
		statement.setString(9, usuario.getUf());
		statement.setString(10, usuario.getCep());
		statement.setString(11, usuario.getDescricao());
		statement.setString(12, usuario.getFoto());
		statement.setBoolean(13, usuario.getStatus());
		statement.setString(14, usuario.getLogin());
		statement.setString(15, usuario.getSenha());
		statement.setString(16, usuario.getPermissoes());
		statement.setInt(17, usuario.getVagas());
		statement.setString(18, usuario.getRedesSociais());
		statement.setInt(19, usuario.getDenuncias());
		statement.setInt(20, usuario.getMensagens());
		statement.setString(21, usuario.getCpf());
		statement.setString(22, usuario.getDataNasc());
		statement.setString(23, usuario.getEscolaridade());
		statement.setString(24, usuario.getIdiomas());
		statement.setString(25, usuario.getCompetencias());
		statement.setBoolean(26, usuario.getFornecedor());
		statement.setString(27, usuario.getCnpj());
		statement.setString(28, usuario.getSite());
		statement.setInt(29, usuario.getId());
		
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
			String numero = resultSet.getString("numero");
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
			int vagas = resultSet.getInt("vagas");
			String redesSociais = resultSet.getString("redesSociais");
			int denuncias = resultSet.getInt("denuncias");
			int mensagens = resultSet.getInt("mensagens");
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
