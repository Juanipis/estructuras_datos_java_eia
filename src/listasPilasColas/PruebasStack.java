package listasPilasColas;

import java.util.Stack;

public class PruebasStack {

	
	public static void main(String [] args) {
		String palabra = "PROBLEMAS HIPER-INTERESANTES.O";
		System.out.println(palabra);
		String codificado = Encriptado.codificar(palabra);
		System.out.println(codificado);
		String decodificado = Encriptado.deCodificar(codificado);
		System.out.println(decodificado);
		
	}

}
