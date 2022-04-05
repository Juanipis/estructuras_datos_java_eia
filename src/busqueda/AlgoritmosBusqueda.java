package busqueda;

public class AlgoritmosBusqueda {
	public static int busquedaBinIterativa(Comparable[] a, Comparable valor) {
		int inicio= 0;
		int fin=a.length-1;
		int medio;
		while(inicio<=fin) {
			medio = (inicio+fin)/2;
			if(a[medio].compareTo(valor)==0) {
				return medio;
			}
			else {
				if(a[medio].compareTo(valor)>0) {
					fin=medio-1;
				}else {
					inicio=medio+1;
				}
			}
		}
		return -1;
	}
	public static int busquedaBinRecursiva(Comparable[] arr, Comparable valor) {
		return busquedaBinRecursiva(arr,valor,0,arr.length-1);
	}
	public static int busquedaBinRecursiva(Comparable[] arr, Comparable valor, int inicio, int fin){
		int medio;
		if(inicio>=fin) {
			return arr[inicio].compareTo(valor) == 0 ? inicio:-1;
 		}
		else {
			medio = (inicio+fin)/2;
			if(arr[medio].compareTo(valor) == 0) {
				return medio;
			}
			else {
				return (arr[medio].compareTo(valor)>0) ? 
						busquedaBinRecursiva(arr,valor,inicio,medio-1):
						busquedaBinRecursiva(arr,valor,inicio,medio-1);
			}
		}
	}
}
