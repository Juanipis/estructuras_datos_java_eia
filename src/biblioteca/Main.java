package biblioteca;

public class Main {

	public static void main(String[] args) {
		//Inicializacion
		Biblioteca biblioteca = new Biblioteca();
		System.out.println(biblioteca); 
		
		//Añadimos unos libros
		biblioteca.addLibro("El señor de los anillos", "SA1", "J. R. R. Tolkien", "Random house", 12);
		biblioteca.addLibro("El olvido que seremos", "OS1", "Héctor Abad Faciolince", "Alfaguara", 1);
		biblioteca.addLibro("La cuchara menguante", "CM1", "Sam Kean", "Ariel 75", 21);
		System.out.println(biblioteca); 
		
		//Eliminamos un libro
		biblioteca.eliminarLibro("El señor de los anillos");
		System.out.println(biblioteca);	
		
		//Añadir ejemplar
		biblioteca.addEjemplar("El olvido que seremos");
		biblioteca.addEjemplar("El olvido que seremos");
		biblioteca.addEjemplar("La cuchara menguante");
		biblioteca.addEjemplar("La cuchara menguante");
		biblioteca.addEjemplar("La cuchara menguante");
		System.out.println(biblioteca);
		
		//Eliminar ejemplar
		biblioteca.eliminarEjemplar("OS1", "AJQ21");
		System.out.println(biblioteca);
		
		//Hacer prestamo
		String[] prestamo = {"Juan Pablo", "30012452", "Estudiante", "El olvido que seremos", "La cuchara menguante", "La cuchara menguante"}; 
		biblioteca.prestamo(prestamo, "1000826125");
		System.out.println(biblioteca);
		
		//Verificamos prestamo haciendo public prestamo
		//System.out.println(biblioteca.prestamo[0]);
		
		//Devolver prestamo
		biblioteca.devolucion("1000826125");
		System.out.println(biblioteca);
		
		//Buscamos libro
		try {
			System.out.println(biblioteca.buscarLibroExcepcion("La cucharar menguante"));
		} catch (NoExisteLibro e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
