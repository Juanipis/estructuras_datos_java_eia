package arboles;

import java.util.*;

class ExceptionNodo extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExceptionNodo(String s) {
		super(s);
	}
	
}

public class ABB<T extends Comparable<T>> extends ArbolB<T>{
	
	//hacer arbol binario con su metodo de deleteNodo, buscar y entender el insertar
	public ABB(NodoB<T> raiz) {
		super(raiz);
	}
	
	public ABB() {
		super(null);
	}
	
	public int altura() {
		return raiz.altura() + 1;
	}
	
	public void insertNodo(T llaveN) throws ExceptionNodo{
		raiz = insertNodo(new NodoB<T>(llaveN), raiz);
	}
	
	public void insertNodo(NodoB<T> n) throws ExceptionNodo{
		raiz = insertNodo(n, raiz);
	}
	
	protected NodoB<T> insertNodo(NodoB<T> n, NodoB<T> r) throws ExceptionNodo{
		if (r == null) {
			r = n;
		} else {
			if (n.getLlave().compareTo(r.getLlave()) < 0)//si es menor que el actual se va hacia la izquierda
				r.setHijoIzq(insertNodo(n,r.getHijoIzq()));
			else if (n.getLlave().compareTo(r.getLlave()) > 0)//si es mayor que el actual se va a la derecha
				r.setHijoDer(insertNodo(n,r.getHijoDer()));
			else if (n.getLlave().compareTo(r.getLlave()) == 0)//si es igual hay un error
				throw new ExceptionNodo ("El nodo esta repetido");
		}
		return r;
	}
	
	public NodoB<T> getHijoMin(NodoB<T> a){
		if (a.getHijoIzq() == null) 
			return a;
		else return getHijoMin(a.getHijoIzq());
	}
	
	public NodoB<T> getHijoMax(NodoB<T> a){
		if (a.getHijoDer() == null) 
			return a;
		else return getHijoMax(a.getHijoDer());
	}
	
	public NodoB<T> buscar(T llaveN) throws ExceptionNodo{
		return buscar(raiz, llaveN);
	}
	
	public NodoB<T> buscar(NodoB<T> n, T llaveN) throws ExceptionNodo{
		if (n == null)
			throw new ExceptionNodo("No existe un nodo con ese valor");
		if (n.getLlave().compareTo(llaveN) > 0) 
			return buscar(n.getHijoIzq(), llaveN);
		if (n.getLlave().compareTo(llaveN) < 0) 
			return buscar(n.getHijoDer(), llaveN);
		return n;
	}
	/*
	protected void deleteNodoNodo(T llaveN)throws ExceptionNodo{
		deleteNodoNodo(raiz, llaveN);
	}

	protected void deleteNodoNodo(NodoB<T> n, T r) throws ExceptionNodo{
		if (n == null)
			throw new ExceptionNodo("No existe un nodo con ese valor");
		if (n.getLlave().compareTo(r) > 0) //si la llave es menor al nodo actual se va a la izquierda
			deleteNodoNodo(n.getHijoIzq(), r);
		else if (n.getLlave().compareTo(r) < 0)//si la llave es mayor que el nodo actual se va a la derecha 
			deleteNodoNodo(n.getHijoDer(), r);
		else if (n.getLlave().compareTo(r) == 0){//tbd
			if (n.hijoDer == null && n.hijoIzq == null) {//se elimina y ya 
				if (n.getPadre().getHijoIzq() == n)
					n.getPadre().setHijoIzq(null);
				else n.getPadre().setHijoDer(null);
			} else if(n.hijoDer == null) {//se cambia por el hijo de la izquierda
				n.getHijoIzq().setPadre(n.getPadre());
				if (n.getPadre().getHijoIzq() == n)
					n.getPadre().setHijoIzq(n.hijoIzq);
				else n.getPadre().setHijoDer(n.hijoDer);
			} else if(n.hijoDer == null) {//se cambia por el hijo de la derecha 
				n.getHijoDer().setPadre(n.getPadre());
				if (n.getPadre().getHijoIzq() == n)
					n.getPadre().setHijoIzq(n.hijoIzq);
				else n.getPadre().setHijoDer(n.hijoDer);
			} else {//si tiene ambos hijos entonces recordar que se cambia por el que este mas hacia la izquierda o mas hacia la derecha dependiendo de si el padre es menor o mayor
				NodoB<T> aux = getHijoMax(n.getHijoIzq());//este caso no funciona todavia
				deleteNodoNodo(n.getHijoIzq(), aux.getLlave());
				aux.setHijoDer(n.getHijoDer());
				aux.setHijoIzq(n.getHijoIzq());
				
				if (n != raiz && n.getPadre().getHijoIzq() == n ) {
					aux.setPadre(n);
					n.getPadre().setHijoIzq(aux);
				}
				else if (n != raiz) {
					aux.setPadre(n);
					n.getPadre().setHijoDer(aux);
				} else raiz = aux;
			}
		}
	}
	*/
	public void deleteNodo(T llave) throws ExceptionNodo{
		raiz = deleteNodo(llave, raiz);
	}
	
