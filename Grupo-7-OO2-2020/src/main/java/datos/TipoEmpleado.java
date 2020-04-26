package datos;

public class TipoEmpleado {	
	
	private long idTipoEmpleado;
	private String nombre;
	private String descripcion;
	private double sueldoBasico;
	
	public TipoEmpleado() {}
	
	public TipoEmpleado(String nombre, String descripcion, double sueldoBasico) {
		super();		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.sueldoBasico = sueldoBasico;
	}

	public long getIdTipoEmpleado() {
		return idTipoEmpleado;
	}

	protected void setIdTipoEmpleado(long idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	@Override
	public String toString() {
		return "TipoEmpleadoID: " + idTipoEmpleado + ", Nombre=" + nombre + ", Descripcion=" + descripcion
				+ ", SueldoBasico=" + sueldoBasico;
	}

	
	
}
