package parcial2019;

public class Equipo {
	private String nombreEquipo;
	private Jugador[] integrantes;
	public Equipo(String nombreEquipo,Jugador[] integrantes) {
		this.nombreEquipo = nombreEquipo;
		this.integrantes = integrantes;
	}
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	
	public Jugador[] getIntegrantes() {
		return this.integrantes;
	}
}
