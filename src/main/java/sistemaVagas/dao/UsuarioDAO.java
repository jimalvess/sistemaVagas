package sistemaVagas.dao;

import java.sql.SQLException;
import java.util.List;

import sistemaVagas.dto.UsuarioDTO;


public interface UsuarioDAO {
	
	List<UsuarioDTO> getAllUsuarios() throws SQLException;
	boolean addNewUsuario(UsuarioDTO newUsuario) throws SQLException;
	boolean updateUsuario(UsuarioDTO usuario) throws SQLException;
	boolean deleteUsuario(UsuarioDTO usuario)throws SQLException;
	UsuarioDTO getUsuarioById(int id) throws SQLException;
	boolean inserirPostador(int idPostador, int idVaga) throws SQLException;
	boolean candidatarVaga(int idCandidato, int idVaga) throws SQLException;
	boolean inserirVagaNaVaga(int idVaga, int idUsuarioVagas) throws SQLException;
}