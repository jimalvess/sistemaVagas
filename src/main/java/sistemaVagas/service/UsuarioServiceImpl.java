package sistemaVagas.service;

import java.sql.SQLException;
import java.util.List;

import sistemaVagas.dao.UsuarioDAO;
import sistemaVagas.dao.UsuarioDAOImpl;
import sistemaVagas.dto.UsuarioDTO;

public class UsuarioServiceImpl implements UsuarioService {

private UsuarioDAO usuarioDAO;
	
	
	public UsuarioServiceImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.usuarioDAO = new UsuarioDAOImpl(jdbcURL, jdbcUsername, jdbcPassword);
	}

	@Override
	public List<UsuarioDTO> getAllUsuarios() throws SQLException {
		return this.usuarioDAO.getAllUsuarios();
	}

	@Override
	public boolean addNewUsuario(UsuarioDTO newUsuario) throws SQLException {
		return this.usuarioDAO.addNewUsuario(newUsuario);
	}

	@Override
	public boolean updateUsuario(UsuarioDTO usuario) throws SQLException {
		return this.usuarioDAO.updateUsuario(usuario);
	}

	@Override
	public boolean deleteUsuario(UsuarioDTO usuario) throws SQLException {
		return this.usuarioDAO.deleteUsuario(usuario);
	}

	@Override
	public UsuarioDTO getUsuarioById(int id) throws SQLException {
		return this.usuarioDAO.getUsuarioById(id);
	}
}
