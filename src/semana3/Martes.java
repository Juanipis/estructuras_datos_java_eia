package semana3;

import java.util.Arrays;

public class Martes {

	public static char[] devolverVocales(String txt) {
		
		String vocales ="a�e�i�o�u�";
		char[] result = new char[0];

		for (int i = 0; i < txt.length(); i++) {
			if(vocales.contains(String.valueOf(txt.toLowerCase().charAt(i)))) {
				result = Arrays.copyOf(result, result.length+1);
				result[result.length-1] = txt.charAt(i);
			}
		}
		
		return result;
	}
	
	public static char[] devolverVocalesSinRepetir(String txt) {
		String vocales ="A�a�E�e�I�i�O�o�U�u�";
		String resultString = "";
		
		for (int i = 0; i < txt.length(); i++) {
			if(vocales.contains(String.valueOf(txt.charAt(i))) && !resultString.contains(String.valueOf(txt.charAt(i)))) {
				resultString += txt.charAt(i);
			}
		}
		
		//Convertimos resultString en char[];
		return resultString.toCharArray();
		
		
		
		
	}
}
