package sistemaVagas.dto;

public class DenunciaDTO {
	
    private int id;
	private String denunciante;
	private String denunciado;
	private String tipo;
	private String detalhe;
	
	public DenunciaDTO(int id, String denunciante, String denunciado, String tipo, String detalhe) {
		super();
		this.id = id;
		this.denunciante = denunciante;
		this.denunciado = denunciado;
		this.tipo = tipo;
		this.detalhe = detalhe;
	}
	
	public DenunciaDTO(String denunciante, String denunciado, String tipo, String detalhe) {
		super();
		this.denunciante = denunciante;
		this.denunciado = denunciado;
		this.tipo = tipo;
		this.detalhe = detalhe;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDenunciante() {
		return denunciante;
	}
	public void setDenunciante(String denunciante) {
		this.denunciante = denunciante;
	}
	public String getDenunciado() {
		return denunciado;
	}
	public void setDenunciado(String denunciado) {
		this.denunciado = denunciado;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
	
	

}
