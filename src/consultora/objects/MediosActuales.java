package src.consultora.objects;

public class MediosActuales extends Seguimiento {
	private String redSocial;
	private int publicacionesApoyo;
	private int mgPublicacionApoyo;
	private int publicacionesRechazo;
	private int mgPublicacionRechazo;
	private int publicacionesNeutrales;
	private int mgPublicacionNeutral;

	private int replicas;
	
	public MediosActuales (String cod_tema, String redSocial, int publicacionesApoyo, int mgPublicacionApoyo, int publicacionesRechazo,
			int mgPublicacionRechazo, int publicacionesNeutrales, int mgPublicacionNeutral, int replicas) {
		super (cod_tema);
		this.redSocial = redSocial;
		this.publicacionesApoyo = publicacionesApoyo;
		this.mgPublicacionApoyo = mgPublicacionApoyo;
		this.publicacionesRechazo = publicacionesRechazo;
		this.mgPublicacionRechazo = mgPublicacionRechazo;
		this.publicacionesNeutrales = publicacionesNeutrales;
		this.mgPublicacionNeutral = mgPublicacionNeutral;
		this.replicas = replicas;
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
	
	public int getMgPublicacionApoyo() {
		return mgPublicacionApoyo;
	}

	public void setMgPublicacionApoyo(int mgPublicacionApoyo) {
		this.mgPublicacionApoyo = mgPublicacionApoyo;
	}

	public int getPublicacionesRechazo() {
		return publicacionesRechazo;
	}

	public void setPublicacionesRechazo(int publicacionesRechazo) {
		this.publicacionesRechazo = publicacionesRechazo;
	}

	public int getMgPublicacionRechazo() {
		return mgPublicacionRechazo;
	}

	public void setMgPublicacionRechazo(int mgPublicacionRechazo) {
		this.mgPublicacionRechazo = mgPublicacionRechazo;
	}
	
	public int getPublicacionesNeutrales() {
		return publicacionesNeutrales;
	}

	public void setPublicacionesNeutrales(int publicacionesNeutrales) {
		this.publicacionesNeutrales = publicacionesNeutrales;
	}
	
	public int getMgPublicacionNeutral() {
		return mgPublicacionNeutral;
	}

	public void setMgPublicacionNeutral(int mgPublicacionNeutral) {
		this.mgPublicacionNeutral = mgPublicacionNeutral;
	}


	/* El sistema calcula e informa si en la redes sociales el tratamiento del tema fue en apoyo o no. 
	 * 	Se considera que fue en apoyo si las publicaciones en apoyo por los “me gusta” en apoyo superan 
	 * en un 20 % las publicaciones en rechazo por los “me gusta” en rechazo.
	 */

	public boolean esApoyado(){
		
		if (((publicacionesApoyo*mgPublicacionApoyo) + ((publicacionesApoyo*mgPublicacionApoyo)*0.2)) > (publicacionesRechazo*mgPublicacionRechazo)){
			return true;
		}
		else 
			return false;
		
	}
	
	/*Para las redes sociales: si la cantidad de publicaciones son 
	 * superiores a las 5000 y las réplicas 15000.
	 */

	public boolean esTrascendente() {
		
		int totalPublicaciones = publicacionesApoyo + publicacionesNeutrales + publicacionesRechazo;
		
		if (totalPublicaciones > 5000 && replicas > 15000){
			return true;
		}
		else 
			return false;
	}
	
}
