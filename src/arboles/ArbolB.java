package arboles;

import java.util.*;

public class ArbolB<T extends Comparable<T>> {
	
	protected NodoB<T> raiz;

	public ArbolB (NodoB<T> raiz) {
		this.raiz = raiz;
	}
	
	public NodoB<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoB<T> raiz) {
		this.raiz = raiz;
		
	}
	
	/*
	public void preorden() {
		System.out.print("Preorden: ");
		preorden(raiz);
		System.out.println();
	}
	
	public void preorden(NodoB<T> raiz) {
		if (raiz != null) {
			System.out.print(raiz.getLlave() + " ");
			preorden(raiz.getHijoIzq());
			preorden(raiz.getHijoDer());
		}
	}
	*/
	
	public ArrayList<T> preOrden(){
		return preOrden(raiz, new ArrayList<T>());
	}
	
	public ArrayList<T> preOrden(NodoB<T> n, ArrayList<T> lista){
		if (n != null) {
			lista.add(n.getLlave());
			preOrden(n.getHijoIzq(), lista);
			preOrden(n.getHijoDer(), lista);	
		}
		return lista;
	}
	
	/*
	public void postorden (){
		System.out.print("Postorden: ");
		postorden(raiz);
		System.out.println();
	}
	
	public void postorden (NodoB<T> raiz) {
		if (raiz != null) {
			postorden(raiz.getHijoIzq());
			postorden(raiz.getHijoDer());
			System.out.print(raiz.getLlave() + " ");
		}
	}
	*/
	
	public ArrayList<T> postOrden(){
		return postOrden(raiz, new ArrayList<T>());
	}
	
	public ArrayList<T> postOrden(NodoB<T> n, ArrayList<T> lista){
		if (n != null) {
			postOrden(n.getHijoIzq(), lista);
			postOrden(n.getHijoDer(), lista);
			lista.add(n.getLlave());
		}
		return lista;
	}
	
	/*
	public void inorden () {
		System.out.print("Inorden: ");
		inorden(raiz);
		System.out.println();
	}
	
	public void inorden (NodoB<T> raiz) {
		if (raiz != null) {
			inorden(raiz.getHijoIzq());
			System.out.print(raiz.getLlave() + " ");
			inorden(raiz.getHijoDer());
		}
	}
	*/
	
	public ArrayList<T> inorden(){
		return inorden(raiz, new ArrayList<T>());
	}
	
	public ArrayList<T> inorden(NodoB<T> n, ArrayList<T> lista){
		if (n != null) {
			inorden(n.getHijoIzq(), lista);
			lista.add(n.getLlave());
			inorden(n.getHijoDer(), lista);
		}
		return lista;
	}
	
	//queda propuesto hacer el preorden, postorden e inorden pero que devuelva un ArrayList de los Nodos en ese orden
	//Hacer un algoritmo que duevuelva el arbol teniendo la lista indorden y la lista preorden, para probar usar cualquier arbol
	//pero se recomienda el del cuaderno
	//
	
	/*
	public void construirArbol(ArrayList<T> inorden, ArrayList<T> preorden) {//se construye un arbol con lista inorden y lista preorden
		raiz = new NodoB<T>(preorden.get(0));
		construirArbol(inorden, preorden, raiz, 0, inorden.indexOf(preorden.get(0)));
	}
	
	public void construirArbol(ArrayList<T> inorden, ArrayList<T> preorden, NodoB<T> n, int posP, int posI) {//se construye un arbol con lista inorden y lista preorden
		if (posP == preorden.size() || posI == inorden.size())
			return;
		else if (inorden.indexOf(preorden.get(posP+1)) < posI) {
			NodoB<T> aux = new NodoB<T>(preorden.get(posP+1));
			n.setHijoIzq(aux);
			posI = inorden.indexOf(posP+1);
			construirArbol(inorden, preorden, aux, posP+1, posI);
			while () {
				
			}
		
		}
	}
	*/
	
	public static void main(String[] args) {
		
		ArrayList<Integer> inorden = new ArrayList<Integer>();
		inorden.add(2); inorden.add(6); inorden.add(15); inorden.add(7); inorden.add(3); inorden.add(21); inorden.add(8); inorden.add(20); inorden.add(11); inorden.add(1); inorden.add(36); inorden.add(10); inorden.add(4); inorden.add(9); 
		ArrayList<Integer> preorden = new ArrayList<Integer>();
		preorden.add(20); preorden.add(15); preorden.add(2); preorden.add(6); preorden.add(3); preorden.add(7); preorden.add(8); preorden.add(21); preorden.add(36); preorden.add(11); preorden.add(1); preorden.add(10); preorden.add(9); preorden.add(4);		

	}
	
}
