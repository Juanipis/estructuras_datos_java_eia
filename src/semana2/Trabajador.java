package semana2;

public class Trabajador {
	private String nombre;
	private double salarioBasico;
	private int cantDiasTrabajados;
	private int[] cantDiasTrabajadosMes;
	
	
	
	public Trabajador(String nombre, double salarioBasico) {
		this.setNombre(nombre);
		this.setSalarioBasico(salarioBasico);
		this.cantDiasTrabajados = 0;
		
		
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
	
	
	/*Nombre*/
	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int[] getCantDiasTrabajadosMes() {
		return cantDiasTrabajadosMes;
	}


	public void setCantDiasTrabajadosMes(int[] cantDiasTrabajadosMes) {
		this.cantDiasTrabajadosMes = cantDiasTrabajadosMes;
	}
	
	
	
	public double getSalario() {
		return this.getSalarioBasico()*this.getCantDiasTrabajados()/24.0;
	}
	
	@Override
	public String toString() {
		return this.getNombre() + " tiene como salario para este mes: " + this.getSalario() + " pesos";
	}


	

	
	
}
