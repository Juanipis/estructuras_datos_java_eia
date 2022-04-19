package listasPilasColas;

import java.util.Comparator;
import java.util.PriorityQueue;

import ordenamiento.Persona;

public class ColasPrioridad {
	public Comparator<Persona> compPersonasNE = new Comparator<Persona>() {
		@Override
		public int compare(Persona o1, Persona o2) {
			return (o1.getNombre().compareTo(o2.getNombre())==0)?
					o1.getEdad()-o2.getEdad():o1.getNombre().compareTo(o2.getNombre());
		}
	};
	
	public static void main(String[] args) {
		Comp comp1 = new Comp();
		Comp2 comp2 = new Comp2("Juan");
		PriorityQueue<Persona> pq = new PriorityQueue<>(comp1);
		pq.add(new Persona("Juan", 20));
		pq.add(new Persona("Juan", 16));
		pq.add(new Persona("Abel", 20));
		pq.add(new Persona("Ana", 20));
		pq.add(new Persona("Abel", 15));
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		System.out.println("-------");
		PriorityQueue<Persona> pq1 = new PriorityQueue<>(comp2);
		pq1.add(new Persona("Juan", 20));
		pq1.add(new Persona("Juan", 16));
		pq1.add(new Persona("Abel", 20));
		pq1.add(new Persona("Ana", 20));
		pq1.add(new Persona("Abel", 15));
		while(!pq1.isEmpty()) {
			System.out.println(pq1.poll());
		}
		/*//Para enteros
		PriorityQueue<Integer> pqInt = new PriorityQueue<>();
		pqInt.add(21);
		pqInt.add(2);
		pqInt.add(-100);
		pqInt.add(88);
		while(!pqInt.isEmpty()) {
			System.out.println(pqInt.poll());
		}
		 */
	}

}
class Comp implements Comparator<Persona>{

	@Override
	public int compare(Persona arg0, Persona arg1) {
		// TODO Auto-generated method stub
		return arg0.getNombre().compareTo(arg1.getNombre());
	}
	
}

class Comp2 implements Comparator<Persona>{
	private String tipo;
	public Comp2(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public int compare(Persona arg0, Persona arg1) {
		if(tipo.compareTo("nombre")==0) {
			return arg0.getNombre().compareTo(arg1.getNombre());
		}else {
			return arg0.getEdad()-arg1.getEdad();
		}
	}
}