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
		/* String[] datos 
		 * nombreUsuario : 0
		 * telefonoUsuario : 1
		 * tipoUsuario : 2
		 * codigoLibro1: 3
		 * codigoLibro2 : 4
		 * en adelante solo hay libros...
		 * */
		Usuario usrPrestamo = this.buscarUsuario(CC);
		if(usrPrestamo == null) { //Añadimos el nuevo usuario a la lista de usuarios dado que no existe
			this.usuarios = Arrays.copyOf(this.usuarios, this.usuarios.length+1);
			this.usuarios[this.usuarios.length-1] = new Usuario(datos[0], CC, datos[1], datos[2]); //Nombre CC telefono tipo
			usrPrestamo = this.buscarUsuario(CC);
		}
		
		Ejemplar[] ejemplaresPrestar = new Ejemplar[0];
		for(int i=3; i< datos.length; i++) {
			Ejemplar prestamoEjemplar = this.buscarLibro(datos[i]);
			if(prestamoEjemplar != null && prestamoEjemplar.disponible && prestamoEjemplar.existencia) {
				//Establecemos que los ejemplares no estan disponibles
				prestamoEjemplar.disponible = false;
				ejemplaresPrestar = Arrays.copyOf(ejemplaresPrestar, ejemplaresPrestar.length+1);
				ejemplaresPrestar[ejemplaresPrestar.length-1] = prestamoEjemplar;
			}
		}
		
		//Comprobamos que se haya podido obtener todos los ejemplares
		if(ejemplaresPrestar.length>0) {
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
			//hacemos que los ejemplares esten disponibles nuevamente
			for(Ejemplar ejm : this.prestamo[index].ejemplar) {
				ejm.disponible = true;
			}
			Usuario usrPrestamo = this.prestamo[index].usuario;
			Prestamo[] temp = new Prestamo[this.prestamo.length-1];
			System.arraycopy(this.prestamo, 0, temp, 0, index);
			System.arraycopy(this.prestamo, index+1, temp, index, this.prestamo.length-index-1);
			this.prestamo = temp;
			
			
			return usrPrestamo;
		}
		else {
			return null;
		}
	}
	
	public Ejemplar buscarLibro(String nombreLibro) {
		int index=0;
		while(index < this.libros.length && !this.libros[index].getTitulo().equals(nombreLibro)) index++;		
		return (this.libros[index] != null && this.libros[index].getCantDisponible() >0 && this.libros[index].buscarEjemplar().disponible) 
				? this.libros[index].buscarEjemplar() : null; 
	}
	/* otra manera
	public Ejemplar buscarLibro(String nombreLibro) {
		int index=0;
		while(index < this.libros.length && !this.libros[index++].getTitulo().equals(nombreLibro));		
		return (this.libros[--index] != null && this.libros[index].getCantDisponible() >0 && this.libros[index].buscarEjemplar().disponible) 
				? this.libros[index].buscarEjemplar() : null; 
	}
	*/
	public Usuario buscarUsuario(String CC) {
		for(Usuario usr : this.usuarios) {
			if(usr != null && usr.getCC().equals(CC)) {
				return usr;
			}
		}
		return null;
	}
	
	public void addLibro(String titulo, String codigo, String autores, String editorial, int edicion) {
		this.libros = Arrays.copyOf(this.libros, this.libros.length+1);
		this.libros[this.libros.length-1]= new Libro(titulo, codigo, autores, editorial, edicion);
	}
	
	public void eliminarLibro(String codigoLibro) {
		int index  = 0;
		while(index < this.libros.length && this.libros[index] != null && !this.libros[index].getCodigo().equals(codigoLibro)) {
			index++;
		}
		if(index < this.libros.length && this.libros[index] != null && this.libros[index].getCodigo().equals(codigoLibro)) {
			Libro[] temp = new Libro[this.libros.length-1];
			System.arraycopy(this.libros, 0, temp, 0, index);
			System.arraycopy(this.libros, index+1, temp, index, this.libros.length-index-1);
			this.libros = temp;
		}
	}
	
	public void addEjemplar(String codigoLibro, String codigoEjemplar) {
		for(Libro lr: this.libros) {
			if(lr != null && lr.getCodigo().equals(codigoLibro)) {
				lr.addEjemplar(codigoEjemplar);
				break;
			}
		}
	}
	
	public void eliminarEjemplar(String codigoLibro, String codigoEjemplar) {
		for(Libro lr: this.libros) {
			if(lr != null && lr.getCodigo().equals(codigoLibro)) {
				lr.eliminarEjemplar(codigoEjemplar);
				break;
			}
		}
	}
	
	
	public void cargarUsuarios() { 
		//¿Qué diablos se hace aquí?
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Biblioteca [libros=" + Arrays.toString(libros) + ", usuarios=" + Arrays.toString(usuarios)
				+ ", prestamo=" + Arrays.toString(prestamo) + "]";
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
		@Override
		public String toString() {
			return "Prestamo [usuario=" + usuario + ", ejemplares=" + Arrays.toString(ejemplar)
			+ ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion+"]";
		}
	}
}
