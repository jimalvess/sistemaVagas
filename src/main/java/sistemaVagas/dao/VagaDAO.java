package sistemaVagas.dao;

import java.sql.SQLException;
import java.util.List;

import sistemaVagas.dto.VagaDTO;


public interface VagaDAO {
	
	List<VagaDTO> getAllVagasEmpresa(int usuarioId) throws SQLException;
	List<VagaDTO> getAllVagasCandidato(int usuarioId) throws SQLException;
	boolean postarVaga(VagaDTO newVaga) throws SQLException;
	boolean editarVaga(VagaDTO vaga) throws SQLException;
	boolean apagaVaga(VagaDTO vaga)throws SQLException;
	VagaDTO getVagaById(int id) throws SQLException;
	
}