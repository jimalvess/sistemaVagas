package sistemaVagas.erro;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequisicaoInvalida extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RequisicaoInvalida(String erro) {
        super(erro);
    }
    
    
}
