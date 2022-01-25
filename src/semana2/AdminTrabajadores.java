package semana2;

import java.util.*;

public class AdminTrabajadores {
	Trabajador[] trabajadores;
	
	public AdminTrabajadores() {
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
		for(int i = 0; i < this.trabajadores.length-1; i++ ) {
			if( nombre == this.trabajadores[i].getNombre()) {
				return this.trabajadores[i];
			}
		}
		
	}
}
