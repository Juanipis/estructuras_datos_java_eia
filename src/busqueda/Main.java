package busqueda;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		String[] arr1 = {"a","c","d","e","g","f"};
		//System.out.println(AlgoritmosBusqueda.busquedaBinIterativa(arr1, "d"));
		//System.out.println(AlgoritmosBusqueda.busquedaBinRecursiva(arr1, "d"));
		System.out.println(AlgoritmosBusqueda.buscarElementoIndiceLD(arr1, "g", 5));
		int[] arr = {2,-9,4,8,9};
		System.out.println(AlgoritmosBusqueda.buscarElemento(arr, -10));
	}
}
