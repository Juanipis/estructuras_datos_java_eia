package arboles;

public class NodoBinario<E extends Comparable<E>> {
	protected E llave;
	protected NodoBinario<E> hijoIzq;
	protected NodoBinario<E> hijoDer;
	protected NodoBinario<E> padre;
	
	public NodoBinario(E llave) {
		this.llave = llave;
		padre=null;
		hijoIzq=null;
		hijoDer=null;
	}

	public NodoBinario(E llave, NodoBinario<E> hijoIzq, NodoBinario<E> hijoDer, NodoBinario<E> padre) {
		super();
		this.llave = llave;
		this.hijoIzq = hijoIzq;
		this.hijoDer = hijoDer;
		this.padre = padre;
	}

	public E getLlave() {
		return llave;
	}

	public void setLlave(E llave) {
		this.llave = llave;
	}

	public NodoBinario<E> getHijoIzq() {
		return hijoIzq;
	}

	public void setHijoIzq(NodoBinario<E> hijoIzq) {
		if(hijoIzq!=null) {
			hijoIzq.setPadre(this);
		}
		this.hijoIzq = hijoIzq;
	}

	public NodoBinario<E> getHijoDer() {
		return hijoDer;
	}

	public void setHijoDer(NodoBinario<E> hijoDer) {
		if(hijoDer!=null) {
			hijoDer.setPadre(this);
		}
		this.hijoDer = hijoDer;
	}

	public NodoBinario<E> getPadre() {
		return padre;
	}

	public void setPadre(NodoBinario<E> padre) {
		this.padre = padre;
	}
	
	public int altura (NodoBinario<E> n) {
		if(n == null) return -1;
		int altder = (n.getHijoDer() == null ? 0:1 + altura(n.getHijoDer()));
		int altizq = (n.getHijoIzq() == null ? 0:1 + altura(n.getHijoIzq()));
		return Math.max(altder, altizq);
	}
	public int altura() {
		return altura(this);
	}
	
	public int FE() {
		return altura(this.getHijoDer())-altura(this.getHijoIzq());
	}
	
	public int FEP(){//calcula FEP de un nodo
		if (this.getHijoDer() != null && this.getHijoIzq() != null)
			return this.getHijoDer().altura() - this.getHijoIzq().altura();
		else if(this.getHijoDer() != null)
		return 1+this.getHijoDer().altura();//se le debe sumar 1 porque la altura no cuenta con el padre
		else if(this.getHijoIzq() != null)
		return -1-this.getHijoIzq().altura();//se le debe restar 1 porque la altura no cuenta con el padre
		else return 0;
		}
	
	@Override
	public String toString() {
		return "NodoB [llave=" + llave + "]";
	}

	
	
	
}
