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

public class DenunciaDAOImpl implements DenunciaDAO {

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
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

// LER TODAS AS DENUNCIAS

	@Override
	public List<DenunciaDTO> getAllDenuncias() throws SQLException {
		List<DenunciaDTO> listDenuncia = new ArrayList<DenunciaDTO>();

		String sql = "SELECT * FROM denuncia";

		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			int denunciante = resultSet.getInt("denunciante");
			int denunciado = resultSet.getInt("denunciado");
			String tipo = resultSet.getString("tipo");
			String detalhe = resultSet.getString("detalhe");

			DenunciaDTO denuncia = new DenunciaDTO(id, denunciante, denunciado, tipo, detalhe);

			listDenuncia.add(denuncia);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return listDenuncia;
	}

// LER UMA DENUNCIA PELA ID

	@Override
	public DenunciaDTO getDenunciaById(int id) throws SQLException {
		DenunciaDTO denuncia = null;
		String sql = "SELECT * FROM denuncia WHERE id = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			int denunciante = resultSet.getInt("denunciante");
			int denunciado = resultSet.getInt("denunciado");
			String tipo = resultSet.getString("tipo");
			String detalhe = resultSet.getString("detalhe");

			denuncia = new DenunciaDTO(id, denunciante, denunciado, tipo, detalhe);
		}

		resultSet.close();
		statement.close();

		return denuncia;
	}

}
