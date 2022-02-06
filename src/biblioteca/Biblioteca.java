package biblioteca;

import java.util.Arrays;
import java.util.Date;

import biblioteca.Libro.Ejemplar;

public class Biblioteca {
	private Libro[] libros;
	private Usuario[] usuarios;
	private Prestamo[] prestamo;
	
	public Biblioteca() {
		this.libros = new Libro[0];
		this.usuarios = new Usuario[0];
		this.prestamo = new Prestamo[0];
	}
	
	public boolean prestamo(String[] datos, String CC) { //Creamos nuevo usuario o buscamos existente
		if(datos.length !=4) {return false;} //En caso de que entreguen mal los datos
		/* String[] datos 
		 * nombreUsuario : 0
		 * telefonoUsuario : 1
		 * tipoUsuario : 2
		 * nombreLibro1: 3
		 * nombreLibro2 : 4
		 * en adelante solo hay libros...
		 * */
		Usuario usrPrestamo = this.buscarUsuario(CC);
		if(usrPrestamo == null) { //Añadimos el nuevo usuario a la lista de usuarios dado que no existe
			this.usuarios = Arrays.copyOf(this.usuarios, this.usuarios.length+1);
			this.usuarios[this.usuarios.length-1] = new Usuario(datos[0], CC, datos[1], datos[2]); //Nombre CC telefono tipo
		}
		
		Ejemplar[] ejemplaresPrestar = new Ejemplar[0];
		for(int i=3; i< datos.length; i++) {
			Ejemplar prestamoEjemplar = this.buscarLibro(datos[i]);
			if(prestamoEjemplar != null && prestamoEjemplar.disponible && prestamoEjemplar.existencia) {
				ejemplaresPrestar = Arrays.copyOf(ejemplaresPrestar, ejemplaresPrestar.length+1);
				ejemplaresPrestar[this.prestamo.length-1] = prestamoEjemplar;
			}
		}
		
		//Comprobamos que se haya podido obtener todos los ejemplares
		if(datos.length-3 == ejemplaresPrestar.length) {
			this.prestamo = Arrays.copyOf(this.prestamo, this.prestamo.length+1);
			this.prestamo[this.prestamo.length-1] = new Prestamo(usrPrestamo, ejemplaresPrestar);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public Usuario devolucion(String CC) {
		int index = 0;
		while(index < this.prestamo.length && this.prestamo[index] != null && !this.prestamo[index].usuario.getCC().equals(CC)) {
			index++;
		}
		if(index < this.prestamo.length && this.prestamo[index] != null && this.prestamo[index].usuario.getCC().equals(CC)) {
			Prestamo[] temp = new Prestamo[this.prestamo.length-1];
			System.arraycopy(this.prestamo, 0, temp, 0, index);
			System.arraycopy(this.prestamo, index+1, temp, index, this.prestamo.length-index-1);
			this.prestamo = temp;
			return this.prestamo[index].usuario;
		}
		else {
			return null;
		}
	}
	
	public Ejemplar buscarLibro(String nombreLibro) {
		for(Libro lr : this.libros) {
			if(lr != null && lr.getTitulo().equals(nombreLibro)) {
				return lr.buscarEjemplar();
			}
		}
		return null;
	}
	
	public Usuario buscarUsuario(String CC) {
		for(Usuario usr : this.usuarios) {
			if(usr != null && usr.getCC().equals(CC)) {
				return usr;
			}
		}
		return null;
	}
	
	public void addLibro(String titulo, String codigo, String autores, String editorial, int edicion) {
		this.libros = Arrays.copyOf(this.libros, this.libros.length);
		this.libros[this.libros.length-1]= new Libro(titulo, codigo, autores, editorial, edicion);
	}
	
	public void eliminarLibro(String nombreLibro) {
		int index  = 0;
		while(index < this.libros.length && this.libros[index] != null && !this.libros[index].getTitulo().equals(nombreLibro)) {
			index++;
		}
		if(index < this.libros.length && this.libros[index] != null && this.libros[index].getTitulo().equals(nombreLibro)) {
			Libro[] temp = new Libro[this.libros.length-1];
			System.arraycopy(this.libros, 0, temp, 0, index);
			System.arraycopy(this.libros, index+1, temp, index, this.libros.length-index-1);
			this.libros = temp;
		}
	}
	
	public void addEjemplar(String nombreLibro, String codigoEjemplar) {
		for(Libro lr: this.libros) {
			if(lr != null && lr.getTitulo().equals(nombreLibro)) {
				lr.addEjemplar(codigoEjemplar);
				break;
			}
		}
	}
	
	public void eliminarEjemplar(String nombreLibro, String codigoEjemplar) {
		for(Libro lr: this.libros) {
			if(lr != null && lr.getTitulo().equals(nombreLibro)) {
				lr.eliminarEjemplar(codigoEjemplar);
				break;
			}
		}
	}
	
	
	public void cargarUsuarios() { 
		//¿Qué diablos se hace aquí?
	}
	
	
	
	
	
	private class Prestamo{
		protected Usuario usuario;
		protected Ejemplar[] ejemplar;
		protected Date fechaPrestamo;
		protected Date fechaDevolucion;
		
		protected Prestamo(Usuario usuario, Ejemplar[] ejemplar) {
			this.usuario = usuario;
			this.ejemplar = ejemplar;
			this.fechaPrestamo = new Date();
			//Solo se presta una semana, 7 dias
			this.fechaDevolucion = new Date(this.fechaPrestamo.getYear(), this.fechaPrestamo.getMonth(), this.fechaPrestamo.getDay()+7, 11, 59, 59);
			
		}
	}
}
