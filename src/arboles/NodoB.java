package arboles;

public class NodoB<T extends Comparable<T>>{

	protected T llave;
	protected NodoB<T> padre;
	protected NodoB<T> hijoDer;
	protected NodoB<T> hijoIzq;
	
	public NodoB(T llave) {
		super();
		this.llave = llave;
		this.hijoDer = null;
		this.hijoIzq = null;
		this.padre = null;
	}
	
	public NodoB(T llave, NodoB<T> hijoIzq, NodoB<T> hijoDer, NodoB<T> padre) {
		super();
		this.llave = llave;
		this.hijoDer = hijoDer;
		this.hijoIzq = hijoIzq;
		this.padre = padre;
	}

	public void setLlave(T llave) {
		this.llave = llave;
	}

	public void setPadre(NodoB<T> padre) {
		this.padre = padre;
	}

	public void setHijoDer(NodoB<T> hijoDer) {
		if (hijoDer != null) 
			hijoDer.setPadre(this);
		this.hijoDer = hijoDer;
	}

	public void setHijoIzq(NodoB<T> hijoIzq) {
		if (hijoIzq != null) 
			hijoIzq.setPadre(this);
		this.hijoIzq = hijoIzq;
	}

	public T getLlave() {
		return llave;
	}

	public NodoB<T> getPadre() {
		return padre;
	}

	public NodoB<T> getHijoDer() {
		return hijoDer;
	}

	public NodoB<T> getHijoIzq() {
		return hijoIzq;
	}
	
	public int altura(NodoB<T> n) {
		if (n == null) return -1;
		int altDer = (n.getHijoDer() == null)? 0: 1 + altura(n.getHijoDer());
		int altIzq = (n.getHijoIzq() == null)? 0: 1 + altura(n.getHijoIzq());
		return Math.max(altDer, altIzq);

	}
	
	public int altura() {
		return altura(this);
	}
	
	public int FE(){//calcula FEP de un nodo
		return altura(this.getHijoDer()) - altura(this.getHijoIzq());
	}
	
}
