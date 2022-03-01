package recursividad;

public class Main {
	public static void main(String [] args) {
		//Obtiene el mayor numero entre
		int[] V = {3,6,-10,9999,1,12,25};
		System.out.println(Metodos.Recursivo(V, 0, 4));
		
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
		String frase = "";
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
