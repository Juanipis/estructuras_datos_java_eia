package biblioteca;

public class Usuario {
	private String nombre;
	private String CC;
	private String telefono;
	private String tipo;
	
	public Usuario(String nombre, String cC, String telefono, String tipo) {
		this.nombre = nombre;
		this.CC = cC;
		this.telefono = telefono;
		this.tipo = tipo;
	}

	public String getCC() {
		return CC;
	}
	
}
