package listasPilasColas;

import java.util.Stack;

public class Encriptado {
	
	public static String codificarFase1(String mensaje) {
		StringBuilder result = new StringBuilder();
		Stack<Character> pila = new Stack<>();
		int indexLetter = 0;
		while(indexLetter < mensaje.length()) {
			if(vocal(mensaje.charAt(indexLetter))) {
				result.append(mensaje.charAt(indexLetter));
				indexLetter++;
				while(indexLetter < mensaje.length() && !vocal(mensaje.charAt(indexLetter))) {
					pila.add(mensaje.charAt(indexLetter));
					indexLetter++;
				}
				while(!pila.empty()) {
					result.append(pila.pop());
				}
			}
			else {
				while(indexLetter < mensaje.length() && !vocal(mensaje.charAt(indexLetter))) {
					pila.add(mensaje.charAt(indexLetter));
					indexLetter++;
				}
				while(!pila.empty()) {
					result.append(pila.pop());
				}
			}
		}
		return result.toString();
	}
	
	public static String codificarFase2(String mensaje) {
		StringBuilder result = new StringBuilder();
		for(int i = mensaje.length()-1; i >=0; i--) {
			result.append(mensaje.charAt(i));
		}
		return result.toString();
	}
	
	public static String codificar(String mensaje) {
		return codificarFase2(codificarFase1(mensaje));
	}
	public static String deCodificar(String mensaje) {
		return codificarFase2(codificarFase1(mensaje));
	}
	
	
	public static boolean vocal(char letter) {
		char[] vocales = {'a','e','i','o','u'};
		int index = 0;
		while(index < 5 && vocales[index] != Character.toLowerCase(letter)) index++;
		return (index < 5 && vocales[index] == Character.toLowerCase(letter)) ? true:false;
		
	}
}

