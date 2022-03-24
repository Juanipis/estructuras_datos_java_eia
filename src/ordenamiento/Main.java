package ordenamiento;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] arr = {9,3,6,1,6,8,3,1};
		AlgoritmosOrdenamiento.bubblesSort(arr);
		System.out.println(Arrays.toString(arr));
		
		Persona pr1 = new Persona("Marcela", 24);
		Persona pr2 = new Persona("Oscar", 21);
		Persona pr3 = new Persona("Marcela", 20);
		Persona pr4 = new Persona("Andrés", 26);
		Persona pr5 = new Persona("Oscar", 30);
		Persona pr6 = new Persona("Nadia", 21);
		
		Persona[] personas = {pr1,pr2,pr3,pr4,pr5,pr6};
		AlgoritmosOrdenamiento.bubblesSort(personas);
		System.out.println(Arrays.toString(personas));
		
		Persona[] personas1 = {pr1,pr2,pr3,pr4,pr5,pr6};
		AlgoritmosOrdenamiento.selectionSort(personas1);
		System.out.println(Arrays.toString(personas1));
		
		Persona[] personas3 = {pr1,pr2,pr3,pr4,pr5,pr6};
		AlgoritmosOrdenamiento.insertSort(personas3);
		System.out.println(Arrays.toString(personas3));
		
		String[] arregl = {"zz","fs","bs","dd"};
		AlgoritmosOrdenamiento.bubblesSort(arregl);
		System.out.println(Arrays.toString(arregl));

	}

}
