package listasPilasColas;

import java.util.Comparator;
import java.util.PriorityQueue;


public class ColasPrioridad2 {

	public static void main(String[] args) {
		ComparadorCola comparador = new ComparadorCola();
		PriorityQueue<PersonaCola> pq = new PriorityQueue<>(10,comparador);
		//En una cola de prioridad al comparar los elementos, estos se insertan
		//De primera si el comparador indica un numero menor a 0
		pq.add(new PersonaCola("Abel", 90, true));
		pq.add(new PersonaCola("Aofia", 40, true));
		pq.add(new PersonaCola("John Fredy",80));
		pq.add(new PersonaCola("Marina", 100, true));
		pq.add(new PersonaCola("Paola", 79, true));
		
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
		
		/*
		
		pq.add(new PersonaCola("Romulo", 16));
		pq.add(new PersonaCola("Ana", 70));
		pq.add(new PersonaCola("John Fredy",80));
		pq.add(new PersonaCola("Marcos", 90));
		pq.add(new PersonaCola("Noguera", 999));
		pq.add(new PersonaCola("Sigifredo", 90 ));
		pq.add(new PersonaCola("Carlos",22));
		*/
		
		

	}

}

class ComparadorCola implements Comparator<PersonaCola>{

	@Override
	public int compare(PersonaCola arg0, PersonaCola arg1) {
		//El elemento que ya esta en la cola es arg1
		//Si devuelve un numero >= 0 entonces va a insertar el elemento en la posicion de arg1
		
		return arg0.getPrioridad()-arg1.getPrioridad();
		
	}
	
}
