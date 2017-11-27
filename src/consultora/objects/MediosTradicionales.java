package consultora.objects;

public class MediosTradicionales extends Seguimiento{
	
	private String operador;
	private int minsTelevision;
	private int minsHorarioCentral;
	private int cantNotasDiarios;
	private int cantTapasRevistas;
	private String apreciacion;
	
	public MediosTradicionales(String cod_tema, String operador, int minsTelevion, int minsHorarioCentral,
			int cantNotasDiarios, int cantTapasRevistas, String apreciacion) {
		super(cod_tema);
		this.operador = operador;
		this.minsTelevision = minsTelevion;
		this.minsHorarioCentral = minsHorarioCentral;
		this.cantNotasDiarios = cantNotasDiarios;
		this.cantTapasRevistas = cantTapasRevistas;
		this.apreciacion = apreciacion;
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

	public int getMinsTelevision() {
		return minsTelevision;
	}

	public void setMinsTelevision(int minsTelevion) {
		this.minsTelevision = minsTelevion;
	}

	public int getMinsHorarioCentral() {
		return minsHorarioCentral;
	}

	public void setMinsHorarioCentral(int minsHorarioCentral) {
		this.minsHorarioCentral = minsHorarioCentral;
	}

	public int getCantNotasDiarios() {
		return cantNotasDiarios;
	}

	public void setCantNotasDiarios(int cantNotasDiarios) {
		this.cantNotasDiarios = cantNotasDiarios;
	}

	public int getCantTapasRevistas() {
		return cantTapasRevistas;
	}

	public void setCantTapasRevistas(int cantTapasRevistas) {
		this.cantTapasRevistas = cantTapasRevistas;
	}

	public boolean esApoyado() {
		return false;
	}
	
	/* Para los medios tradicionales (televisión y diarios): se considera trascendente un tema si
	 *  tuvo al menos una tapa diario, si fue tratado en horario central en algún programa 
	 *  televisivo y si los minutos promedios por día superan los 60 minutos.
	 */

	public boolean esTrascendente() {
		if (cantNotasDiarios > 1 &&  minsHorarioCentral > 1 &&  minsTelevision > 60)
			return true;
		else
			return false;
	}
}
