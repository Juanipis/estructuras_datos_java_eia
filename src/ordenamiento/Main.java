package ordenamiento;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Persona pr1 = new Persona("Marcela", 24);
		Persona pr2 = new Persona("Oscar", 21);
		Persona pr3 = new Persona("Marcela", 24);
		Persona pr4 = new Persona("Andrés", 26);
		Persona pr5 = new Persona("Oscar", 30);
		Persona pr6 = new Persona("Nadia", 21);
		Persona pr7 = new Persona("Marcela", 24);
		Persona pr8 = new Persona("Marcela", 24);
		Persona pr9 = new Persona("Oscar", 21);
		
		Comparable[] personas = {pr1,pr2,pr3,pr4,pr5,pr6,pr7,pr8,pr9};
		System.out.println(Arrays.toString(personas));
		personas = AlgoritmosOrdenamiento.eliminarDuplicados(personas);
		System.out.println(Arrays.toString(personas));
		/*
		System.out.println(AlgoritmosOrdenamiento.ordenado(personas));
		AlgoritmosOrdenamiento.bubblesSort(personas);
		System.out.println(Arrays.toString(personas));
		System.out.println(AlgoritmosOrdenamiento.ordenado(personas));
		
		Persona[] personas1 = {pr1,pr2,pr3,pr4,pr5,pr6};
		AlgoritmosOrdenamiento.selectionSort(personas1);
		System.out.println(Arrays.toString(personas1));
		
		Persona[] personas3 = {pr1,pr2,pr3,pr4,pr5,pr6};
		AlgoritmosOrdenamiento.insertSort(personas3);
		System.out.println(Arrays.toString(personas3));
		
		String[] arregl = {"zz","fs"};
		System.out.println(AlgoritmosOrdenamiento.ordenado(arregl));
		AlgoritmosOrdenamiento.bubblesSort(arregl);
		System.out.println(AlgoritmosOrdenamiento.ordenado(arregl));
		System.out.println(Arrays.toString(arregl));
		
		Persona[] personas4 = {pr1,pr2,pr3,pr4,pr5,pr6};
		String[] letras = {"z","a"};
		Comparable[] listaOrdenada = AlgoritmosOrdenamiento.mergeSort(letras);
		System.out.println(Arrays.toString(listaOrdenada));
		*/
	}

}
