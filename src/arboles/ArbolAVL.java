package arboles;

public class ArbolAVL<E extends Comparable<E>> extends ArbolBinarioBusqueda<E> {
	public ArbolAVL(NodoBinario<E> raiz) {
		super(raiz);
	}

	public ArbolAVL() {
		super(null);
	}
	

	
	/// Hacer el de llamando la llave
	public void insertNodo(NodoBinario<E> n) throws ExeptionNodo {
		super.insertNodo(n);
		balancear(n);
	}

	public void insertNodo(E llaveN) throws ExeptionNodo {
		super.insertNodo(llaveN);
	}
	
	public void eliminarElemento(E n) throws ExeptionNodo {
		NodoBinario<E> nodo = this.buscarElemento(n);
		super.eliminarElemento(nodo.getLlave());
		balancear(nodo.getPadre());
	}

	public void balancear(NodoBinario<E> n) {
		NodoBinario<E> desb = desbalance(n);
		if (desb != null) {
			NodoBinario<E> p = desb.getPadre();
			if (desb.FE() > 0) {
				if (desb.getHijoDer().FE() >= 0) // Caso SimpleIzq FE
					desb = balanceSimpleIzq(desb);
				else
					desb = balanceDobleIzq(desb); // Caso DobleIzq FE
			} else if (desb.FE() < 0) {
				if (desb.getHijoIzq().FE() <= 0)
					desb = balanceSimpleDer(desb);
				else
					desb = balanceDobleDer(desb);
			}
			if (p == null)
				raiz = desb;
			else if (desb.getLlave().compareTo(p.getLlave()) > 0)
				p.setHijoDer(desb);
			else
				p.setHijoIzq(desb);
		}
	}

	public NodoBinario<E> desbalance(NodoBinario<E> n) {
		NodoBinario<E> nodo = n;
		while (nodo != null && Math.abs(nodo.FE()) <= 1) {
			nodo = nodo.getPadre(); // Voy cambiando de nodo de abajo hacia arriba hasta encontrar el desbalance
		}
		return nodo;
	}

	public NodoBinario<E> balanceSimpleIzq(NodoBinario<E> n) {
		NodoBinario<E> der = n.getHijoDer();
		der.setPadre(n.getPadre());
		n.setHijoDer(der.getPadre());
		der.setHijoIzq(n);
		return der;
	}

	public NodoBinario<E> balanceSimpleDer(NodoBinario<E> n) {
		NodoBinario<E> izq = n.getHijoIzq();
		izq.setPadre(n.getPadre());
		n.setHijoIzq(izq.getHijoDer());
		izq.setHijoDer(n);
		return izq;
	}

	public NodoBinario<E> balanceDobleDer(NodoBinario<E> n) {
		n.setHijoIzq(balanceSimpleIzq(n.getHijoIzq()));
		return balanceSimpleDer(n);
	}

	public NodoBinario<E> balanceDobleIzq(NodoBinario<E> n) {
		n.setHijoDer(balanceSimpleDer(n.getHijoDer()));
		return balanceSimpleIzq(n);
	}
}