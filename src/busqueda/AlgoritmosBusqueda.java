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
						busquedaBinRecursiva(arr,valor,medio+1,fin);
			}
		}
	}
	public static int buscarInidiceInsersion(Comparable[] arr,Comparable valor,int inicio, int fin) { //debemos hallar el menor
		int medio;
		if(inicio>=fin) {
			return arr[inicio].compareTo(valor) >= 0 ? inicio:inicio+1;
 		}
		else {
			medio = (inicio+fin)/2;
			if(arr[medio].compareTo(valor) == 0) { //En caso de elemento repetio se inserta ahi
				return medio;
			}
			else {
				return (arr[medio].compareTo(valor)>0) ? 
						buscarInidiceInsersion(arr,valor,inicio,medio-1):
							buscarInidiceInsersion(arr,valor,medio+1,fin);
			}
		}
	}
	public static int buscarElemento(int[] arr, int obj) {
		if(arr.length>0) {
			int resultado = 0;
			for (int i = 0; i < arr.length; i++) {
				if(Math.abs(obj-arr[i])< Math.abs(arr[resultado]-obj)) {
					resultado = i;
				}
			}
			return resultado;
		}
		else{
			return -1;
		}
	}
	
	public static int buscarElementoIndiceLD(Comparable[] arr, Comparable obj, int indice) {
		while(indice<arr.length && arr[indice].compareTo(obj)!= 0) indice++;
		return(indice<arr.length && arr[indice].compareTo(obj)== 0) ? indice:-1;
	}
}
