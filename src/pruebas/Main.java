package pruebas;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		int[] numeros = {12,5,20,4,9,68,21,14};
		
		//Para eliminar de un arreglo desde posición especifica, eliminamos el del index 5, es decir, el numero 68
		int index = numeros.length-1;
		int[] temp = new int[numeros.length-1];
		//Copiamos hasta index-1
		System.arraycopy(numeros, 0, temp, 0, index);
		
		System.arraycopy(numeros, index+1, temp, index, numeros.length-index-1);
		
		
		
		//El pc funciona
		for(int n: temp) {
			System.out.println(n);
		}
		
		Date dia = new Date();
		Date dia2 = new Date(dia.getYear(), dia.getMonth(), dia.getDay()+90);
		System.out.println(dia);
		System.out.println(dia2);
		
	}

}
