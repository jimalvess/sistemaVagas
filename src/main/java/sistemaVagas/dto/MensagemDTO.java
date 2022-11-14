package sistemaVagas.dto;

public class MensagemDTO {
	
    private int id;
	private String assunto;
	private String detalhe;
	private int emissor;
	private int destinatario;
	
	public MensagemDTO(int id, String assunto, String detalhe, int emissor, int destinatario) {
		super();
		this.id = id;
		this.assunto = assunto;
		this.detalhe = detalhe;
		this.emissor = emissor;
		this.destinatario = destinatario;
	}
	
	public MensagemDTO(String assunto, String detalhe, int emissor, int destinatario) {
		super();
		this.assunto = assunto;
		this.detalhe = detalhe;
		this.emissor = emissor;
		this.destinatario = destinatario;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
	public int getEmissor() {
		return emissor;
	}
	public void setEmissor(int emissor) {
		this.emissor = emissor;
	}
	public int getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(int destinatario) {
		this.destinatario = destinatario;
	}

	
}
