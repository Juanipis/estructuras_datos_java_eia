package listasPilasColas;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;


public class ColasPrioridad2 {

	public static void main(String[] args) throws InterruptedException {
		ComparadorCola comparador = new ComparadorCola();
		PriorityQueue<PersonaCola> pq = new PriorityQueue<>(comparador);
		//En una cola de prioridad al comparar los elementos, estos se insertan
		//De primera si el comparador indica un numero menor a 0
		pq.add(new PersonaCola("Pepe", 1, false));
		TimeUnit.SECONDS.sleep(1);
		pq.add(new PersonaCola("Abel", 90, true));
		TimeUnit.SECONDS.sleep(1);
		pq.add(new PersonaCola("Aofia", 40, true));
		TimeUnit.SECONDS.sleep(1);
		pq.add(new PersonaCola("John Fredy",80));
		TimeUnit.SECONDS.sleep(1);
		pq.add(new PersonaCola("Marina", 100, true));
		TimeUnit.SECONDS.sleep(1);
		pq.add(new PersonaCola("Paola", 79, true));
		TimeUnit.SECONDS.sleep(1);
		pq.add(new PersonaCola("Ricardo",80));
		TimeUnit.SECONDS.sleep(1);
		pq.add(new PersonaCola("Andres",12));
		
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
		
		/*
		
		pq.add(new PersonaCola("Romulo", 16));ComparadorCola
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
	public int compare(PersonaCola aInsertar, PersonaCola yaEnCola) {
		//El elemento que ya esta en la cola es arg1
		//Si devuelve un numero >= 0 entonces va a insertar el elemento en la posicion de arg1
		
		if(arg0.getPrioridad() == arg1.getPrioridad()) {
			//Por orden de llegada
			if(arg0.getLlegada().after(arg1.getLlegada())) {
				return 1;
			}
			else {
				return -1;
			}
		}else {
			return arg0.getPrioridad()-arg1.getPrioridad();
		}
		
		
	}
	
}
