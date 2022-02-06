package biblioteca;

import java.util.Arrays;
import java.util.Date;

import biblioteca.Libro.Ejemplar;

public class Main {

	public static void main(String[] args) {
		Libro lr = new Libro("Elementos de euclides","MM-11", "Euclides", "NewMan", 1 );
		lr.addEjemplar("12PP");
		lr.addEjemplar("99RE");
		lr.addEjemplar("41OA");
		lr.addEjemplar("92LO");
		lr.eliminarEjemplar("12PP");
		System.out.println(lr.buscarEjemplar());
		System.out.println(lr.buscarEjemplar());
		lr.eliminarEjemplar("99RE");
		System.out.println(lr.buscarEjemplar());
		
		
	}

}
