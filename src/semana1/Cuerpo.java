/*Juan Pablo Díaz Correa @Juanipis*/
package semana1;

public class Cuerpo {
	private double espacio;
	private double tiempo;
	
	/*Constructor*/
	/*
	public Cuerpo(double espacio, double tiempo) {
		this.espacio = espacio;
		this.tiempo = tiempo;
	}
	*/
	/*Setters*/
	public void setEspacio(double espacio) {
		this.espacio = espacio;
	}
	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	
	/*Getters*/
	public double getEspacio() {
		return this.espacio;
	}
	public double getTiempo() {
		return this.tiempo;
	}
	
	/*Metodos*/
	public double calcVel() { /*En metros y segundos*/
		return this.espacio*this.tiempo;
	}
}
