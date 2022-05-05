package arboles;

public class AVL<E extends Comparable<E>> extends ArbolBinarioBusqueda<E> {

	public AVL(NodoB<E> raiz) {
		super(raiz);
	}
	
	@Override
	public void insertNodo(NodoB<E> n) throws ExeptionNodo{
		super.insertNodo(n);
		balancear(n);
	}
	
	public void insertNodo(E n) throws ExeptionNodo{
		NodoB<E> nodo = new NodoB<>(n);
		super.insertNodo(nodo);
		balancear(nodo);
	}
	
	private void balancear(NodoB<E> n) {
		NodoB<E> desb = desbalance(n);
		if(desb!=null) {
			NodoB<E> p = desb.getPadre();
			
			if(desb.FE() >0) {
				if(desb.getHijoDer().FE()>=0) {
					desb=balanceSimpleIzq(desb);
				}
				else {
					desb = balanceDobleIzq(desb);
				}
			}
			else {
				if(desb.FE()<0) {
					if(desb.getHijoIzq().FE()<=0) {
						desb=balanceSimpleDer(desb);
					}
					else {
						desb=balanceDobleDer(desb);
					}
				}
			}
			if(p==null) {
				raiz=desb;
			}
			else {
				if(desb.getLlave().compareTo(p.getLlave())>0) {
					p.setHijoDer(desb);
				}
				else {
					p.setHijoIzq(desb);
				}
			}
		}
	}
	
	public NodoB<E> desbalance(NodoB<E> n){
		NodoB<E> nodo = n;
		while(nodo!=null && Math.abs(nodo.FE())<=1) {
			nodo = nodo.getPadre();
		}
		return nodo;
	}
	
	public NodoB<E> balanceSimpleIzq(NodoB<E> n){
		NodoB<E> der = n.getHijoDer();
		der.setPadre(n.getPadre());
		n.setHijoDer(der.getHijoIzq());
		der.setHijoIzq(n);
		return der;
	}
	
	public NodoB<E> balanceSimpleDer(NodoB<E> n){
		NodoB<E> izq = n.getHijoIzq();
		izq.setPadre(n.getPadre());
		n.setHijoDer(izq.getHijoDer());
		izq.setHijoIzq(n);
		return izq;
	}
	
	public NodoB<E> balanceDobleDer(NodoB<E> n){
		n.setHijoIzq(balanceSimpleIzq(n.getHijoIzq()));
		return balanceSimpleDer(n);
	}
	
	public NodoB<E> balanceDobleIzq(NodoB<E> n){
		n.setHijoDer(balanceSimpleDer(n.getHijoDer()));
		return balanceSimpleIzq(n);
	}
	
	

}
