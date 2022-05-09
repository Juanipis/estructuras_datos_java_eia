package arboles;

import java.util.ArrayList;

public class ArbolBinarioBusqueda<E extends Comparable<E>> extends Arbol<E> {

	public ArbolBinarioBusqueda() {
		super(null);
	}

	public ArbolBinarioBusqueda(NodoBinario<E> raiz) {
		super(raiz);
	}
	
	public void insertNodo(E llaveN) throws ExeptionNodo {
		raiz=insertNodo(new NodoBinario<E>(llaveN), raiz);
		
	}
	
	protected void insertNodo(NodoBinario<E> n) throws ExeptionNodo {
		raiz=insertNodo(n, raiz);
		
	}

	protected NodoBinario<E> insertNodo(NodoBinario<E> n, NodoBinario<E> r) throws ExeptionNodo {
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
	
	public NodoBinario<E> buscarElemento(E llave) {
		return buscarElemento(llave, this.raiz);
	}
	
	
	protected NodoBinario<E> buscarElemento(E llave, NodoBinario<E> nodo) {
		
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
	
	public NodoBinario<E> buscarAntecesor(NodoBinario<E> n) throws ExeptionNodo{
		return (n.getHijoIzq()==null)? null: buscarMax(n.getHijoIzq());
	}
	
	private NodoBinario<E> buscarMax(NodoBinario<E> n) throws ExeptionNodo{
		return (n.getHijoDer()==null)? n: buscarMax(n.getHijoDer());
	}

	protected void eliminarElemento(E llave) throws ExeptionNodo {
		NodoBinario<E> nodoEliminar = buscarElemento(llave);
		
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
			//Si solo tiene el hijoDer
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
			//Vamos a buscar el elemento mas pequeno del subarbol derecho o izquierdo
			else if(nodoEliminar.hijoDer != null && nodoEliminar.hijoIzq != null) {
				//El elemento a la derecha del inorden
				/*
				ArrayList<NodoB<E>> arr = this.inordenArr();
				E in;
				//Arbol izquierda
				if(arr.indexOf(nodoEliminar)+1 >= arr.size()) {
					in = arr.get(arr.indexOf(nodoEliminar)-1).getLlave();
				}
				//Arbol derecha
				else {
					in = arr.get(arr.indexOf(nodoEliminar)+1).getLlave();
				}
				*/
				//Buscamos antecesor
				NodoBinario<E> in = buscarAntecesor(nodoEliminar);
				//Eliminamos in
				eliminarElemento(in.getLlave());
				//Ahora remplazamos nodoEliminar por in
				nodoEliminar.setLlave(in.getLlave());
				
			}
		}
		
	}
	
	
	//Con inorden y preorden crear arbol
	public ArbolBinarioBusqueda<E> crearArbol(ArrayList<E> preorden, ArrayList<E> inorden)  {
		ArbolBinarioBusqueda<E> ar = new ArbolBinarioBusqueda<>();
		ar.setRaiz(new NodoBinario<E>(preorden.get(0)));
		crearArbolNodos(ar, preorden, inorden);
		return ar;
		
		
	}
	
	public void crearArbolNodos(ArbolBinarioBusqueda<E> ar,ArrayList<E> preorden, ArrayList<E> inorden){
		if(preorden.size() != 1 && preorden.size() != 0) { //Mientras que hayan elementos
			//Elemento en posicion 0 es la raiz en preorden
			//Insertamos elemento izquierda
			try {ar.insertNodo(preorden.get(1));} catch (ExeptionNodo e1) {e1.printStackTrace();}
			//Contamos la cantidad de elemento en inorden de izquierda a derecha hasta encontrar la raiz
			int index = 0;
			while(index < inorden.size() && inorden.get(index).compareTo(preorden.get(0)) !=0 ) {	
				index++;
			}
			//Comprobemos que el que vamos a insertar no sea un elemento repetido, caso de dos elementos en preorden e inorden
			if(index+1 < preorden.size() && preorden.get(index+1).compareTo(preorden.get(1)) !=0) {
				try {ar.insertNodo(preorden.get(index+1));} catch (ExeptionNodo e) {e.printStackTrace();}
			}
			
			//Ahora subdividimos ambos arrayList pero eliminando el padre de los que acabamos de insertar
			ArrayList<E> preordenI = new ArrayList<E>( preorden.subList(1, preorden.indexOf(preorden.get(index+1))));
			ArrayList<E> inordenI = new ArrayList<E>( inorden.subList(0, inorden.indexOf(preorden.get(0))));
			
			ArrayList<E> preordenD = new ArrayList<E>( preorden.subList(preorden.indexOf(preorden.get(index+1)), preorden.size()));
			ArrayList<E> inordenD = new ArrayList<E>(inorden.subList(inorden.indexOf(preorden.get(0))+1 , inorden.size()));
			
			//Llamada recursiva para cada lado
			crearArbolNodos(ar,preordenI,inordenI);
			crearArbolNodos(ar,preordenD,inordenD);
		}
		
	}
	
	public ArbolBinarioBusqueda<E> crearArbol(ArrayList<E> preorden) throws ExeptionNodo  {
		ArbolBinarioBusqueda<E> ar = new ArbolBinarioBusqueda<>();
		ar.setRaiz(new NodoBinario<E>(preorden.get(0)));
		for (int i = 1; i < preorden.size(); i++) {
			ar.insertNodo(preorden.get(i));
		}
		return ar;
	}
		
	
	public int altura (NodoBinario<E> n) {
		if(n == null) return -1;
		int altder = (n.getHijoDer() == null ? 0:1 + altura(n.getHijoDer()));
		int altizq = (n.getHijoIzq() == null ? 0:1 + altura(n.getHijoIzq()));
		return Math.max(altder, altizq);
	}
	
	public int altura() {
		return altura(this.raiz);
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
