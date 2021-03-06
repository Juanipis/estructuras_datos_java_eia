package ordenamiento;

import java.util.Arrays;
import java.util.Random;

public class PruebaDeOrdenamiento {

	public static void main(String[] args) {
		int N= 10000;
		Random r = new Random();
		Integer[] lista = new Integer[N];
		for(int i=0;i<N;i++) {
			lista[i] = r.nextInt(2*N);
			//lista[i] = N-i;
			//lista[i] = i;
		}
		try {
			
			Integer[] listaTemp = Arrays.copyOf(lista, lista.length);
			long timeinicio = System.currentTimeMillis();
			AlgoritmosOrdenamiento.bubblesSort(listaTemp);
			long timefin = System.currentTimeMillis();
			System.out.println("BubbleSort: " + (timefin-timeinicio));
			
			listaTemp = Arrays.copyOf(lista, lista.length);
			timeinicio = System.currentTimeMillis();
			AlgoritmosOrdenamiento.selectionSort(listaTemp);
			timefin = System.currentTimeMillis();
			System.out.println("SelectionSort: " + (timefin-timeinicio));
			
			listaTemp = Arrays.copyOf(lista, lista.length);
			timeinicio = System.currentTimeMillis();
			AlgoritmosOrdenamiento.insertSort(listaTemp);
			timefin = System.currentTimeMillis();
			System.out.println("InsertSort: " + (timefin-timeinicio));
			
			listaTemp = Arrays.copyOf(lista, lista.length);
			timeinicio = System.currentTimeMillis();
			AlgoritmosOrdenamiento.quickSort(listaTemp);
			timefin = System.currentTimeMillis();
			System.out.println("QuickSort: " + (timefin-timeinicio));
			
			/*
			listaTemp = Arrays.copyOf(lista, lista.length);
			timeinicio = System.currentTimeMillis();
			AlgoritmosOrdenamiento.quickSortRandomPivote(listaTemp);
			System.out.println(Arrays.toString(listaTemp));
			System.out.println(AlgoritmosOrdenamiento.ordenado(listaTemp));
			timefin = System.currentTimeMillis();
			System.out.println("QuickSort Random Pivote: " + (timefin-timeinicio));
			*/
			listaTemp = Arrays.copyOf(lista, lista.length);
			timeinicio = System.currentTimeMillis();
			Comparable [] arr = AlgoritmosOrdenamiento.mergeSort(listaTemp);
			//System.out.println(AlgoritmosOrdenamiento.ordenado(arr));
			timefin = System.currentTimeMillis();
			System.out.println("MergeSort: " + (timefin-timeinicio));
		}finally {
			
		}

	}

}
