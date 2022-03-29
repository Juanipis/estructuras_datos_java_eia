package ordenamiento;

public class AlgoritmosOrdenamiento {

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

}
