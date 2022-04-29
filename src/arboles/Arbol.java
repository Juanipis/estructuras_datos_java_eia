package arboles;

public class Arbol<E extends Comparable<E>>  {
	protected NodoB<E> raiz;
	
	public Arbol(NodoB<E> raiz) {
		super();
		this.raiz = raiz;
	}
	public Arbol() {
		super();
		this.raiz = null;
	}
	
	public NodoB<E> getRaiz(){
		return raiz;
	}
	public void setRaiz(NodoB<E>raiz) {
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
	private void preorden(NodoB<E> r) {
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
	private void posorden(NodoB<E> r) {
		if(r!=null) {
			posorden(r.getHijoIzq());
			posorden(r.getHijoDer());
			System.out.println(r.getLlave() + " ");

		}
	}
	//Posorden
	/* Algoritmo
	 * Izquierda - Raiz - Derecha  */
	public void inorden() {
		inorden(raiz);
		System.out.println();
	}
	private void inorden(NodoB<E> r) {
		if(r!=null) {
			inorden(r.getHijoIzq());
			System.out.println(r.getLlave() + " ");
			inorden(r.getHijoDer());
		}
	}
	
}