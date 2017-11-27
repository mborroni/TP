package consultora.objects;
import java.util.Date;
import java.time.LocalDate;

public class Tema {

	private String codigo;
	private String palabraClave;
	private Date inicio;
	private Date fin;
	private String descripcion;
	private MediosTradicionales seguimientoMT;
	private MediosActuales seguimientoMA;

	public Tema(String codigo, String palabraClave, Date inicio, Date fin, String descripcion, MediosTradicionales seguimientoMT) {
		this.codigo = codigo;
		this.palabraClave = palabraClave;
		this.setInicio(inicio);
		this.setFin(fin);
		this.descripcion = descripcion;
		this.seguimientoMT = seguimientoMT;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPalabraClave() {
		return palabraClave;
	}

	public void setPalabraClave(String palabraClave) {
		this.palabraClave = palabraClave;
	}
 
	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
		/*ZoneId defaultZoneId = ZoneId.systemDefault();
		Instant instant = inicio.toInstant();
		LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();*/
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
		
		/*ZoneId defaultZoneId = ZoneId.systemDefault();
		Instant instant = fin.toInstant();
		LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();*/
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public MediosActuales getSeguimientoMA() {
		return seguimientoMA;
	}

	public void setSeguimientoMA(MediosActuales seguimientoMA) {
		this.seguimientoMA = seguimientoMA;
	}

	public MediosTradicionales getSeguimientoMT() {
		return seguimientoMT;
	}

	public void setSeguimientoMT(MediosTradicionales seguimientoMT) {
		this.seguimientoMT = seguimientoMT;
	}
	
	// TODO Local Date

}
