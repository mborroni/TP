import java.util.ArrayList;

public abstract class SeguimientoDAO {
	
	public abstract void agregarSeguimiento(Seguimiento seguimiento);
	
	public abstract ArrayList<Seguimiento> buscarSeguimientos(String texto);
	
	public abstract ArrayList<Seguimiento> obtenerSeguimientosPorCodigo(String codigo);
	
	public abstract ArrayList<Seguimiento> buscarSeguimientoPorOp(String apellido);

}

