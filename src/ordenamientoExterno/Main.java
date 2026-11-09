package ordenamientoExterno;

import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		arr.add(1);arr.add(2);arr.add(5);arr.add(3);arr.add(4);arr.add(6);arr.add(1);arr.add(2);arr.add(3);arr.add(4);arr.add(99);
		ArrayList<ArrayList<Integer>> arrDividido = Polifasico.divisionArray(arr);
		System.out.println(arrDividido.subList(0, 2));
		System.out.println(arrDividido.subList(2, 3));
	}
}
