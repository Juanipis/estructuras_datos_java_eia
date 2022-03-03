package recursividad;

public class Main {
	public static void main(String [] args) {
		//Obtiene el mayor numero entre
		int[] V = {3,6,-10,9999,1,12,25};
		System.out.println(Metodos.Recursivo(V, 0, 4));
		
		int[] arr = {1,2,3,4,5};
		try {
			System.out.println(Metodos.sumaArregloDivideVeceras(arr));
		} catch (ArregloVacio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long time_start = System.currentTimeMillis();
		System.out.println(Metodos.fibonacciIter(10));
		long time_end = System.currentTimeMillis();
		System.out.println("Iterativo: Tiempo usado = " + (time_end-time_start));
		
		time_start = System.currentTimeMillis();
		System.out.println(Metodos.fibonacciRecursivo(10));
		time_end = System.currentTimeMillis();
		System.out.println("Recursivo: Tiempo usado = ");
		System.out.println(time_end-time_start);
		/*
		try {
			System.out.println(Metodos.reversoCadena(""));
		} catch (ArregloVacio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*
		try {
			System.out.println(Metodos.comprobarParImpar(0));
		} catch (NumeroCero e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*
		String frase = "somos somos";
		try {
			System.out.println(Metodos.comprobarPalindromo(frase));
		} catch (ArregloVacio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*
		long fnumero;
		try {
			fnumero = Metodos.factorial(44);
			System.out.println(fnumero);
		} catch (NumeroNegativo e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		long snumero;
		try {
			snumero = Metodos.sumatoria(20);
			System.out.println(snumero);
		} catch (NumeroNegativo e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		try {
			long sumaArreglo = Metodos.sumaArreglo(new int[] {1});
			System.out.println(sumaArreglo);
		} catch (ArregloVacio e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		try {
			int arregloMax = Metodos.mayorArreglo(new int[] {});
			System.out.println(arregloMax);
		} catch (ArregloVacio e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
}
