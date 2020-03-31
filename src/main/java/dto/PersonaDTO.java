package dto;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private String email;
	private String cumpleanios;
	private String calle;
	private String altura;
	private String piso;
	private String depto;
	private String loc;
	private String tipo;

	public PersonaDTO(int idPersona, String nombre, String telefono, String email, String cumpleanios, 
			String calle, String altura, String piso, String depto, String loc, String tipo) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.cumpleanios = cumpleanios;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.depto = depto;
		this.loc = loc;
		this.tipo = tipo;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCumpleanios() {
		return cumpleanios;
	}

	public void setCumpleanios(String cumpleanios) {
		this.cumpleanios = cumpleanios;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}
		
}
