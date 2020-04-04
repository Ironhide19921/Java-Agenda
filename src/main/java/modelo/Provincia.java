package modelo;

import java.util.List;

import dto.ProvinciaDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.ProvinciaDAO;

public class Provincia {
	
	private ProvinciaDAO provincia;
	
	public Provincia(DAOAbstractFactory metodo_persistencia){
		this.provincia = metodo_persistencia.createProvinciaDAO();
	}

	public List<ProvinciaDTO> obtenerLocalidades(){
		return this.provincia.readAll();		
	}
	
	public List<ProvinciaDTO> obtenerLocalidades(String nombre){
		return this.provincia.getLocalidadesByProv(nombre);		
	}
	
	public List<String> obtenerLocs(String nombre){
		return this.provincia.getLocsByProv(nombre);		
	}
	
}
