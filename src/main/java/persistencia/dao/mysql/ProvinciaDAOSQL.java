package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ProvinciaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.ProvinciaDAO;

public class ProvinciaDAOSQL implements ProvinciaDAO{
	
	private static final String readall = "SELECT DISTINCT (p.NombreProvincia) FROM provincias p";	
	private static final String getLocalidadesPorProv = "SELECT NombreProvincia, NombreLocalidad FROM provincias WHERE NombreProvincia = ?";

	public List<ProvinciaDTO> readAll(){
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<ProvinciaDTO> provincias = new ArrayList<ProvinciaDTO>();
		Conexion conexion = Conexion.getConexion();
		try{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				provincias.add(getProvinciaDTO(resultSet));
			}
		} 
		catch (SQLException e){
			e.printStackTrace();
		}
		return provincias;
	}
	
	private ProvinciaDTO getProvinciaDTO(ResultSet resultSet) throws SQLException{
		String prov = resultSet.getString("NombreProvincia");
		return new ProvinciaDTO(prov);
	}
	
	@Override
    public List<ProvinciaDTO> getLocalidadesByProv(String nombreProvincia) {
   		 PreparedStatement statement;
   		 ResultSet resultSet; //Guarda el resultado de la query
   		 ArrayList<ProvinciaDTO> listaLocalidades = new ArrayList<ProvinciaDTO>();
   		 Conexion conexion = Conexion.getConexion();
   		 try{
   			 statement = conexion.getSQLConexion().prepareStatement(getLocalidadesPorProv);
   			 statement.setString(1, nombreProvincia);
   			 resultSet = statement.executeQuery();
   			 while(resultSet.next()){
   				 listaLocalidades.add(getLocalidadPorProvDTO(resultSet));
   			 }
   		 }
   		 catch (SQLException e){
   			 e.printStackTrace();
   		 }
   		 return listaLocalidades;    
    }
    
    private ProvinciaDTO getLocalidadPorProvDTO(ResultSet resultSet) throws SQLException{
   	 	String prov = resultSet.getString("NombreProvincia");
   	 	String loc = resultSet.getString("NombreLocalidad");
   	 	return new ProvinciaDTO(prov, loc);
    }
    

}
