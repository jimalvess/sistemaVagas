package sistemaVagas.dao;

import java.sql.SQLException;
import java.util.List;

import sistemaVagas.dto.DenunciaDTO;
import sistemaVagas.dto.MensagemDTO;
import sistemaVagas.dto.UsuarioDTO;

public interface UsuarioDAO {

	List<UsuarioDTO> getAllUsuarios() throws SQLException;

	boolean addNewUsuario(UsuarioDTO newUsuario) throws SQLException;

	boolean updateUsuario(UsuarioDTO usuario) throws SQLException;

	boolean deleteUsuario(UsuarioDTO usuario) throws SQLException;

	UsuarioDTO getUsuarioById(int id) throws SQLException;

	boolean inserirPostador(int idPostador, int idVaga) throws SQLException;

	boolean candidatarVaga(int idCandidato, int idVaga) throws SQLException;

	boolean inserirVagaNaVaga(int idVaga, int idUsuarioVagas) throws SQLException;

	boolean addNewMessage(MensagemDTO newMensagem, int idUsuario) throws SQLException;

	List<MensagemDTO> getAllMensagens(int idUsuario) throws SQLException;

	boolean deleteMensagem(MensagemDTO mensagem, int idUsuario) throws SQLException;

	MensagemDTO getMensagemById(int idUsuario) throws SQLException;

	boolean addNewDenuncia(DenunciaDTO newDenuncia, int idUsuario) throws SQLException;

	DenunciaDTO getDenunciaById(int idUsuario) throws SQLException;
}