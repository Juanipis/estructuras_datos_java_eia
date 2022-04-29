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
	
	public NodoB<E> buscarElemento(E llave) {
		return buscarElemento(llave, this.raiz);
	}
	
	
	protected NodoB<E> buscarElemento(E llave, NodoB<E> nodo) {
		
		if(raiz != null) {
			//Si el elemento raiz es el buscado
			if(nodo.getLlave().compareTo(llave) ==0) {
				return nodo;
			}
			//Si el elemento es menor que la raiz
			else if(llave.compareTo(nodo.getLlave()) < 0 && nodo.getHijoIzq() !=null) {
				return buscarElemento(llave, nodo.getHijoIzq());
			}
			// Si el elemento es mayor que la raiz
			else if(llave.compareTo(nodo.getLlave()) > 0 && nodo.getHijoDer() !=null) {
				return buscarElemento(llave, nodo.getHijoDer());
			}
			else {
				return null;
			}
			
		}
		else {
			return null;
		}	
	}
	
	public void eliminarElemento(E llave) {
		NodoB<E> nodoEliminar = buscarElemento(llave);
		
		if(nodoEliminar != null) {
			//Caso 1 ¿Es hoja?
			if(nodoEliminar.hijoIzq == null && nodoEliminar.hijoDer == null) {
				//Es raiz?
				if(nodoEliminar.padre == null) {
					this.setRaiz(null);
				}
				//Es izquierda?
				else if(nodoEliminar.padre.hijoIzq != null && nodoEliminar.padre.hijoIzq.equals(nodoEliminar)) {
					nodoEliminar.padre.setHijoIzq(null);
				}
				//Es derecha?
				else{
					nodoEliminar.padre.setHijoDer(null);
				}
			}
			//Caso 2 ¿Solo tiene un hijo?
			//Si solo tiene el hijoIzq
			else if(nodoEliminar.hijoIzq != null && nodoEliminar.hijoDer == null) {
				//Es la raiz?
				if(nodoEliminar.padre == null) {
					this.setRaiz(nodoEliminar.hijoIzq);
				}
				else {
					nodoEliminar.padre.setHijoIzq(nodoEliminar.hijoIzq);
				}
			}
			else if(nodoEliminar.hijoDer != null && nodoEliminar.hijoIzq == null) {
				//Es la raiz?
				if(nodoEliminar.padre == null) {
					this.setRaiz(nodoEliminar.hijoDer);
				}
				else {
					nodoEliminar.padre.setHijoDer(nodoEliminar.hijoDer);
				}
			}
			
			//Caso 3 ¿Tiene dos hijos?
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
