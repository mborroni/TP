
public class Seguimiento {

	private int cod_seguimiento;
	private String codigo;
	private String operador;
	private String apreciacion;
	
	public Seguimiento(String cod_tema, String operador, String apreciacion) {
		this.codigo = cod_tema;
		this.operador = operador;
		this.apreciacion = apreciacion;
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


	public String getApreciacion() {
		return apreciacion;
	}

	public void setApreciacion(String apreciacion) {
		this.apreciacion = apreciacion;
	}

}
