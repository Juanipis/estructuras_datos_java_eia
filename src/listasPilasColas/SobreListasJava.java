package listasPilasColas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class SobreListasJava {
	public static <E> void printList(ArrayList<E> list) {
		for(E e:list) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Pedro");
		lista.add("Olga");
		lista.add("Miguel");
		lista.add("Pana");
		lista.add("Ramón");
		lista.add("Olga");
		lista.add("Olga");
		lista.add("Olga");
		lista.add("Pana");
		lista.add("Pana");
		printList(lista);
		
		//Para eliminar elementos
		//Con for clasico la lista cambia de tamaño, por lo cual el indice se a
		ArrayList<String> listaTemp =(ArrayList<String>) lista.clone();
		for (int i = 0; i < listaTemp.size(); i++) {
			if(listaTemp.get(i).compareTo("Pana")==0) {
				listaTemp.remove(i);
				i--;
			}
		}
		lista = listaTemp;
		System.out.println(lista);
		//Con iterator
		ListIterator<String> it = lista.listIterator();
		String e;
		while(it.hasNext()) {
			e=it.next();
			if(e.compareTo("Olga")==0) {
				it.remove();
			}
		}
		System.out.println("-----------");
		System.out.println(lista);
	}
}
