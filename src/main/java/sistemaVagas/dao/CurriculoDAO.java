package sistemaVagas.dao;

import java.sql.SQLException;
import java.util.List;

import sistemaVagas.dto.CurriculoDTO;

public interface CurriculoDAO {
	
	List<CurriculoDTO> getAllCurriculos() throws SQLException;
	boolean addNewCurriculo(CurriculoDTO newCurriculo) throws SQLException;
	boolean updateCurriculo(CurriculoDTO curriculo) throws SQLException;
	boolean deleteCurriculo(CurriculoDTO curriculo)throws SQLException;
	CurriculoDTO getCurriculoById(int id) throws SQLException;
	
	/*
	 * List<CurriculoDTO> findByUfContaining(String uf); List<CurriculoDTO>
	 * findByUfStartingWith(String uf); List<CurriculoDTO>
	 * findByLocalidadeContaining(String localidade); List<CurriculoDTO>
	 * findByLocalidadeStartingWith(String localidade); List<CurriculoDTO>
	 * findByTempoAtuacaoContaining(String tempoAtuacao); List<CurriculoDTO>
	 * findByTempoAtuacaoStartingWith(String tempoAtuacao); List<CurriculoDTO>
	 * findByViagemContaining(Boolean viagem);
	 */
}