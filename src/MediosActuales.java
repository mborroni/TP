
public class MediosActuales extends Seguimiento {
	private String redSocial;
	private int publicacionesApoyo;
	private int publicacionesRechazo;
	private int publicacionesNeutrales;
	private int mg;
	
	public MediosActuales (String cod_tema, String operador, String redSocial, int publicacionesApoyo, int publicacionesRechazo,
			int publicacionesNeutrales, int mg, String apreciacion) {
		super (cod_tema, operador, apreciacion);
		this.redSocial = redSocial;
		this.publicacionesApoyo = publicacionesApoyo;
		this.publicacionesRechazo = publicacionesRechazo;
		this.publicacionesNeutrales = publicacionesNeutrales;
		this.mg = mg;		
	}

}
