package busqueda;

public class Main {
	public static void main(String[] args) {
		String[] arr1 = {"a","b","c","d","f","z"};
		System.out.println(AlgoritmosBusqueda.busquedaBinIterativa(arr1, "c"));
		System.out.println(AlgoritmosBusqueda.busquedaBinRecursiva(arr1, "c"));
	}
}
