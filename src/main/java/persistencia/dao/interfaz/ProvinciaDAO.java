package persistencia.dao.interfaz;

import java.util.List;

import dto.ProvinciaDTO;

public interface ProvinciaDAO {
	
	public List<ProvinciaDTO> readAll();
	
	public List<ProvinciaDTO> getLocalidadesByProv(String nombre);
	
}
