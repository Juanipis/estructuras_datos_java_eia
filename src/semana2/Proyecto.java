package semana2;

import java.util.*;

public class Proyecto {
	private Trabajador[] trabajadores;
	
	public Proyecto() {
		trabajadores = new Trabajador[0];
	}
	
	public Trabajador[] getTrabajadores() {
		return this.trabajadores;
	}
	
	public void addTrabajador(Trabajador trj) {
		this.trabajadores = Arrays.copyOf(this.getTrabajadores(), this.getTrabajadores().length+1);
		this.trabajadores[this.trabajadores.length-1] = trj;
	}
	
	public Trabajador buscarTrabajador(String nombre) {
		for(int i = 0; i < this.trabajadores.length; i++ ) {
			if( nombre == this.trabajadores[i].getNombre()) {
				return this.trabajadores[i];
			}
		}
		/*Si no se encuentra el trabajador, devolver un NaN*/
		return new Trabajador("NaN", 0.0);
		
	}
	
	public double buscarSalarioTrabajador(String nombre) {
		return this.buscarTrabajador(nombre).getSalario();
	}
	
	public int getHorasProyecto() {
		int horas = 0;
		
		for(int i = 0; i < this.getTrabajadores().length; i++) {
			horas += (this.getTrabajadores()[i].getCantDiasTrabajados())*24;
		}
		
		return horas;
	}
}
