package arboles;

import java.util.ArrayList;

import test.Persona;

public class Main {
	public static void main(String[] args) {
		NodoBinario<Integer> n1 = new NodoBinario<>(10);
		NodoBinario<Integer> n2 = new NodoBinario<>(7);
		NodoBinario<Integer> n3 = new NodoBinario<>(15);
		NodoBinario<Integer> n4 = new NodoBinario<>(5);
		NodoBinario<Integer> n5 = new NodoBinario<>(9);
		NodoBinario<Integer> n6 = new NodoBinario<>(12);
		NodoBinario<Integer> n20 = new NodoBinario<>(20);
		
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
		ArrayList<Integer> pre = new ArrayList<>();
		ArrayList<Integer> in = new ArrayList<>();
		pre.add(5);pre.add(2);pre.add(1);pre.add(3);pre.add(4);pre.add(9);pre.add(7);pre.add(6);pre.add(8);pre.add(10);pre.add(15);pre.add(16);
		in.add(1);in.add(2);in.add(3);in.add(4);in.add(5);in.add(6);in.add(7);in.add(8);in.add(9);in.add(10);in.add(15);in.add(16);
//		System.out.println(pre);
//		System.out.println(in);
//		System.out.println(pre.subList(1, pre.indexOf(9))); //Para lado izquierdo, de 1 a el indice del hermano
//		System.out.println(in.subList(0, in.indexOf(5))); // de 0 hasta la raiz
//		System.out.println(pre.subList(pre.indexOf(9), pre.size())); // Para lado derecho desde el hijo derecha hasta el tamano
//		System.out.println(in.subList(in.indexOf(5)+1, in.size()));
		ArbolBinarioBusqueda<Integer> arbol= new ArbolBinarioBusqueda<>();
		arbol = arbol.crearArbol(pre, in);
		try {
			arbol = arbol.crearArbol(pre);
		} catch (ExeptionNodo e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(arbol.raiz);
		System.out.println(arbol.raiz.hijoIzq + " " + arbol.raiz.hijoDer);
		System.out.println(arbol.inordenArr());
		System.out.println(arbol.preordenArr());
		System.out.println(arbol.altura());
//		System.out.println("-------------");
//		System.out.println(arbolBB.buscarElemento(5));
		
		
//		System.out.println(arbolBB.buscarElemento(3));
//		arbolBB.eliminarElemento(3);
//		System.out.println(arbolBB.buscarElemento(4).getPadre());
//		System.out.println(arbolBB.buscarElemento(3));
//		ArbolBinarioBusqueda<Integer> arbolR = new ArbolBinarioBusqueda<>();
//		try {
//			arbolR.insertNodo(2);
//			System.out.println(arbolR.buscarElemento(2));
//			arbolR.eliminarElemento(2);
//			System.out.println(arbolR.buscarElemento(2));
//		} catch (ExeptionNodo e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}
