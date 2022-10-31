package sistemaVagas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistemaVagas.dto.VagaDTO;

public class VagaDAOImpl implements VagaDAO {
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public VagaDAOImpl(String jdbcURL, String jdbcUsername, String jdbcPassword, Connection jdbcConnection) {
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
	public List<VagaDTO> getAllVagas() throws SQLException {
		List<VagaDTO> listVaga = new ArrayList<VagaDTO>();
		
		String sql = "SELECT * FROM vaga";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String cargo = resultSet.getString("cargo");
			String localidade = resultSet.getString("localidade");
			String uf = resultSet.getString("uf");
			String dataInclusao = resultSet.getString("dataInclusao");
			int prazoCampo = resultSet.getInt("prazoCampo");
			String prazoPagto = resultSet.getString("prazoPagto");
			float valor = resultSet.getFloat("valor");
			String experienciaDesejada = resultSet.getString("experienciaDesejada");
			String descricao = resultSet.getString("descricao");
			
			VagaDTO vaga = new VagaDTO(
					id, 
					cargo, 
					localidade, 
					uf, 
					dataInclusao, 
					prazoCampo, 
					prazoPagto, 
					valor, 
					experienciaDesejada, 
					descricao);
			
			listVaga.add(vaga);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listVaga;
	}
	
	@Override
	public boolean addNewVaga(VagaDTO newVaga) throws SQLException {
		String sqlInsert = "INSERT INTO vaga ("
				+ "cargo, "
				+ "localidade, "
				+ "uf, "
				+ "dataInclusao, "
				+ "prazoCampo, "
				+ "prazoPagto, "
				+ "valor, "
				+ "experienciaDesejada, "
				+ "descricao) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlInsert);
		statement.setString(1, newVaga.getCargo());
		statement.setString(2, newVaga.getLocalidade());
		statement.setString(3, newVaga.getUf());
		statement.setString(4, newVaga.getDataInclusao());
		statement.setInt(5, newVaga.getPrazoCampo());
		statement.setString(6, newVaga.getPrazoPagto());
		statement.setFloat(7, newVaga.getValor());
		statement.setString(8, newVaga.getExperienciaDesejada());
		statement.setString(9, newVaga.getDescricao());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	@Override
	public boolean updateVaga(VagaDTO vaga) throws SQLException {
		String sql = "UPDATE vaga SET "
				+ "cargo = ?, "
				+ "localidade = ?, "
				+ "uf = ?, "
				+ "dataInclusao = ?, "
				+ "prazoCampo = ?, "
				+ "prazoPagto = ?, "
				+ "valor = ?, "
				+ "experienciaDesejada = ?, "
				+ "descricao = ?"
				+ " WHERE id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, vaga.getCargo());
		statement.setString(2, vaga.getLocalidade());
		statement.setString(3, vaga.getUf());
		statement.setString(4, vaga.getDataInclusao());
		statement.setInt(5, vaga.getPrazoCampo());
		statement.setString(6, vaga.getPrazoPagto());
		statement.setFloat(7, vaga.getValor());
		statement.setString(8, vaga.getExperienciaDesejada());
		statement.setString(9, vaga.getDescricao());
		statement.setInt(10, vaga.getId());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	@Override
	public boolean deleteVaga(VagaDTO vaga) throws SQLException {
		String sql = "DELETE FROM vaga where id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, vaga.getId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	@Override
	public VagaDTO getVagaById(int id) throws SQLException {
		VagaDTO vaga = null;
		String sql = "SELECT * FROM vaga WHERE id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String cargo = resultSet.getString("cargo");
			String localidade = resultSet.getString("localidade");
			String uf = resultSet.getString("uf");
			String dataInclusao = resultSet.getString("dataInclusao");
			int prazoCampo = resultSet.getInt("prazoCampo");
			String prazoPagto = resultSet.getString("prazoPagto");
			float valor = resultSet.getFloat("valor");
			String experienciaDesejada = resultSet.getString("experienciaDesejada");
			String descricao = resultSet.getString("descricao");
			
			vaga = new VagaDTO(
					id, 
					cargo, 
					localidade, 
					uf, 
					dataInclusao, 
					prazoCampo, 
					prazoPagto, 
					valor, 
					experienciaDesejada, 
					descricao);
		}
		
		resultSet.close();
		statement.close();
		
		return vaga;
	}

}
