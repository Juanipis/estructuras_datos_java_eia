package recursividad;

public class Main {
	public static void main(String [] args) {
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
	}
}
