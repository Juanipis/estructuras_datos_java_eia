package arboles;

public class AVL <T extends Comparable<T>> extends ABB<T>{

	//sobreescribir insertar e intentar hacerlo con rotaciones simples y dobles usando fep
	//recordar fep = altHijoDer - altHijoIzq;
		
		public int FEP(NodoB<T> n){//calcula FEP de un nodo
			return n.altura(n.getHijoDer()) - n.altura(n.getHijoIzq());
		}
		
		// Como yo hice la insercion
		/*
		public void insertNodo (T llaveN) throws ExceptionNodo {
			raiz = insertNodo(new NodoB<T>(llaveN), raiz);
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
			r = rotacion(r);//se define si se debe cambiar la raiz del subarbol correspondiente a r
			return r;
		}
		
		public NodoB<T> rotacion(NodoB<T> r) {//evalua si es necesaria una rotacion simple o doble y las ejecuta
			if (FEP(r) > 1) {//rotSimIzq
				if (FEP(r.getHijoDer()) < 0) {//rotDoble
					r.setHijoDer(rotacionSimDer(r.getHijoDer()));	
				}
				return rotacionSimIzq(r);
			} else if (FEP(r) < -1) {//rotSimDer
				if (FEP(r.getHijoIzq()) > 0) {//rotDoble
					r.setHijoIzq(rotacionSimIzq(r.getHijoIzq()));
				}
				return rotacionSimDer(r);
			}
			return r;//devuelve el padre del subarbol
		}
		
		public NodoB<T> rotacionSimDer(NodoB<T> n) {//rotacion simple a la derecha
			NodoB<T> aux = n.getHijoIzq();//se crea el aux que sera el hijo de la izquierda
			n.setHijoIzq(aux.getHijoDer());//el hijo derecho de aux se vuelve el hijo del izquierdo de n 
			aux.setHijoDer(n);//hijo derecho del aux se vuelve n
			return aux;//devuelve aux, que sera la nueva raiz del subarbol
		}
		
		public NodoB<T> rotacionSimIzq(NodoB<T> n) {//rotacion simple a la izquierda, funciona igual al anterior pero der en vez de izq e izq en vez de der
			NodoB<T> aux = n.getHijoDer();
			n.setHijoDer(aux.getHijoIzq());
			aux.setHijoIzq(n);
			return aux;
		}
		*/
		
		
		//Como la profe nos dio la insercion
		
		public void insertNodo(T llave) throws ExceptionNodo {
			insertNodo(new NodoB<T>(llave));
		}
		
		public void insertNodo(NodoB<T> n) throws ExceptionNodo {
			super.insertNodo(n);
			balancear(n);
		}
		
		public void deleteNodo(T llave) throws ExceptionNodo {
			NodoB<T> n = buscar(llave);
			NodoB<T> padre;
			if (n.getHijoDer() != null && n.getHijoIzq() != null) 
				padre = buscarAntecesor(n).getPadre();
			else 
				padre = n.getPadre();
			super.deleteNodo(llave);
			if (padre == null) 
				balancear(raiz);
			else 
				while(padre != null) {
					balancear(padre);
					padre = padre.getPadre();
				}
		}
		
		private void balancear(NodoB<T> n) {
			NodoB<T> desb = desbalance(n);
			if (desb != null) {
				NodoB<T> p = desb.getPadre();
				
				if ( desb.FE() > 0) {
					if ( desb.getHijoDer().FE() >= 0) 
						desb = balanceSimpleIzq(desb);
					else
						desb = balanceDobleIzq(desb);
				} else {
					if (desb.FE() < 0) {
						if (desb.getHijoIzq().FE() <= 0)
							desb = balanceSimpleDer(desb);
						else 
							desb = balanceDobleDer(desb);
					}
				}
				if (p == null) 
					raiz = desb;
				else 
					if (desb.getLlave().compareTo(p.getLlave()) > 0)
						p.setHijoDer(desb);
					else 
						p.setHijoIzq(desb);
			}
		}
		
		public NodoB<T> desbalance(NodoB<T> n) {
			NodoB<T> nodo = n;
			while (nodo != null && Math.abs(nodo.FE()) <= 1) {
				nodo = nodo.getPadre();
			}
			return nodo;
		}
		
		public NodoB<T> balanceSimpleIzq(NodoB<T> n) {
			NodoB<T> der = n.getHijoDer();
			der.setPadre(n.getPadre());
			n.setHijoDer(der.getHijoIzq());
			der.setHijoIzq(n);
			return der;
		}
		
		public NodoB<T> balanceSimpleDer(NodoB<T> n) {
			NodoB<T> izq = n.getHijoIzq();
			izq.setPadre(n.getPadre());
			n.setHijoIzq(izq.getHijoDer());
			izq.setHijoDer(n);
			return izq;
		}
		
		public NodoB<T> balanceDobleDer(NodoB<T> n){
			n.setHijoIzq(balanceSimpleIzq(n.getHijoIzq()));
			return balanceSimpleDer(n);
		}
		
		public NodoB<T> balanceDobleIzq(NodoB<T> n){
			n.setHijoDer(balanceSimpleDer(n.getHijoDer()));
			return balanceSimpleIzq(n);
		}
		
		
		
		//para la siguiente clase hacer el metodo deleteNodo
		public static void main(String[] args) {
		AVL<Integer> arbol = new AVL<Integer>();
		try {
			arbol.insertNodo(7);
			arbol.insertNodo(3);
			arbol.insertNodo(20);
			arbol.insertNodo(18);
			arbol.insertNodo(5);
			arbol.insertNodo(22);
			arbol.insertNodo(2);
			arbol.insertNodo(25);
			arbol.insertNodo(1);
			arbol.insertNodo(4);
			arbol.insertNodo(6);
			System.out.println(arbol.getRaiz().getLlave());
			System.out.println(arbol.getRaiz().altura());
			System.out.println("Inorden: " + arbol.inorden());
			System.out.println("Preorden: " + arbol.preOrden());
			System.out.println("Postorden: " + arbol.postOrden());
			System.out.println(arbol.cantHojas());
		} catch (ExceptionNodo e) {
			e.printStackTrace();
		}

	}

}
