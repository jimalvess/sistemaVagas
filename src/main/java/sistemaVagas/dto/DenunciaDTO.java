package sistemaVagas.dto;

public class DenunciaDTO {
	
    private int id;
	private int denunciante;
	private int denunciado;
	private String tipo;
	private String detalhe;
	
	public DenunciaDTO(int id, int denunciante, int denunciado, String tipo, String detalhe) {
		super();
		this.id = id;
		this.denunciante = denunciante;
		this.denunciado = denunciado;
		this.tipo = tipo;
		this.detalhe = detalhe;
	}
	
	public DenunciaDTO(int denunciante, int denunciado, String tipo, String detalhe) {
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
	public int getDenunciante() {
		return denunciante;
	}
	public void setDenunciante(int denunciante) {
		this.denunciante = denunciante;
	}
	public int getDenunciado() {
		return denunciado;
	}
	public void setDenunciado(int denunciado) {
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
