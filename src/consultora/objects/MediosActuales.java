package consultora.objects;

public class MediosActuales extends Seguimiento {
	private String redSocial;
	private int publicacionesApoyo;
	private int publicacionesRechazo;
	private int publicacionesNeutrales;
	private int replicas;
	private int mg;
	
	public MediosActuales (int cod_seguimiento, String cod_tema, String operador, String redSocial, int publicacionesApoyo, int publicacionesRechazo,
			int publicacionesNeutrales, int replicas, int mg) {
		super (cod_seguimiento, cod_tema, operador);
		this.redSocial = redSocial;
		this.publicacionesApoyo = publicacionesApoyo;
		this.publicacionesRechazo = publicacionesRechazo;
		this.publicacionesNeutrales = publicacionesNeutrales;
		this.replicas = replicas;
		this.mg = mg;		
	}

	public int getReplicas() {
		return replicas;
	}

	public void setReplicas(int replicas) {
		this.replicas = replicas;
	}

	public String getRedSocial() {
		return redSocial;
	}

	public void setRedSocial(String redSocial) {
		this.redSocial = redSocial;
	}

	public int getPublicacionesApoyo() {
		return publicacionesApoyo;
	}

	public void setPublicacionesApoyo(int publicacionesApoyo) {
		this.publicacionesApoyo = publicacionesApoyo;
	}

	public int getPublicacionesRechazo() {
		return publicacionesRechazo;
	}

	public void setPublicacionesRechazo(int publicacionesRechazo) {
		this.publicacionesRechazo = publicacionesRechazo;
	}

	public int getPublicacionesNeutrales() {
		return publicacionesNeutrales;
	}

	public void setPublicacionesNeutrales(int publicacionesNeutrales) {
		this.publicacionesNeutrales = publicacionesNeutrales;
	}

	public int getMg() {
		return mg;
	}

	public void setMg(int mg) {
		this.mg = mg;
	}

}
