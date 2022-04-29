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
	
	public E buscarElemento(E llave) throws ExeptionNodo {
		return buscarElemento(llave, this.raiz);
	}
	
	protected E buscarElemento(E llave, NodoB<E> nodo) throws ExeptionNodo {
		
		if(raiz != null) {
			//Si el elemento raiz es el buscado
			if(nodo.getLlave().compareTo(llave) ==0) {
				return nodo.getLlave();
			}
			//Si el elemento es menor que la raiz
			if(llave.compareTo(nodo.getLlave()) < 0 && nodo.getHijoIzq() !=null) {
				return buscarElemento(llave, nodo.getHijoIzq());
			}
			// Si el elemento es mayor que la raiz
			if(llave.compareTo(nodo.getLlave()) > 0 && nodo.getHijoDer() !=null) {
				return buscarElemento(llave, nodo.getHijoDer());
			}
			else {
				throw new ExeptionNodo("No se encontro el elemento");
			}
			
		}
		else {
			throw new ExeptionNodo("No se encontro el elemento");
		}
		
	}
}

class ExeptionNodo extends Exception{
	public ExeptionNodo() {
		super("Nodo ya existe");
	}
	public ExeptionNodo(String msg) {
		super(msg);
	}
}
