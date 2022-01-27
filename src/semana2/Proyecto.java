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
	
	public void addTrabajador(String nombre, double slbasico) {
		Trabajador tr = new Trabajador(nombre, slbasico);
		this.trabajadores = Arrays.copyOf(this.getTrabajadores(), this.getTrabajadores().length+1);
		this.trabajadores[this.trabajadores.length-1] = tr;
	}
	
	public Trabajador buscarTrabajador(String nombre) {
		int c = 0;
		while((c< this.trabajadores.length) && !(this.getTrabajadores()[c].getNombre().equals(nombre))) {
			c++;
		}
		return (this.trabajadores[c].getNombre().equals(nombre)) ? this.trabajadores[c]:null;
	}
	
	public void setCantDiasTrabajados(String nombre, int diasTrabajados) {
		this.buscarTrabajador(nombre).setCantDiasTrabajados(diasTrabajados);;
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
	
	public double getSalarioMinTrabajador() { 
		double salMin = 0.0;
		
		if((this.getTrabajadores() != null) && this.getTrabajadores().length > 0 ) { 
			salMin = this.getTrabajadores()[0].getSalario();
			
			//For clasico
			///*
			for(int i = 1; i < this.getTrabajadores().length; i++) {
				salMin = (salMin > this.getTrabajadores()[i].getSalario()) ? this.getTrabajadores()[i].getSalario():salMin;
			}
			//*/
			
			//For each 
			/*
			for(Trabajador trabajador : this.getTrabajadores()) {
				salMin = (salMin > trabajador.getSalario()) ? trabajador.getSalario():salMin;
			}
			*/
			
		}
		else {
			return -1;
		}
		
		return salMin;
		

	}
}
