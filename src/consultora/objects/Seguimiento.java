package consultora.objects;

public abstract class Seguimiento {

	private String codigo;
	private String operador;
	
	public Seguimiento(String cod_tema, String operador) {
		this.codigo = cod_tema;
		this.operador = operador;
	}


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public abstract boolean esApoyado();
	
	public abstract boolean esTrascendente();
	
}
