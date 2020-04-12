package persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class ConexionReporte 
{
	public static ConexionReporte instancia;
	private Connection connection;
	private Logger log = Logger.getLogger(ConexionReporte.class);	
	
	public ConexionReporte()
	{
		try
		{
			Class.forName("org.gjt.mm.mysql.Driver"); // quitar si no es necesario
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost/agenda","root","");
			this.connection.setAutoCommit(false);
			log.info("Conexión exitosa");
		}
		catch(Exception e)
		{
			log.error("Conexión fallida", e);
		}
	}
	
	
	public static ConexionReporte getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new ConexionReporte();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
			log.info("Conexion cerrada");
		}
		catch (SQLException e) 
		{
			log.error("Error al cerrar la conexión!", e);
		}
		instancia = null;
	}
}
