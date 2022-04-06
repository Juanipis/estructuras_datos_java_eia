package listasPilasColas;

import ordenamiento.Persona;

public class Main {

	public static void main(String[] args) {
		/*
		Nodo<Persona> nodo1 = new Nodo<Persona>(new Persona("Pedro",12));
		nodo1.setCabecera(new Persona("Juan",12));
		nodo1.getCabecera().setCabecera(new Persona("Mariana", 20));
		System.out.println(nodo1.getCabecera().tieneCabecera());
		System.out.println(nodo1.getCabecera().getCuerpo());
		*/
		
		Lista<Persona> lista1 = new Lista<Persona>();
		lista1.add(new Persona("Juan",15));
		lista1.add(new Persona("Fransisco",29));
		lista1.add(new Persona("Mariana",11));
		
		
		lista1.insert(new Persona("Peter Parker",17), 0);
		System.out.println("------------");
		lista1.printLista();
		System.out.println("El indice de " + lista1.getObject(lista1.getIndex(new Persona("Fransisco",29))) + " es: " + lista1.getIndex(new Persona("Fransisco",29)));
		System.out.println("El indice de " + lista1.getObject(lista1.getIndex(new Persona("Fransisco",30))) + " es: " + lista1.getIndex(new Persona("Fransisco",30)));
		System.out.println("----------------");
		System.out.println("Vamos a eliminar a Fransisco");
		lista1.remove(lista1.getIndex(new Persona("Fransisco",29)));
		lista1.printLista();
		System.out.println("    ***    ");
		lista1.remove(lista1.getIndex(new Persona("Mariana",11)));
		System.out.println("Ahora a Mariana");
		lista1.printLista();
		System.out.println("----------------");
		
		lista1.insert(new Persona("Akire",9), 1);
		lista1.printLista();
		lista1.clear();
		System.out.println("Limpiamos lista :" + (lista1.getNodo() == null));
		lista1.add(new Persona("Juan",15));
		lista1.printLista();
		System.out.println("Lista tiene a Juan :" + lista1.contains(new Persona("Juan",15)));
		
	}

}
