package sistemaVagas.dao;

import java.sql.SQLException;
import java.util.List;

import sistemaVagas.dto.DenunciaDTO;

public interface DenunciaDAO {
	List<DenunciaDTO> getAllDenuncias() throws SQLException;

	DenunciaDTO getDenunciaById(int id) throws SQLException;
}