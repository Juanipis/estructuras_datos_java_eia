package repasoParcial;

import java.util.Arrays;

public class Main {
	public static void main(String [] args) {
		String[] arr = {"Hola"};
		/*
		try {
			arr = MetodosMatrices.adicionarElementoPosicionArregloString(arr, "Mundo", 0);
		} catch (indexNegativoArreglo e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			arr = MetodosMatrices.eliminarElementoArregloString(arr, "Hola");
			System.out.println(Arrays.toString(arr));
		} catch (elementoNoEncontrado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		/*
		arr = MetodosMatrices.adicionarElementoFinalArregloString(arr, "hola");
		System.out.println(Arrays.toString(arr));
		*/
		
		try {
			arr = MetodosMatrices.adicionarElementoPosicionArregloString(arr, "Mundo",10 );
		} catch (indexNegativoArreglo e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Arrays.toString(arr));
		/*
		try {
			System.out.println(arr[MetodosMatrices.buscarElementoArregloStringInt(arr, "mundo")]);
		} catch (elementoNoEncontrado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(MetodosMatrices.contarNullsArreglo(arr));
		
		arr = MetodosMatrices.eliminarNullsArreglo(arr);
		System.out.println(Arrays.toString(arr));
		*/
	}
}
