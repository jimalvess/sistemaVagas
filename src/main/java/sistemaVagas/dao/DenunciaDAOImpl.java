package sistemaVagas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistemaVagas.dto.DenunciaDTO;

public class DenunciaDAOImpl implements DenunciaDAO{
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public DenunciaDAOImpl(String jdbcURL, String jdbcUsername, String jdbcPassword, Connection jdbcConnection) {
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
	public List<DenunciaDTO> getAllDenuncias() throws SQLException {
		List<DenunciaDTO> listDenuncia= new ArrayList<DenunciaDTO>();
		
		String sql = "SELECT * FROM denuncia";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String denunciante = resultSet.getString("denunciante");
			String denunciado = resultSet.getString("denunciado");
			String tipo = resultSet.getString("tipo");
			String detalhe = resultSet.getString("detalhe");
			
			DenunciaDTO denuncia = new DenunciaDTO(
					id, 
					denunciante, 
					denunciado, 
					tipo, 
					detalhe);
			
			listDenuncia.add(denuncia);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listDenuncia;
	}
	
	@Override
	public boolean addNewDenuncia(DenunciaDTO newDenuncia) throws SQLException {
		String sqlInsert = "INSERT INTO denuncia ("
				+ "denunciante, "
				+ "denunciado, "
				+ "tipo, "
				+ "detalhe) "
				+ "VALUES (?, ?, ?, ?)";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlInsert);
		statement.setString(1, newDenuncia.getDenunciante());
		statement.setString(2, newDenuncia.getDenunciado());
		statement.setString(3, newDenuncia.getTipo());
		statement.setString(4, newDenuncia.getDetalhe());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	@Override
	public boolean updateDenuncia(DenunciaDTO denuncia) throws SQLException {
		String sql = "UPDATE denuncia SET "
				+ "denunciante = ?, "
				+ "denunciado = ?, "
				+ "tipo = ?, "
				+ "detalhe = ?"
				+ " WHERE id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, denuncia.getDenunciante());
		statement.setString(2, denuncia.getDenunciado());
		statement.setString(3, denuncia.getTipo());
		statement.setString(4, denuncia.getDetalhe());
		statement.setInt(5, denuncia.getId());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	@Override
	public boolean deleteDenuncia(DenunciaDTO denuncia) throws SQLException {
		String sql = "DELETE FROM denuncia where id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, denuncia.getId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	@Override
	public DenunciaDTO getDenunciaById(int id) throws SQLException {
		DenunciaDTO denuncia = null;
		String sql = "SELECT * FROM denuncia WHERE id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String denunciante = resultSet.getString("denunciante");
			String denunciado = resultSet.getString("denunciado");
			String tipo = resultSet.getString("tipo");
			String detalhe = resultSet.getString("detalhe");
			
			denuncia = new DenunciaDTO(
					id, 
					denunciante, 
					denunciado, 
					tipo, 
					detalhe);
		}
		
		resultSet.close();
		statement.close();
		
		return denuncia;
	}

}
