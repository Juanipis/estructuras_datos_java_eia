package parcial2019;

import java.util.Arrays;

public class CompetenciaInframundo extends CompetenciaEquipos {
	private Jugador[] mujeres = new Jugador[0];
	private Jugador[] hombres = new Jugador[0];
	
	public CompetenciaInframundo(Equipo equipo1, Equipo equipo2, String pista) {
		super(equipo1, equipo2, pista);
		//Separemos hombres y mujeres equipo 1
		this.separacionEquipo(this.equipoGanador());
		this.separacionEquipo(this.equipoPerdedor());
	}
	
	public void separacionEquipo(Equipo eq) {
		for(Jugador jge1 : eq.getIntegrantes()) {
			if(jge1 != null) {
				if(jge1.getGenero() == 'M') { //Masculino
					this.addHombre(jge1);
				}else if(jge1.getGenero() == 'F') { //Femenino
					this.addMujer(jge1);
				}
			}
		}
	}
	
	public void addMujer(Jugador jg) {
		mujeres = Arrays.copyOf(mujeres, mujeres.length+1);
		mujeres[mujeres.length-1] = jg;
	}
	public void addHombre(Jugador jg) {
		hombres = Arrays.copyOf(hombres, hombres.length+1);
		hombres[hombres.length-1] = jg;
	}
}
