package sistemaVagas.dao;

import java.sql.SQLException;
import java.util.List;

import sistemaVagas.dto.VagaDTO;


public interface VagaDAO {
	
	List<VagaDTO> getAllVagas(int usuarioId) throws SQLException;
	boolean addNewVaga(VagaDTO newVaga) throws SQLException;
	boolean updateVaga(VagaDTO vaga) throws SQLException;
	boolean deleteVaga(VagaDTO vaga)throws SQLException;
	VagaDTO getVagaById(int id) throws SQLException;
	
	
}