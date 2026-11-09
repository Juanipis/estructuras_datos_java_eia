package ordenamiento;

import java.util.Arrays;

public class Pruebas {

	public static void main(String[] args) {
		Persona pr1 = new Persona("Marcela", 24);
		Persona pr4 = new Persona("Andrés", 10);
		Persona pr5 = new Persona("Felipe", 30);
		Persona pr6 = new Persona("Nadia", 21);
		Persona pr9 = new Persona("Oscar", 90);
		
		Comparable[] personas = {pr1,pr4,pr5,pr6,pr9};
		AlgoritmosOrdenamiento.insertSortConBusquedaBinaria(personas);
		System.out.println(Arrays.toString(personas));

	}

}
