package recursividad;

public class Metodos {
	public static long factorial(long n) throws NumeroNegativo {
		if(n<0) {
			throw new NumeroNegativo(n);
		}
		if(n==1 || n==0) {
			return 1;
		}else {
			return n*Metodos.factorial(n-1);
		}
	}
	
	public static long sumatoria(long n) throws NumeroNegativo {
		if(n < 0) {
			throw new NumeroNegativo(n);
		}
		else if(n == 0) {
			return 0;
		}
		else if(n == 1 ) {
			return 1;
		}else{
			return n+Metodos.sumatoria(n-1);
		}
	}
	
	public static long sumaArreglo(int[] arreglo) throws ArregloVacio {
		int n = 0;
		if(arreglo.length == 1) {
			return arreglo[0];
		}
		else if(n < arreglo.length) {
			return arreglo[0]+Metodos.sumaArrego(arreglo, n+1);
		}else {
			throw new ArregloVacio();
		}
	}
	private static long sumaArrego(int[] arreglo, int pos) {
		if(pos == arreglo.length-1) {
			return arreglo[pos];
		}else {
			return arreglo[pos]+ Metodos.sumaArrego(arreglo, pos+1);
		}
	}
	public static int mayorArreglo(int[] arr) throws ArregloVacio {
		if(arr.length == 0) {
			throw new ArregloVacio();
		}else if(arr.length == 1) {
			return arr[0];
		}else {
			return Math.max(arr[0], Metodos.mayorArreglo(arr, 1));
		}
	}
	private static int mayorArreglo(int[] arr, int n) {
		if(n == arr.length-1) {
			return arr[n];
		}else {
			return Math.max(arr[n], Metodos.mayorArreglo(arr, n+1));
		}
	}
}
class NumeroNegativo extends Exception{
	public NumeroNegativo(long num) {
		super("No es posible realizar la operación con el número: " + num + " porque es negativo");
	}
}
class ArregloVacio extends Exception{
	public ArregloVacio() {
		super("El arreglo no tiene elementos");
	}
}