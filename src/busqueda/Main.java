package busqueda;

public class Main {
	public static void main(String[] args) {
		String[] arr1 = {"a","b","c","d","f","z"};
		System.out.println(AlgoritmosBusqueda.busquedaBinIterativa(arr1, "c"));
		System.out.println(AlgoritmosBusqueda.busquedaBinRecursiva(arr1, "c"));
		
		int[] arr = {2,-9,4,8,9};
		System.out.println(AlgoritmosBusqueda.buscarElemento(arr, -10));
	}
}
