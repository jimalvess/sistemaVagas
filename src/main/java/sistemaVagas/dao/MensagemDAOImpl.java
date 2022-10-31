package sistemaVagas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistemaVagas.dto.MensagemDTO;

public class MensagemDAOImpl implements MensagemDAO{
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public MensagemDAOImpl(String jdbcURL, String jdbcUsername, String jdbcPassword, Connection jdbcConnection) {
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
	public List<MensagemDTO> getAllMensagens() throws SQLException {
		List<MensagemDTO> listMensagem= new ArrayList<MensagemDTO>();
		
		String sql = "SELECT * FROM mensagem";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String assunto = resultSet.getString("assunto");
			String detalhe = resultSet.getString("detalhe");
			String emissor = resultSet.getString("emissor");
			String destinatario = resultSet.getString("destinatario");
			
			MensagemDTO mensagem = new MensagemDTO(
					id, 
					assunto, 
					detalhe, 
					emissor, 
					destinatario);
			
			listMensagem.add(mensagem);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listMensagem;
	}
	
	@Override
	public boolean addNewMensagem(MensagemDTO newMensagem) throws SQLException {
		String sqlInsert = "INSERT INTO mensagem ("
				+ "assunto, "
				+ "detalhe, "
				+ "emissor, "
				+ "destinatario) "
				+ "VALUES (?, ?, ?, ?)";
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlInsert);
		statement.setString(1, newMensagem.getAssunto());
		statement.setString(2, newMensagem.getDetalhe());
		statement.setString(3, newMensagem.getEmissor());
		statement.setString(4, newMensagem.getDestinatario());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	@Override
	public boolean updateMensagem(MensagemDTO mensagem) throws SQLException {
		String sql = "UPDATE mensagem SET "
				+ "assunto = ?, "
				+ "detalhe = ?, "
				+ "emissor = ?, "
				+ "destinatario = ?"
				+ " WHERE id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, mensagem.getAssunto());
		statement.setString(2, mensagem.getDetalhe());
		statement.setString(3, mensagem.getEmissor());
		statement.setString(4, mensagem.getDestinatario());
		statement.setInt(5, mensagem.getId());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	@Override
	public boolean deleteMensagem(MensagemDTO mensagem) throws SQLException {
		String sql = "DELETE FROM mensagem where id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, mensagem.getId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	@Override
	public MensagemDTO getMensagemById(int id) throws SQLException {
		MensagemDTO mensagem = null;
		String sql = "SELECT * FROM mensagem WHERE id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String assunto = resultSet.getString("assunto");
			String detalhe = resultSet.getString("detalhe");
			String emissor = resultSet.getString("emissor");
			String destinatario = resultSet.getString("destinatario");
			
			mensagem = new MensagemDTO(
					id, 
					assunto, 
					detalhe, 
					emissor, 
					destinatario);
		}
		
		resultSet.close();
		statement.close();
		
		return mensagem;
	}

}
