package src.consultora.dao;

import src.consultora.objects.Seguimiento;

public abstract class SeguimientoDAO {
	
	public abstract void agregarSeguimiento(Seguimiento seguimiento);
	
	public abstract Seguimiento obtenerSeguimientoPorCodigo(String texto);
	
}

