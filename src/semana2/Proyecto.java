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
	
	public Trabajador getTrabajador(String nombre) {
		if(this.getTrabajadores().length == 0) {
			return null;
		}
		int c = 0;
		while((c< this.trabajadores.length) && this.getTrabajadores()[c] != null && !(this.getTrabajadores()[c].getNombre().equals(nombre)) ) {
			c++;
		}
		
		return (c!=this.getTrabajadores().length && this.trabajadores[c].getNombre().equals(nombre)) ? this.trabajadores[c]:null;
	}
	
	
	public int getIndexTrabajador(String nombre) {
		if(this.getTrabajadores().length == 0) {
			return -1;
		}
		int c = 0;
		while((c< this.trabajadores.length) && this.getTrabajadores()[c] != null && !(this.getTrabajadores()[c].getNombre().equals(nombre)) ) {
			c++;
		}
		
		return (c!=this.getTrabajadores().length && this.trabajadores[c].getNombre().equals(nombre)) ? c:-1;
	}
	
	public void setCantDiasTrabajados(String nombre, int diasTrabajados) {
		this.getTrabajador(nombre).setCantDiasTrabajados(diasTrabajados);;
	}
	
	public void setCantDiasTrabajadosMes(String nombre, int mes, int diasTrabajados) {
		this.getTrabajador(nombre).setCantDiasTrabajadosMes(mes, diasTrabajados);
	}
	
	public double getSalarioTrabajador(String nombre) {
		if(this.getTrabajadores().length == 0) {
			return Double.NaN;
		}
		return this.getTrabajador(nombre).getSalario();
	}
	
	public double getSalarioMesTrabajador(String nombre, int mes) {
		return this.getTrabajador(nombre).getSalarioMes(mes);
	}
	
	public int getHorasProyecto() {
		int horas = 0;
		int c = 0;
		while((c< this.trabajadores.length) && this.getTrabajadores()[c] != null) {
			horas += (this.getTrabajadores()[c].getCantDiasTrabajados())*24;
			c++;
		}
		
		return horas;
	}
	
	public double getSalarioMinTrabajador() { 
		double salMin = 0.0;
		
		if((this.getTrabajadores() != null) && this.getTrabajadores().length > 0 ) { 
			salMin = this.getTrabajadores()[0].getSalario();
			
			//For clasico
			/*
			for(int i = 1; i < this.getTrabajadores().length; i++) {
				salMin = (salMin > this.getTrabajadores()[i].getSalario()) ? this.getTrabajadores()[i].getSalario():salMin;
			}
			*/
			
			//For each 
			///*
			for(Trabajador trabajador : this.getTrabajadores()) {
				salMin = (salMin > trabajador.getSalario()) ? trabajador.getSalario():salMin;
			}
			//*/
			
		}
		else {
			return -1;
		}
		return salMin;
	}
	
	public double getSalarioPromedioMes(int mes) { //Teniendo en cuenta todos los trabajadores de un mes
		double salarioPromedio = 0.0;
		int meses = 0;
		if(mes >= 0 && mes <= 11) {
			for(Trabajador trabajador : this.getTrabajadores()) {
				if(trabajador != null && trabajador.getSalarioMes(mes) !=-1.0) {
					salarioPromedio += trabajador.getSalarioMes(mes);
					meses++;
				}
			}
		}
		return (meses != 0) ? salarioPromedio/meses : -1;
		}
	
	public void insertarTrabajador(String nombre, double salarioBasico, int index) {
		if(index>=0 && index < this.getTrabajadores().length && salarioBasico >= 0.0) {
			Trabajador[] temp = new Trabajador[this.getTrabajadores().length+1];
			temp[index] = new Trabajador(nombre, salarioBasico);
			int arrA = 0;
			int arrT = 0;
			while(arrT < temp.length) {
				if(arrT != index) {
					temp[arrT] = this.getTrabajadores()[arrA];
					arrA++;
					arrT++;
				}
				else {
					arrT++;
				}
			}
			this.trabajadores = temp;
		}
	}
	
	public void eliminarTrabajador(String nombre) {
		if(this.getTrabajador(nombre) != null) {
			Trabajador[] temp = new Trabajador[this.getTrabajadores().length-1];
			int numTrabajador = this.getIndexTrabajador(nombre);
			System.out.println(temp.length);

			int arT = 0;
			int arO = 0;
			
			while(arT < temp.length) {
				if(arT == numTrabajador) {
					arO++;
				}
				temp[arT] = this.getTrabajadores()[arO];
				arT++;
				arO++;
			}
			this.trabajadores = temp;
			
		}
		
	}
}

