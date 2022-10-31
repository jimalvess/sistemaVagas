package sistemaVagas.dao;

import java.sql.SQLException;
import java.util.List;

import sistemaVagas.dto.DenunciaDTO;

public interface DenunciaDAO {
	List<DenunciaDTO> getAllDenuncias() throws SQLException;
	boolean addNewDenuncia(DenunciaDTO newDenuncia) throws SQLException;
	boolean updateDenuncia(DenunciaDTO denuncia) throws SQLException;
	boolean deleteDenuncia(DenunciaDTO denuncia)throws SQLException;
	DenunciaDTO getDenunciaById(int id) throws SQLException;
}