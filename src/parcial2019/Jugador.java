package parcial2019;

public class Jugador {
	private String nombre;
	private int edad;
	private String region;
	private char genero;
	
	public Jugador(String nombre, int edad, String region) {
		this.nombre = nombre;
		this.edad = edad;
		this.region = region;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public String getRegion() {
		return region;
	}

	public char getGenero() {
		return genero;
	}
	
}
