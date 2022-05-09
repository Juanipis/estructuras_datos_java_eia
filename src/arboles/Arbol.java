package arboles;

import java.util.ArrayList;

public class Arbol<E extends Comparable<E>>  {
	protected NodoBinario<E> raiz;
	
	public Arbol(NodoBinario<E> raiz) {
		super();
		this.raiz = raiz;
	}
	public Arbol() {
		super();
		this.raiz = null;
	}
	
	public NodoBinario<E> getRaiz(){
		return raiz;
	}
	public void setRaiz(NodoBinario<E>raiz) {
		this.raiz = raiz;
	}
	
	//Metodos de recorrido
	
	//Preorden
	/* Algoritmo
	 * Raiz - Izquierda - Derecha */
	public void preorden() {
		preorden(raiz);
		System.out.println();
	}
	private void preorden(NodoBinario<E> r) {
		if(r!=null) {
			System.out.println(r.getLlave() + " ");
			preorden(r.getHijoIzq());
			preorden(r.getHijoDer());
		}
	}
	
	//Posorden
	/* Algoritmo
	 * Izquierda - Derecha -Raiz */
	public void posorden() {
		posorden(raiz);
		System.out.println();
	}
	private void posorden(NodoBinario<E> r) {
		if(r!=null) {
			posorden(r.getHijoIzq());
			posorden(r.getHijoDer());
			System.out.println(r.getLlave() + " ");

		}
	}
	//Inorden
	/* Algoritmo
	 * Izquierda - Raiz - Derecha  */
	public void inorden() {
		inorden(raiz);
		System.out.println();
	}
	private void inorden(NodoBinario<E> r) {
		if(r!=null) {
			inorden(r.getHijoIzq());
			System.out.println(r.getLlave() + " ");
			inorden(r.getHijoDer());
		}
	}
	
	//Por arreglos
	public ArrayList<NodoBinario<E>> preordenArr() {
		ArrayList<NodoBinario<E>> preOrden = new ArrayList<>();
		preordenArr(raiz, preOrden);
		return preOrden;
		
	}
	private void preordenArr(NodoBinario<E> r, ArrayList<NodoBinario<E>> preOrden) {
		if(r!=null) {
			preOrden.add(r);
			preordenArr(r.getHijoIzq(), preOrden);
			preordenArr(r.getHijoDer(), preOrden);
		}
	}
	
	public ArrayList<NodoBinario<E>>  inordenArr() {
		ArrayList<NodoBinario<E>> inOrden = new ArrayList<>();
		inordenArr(raiz, inOrden);
		return inOrden;
		
	}
	private void inordenArr(NodoBinario<E> r, ArrayList<NodoBinario<E>> inOrden) {
		if(r!=null) {
			inordenArr(r.getHijoIzq(), inOrden);
			inOrden.add(r);
			inordenArr(r.getHijoDer(), inOrden);
		}
	}
	

}
