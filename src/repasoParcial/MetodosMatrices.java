package repasoParcial;

import java.util.ArrayList;
import java.util.Arrays;

public class MetodosMatrices {
	
	/* El clasico
	public static int buscarElementoArregloStringInt(String[] arr, String elemento) throws elementoNoEncontrado {
		int index = 0;
		while(index < arr.length && arr[index] != null && !arr[index].equalsIgnoreCase(elemento)) index++; 
		if(index < arr.length && arr[index] != null && arr[index].equalsIgnoreCase(elemento)) {
			return index;
		}else {
			throw new elementoNoEncontrado(elemento);
		}
	}*/
	// El que es capaz de buscar a pesar de los null
	public static int buscarElementoArregloStringInt(String[] arr, String elemento) throws elementoNoEncontrado{
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != null && arr[i].equalsIgnoreCase(elemento)) {
				return i;
			}
		}
		//No lo encontró lanza excepcion
		throw new elementoNoEncontrado(elemento); 
	}
	
	public static int contarNullsArreglo(Object[] arr) {
		int contador = 0;
		for (Object object : arr) {
			contador = (object == null) ? contador+1:contador;
		}
		return contador;
	}
	
	public static String[] eliminarNullsArreglo(String[] arr) {
		ArrayList<String> arT = new ArrayList<>(Arrays.asList(arr));
		int index = 0;
		while(index < arT.size()) {
			if(arT.get(index) == null) {
				arT.remove(index);
			}else {
				index++;
			}
		}
		return arT.toArray(new String[arT.size()]);
		
	}
	
	
	public static String[] adicionarElementoFinalArregloString(String[] arr, String elemento) {
		arr = Arrays.copyOf(arr, arr.length+1);
		arr[arr.length-1] = elemento;
		return arr;
	}
	
	public static String[] adicionarElementoPosicionArregloString(String[] arr, String elemento, int index) throws indexNegativoArreglo {
		if(index < 0) {
			throw new indexNegativoArreglo(index);
		}
		else if(index >arr.length) { // Se generan espacios vacios de intermedio
			arr = Arrays.copyOf(arr, index+1);
			arr[index] = elemento;
			return arr;
		}else if(index == arr.length) { //Se añade al final
			return adicionarElementoFinalArregloString(arr, elemento);
		}else if(index == 0) {
			String[] arr2 = new String[arr.length+1];
			System.arraycopy(arr, 0, arr2, 1, arr.length);
			arr2[0] = elemento;
			return arr2;
		}else {
			String[] arr2 = new String[arr.length+1];
			System.arraycopy(arr, 0, arr2, 0, index);
			System.arraycopy(arr, index-1, arr2, index, arr2.length-index);
			arr2[index] = elemento;
			return arr2;
		}
	}
	
	public static String[] eliminarElementoArregloString(String [] arr, String elemento) throws elementoNoEncontrado {
		int index = buscarElementoArregloStringInt(arr, elemento);
		String[] arrT = new String[arr.length-1];
		System.arraycopy(arr, 0, arrT, 0, index);
		System.arraycopy(arr, index+1, arrT, index, arr.length-index-1);
		return arrT;
	}
}
