package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.PersonaDTO;

public class PersonaDAOSQL implements PersonaDAO
{
	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono, email, cumpleanios, calle, altura, piso, depto, loc, tipo, codPostal, equipoPref) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM personas";
	private static final String update = "UPDATE personas SET nombre = ?, telefono=?, email=?, cumpleanios=?, calle=?,"
			+ " altura=?, piso=?, depto=?, loc=?, tipo=?, codPostal=?, equipoPref=? WHERE idPersona = ?";
		
	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, persona.getEmail());
			statement.setString(5, persona.getCumpleanios());
			statement.setString(6, persona.getCalle());
			statement.setString(7, persona.getAltura());
			statement.setString(8, persona.getPiso());
			statement.setString(9, persona.getDepto());
			statement.setString(10, persona.getLoc());
			statement.setString(11, persona.getTipo());
			statement.setString(12, persona.getCodPostal());
			statement.setString(13, persona.getEquipoPref());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	@Override
	public void update(PersonaDTO persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		//boolean isUpdateExitoso = false;
		try{
			statement = conexion.prepareStatement(update);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getTelefono());
			statement.setString(3, persona.getEmail());
			statement.setString(4, persona.getCumpleanios());
			statement.setString(5, persona.getCalle());
			statement.setString(6, persona.getAltura());
			statement.setString(7, persona.getPiso());
			statement.setString(8, persona.getDepto());
			statement.setString(9, persona.getLoc());
			statement.setString(10, persona.getTipo());
			//
			statement.setString(11, persona.getCodPostal());
			statement.setString(12, persona.getEquipoPref());
			//
			statement.setInt(13, persona.getIdPersona());
			//statement.setInt(11, persona.getIdPersona());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
//		return isUpdateExitoso;
	}
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersonaDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	private PersonaDTO getPersonaDTO(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idPersona");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Telefono");
		String email = resultSet.getString("Email");
		String cumple = resultSet.getString("Cumpleanios");
		String calle = resultSet.getString("Calle");
		String altura = resultSet.getString("ALtura");
		String piso = resultSet.getString("Piso");
		String depto = resultSet.getString("Depto");
		String loc = resultSet.getString("loc");
		String tipo = resultSet.getString("tipo");
		String codPostal = resultSet.getString("CodPostal");
		String equipoPref = resultSet.getString("EquipoPref");
		return new PersonaDTO(id, nombre, tel, email, cumple, calle, altura, piso, depto, loc, tipo, codPostal, equipoPref);
	}

	
}
