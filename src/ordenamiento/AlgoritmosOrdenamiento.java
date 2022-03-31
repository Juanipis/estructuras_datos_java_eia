package ordenamiento;

import java.util.Arrays;
import java.util.Random;

public class AlgoritmosOrdenamiento {
	public static Random rnd = new Random();

	public static void bubblesSort(int [] a) {
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-1-i; j++) {
				if(a[j+1]<a[j]) {
					int temp=a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	public static void bubblesSort(Comparable [] a) {
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-1-i; j++) {
				if(a[j+1].compareTo(a[j])<0) {
					Comparable temp=a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	public static void selectionSort(Comparable[] a) {
		for (int i = 0; i < a.length-1; i++) {
			int im=i;
			for (int j = i+1; j < a.length; j++) {
				if(a[j].compareTo(a[im])<0) {
					im=j;
				}
			}
			Comparable temp = a[i];
			a[i] = a[im];
			a[im] = temp;
		}
	}
	
	public static void insertSort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			Comparable temp = a[i]; //El que quiero insertar
			int j=i;
			while(j>0 && temp.compareTo(a[j-1])<0) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = temp;
		}
	}
	
	public static boolean ordenado(Comparable[] a) { //De menor a mayor
		if(a.length == 0 || a.length == 1) return true;
		int index = 0;
		while(index<a.length-1 && a[index].compareTo(a[index+1]) <= 0) {
			index++;
		}
		return (index==a.length-1 && a[index-1].compareTo(a[index]) <= 0) ? true: false;
	}
	public static void quickSort(Comparable[] a) {
		quickSortr(a,0, a.length-1);
	}
	private  static void quickSortr(Comparable[] a, int inicio, int fin) {
		if(fin <= inicio) {
			return;
		}
		else {
			Comparable pivote = a[fin];
			int i = inicio-1;
			int j = fin;
			Comparable temp;
			while(i<j) {
				while(a[++i].compareTo(pivote)<0);
				while(j > inicio && pivote.compareTo(a[--j])<0);
				if(i<j) {
					temp=a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			temp=a[i];
			a[i]=a[fin];
			a[fin] = temp;
			int partition = i;
			quickSortr(a, inicio, partition-1);
			quickSortr(a, partition+1, fin);
		}
	}
	
	private  static void quickSortrRandomPivote(Comparable[] a, int inicio, int fin) {
		if(fin <= inicio) {
			return;
		}
		else {
			Comparable pivote = a[AlgoritmosOrdenamiento.rnd.nextInt(fin+1)];
			int i = inicio-1;
			int j = fin;
			Comparable temp;
			while(i<j) {
				while(a[++i].compareTo(pivote)<0);
				while(j > inicio && pivote.compareTo(a[--j])<0);
				if(i<j) {
					temp=a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			temp=a[i];
			a[i]=a[fin];
			a[fin] = temp;
			int partition = i;
			quickSortr(a, inicio, partition-1);
			quickSortr(a, partition+1, fin);
		}
	}

	
	public static Comparable[] mergeSort(Comparable[] lista) {
		if(lista.length == 1 || lista.length == 0) {
			return lista;
		}
		else {
			Comparable[] lmitad1 = mergeSort(Arrays.copyOfRange(lista, 0, lista.length/2));
			Comparable[] lmitad2 = mergeSort(Arrays.copyOfRange(lista, lista.length/2, lista.length));
			return mergeListasOrdenadas(lmitad1, lmitad2);
		}
	}
	
	public static Comparable[] mergeListasOrdenadas(Comparable[] l1, Comparable[] l2) {
		// Se supone que ambas listas estan ordenadas
		Comparable[] lsO = new Comparable[l1.length + l2.length];
		int indexl1 = 0;
		int indexl2 = 0;
		int indexlsO = 0;
		while(indexl1 < l1.length || indexl2 < l2.length ) {
			if(indexl1< l1.length && indexl2 == l2.length) { // Si ya llenamos la lista l2, simplemente agregamos a la lista
				lsO[indexlsO++] = l1[indexl1++];
			}
			else if(indexl1 == l1.length && indexl2 < l2.length) { // Si ya llenamos la lista l1, simplemente agregamos a la lista
				lsO[indexlsO++] = l2[indexl2++];
			}
			else{ //Puede suceder que el de l1 sea mayor o menor
				if(l1[indexl1].compareTo(l2[indexl2])<0) { //Si el elmento de la lista l1 es menor al de la lista l2
					lsO[indexlsO++] = l1[indexl1++];
				}
				else { //Si el elmento de la lista l1 es mayor al de la lista l2
					lsO[indexlsO++] = l2[indexl2++];
				}
			}
		}
		return lsO;
	}

}
