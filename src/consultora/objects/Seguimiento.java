package consultora.objects;

public class Seguimiento {

	private int cod_seguimiento;
	private String codigo;
	private String operador;
	
	public Seguimiento(int cod_seguimiento, String cod_tema, String operador) {
		this.cod_seguimiento = cod_seguimiento;
		this.codigo = cod_tema;
		this.operador = operador;
	}

	public int getCod_seguimiento() {
		return cod_seguimiento;
	}


	public void setCod_seguimiento(int cod_seguimiento) {
		this.cod_seguimiento = cod_seguimiento;
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

	
}
