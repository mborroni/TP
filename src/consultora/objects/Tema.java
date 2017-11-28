package consultora.objects;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class Tema {

	private String codigo;
	private String palabraClave;
	private LocalDate inicio;
	private LocalDate fin;
	private String descripcion;
	private MediosTradicionales seguimientoMT;
	private MediosActuales seguimientoMA;

	public Tema(String codigo, String palabraClave, Date inicio, Date fin, String descripcion, MediosTradicionales seguimientoMT, MediosActuales seguimientoMA) {
		this.codigo = codigo;
		this.palabraClave = palabraClave;
		this.inicio = toLocalDate(inicio);
		this.fin = toLocalDate(fin);
		this.descripcion = descripcion;
		this.seguimientoMT = seguimientoMT;
		this.seguimientoMA = seguimientoMA;
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
 
	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
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
	
	public LocalDate toLocalDate(Date date){
		LocalDate localDate = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate;
	}
	
}
