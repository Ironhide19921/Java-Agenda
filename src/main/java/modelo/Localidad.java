package modelo;

import java.util.List;

import dto.LocalidadDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.LocalidadDAO;


public class Localidad 
{
	private LocalidadDAO localidad;	
	
	public Localidad(DAOAbstractFactory metodo_persistencia)
	{
		this.localidad = metodo_persistencia.createLocalidadDAO();
	}
	
	public void agregarLocalidad(LocalidadDTO nuevaLocalidad)
	{
		this.localidad.insert(nuevaLocalidad);
	}

	public void borrarLocalidad(LocalidadDTO localidad_a_eliminar) 
	{
		this.localidad.delete(localidad_a_eliminar);
	}
	
	public List<LocalidadDTO> obtenerLocalidades()
	{
		return this.localidad.readAll();		
	}
	
	public void editarLocalidad(LocalidadDTO localidad) {
		this.localidad.update(localidad);
	}
}
