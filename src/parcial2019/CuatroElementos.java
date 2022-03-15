package parcial2019;

public class CuatroElementos {
	private Equipo[] equipos;
	private Jugador[] jugadores;
	private Competencia[] competencias;
	
	public CuatroElementos(Equipo[] equipos, Jugador[] jugadores, Competencia[] competencias) {
		this.equipos = equipos;
		this.jugadores = jugadores;
		this.competencias = competencias;
	}
	
	public int buscarEquipo(String nombreEquipo) throws NoExisteEquipo {
		int index = 0;
		while(index < equipos.length && equipos[index] != null && !equipos[index].getNombreEquipo().equals(nombreEquipo)) {
			index++;
		}
		if(index < equipos.length && equipos[index] != null && equipos[index].getNombreEquipo().equals(nombreEquipo)) {
			return index;
		}else {
			throw new NoExisteEquipo(nombreEquipo);
		}
	}
	
	public boolean buscarEquipo(String nombreEquipo, String competencia) throws NoExisteEquipo {
		int index = 0;
		while(index < competencias.length && competencias[index] != null && !competencias[index].getPista().equals(competencia)) index++;
		
		return (index < competencias.length && competencias[index] != null 
				&& competencias[index].getPista().equals(competencia) 
				&& competencias[index] instanceof CompetenciaEquipos 
				&& (((CompetenciaEquipos)competencias[index]).getNombreEquipoGanador().equals(nombreEquipo) ) 
				|| ((CompetenciaEquipos)competencias[index]).getNombreEquipoPerdedor().equals(nombreEquipo))? true:false;
	}
	
	public double buscarPorcientoGanadosEquipo(String nombreEquipo) {
		int CompeticionesEquipo = 0;
		int CompeticionesGanadas = 0;
		for(Competencia cp : competencias) {
			if(cp != null && cp instanceof CompetenciaEquipos) {
				if(((CompetenciaEquipos)cp).getNombreEquipoGanador().equals(nombreEquipo)) {
					CompeticionesEquipo++;
					CompeticionesGanadas++;
				}else if(((CompetenciaEquipos)cp).getNombreEquipoPerdedor().equals(nombreEquipo)) {
					CompeticionesEquipo++;
				}
			}
		}
		return (double) CompeticionesGanadas*100/CompeticionesEquipo;
	}
	
}

class NoExisteEquipo extends Exception{
	public NoExisteEquipo(String nombreEquipo) {
		super("El equipo: " + nombreEquipo + " no está en la competencia");
	}
}