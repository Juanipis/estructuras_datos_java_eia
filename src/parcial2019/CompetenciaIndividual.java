package parcial2019;

public class CompetenciaIndividual extends Competencia {
	private Jugador[] jugadores;
	private Jugador jugadorGanador;
	public CompetenciaIndividual(String pista, Jugador[] jugadores, int jugadorGanador) {
		super(pista);
		this.jugadores = jugadores;
		this.jugadorGanador  = this.jugadores[jugadorGanador];
	}
	public Jugador[] getJugadores() {
		return jugadores;
	}
	public Jugador getJugadorGanador() {
		return jugadorGanador;
	}

}
