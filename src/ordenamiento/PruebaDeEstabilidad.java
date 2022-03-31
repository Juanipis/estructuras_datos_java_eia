package ordenamiento;

import java.util.Arrays;

public class PruebaDeEstabilidad {

	public static void main(String[] args) {
		Persona pr1 = new Persona("Marcela", 24);
		Persona pr2 = new Persona("Oscar", 21);
		Persona pr3 = new Persona("Marcela", 20);
		Persona pr4 = new Persona("Marcela", 20);
		Persona pr5 = new Persona("Andrés", 26);
		Persona pr6 = new Persona("Oscar", 30);
		Persona pr7 = new Persona("Nadia", 21);
		Persona pr8 = new Persona("Marcela", 20);
		
		Persona[] personas = {pr1,pr2,pr3,pr4,pr5,pr6,pr7,pr8};
		
		Persona[] personas1 = Arrays.copyOf(personas, personas.length);
		AlgoritmosOrdenamiento.bubblesSort(personas1);
		System.out.println(Arrays.toString(personas1));
		
		Persona[] personas2 = Arrays.copyOf(personas, personas.length);
		AlgoritmosOrdenamiento.selectionSort(personas2);
		System.out.println(Arrays.toString(personas2));
		
		Persona[] personas3 = Arrays.copyOf(personas, personas.length);
		AlgoritmosOrdenamiento.insertSort(personas3);
		System.out.println(Arrays.toString(personas3));
		
		Persona[] personas4 = Arrays.copyOf(personas, personas.length);
		AlgoritmosOrdenamiento.quickSort(personas4);
		System.out.println(Arrays.toString(personas4));
		
		Persona[] personas5 = Arrays.copyOf(personas, personas.length);
		Comparable[] personas5Ordenado = AlgoritmosOrdenamiento.mergeSort(personas5);
		System.out.println(Arrays.toString(personas5Ordenado));
		

	}

}
