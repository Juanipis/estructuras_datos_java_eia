package ordenamiento;

public class Persona implements Comparable<Persona>{
	private String nombre;
	private int edad;
	
	
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	

	/*
	@Override
	public String toString() {
		return nombre + "-" + edad;
	}
*/

	@Override
	public int compareTo(Persona pr) {
		//Por nombre
		//return this.getNombre().compareTo(pr.getNombre());
		
		//Por edad
		//return this.getEdad()-pr.getEdad();
		
		//Por edad y si es igual por nombre
		int compar = this.getEdad()-pr.getEdad();
		return (compar != 0) ? compar: this.getNombre().compareTo(pr.getNombre());
		
	}
}
