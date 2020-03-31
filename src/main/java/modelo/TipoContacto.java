package modelo;

import java.util.List;
import dto.TipoContactoDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.TipoContactoDAO;


public class TipoContacto 
{
	private TipoContactoDAO tipoContacto;	
	
	public TipoContacto(DAOAbstractFactory metodo_persistencia)
	{
		this.tipoContacto = metodo_persistencia.createTipoContactoDAO();
	}
	
	public void agregarTipoContacto(TipoContactoDTO nuevaTipoContacto)
	{
		this.tipoContacto.insert(nuevaTipoContacto);
	}

	public void borrarTipoContacto(TipoContactoDTO tipoContacto_a_eliminar) 
	{
		this.tipoContacto.delete(tipoContacto_a_eliminar);
	}
	
	public List<TipoContactoDTO> obtenerTiposContacto()
	{
		return this.tipoContacto.readAll();		
	}
	
	public void editarTipoContacto(TipoContactoDTO tipoContacto) {
		this.tipoContacto.update(tipoContacto);
	}
	
}
