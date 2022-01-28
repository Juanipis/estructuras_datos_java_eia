package semana2;

import java.util.Arrays;

public class Trabajador {
	private String nombre;
	private double salarioBasico;
	private int cantDiasTrabajados;
	private int[] cantDiasTrabajadosMes;
	
	
	
	public Trabajador(String nombre, double salarioBasico) {
		this.setNombre(nombre);
		this.setSalarioBasico(salarioBasico);
		this.cantDiasTrabajados = 0;
		this.cantDiasTrabajadosMes = new int[12];
		Arrays.fill(this.cantDiasTrabajadosMes, -1); //Lo llenamos con -1 para saber que meses no trabajo
		
		
	}
	

	/*Salario basico*/
	private double getSalarioBasico() {
		return salarioBasico;
	}
	private void setSalarioBasico(double salarioBasico) {
		this.salarioBasico = salarioBasico;
	}
	
	/*Dias trabajados*/
	public int getCantDiasTrabajados() {
		return cantDiasTrabajados;
	}
	public void setCantDiasTrabajados(int cantDiasTrabajados) {
		this.cantDiasTrabajados = cantDiasTrabajados;
	}
	
	/*Dias trabajados mes*/
	public int[] getCantDiasTrabajadosMes() {
		return this.cantDiasTrabajadosMes;
	}
	public void setCantDiasTrabajadosMes(int mes, int dias ) {
		if((mes>=0 && mes < this.getCantDiasTrabajadosMes().length) &&  (dias >=0 && dias <= 31)) {
			this.getCantDiasTrabajadosMes()[mes] = dias;
		}
	}
	
	/*Nombre*/
	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
		
	
	public double getSalario() {
		return this.getSalarioBasico()*this.getCantDiasTrabajados()/24.0;
	}
	public double getSalarioMes(int mes) {
		return (this.getCantDiasTrabajadosMes()[mes] > -1) ? this.getSalarioBasico()*this.getCantDiasTrabajadosMes()[mes]/24.0 : -1;
	}
	
	public double getSalarioPromedio() {
		double salario = 0;
		int mesesTrabajados = 0;
		for(int mes: this.getCantDiasTrabajadosMes()) {
			if(this.getCantDiasTrabajadosMes()[mes] > -1) {
				mesesTrabajados++;
				salario += this.getSalarioBasico()*this.getCantDiasTrabajadosMes()[mes]/24.0;
			}
		}
		return salario/mesesTrabajados;
	}
	
	@Override
	public String toString() {
		return this.getNombre() + " tiene como salario para este mes: " + this.getSalario() + " pesos";
	}


	

	
	
}
