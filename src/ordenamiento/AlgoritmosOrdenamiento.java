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
	
	public static void quickSortRandomPivote(Comparable[] a) {
		quickSortRandom(a,0, a.length-1);
	}
	
	private static void quickSortRandom(Comparable[] a, int inicio, int fin){
		Random r=new Random();
		if (fin <= inicio)
			return;
		else {//CAMBIO://El pivote se selecciona en una pocisión aleatoria
			int indexPivote=r.nextInt((fin-inicio))+inicio;
			//System.out.println("Pivote: "+ a[indexPivote]);
			Comparable pivote= a[indexPivote];
			int i = inicio-1;
			int j = fin+1; // //CAMBIO: Se cambia fin, para llamar con length-1
			Comparable temp;
			while (i< j) {//busca un elemento mayor que pivote, si no para en el pivote (el último)
		//CAMBIO: ADICIONAR i<fin y cambiar <0 por <=0 en ambos ciclos, para que salten el pivote
		while( i < fin && a[++i].compareTo(pivote)<=0);//se busca un elemento menor que el pivote, si no lo hay, para en el primero
		while( j > inicio && pivote.compareTo(a[--j])<=0 );
		if( i < j ){//se intercambian los elementos
		temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		}
		}//se sale del ciclo cuando la i>=j
		//La posición correcta del pivote depende de dónde quedaron la i y la j
		int partition=i;
		if (i>indexPivote)
		partition=j;
		if (i>=indexPivote && j<=indexPivote)
		partition=indexPivote;
		else{
		temp=a[partition];
		a[partition]=a[indexPivote]; // cambio
		a[indexPivote]=temp;
		}
		//Ordenamiento.printLista(a);
		quickSortRandom( a, inicio, partition-1 );
		quickSortRandom( a, partition+1, fin );
		}
		}

		//CAMBIO: Llamar con a.length.1
		public static void quickSortRandom(Comparable[] a){
		quickSortRandom(a, 0, a.length-1);
		}

	
	
	public static Comparable[] mergeSort(Comparable[] lista) {
		if(lista.length == 1 || lista.length == 0) {
			return lista;
		}
		else {
			return mergeListasOrdenadas(
					mergeSort(Arrays.copyOfRange(lista, 0, lista.length/2)), 
					mergeSort(Arrays.copyOfRange(lista, lista.length/2, lista.length)));
		}
	}
	
	
	
	public static Comparable[] mergeListasOrdenadas(Comparable[] l1, Comparable[] l2) {
		// Se supone que ambas listas estan ordenadas
		Comparable[] lsO = new Comparable[l1.length + l2.length];
		int indexl1 = 0;
		int indexl2 = 0;
		int indexlsO = 0;
		while(indexl1 < l1.length || indexl2 < l2.length ) {
			if(indexl2 == l2.length && indexl1< l1.length ) { // Si ya llenamos la lista l2, simplemente agregamos a la lista
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
	
	
	
	//Este merge es estable
	public static Comparable[] mergeSortO(Comparable[] lista) throws Exception {
		return mergeSortO(lista,0,lista.length-1);
	}
	private static Comparable[] mergeSortO(Comparable[] lista, int inicio, int fin) throws Exception {
		if(inicio==fin)
			return new Comparable[] {lista[inicio]};
		else {
			Comparable[] list1=mergeSortO(lista, inicio, (inicio+fin)/2);
			Comparable[] list2=mergeSortO(lista, (inicio+fin)/2+1, fin);
			return mergeOrdenandas(list1,list2);
		}
	}
	
	public static Comparable[] mergeOrdenandas(Comparable[] lista1, Comparable[] lista2) throws Exception{
		if (lista1== null || lista2==null)
		throw new Exception("Una lista es vacia");
		Comparable[] result= new Comparable[lista1.length+lista2.length];
		int i=0,j=0;
		while (i<lista1.length && j<lista2.length)
		result[i+j]=(lista1[i].compareTo(lista2[j])<=0)? lista1[i++]:lista2[j++];
		for(int k=i;k<lista1.length;k++)
		result[k+j]=lista1[k];
		for (int k=j;k<lista2.length;k++)
		result[k+i]=lista2[k];
		return result;
		}

}
