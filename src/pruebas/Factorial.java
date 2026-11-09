package pruebas;

import java.math.BigInteger;

public class Factorial {
	public static int factorial(int numero) {
		if(numero == 1 || numero == 0){return 1;}
        else if(numero <0 ){return -1;}
        else if(numero <=0 ){return 0;}
		BigInteger resultado = new BigInteger(String.valueOf(numero));
		for(int i = numero-1; i>=1; i--) {
			resultado.multiply(BigInteger.valueOf(i));
		}
		return resultado.intValue();
	}
}