	public NodoB<T> deleteNodo(T llave, NodoB<T> r) throws ExceptionNodo{
		if ( r == null)
			throw new ExceptionNodo("No existe un nodo con ese valor");
		else {
			if (llave.compareTo(r.getLlave()) < 0)
				r.setHijoIzq(deleteNodo(llave, r.getHijoIzq()));
			else {
				if (llave.compareTo(r.getLlave()) > 0)
					r.setHijoDer(deleteNodo(llave, r.getHijoDer()));
				else {
					if (r.getHijoDer() != null && r.getHijoIzq() != null) {
						NodoB<T> antecesor = buscarAntecesor(r);
						r.setLlave(antecesor.getLlave());
						r.setHijoIzq(deleteNodo(antecesor.getLlave(), r.getHijoIzq()));
					} else {
						if (r.getHijoDer() != null)
							r = r.getHijoDer();
						else r = r.getHijoIzq();
					}
				}
			}
		}
		return r;
	}
	
	public NodoB<T> buscarAntecesor(NodoB<T> n) {
		return(n.getHijoDer() == null)? null: buscarMax(n.getHijoIzq());
	}
	
	public NodoB<T> buscarMax(NodoB<T> n){
		return(n.getHijoDer() == null)? n: buscarMax(n.getHijoDer());
	}
	
	public int alturaNodo(NodoB<T> n) {
		if (n == null)
			return -1;
		return hojaLejana(n, 0);
	}
	
	public int hojaLejana(NodoB<T> n, int i){ 
		if (n.getHijoDer() != null && n.getHijoIzq() != null) {
			int aux1 = hojaLejana(n.getHijoIzq(), i+1);
			int aux2 = hojaLejana(n.getHijoDer(), i+1);
			return (aux1 > aux2)? aux1: aux2;
		} else if (n.getHijoDer() != null) {
			return hojaLejana(n.getHijoDer(), i+1);
		} else if (n.getHijoIzq() != null) {
			return hojaLejana(n.getHijoIzq(), i+1);
		}
		return i;
	}
	
	//hacer para la siguiente clase el de contruir con lista preorden e inorden pero solo con el preorden en un ABB
	
	public void construirConPreOrden (ArrayList<T> pre) throws ExceptionNodo {
		raiz = construirConPreOrden(pre, new NodoB<T>(pre.get(0)), 1, pre.size());
	}
	
	public NodoB<T> construirConPreOrden (ArrayList<T> pre, NodoB<T> n, int k, int valMax) throws ExceptionNodo {
		
		raiz = new NodoB<T>(pre.get(0));
		
		for (int i = 1; i < pre.size(); i++) {
			insertNodo(pre.get(i));
		}
		
		return raiz;
		
		/*
		if (k > valMax-1) 
			return n;
		int i = 0;
		while (pre.get(++i).compareTo(n.getLlave()) <= 0);
		
		n.setHijoIzq(construirConPreOrden(pre, new NodoB<T>(pre.get(k)), k+1, i));
		
		n.setHijoDer(construirConPreOrden(pre, new NodoB<T>(pre.get(i)), i+1, valMax));
		
		return n;
		*/
	}
	
	public int cantHojas() {
		return cantHojas(raiz);
	}
	
	public int cantHojas(NodoB<T> n) {
		if (n == null)
			return 0;
		if (n.getHijoDer() == null && n.getHijoIzq() == null)
			return 1;
		return cantHojas(n.getHijoDer()) + cantHojas(n.getHijoIzq());
	}
	
	public static void main(String[] args) {
		ABB<Integer> a3 = new ABB<Integer>();
		try {
			a3.insertNodo(10);
			a3.insertNodo(15);
			a3.insertNodo(17);
			a3.insertNodo(13);
			a3.insertNodo(5);
			a3.insertNodo(8);
			a3.insertNodo(6);
			a3.insertNodo(3);

		} catch (ExceptionNodo e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(a3.buscar(15).getLlave());
		} catch (ExceptionNodo e1) {
			e1.printStackTrace();
		}
		System.out.println(a3.inorden());
		System.out.println(a3.preOrden());
		System.out.println();
		try {
			a3.construirConPreOrden(a3.preOrden());
		} catch (ExceptionNodo e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(a3.inorden());
		System.out.println(a3.preOrden());

	}

}
