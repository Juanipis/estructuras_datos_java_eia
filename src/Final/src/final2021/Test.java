package final2021;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		ArrayList<String> nombres = new ArrayList<>();
		nombres.add("Hola");
		nombres.add("Mundo");
		nombres.add("Bonito");
		nombres.add("Hermoso");
		System.out.println(nombres);
		Collections.reverse(nombres);
		System.out.println(nombres);
		
		int[][] matriz = {{1,2,3},{4,5,6,7},{4,5,6,7,10}};
		System.out.println(matriz[1].length);
	}

}
