package arboles;

public class ArbolBinarioBusqueda<E extends Comparable<E>> extends Arbol<E> {

	public ArbolBinarioBusqueda() {
		super(null);
	}

	public ArbolBinarioBusqueda(NodoB<E> raiz) {
		super(raiz);
	}
	
	public void insertNodo(E llaveN) throws ExeptionNodo {
		raiz=insertNodo(new NodoB<E>(llaveN), raiz);
		
	}
	public void insertNodo(NodoB<E> n) throws ExeptionNodo {
		raiz=insertNodo(n, raiz);
		
	}

	protected NodoB<E> insertNodo(NodoB<E> n, NodoB<E> r) throws ExeptionNodo {
		if(r==null) {
			r=n;
		}else {
			if(n.getLlave().compareTo(r.getLlave())<0) {
				r.setHijoIzq(insertNodo(n,r.getHijoIzq()));
			}
			if(n.getLlave().compareTo(r.getLlave())>0) {
				r.setHijoDer(insertNodo(n,r.getHijoDer()));
			}
			if(n.getLlave().compareTo(r.getLlave())==0) {
				throw new ExeptionNodo();
			}
		}
		return r;
	}
}

class ExeptionNodo extends Exception{
	public ExeptionNodo() {
		super("Nodo ya existe");
	}
}
