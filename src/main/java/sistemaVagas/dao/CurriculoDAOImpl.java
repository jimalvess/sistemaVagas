package sistemaVagas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistemaVagas.dto.CurriculoDTO;

public class CurriculoDAOImpl implements CurriculoDAO{
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public CurriculoDAOImpl(String jdbcURL, String jdbcUsername, String jdbcPassword, Connection jdbcConnection) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
		this.jdbcConnection = jdbcConnection;
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
	public List<CurriculoDTO> getAllCurriculos() throws SQLException {
		List<CurriculoDTO> listCurriculo= new ArrayList<CurriculoDTO>();
		
		String sql = "SELECT * FROM curriculo";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			String tel1 = resultSet.getString("tel1");
			String tel2 = resultSet.getString("tel2");
			String logradouro= resultSet.getString("logradouro");
			String numero = resultSet.getString("numero");
			String complemento = resultSet.getString("complemento");
			String bairro = resultSet.getString("bairro");
			String localidade = resultSet.getString("localidade");
			String uf = resultSet.getString("uf");
			String cep = resultSet.getString("cep");
			String descricao = resultSet.getString("descricao");
			String cpf = resultSet.getString("cpf");
			String dataNasc = resultSet.getString("dataNasc");
			String escolaridade = resultSet.getString("escolaridade");
			String instituicao = resultSet.getString("instituicao");
			String tempoAtuacao = resultSet.getString("tempoAtuacao");
			String vagas = resultSet.getString("vagas");
			String tecnologias = resultSet.getString("tecnologias");
			String redesSociais = resultSet.getString("redesSociais");
			String competencias = resultSet.getString("competencias");
			String cnh = resultSet.getString("cnh");
			boolean viagem = resultSet.getBoolean("viagem");
			String idiomas = resultSet.getString("idiomas");
			
			CurriculoDTO curriculo = new CurriculoDTO(
					id,
					nome,
					tel1,
					tel2,
					logradouro,
					numero,
					complemento,
					bairro,
					localidade,
					uf,
					cep,
					descricao,
					cpf,
					dataNasc,
					escolaridade,
					instituicao,
					tempoAtuacao,
					vagas,
					tecnologias,
					redesSociais,
					competencias,
					cnh,
					viagem,
					idiomas);
			
			listCurriculo.add(curriculo);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listCurriculo;
	}
	
