package dto;

public class ProvinciaDTO {
	
	private int idProvincia;
	private String nombreProvincia;
	private String nombreLocalidad;

	public ProvinciaDTO(int idLocalidad, String nombre, String nombreLocalidad){
		this.idProvincia = idLocalidad;
		this.nombreProvincia = nombre;
		this.nombreLocalidad = nombreLocalidad;
	}
	
	public ProvinciaDTO(int idLocalidad, String nombre){
		this.idProvincia = idLocalidad;
		this.nombreProvincia = nombre;
	}
	
	public int getIdLocalidad() {
		return this.idProvincia;
	}

	public void setIdProvincia(int idProvincia){
		this.idProvincia = idProvincia;
	}

	public String getNombreProvincia(){
		return this.nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia){
		this.nombreProvincia = nombreProvincia;
	}

	public String getNombreLocalidad() {
		return nombreLocalidad;
	}

	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}

}
