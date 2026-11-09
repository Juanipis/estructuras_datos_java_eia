package ordenamientoExterno;

import java.util.ArrayList;
public class Polifasico {
	
	public static ArrayList<ArrayList<Integer>> divisionArray(ArrayList<Integer> arr){
		ArrayList<ArrayList<Integer>> arrDividido = new ArrayList<ArrayList<Integer>> ();
		ArrayList<Integer> arrTemp = new ArrayList<Integer>();
		for (int i = 0; i < arr.size(); i++) {
			arrTemp.add(arr.get(i));
			if( i < arr.size()-1  && arr.get(i) > arr.get(i+1)) {
				arrDividido.add( (ArrayList<Integer>) arrTemp.clone());
				arrTemp.clear();
			}
		}
		arrDividido.add( (ArrayList<Integer>) arrTemp.clone());
		return arrDividido;
	}
	
	public static ArrayList<ArrayList<Comparable>> divisionArrayComparable(ArrayList<Comparable> arr){
		ArrayList<ArrayList<Comparable>> arrDividido = new ArrayList<ArrayList<Comparable>> ();
		ArrayList<Comparable> arrTemp = new ArrayList<Comparable>();
		for (int i = 0; i < arr.size(); i++) {
			arrTemp.add(arr.get(i));
			if( i < arr.size()-1  && arr.get(i).compareTo(arr.get(i+1))>0) {
				arrDividido.add( (ArrayList<Comparable>) arrTemp.clone());
				arrTemp.clear();
			}
		}
		arrDividido.add( (ArrayList<Comparable>) arrTemp.clone());
		return arrDividido;
	}
}
