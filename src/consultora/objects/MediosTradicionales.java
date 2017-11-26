package consultora.objects;

public class MediosTradicionales extends Seguimiento{
	
	private int minsTelevision;
	private int minsHorarioCentral;
	private int cantNotasDiarios;
	private int cantTapasRevistas;
	private String apreciacion;
	
	public MediosTradicionales(int cod_seguimiento, String cod_tema, String operador, int minsTelevion, int minsHorarioCentral,
			int cantNotasDiarios, int cantTapasRevistas, String apreciacion) {
		super(cod_seguimiento, cod_tema, operador);
		this.minsTelevision = minsTelevion;
		this.minsHorarioCentral = minsHorarioCentral;
		this.cantNotasDiarios = cantNotasDiarios;
		this.cantTapasRevistas = cantTapasRevistas;
		this.apreciacion = apreciacion;
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
}
