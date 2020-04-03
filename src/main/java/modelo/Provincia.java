package modelo;

import java.util.List;

import dto.ProvinciaDTO;
import persistencia.dao.interfaz.ProvinciaDAO;

public class Provincia {
	
	private ProvinciaDAO provincia;	

	public List<ProvinciaDTO> obtenerLocalidades(){
		return this.provincia.readAll();		
	}
	
}
