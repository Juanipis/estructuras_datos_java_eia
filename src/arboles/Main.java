package arboles;

import test.Persona;

public class Main {
	public static void main(String[] args) {
		NodoB<Integer> n1 = new NodoB<>(10);
		NodoB<Integer> n2 = new NodoB<>(7);
		NodoB<Integer> n3 = new NodoB<>(15);
		NodoB<Integer> n4 = new NodoB<>(5);
		NodoB<Integer> n5 = new NodoB<>(9);
		NodoB<Integer> n6 = new NodoB<>(12);
		NodoB<Integer> n20 = new NodoB<>(20);
		
		/*
		n1.setHijoIzq(n2);
		n1.setHijoDer(n3);
		
		n2.setHijoIzq(n4);
		n2.setHijoDer(n5);
		n3.setHijoIzq(n6);
		n4.setHijoDer(n20);
		
		Arbol<Integer> arbol = new Arbol<>(n1);
		System.out.println("Preorden");
		arbol.preorden();
		System.out.println("------\nPosorden");
		arbol.posorden();
		System.out.println("------\nInorden");
		arbol.inorden();
		*/
		ArbolBinarioBusqueda<Integer> arbolBB = new ArbolBinarioBusqueda<>();
		try {
			arbolBB.insertNodo(5);
			arbolBB.insertNodo(2);
			arbolBB.insertNodo(3);
			arbolBB.insertNodo(1);
			arbolBB.insertNodo(9);
			arbolBB.insertNodo(7);
			arbolBB.insertNodo(8);
			arbolBB.insertNodo(6);
			arbolBB.insertNodo(4);
			arbolBB.insertNodo(10);
			arbolBB.insertNodo(15);
			arbolBB.insertNodo(16);
		} catch (ExeptionNodo e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Preorden");
		arbolBB.preorden();
		
		try {
			System.out.println(arbolBB.buscarElemento(16));
		} catch (ExeptionNodo e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
