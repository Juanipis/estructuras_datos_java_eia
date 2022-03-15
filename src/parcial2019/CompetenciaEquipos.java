package parcial2019;

public class CompetenciaEquipos extends Competencia {
	private Equipo equipoGanador;
	private Equipo equipoPerdedor;
	
	public CompetenciaEquipos(Equipo equipo1, Equipo equipo2, String pista) {
		super(pista);
		this.equipoGanador = equipo1;
		this.equipoPerdedor = equipo2;
	}

	public Equipo equipoGanador() {
		return equipoGanador;
	}
	public String getNombreEquipoGanador() {
		return this.equipoGanador.getNombreEquipo();
	}
	
	public String getNombreEquipoPerdedor() {
		return this.equipoGanador.getNombreEquipo();
	}


	public Equipo equipoPerdedor() {
		return equipoPerdedor;
	}
}
