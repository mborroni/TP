package src.consultora.objects;

public abstract class Seguimiento {

	private String codigo;
	
	public Seguimiento(String cod_tema) {
		this.codigo = cod_tema;
	}


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public abstract boolean esTrascendente();
	
}
