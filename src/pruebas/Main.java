package pruebas;

import java.util.Arrays;

import ordenamiento.AlgoritmosOrdenamiento;



public class Main {

	public static void main(String[] args) {
		Comparable[] arr = {"0","1","2","3","4","5","6","7"};
		int[] arregloInt = {0,1,2,3,4,5};
		int i = 0;
		while(i< arregloInt.length-1) {
			i++;
		}
		System.out.println(i);
		
		int index = 5;
		int indexfin= 6;
		
		arr = AlgoritmosOrdenamiento.eliminarElementosArregloRangos(arr, index, indexfin);
		System.out.println(Arrays.toString(arr));
		/*
		String[] arrT = new String[arr.length-indexfin+index-1];
		System.out.println(arr.length);
		System.out.println(arr.length-indexfin+index-1);
		
		
		
		System.arraycopy(arr, 0, arrT, 0, index);
		System.arraycopy(arr, indexfin+1, arrT, index, arr.length-indexfin-1);
		
		System.out.println(Arrays.toString(arrT) );
		*/
	}

}
