package sistemaVagas.service;

import java.sql.SQLException;
import java.util.List;

import sistemaVagas.dto.UsuarioDTO;

public interface UsuarioService {

	List<UsuarioDTO> getAllUsuarios() throws SQLException;

	boolean addNewUsuario(UsuarioDTO newUsuario) throws SQLException;

	boolean updateUsuario(UsuarioDTO usuario) throws SQLException;

	boolean deleteUsuario(UsuarioDTO usuario) throws SQLException;

	UsuarioDTO getUsuarioById(int id) throws SQLException;

}
