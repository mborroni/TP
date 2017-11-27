package consultora.dao;

import java.util.ArrayList;

import consultora.objects.Seguimiento;

public abstract class SeguimientoDAO {
	
	public abstract void agregarSeguimiento(Seguimiento seguimiento);
	
	public abstract ArrayList<Seguimiento> buscarSeguimiento(String texto);
	
	public abstract ArrayList<Seguimiento> obtenerSeguimientosPorCodigo(String codigo);
	
}