	@Override
	public boolean addNewCurriculo(CurriculoDTO newCurriculo) throws SQLException {
		String sqlInsert = "INSERT INTO curriculo ("
				+ "nome, "
				+ "tel1, "
				+ "tel2, "
				+ "logradouro, "
				+ "numero, "
				+ "complemento, "
				+ "bairro, "
				+ "localidade, "
				+ "uf, "
				+ "cep, "
				+ "descricao, "
				+ "cpf, "
				+ "dataNasc, "
				+ "escolaridade, "
				+ "instituicao, "
				+ "tempoAtuacao, "
				+ "vagas, "
				+ "tecnologias, "
				+ "redesSociaos, "
				+ "competencias, "
				+ "cnh, "
				+ "viagem, "
				+ "idiomas) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlInsert);
		statement.setString(1, newCurriculo.getNome());
		statement.setString(2, newCurriculo.getTel1());
		statement.setString(3, newCurriculo.getTel2());
		statement.setString(4, newCurriculo.getLogradouro());
		statement.setString(5, newCurriculo.getNumero());
		statement.setString(6, newCurriculo.getComplemento());
		statement.setString(7, newCurriculo.getBairro());
		statement.setString(8, newCurriculo.getLocalidade());
		statement.setString(9, newCurriculo.getUf());
		statement.setString(10, newCurriculo.getCep());
		statement.setString(11, newCurriculo.getDescricao());
		statement.setString(12, newCurriculo.getCpf());
		statement.setString(13, newCurriculo.getDataNasc());
		statement.setString(14, newCurriculo.getEscolaridade());
		statement.setString(15, newCurriculo.getInstituicao());
		statement.setString(16, newCurriculo.getTempoAtuacao());
		statement.setString(17, newCurriculo.getVagas());
		statement.setString(18, newCurriculo.getTecnologias());
		statement.setString(19, newCurriculo.getRedesSociais());
		statement.setString(20, newCurriculo.getCompetencias());
		statement.setString(21, newCurriculo.getCnh());
		statement.setBoolean(22, newCurriculo.getViagem());
		statement.setString(23, newCurriculo.getIdiomas());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	@Override
	public boolean updateCurriculo(CurriculoDTO curriculo) throws SQLException {
		String sql = "UPDATE curriculo SET "
				+ "nome, "
				+ "tel1, "
				+ "tel2, "
				+ "logradouro, "
				+ "numero, "
				+ "complemento, "
				+ "bairro, "
				+ "localidade, "
				+ "uf, "
				+ "cep, "
				+ "descricao, "
				+ "cpf, "
				+ "dataNasc, "
				+ "escolaridade, "
				+ "instituicao, "
				+ "tempoAtuacao, "
				+ "vagas, "
				+ "tecnologias, "
				+ "redesSociaos, "
				+ "competencias, "
				+ "cnh, "
				+ "viagem, "
				+ "idiomas"
				+ " WHERE id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, curriculo.getNome());
		statement.setString(2, curriculo.getTel1());
		statement.setString(3, curriculo.getTel2());
		statement.setString(4, curriculo.getLogradouro());
		statement.setString(5, curriculo.getNumero());
		statement.setString(6, curriculo.getComplemento());
		statement.setString(7, curriculo.getBairro());
		statement.setString(8, curriculo.getLocalidade());
		statement.setString(9, curriculo.getUf());
		statement.setString(10, curriculo.getCep());
		statement.setString(11, curriculo.getDescricao());
		statement.setString(12, curriculo.getCpf());
		statement.setString(13, curriculo.getDataNasc());
		statement.setString(14, curriculo.getEscolaridade());
		statement.setString(15, curriculo.getInstituicao());
		statement.setString(16, curriculo.getTempoAtuacao());
		statement.setString(17, curriculo.getVagas());
		statement.setString(18, curriculo.getTecnologias());
		statement.setString(19, curriculo.getRedesSociais());
		statement.setString(20, curriculo.getCompetencias());
		statement.setString(21, curriculo.getCnh());
		statement.setBoolean(22, curriculo.getViagem());
		statement.setString(23, curriculo.getIdiomas());
		statement.setInt(24, curriculo.getId());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}

	@Override
	public boolean deleteCurriculo(CurriculoDTO curriculo) throws SQLException {
		String sql = "DELETE FROM curriculo where id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, curriculo.getId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	@Override
	public CurriculoDTO getCurriculoById(int id) throws SQLException {
		CurriculoDTO curriculo = null;
		String sql = "SELECT * FROM curriculo WHERE id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String nome = resultSet.getString("nome");
			String tel1 = resultSet.getString("tel1");
			String tel2 = resultSet.getString("tel2");
			String logradouro= resultSet.getString("logradouro");
			String numero = resultSet.getString("numero");
			String complemento = resultSet.getString("complemento");
			String bairro = resultSet.getString("bairro");
			String localidade = resultSet.getString("localidade");
			String uf = resultSet.getString("uf");
			String cep = resultSet.getString("cep");
			String descricao = resultSet.getString("descricao");
			String cpf = resultSet.getString("cpf");
			String dataNasc = resultSet.getString("dataNasc");
			String escolaridade = resultSet.getString("escolaridade");
			String instituicao = resultSet.getString("instituicao");
			String tempoAtuacao = resultSet.getString("tempoAtuacao");
			String vagas = resultSet.getString("vagas");
			String tecnologias = resultSet.getString("tecnologias");
			String redesSociais = resultSet.getString("redesSociais");
			String competencias = resultSet.getString("competencias");
			String cnh = resultSet.getString("cnh");
			boolean viagem = resultSet.getBoolean("viagem");
			String idiomas = resultSet.getString("idiomas");
			
			curriculo = new CurriculoDTO(
					id, 
					nome,
					tel1,
					tel2,
					logradouro,
					numero,
					complemento,
					bairro,
					localidade,
					uf,
					cep,
					descricao,
					cpf,
					dataNasc,
					escolaridade,
					instituicao,
					tempoAtuacao,
					vagas,
					tecnologias,
					redesSociais,
					competencias,
					cnh,
					viagem,
					idiomas);
		}
		
		resultSet.close();
		statement.close();
		
		return curriculo;
	}
}
