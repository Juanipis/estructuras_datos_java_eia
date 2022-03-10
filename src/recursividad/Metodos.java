package recursividad;

import java.math.BigInteger;
import java.util.Arrays;

import semana2.Trabajador;

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
	
	public static long fibonacciIter(long n) {
		long anterior = 0;
		long actual = 1;
		for (int i = 1; i < n; i++) {
			actual+=anterior;
			anterior=actual-anterior;
		}
		return actual;
	}
	
	public static long fibonacciRecursivo(long n) {
		if(n == 1 || n==0) {
			return n;
		}else {
			return fibonacciRecursivo(n-1)+fibonacciRecursivo(n-2);
		}
	}
	
	
	public static int sumaArregloDivideVeceras(int[] arreglo) throws ArregloVacio {
		if(arreglo == null || arreglo.length == 0) {
			throw new ArregloVacio();
		}else {
			return Metodos.sumaArregloDivideVeceras(arreglo, 0, arreglo.length-1);
		}
		
	}
	
	private static int sumaArregloDivideVeceras(int[] arreglo, int i1, int i2) {
		if(i1==i2) {
			return arreglo[i1];
		}else {
			return Metodos.sumaArregloDivideVeceras(arreglo, i1, (i1+i2)/2)+Metodos.sumaArregloDivideVeceras(arreglo, (i1+i2)/2+1, i2); 
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
	
	public static boolean comprobarPalindromo(String frase) throws ArregloVacio {
		if(frase == null) {
			throw new ArregloVacio();
		}
		else if(frase.length() == 0) {
			throw new ArregloVacio();
		} else if(frase.length() == 1) {
			return true;
		}else {
			return Metodos.comprobarPalindromo(frase.toLowerCase().toCharArray(), 0, frase.length()-1);
		}
	}
	
	private static boolean comprobarPalindromo(char[] arr, int a, int b) { //a menor, b mayor
		if(b-a == 0 || b-a ==1) {
			return arr[a]==arr[b];
		}else {
			return arr[a]==arr[b] && Metodos.comprobarPalindromo(arr, a+1, b-1);
		}
	}
	
	public static boolean comprobarParImpar(int numero) throws NumeroCero {
		if(numero == 0) {
			throw new NumeroCero();
		}else {
			numero = (numero < 0) ? numero*-1:numero;
			return Metodos.comprobarParImparPos(0, numero);
		}
	}
	private static boolean comprobarParImparPos(int sumatoria, int numero) {
		if(numero-sumatoria == 0) {
			return true;
		}else if(numero-sumatoria == 1) {
			return false;
		}else {
			return Metodos.comprobarParImparPos(sumatoria+2, numero);
		}
	}
	
	public static String reversoCadena(String cadena) throws ArregloVacio {
		
		if(cadena == null) {
			throw new ArregloVacio();
		}
		
		else if(cadena.length() == 0) {
			throw new ArregloVacio();
		}
		else if(cadena.length() == 1) {
			return cadena;
		}
		else {
			return Metodos.reversoCadenaPos(cadena, cadena.length()-1);
		}
	}
	
	private static String reversoCadenaPos(String cadena, int pos) {
		if(pos == 0) {
			return cadena.charAt(pos)+"";
		}else {
			return cadena.charAt(pos)+Metodos.reversoCadenaPos(cadena, pos-1);
		}
	}
	
	public static int Recursivo(int[] V, int i1, int i2) {
		int aux1, aux2;
		if(i1==i2) {
			return V[i1];
		}else {
			aux1 = Metodos.Recursivo(V, i1, (i1+i2)/2);
			aux2 = Metodos.Recursivo(V, ((i1+i2)/2)+1, i2);
			if(aux1>aux2) {
				return aux1;
			}else {
				return aux2;
			}
		}
	}
	
	public static long fibonacciFast2(int n) {
		int actual=(n==0) ?0:1;
		return fibonacciFastR2(n,0,actual);
	}
	
	public static long fibonacciFastR2(int n, long anterior, long actual) {
		if(n<=1) {
			return actual;
		}
		return fibonacciFastR2(n-1, actual, actual+anterior);
	}
	
	public static BigInteger fibonacciFast3(int n) {
		int actual=(n==0) ?0:1;
		return fibonacciFastR3(n,new BigInteger("0"),new BigInteger(Integer.toString(actual)));
	}
	
	public static BigInteger fibonacciFastR3(int n, BigInteger anterior, BigInteger actual) {
		if(n<=1) {
			return actual;
		}
		return fibonacciFastR3(n-1, actual, new BigInteger(actual.toString()).add(anterior));
	}
	
	/*
	public static int[] arregloPares(int [] arr) {
		if(arr.length == 1) {
			if(arr[0]%2 ==0) {
				return new int[] {arr[0]};
			}else {
				return new int[0];
			}
		}else {
			if(arr[0]%2 ==0) {
				int[] arrT = arregloPares(Metodos.reduccion(0, arr));
				int[] arrPares = new int[arrT.length+1];
				arrPares[0]= arr[0];
				for(int i =1; i<arrT.length; i++) {
					arrPares[i] = arrT[i-1];
				}
				return arrPares;
			}else {
				return arregloPares(Metodos.reduccion(0, arr));
			}
		}
	}*/
	
	public static int[] arrPares(int[] arr) {
		return(Metodos.arregloPares(0, arr, new int[0]));
	}
	
	public static int[] arregloPares(int n, int[] arr, int[] pares) {
		if(n == arr.length-1) {
			if(arr[n]%2 == 0) {
				pares = Arrays.copyOf(pares, pares.length+1);
				pares[pares.length-1] = arr[n];
				
			}
			return pares;
		}
		else {
			if(n< arr.length && arr[n]%2 == 0) {
				pares = Arrays.copyOf(pares, pares.length+1);
				pares[pares.length-1] = arr[n];
			}
			return arregloPares(n+1, arr, pares);
		}
	}
	
	public static int[] reduccion(int index, int[] arr) {
		int[] temp = new int[arr.length-1];
		int arT = 0;
		int arO = 0;
		
		while(arT < temp.length) {
			if(arT == index) {
				arO++;
			}
			temp[arT] = arr[arO];
			arT++;
			arO++;
		}
		return temp;
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
class NumeroCero extends Exception{
	public NumeroCero() {
		super("No se puede hacer la operacion con el cero");
	}
}