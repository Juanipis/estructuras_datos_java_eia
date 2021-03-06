package biblioteca;

import java.util.Arrays;
import java.util.Random;

public class Libro {
	private String titulo;
	private String codigo;
	private String autores;
	private String editorial;
	private int edicion;
	private Ejemplar[] ejemplares;
	private int cantDisponible;
	private boolean existencia;
	private Random rnd = new Random();
	private char[] codigoGenerador = "0123456789ABCDEFGHIJKLNMOPQRSTUVWXYZ".toCharArray();
	
	//Tarea 
	//Cada libro tiene un codigo aleatorio de 5 digitos
	//Cada ejemplar tiene el codigo de 5 digitos del libro y otros 5 aleatorios nuevos
	public Libro(String titulo, String codigo, String autores, String editorial, int edicion) {
		super();
		this.titulo = titulo;
		this.autores = autores;
		this.editorial = editorial;
		this.edicion = edicion;
		this.ejemplares = new Ejemplar[0];
		this.cantDisponible = 0;
		this.existencia = true;
		this.codigo = codigo;
		
		
	}
	public int getCantDisponible() {
		return this.cantDisponible;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	public String getCodigo() {
		return this.codigo;
	}

	public void addEjemplar() {
		this.ejemplares = Arrays.copyOf(this.ejemplares, this.ejemplares.length+1);
		this.ejemplares[this.ejemplares.length-1] = new Ejemplar(this.codigoLibro());
		this.cantDisponible++;
	}
	
	public Ejemplar buscarEjemplar() { //Si el ejemplar existe y esta disponible
		for(Ejemplar ejem : this.ejemplares) {
			if(ejem.existencia && ejem.disponible) {
				return ejem;
			}
		}
		return null;
	}
	
	public void eliminarEjemplar(String codigo) {
		int index = 0;
		while(index < this.ejemplares.length && !this.ejemplares[index].codigo.equals(codigo)) {
			index++;
		}
		if(this.ejemplares[index].codigo.equals(codigo)) {
			Ejemplar[] temp = new Ejemplar[this.ejemplares.length-1];
			System.arraycopy(this.ejemplares, 0, temp, 0, index);
			System.arraycopy(this.ejemplares, index+1, temp, index, this.ejemplares.length-index-1);
			this.ejemplares = temp;
			this.cantDisponible--;
		}
		
	}
	
	public boolean codigoExiste(String codigoLibro) {
		int index=0;
		while(index < this.ejemplares.length && this.ejemplares[index] != null && this.ejemplares[index].codigo != codigoLibro) index++;		
		return (index < this.ejemplares.length && this.ejemplares[index] != null && this.ejemplares[index].codigo == codigoLibro) ? true : false; 
	}
	
	public String codigoLibro() {
		StringBuilder bld = new StringBuilder();
		for(int i = 1; i<=5; i++) {
			bld.append(this.codigoGenerador[this.rnd.nextInt(this.codigoGenerador.length)]);
		}
		return (!this.codigoExiste(this.codigo + bld.toString())) ?   this.codigo + bld.toString() : this.codigoLibro();
		
	}
	
	
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", codigo=" + codigo + ", autores=" + autores + ", editorial=" + editorial
				+ ", edicion=" + edicion + ", ejemplares=" + Arrays.toString(ejemplares) + ", cantDisponible="
				+ cantDisponible + ", existencia=" + existencia + "]";
	}
	
	protected class Ejemplar {
		protected String codigo;
		protected boolean disponible;
		protected boolean existencia;
		
		public Ejemplar(String codigoLibro) {
			this.codigo = codigoLibro;
			this.disponible = true;
			this.existencia = true;
		}

		@Override
		public String toString() {
			return "Ejemplar [codigo=" + codigo + ", disponible=" + disponible + ", existencia=" + existencia + "]";
		}
	}
	
}


