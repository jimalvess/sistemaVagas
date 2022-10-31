package sistemaVagas.dao;

import java.sql.SQLException;
import java.util.List;

import sistemaVagas.dto.UsuarioDTO;


public interface UsuarioDAO {
	/*
	 * public UsuarioDTO findByLogin(String login); List<UsuarioDTO>
	 * findByNomeContaining(String nome); List<UsuarioDTO>
	 * findByNomeStartingWith(String nome); List<UsuarioDTO>
	 * findByUfContaining(String uf); List<UsuarioDTO> findByUfStartingWith(String
	 * uf); List<UsuarioDTO> findByLocalidadeContaining(String localidade);
	 * List<UsuarioDTO> findByLocalidadeStartingWith(String localidade);
	 */
	
	List<UsuarioDTO> getAllUsuarios() throws SQLException;
	boolean addNewUsuario(UsuarioDTO newUsuario) throws SQLException;
	boolean updateUsuario(UsuarioDTO usuario) throws SQLException;
	boolean deleteUsuario(UsuarioDTO usuario)throws SQLException;
	UsuarioDTO getUsuarioById(int id) throws SQLException;
}