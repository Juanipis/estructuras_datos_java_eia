package listasPilasColas;

import java.util.Date;

public class PersonaCola implements Comparable<PersonaCola>{
	private String nombre;
	private int edad;
	private int prioridad; 
	private Date llegada;
	// 1 Embarazo
	// 2 Mayor de 60
	// 3 Cualquiera
	
	public PersonaCola(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.embarazo = false;
		this.prioridad = (edad >60) ? 2:3;
		this.llegada = new Date();
	}
	public PersonaCola(String nombre, int edad, boolean embarazo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.embarazo = embarazo;
		this.prioridad = (embarazo) ? 1:( (edad>60) ? 2:3);
		this.llegada = new Date();
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
	
	public int getPrioridad() {
		return prioridad;
	}
	
	
	@Override
	public String toString() {
		return nombre + "-" + edad;
	}


	@Override
	public int compareTo(PersonaCola pr) {
		//Por nombre
		//return this.getNombre().compareTo(pr.getNombre());
		
		//Por edad
		//return this.getEdad()-pr.getEdad();
		
		//Por edad y si es igual por nombre
		int compar = this.getEdad()-pr.getEdad();
		return (compar != 0) ? compar: this.getNombre().compareTo(pr.getNombre());
		
	}
	public Date getLlegada() {
		return llegada;
	}
	
	
}

