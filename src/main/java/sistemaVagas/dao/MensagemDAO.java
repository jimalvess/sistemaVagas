package sistemaVagas.dao;

import java.sql.SQLException;
import java.util.List;

import sistemaVagas.dto.MensagemDTO;

public interface MensagemDAO {
	
	List<MensagemDTO> getAllMensagens() throws SQLException;
	boolean addNewMensagem(MensagemDTO newMensagem) throws SQLException;
	boolean updateMensagem(MensagemDTO mensagem) throws SQLException;
	boolean deleteMensagem(MensagemDTO mensagem)throws SQLException;
	MensagemDTO getMensagemById(int id) throws SQLException;
}