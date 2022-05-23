package final2021;

import java.util.*;

class ExceptionNodoB extends Exception{
    private static final long serialVersionUID = 1L;

    public ExceptionNodoB(String s){
        super(s);
    }
}

class Nodo<E extends Comparable<E>> {
    protected E llave;
    protected Nodo<E> hijoIzq;
    protected Nodo<E> hijoDer;
    protected Nodo<E> padre;

    public Nodo(E llave) {
        this.llave = llave;
        padre=null;
        hijoIzq=null;
        hijoDer=null;
    }

    public Nodo(E llave, Nodo<E> hijoIzq, Nodo<E> hijoDer, Nodo<E> padre) {
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


    public Nodo<E> getHijoIzq() {
        return hijoIzq;
    }


    public void setHijoIzq(Nodo<E> hijoIzq) {
        if (hijoIzq!=null){
            hijoIzq.setPadre(this);
        }
        this.hijoIzq = hijoIzq;
    }


    public Nodo<E> getHijoDer() {
        return hijoDer;
    }


    public void setHijoDer(Nodo<E> hijoDer) {
        if (hijoDer!=null){
            hijoDer.setPadre(this);
        }
        this.hijoDer = hijoDer;
    }

    public Nodo<E> getPadre() {
        return padre;
    }

    public void setPadre(Nodo<E> padre) {
        this.padre = padre;
    }
    
    @Override
    public String toString() {
        String HI=(hijoIzq==null)? "null":hijoIzq.getLlave().toString();
        String HD=(hijoDer==null)? "null":hijoDer.getLlave().toString();
        return ((Comparable<E>)llave).toString()+ "("+HI+","+HD+")";
    }
    
    public int altura (Nodo<E> n){
        if (n== null) return -1;
        int altder = (n.getHijoDer() == null? 0:1 + altura (n.getHijoDer()));
        int altizq = (n.getHijoIzq() == null? 0:1 + altura (n.getHijoIzq()));
        return Math.max(altder,altizq);
    }
    
    public int altura(){
        return altura(this);
    }
    
    public int FE(){
        return altura(this.getHijoDer())-altura(this.getHijoIzq());
    }
    


}


class ArbolB<E extends Comparable<E>> {

    protected Nodo<E> raiz;
    
    public ArbolB() {
        this.raiz = null;
    }
    
    public ArbolB(Nodo<E> raiz) {
        super();
        this.raiz = raiz;
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<E> raiz) {
        this.raiz = raiz;
    }    
    
    public void preorden(){
        preorden(raiz);
        System.out.println();
    }
    
    public void preorden(Nodo<E> r){
        if (r!=null){
            System.out.print(r.getLlave()+" ");
            preorden(r.getHijoIzq());
            preorden(r.getHijoDer());
        }    
    }
    
    
    public ArrayList<E> preordenList(){
        ArrayList<E> list=new ArrayList<E>();
        preordenList(raiz, list);
        return list;
    }
    
    public void preordenList(Nodo<E> r, ArrayList<E> list){
        if (r!=null){
            list.add(r.getLlave());
            preordenList(r.getHijoIzq(),list);
            preordenList(r.getHijoDer(),list);
        }    
    }
    
    
    public void inorden(){
        inorden(raiz);
    }
    
    public void inorden(Nodo<E> r){
        if (r!=null){
            inorden(r.getHijoIzq());
            System.out.print(r+ " ");
            inorden(r.getHijoDer());
        }    
    }
    
    public void postorden(){
        postorden(raiz);
    }
    
    public void postorden(Nodo<E> r){
        if (r!=null){
            postorden(r.getHijoIzq());
            postorden(r.getHijoDer());
            System.out.print(r.getLlave()+ " ");
        }    
    }
    
    public void insertNodo(Nodo<E> n) throws ExceptionNodoB{
        raiz=insertNodo(n, raiz);
    }

    protected Nodo<E> insertNodo(Nodo<E> n, Nodo<E> r) throws ExceptionNodoB {
        if (r==null){
            r=n;
        }else{
            if (n.getLlave().compareTo(r.getLlave())<0)
                r.setHijoIzq(insertNodo(n,r.getHijoIzq()));
            if (n.getLlave().compareTo(r.getLlave())>0)
                r.setHijoDer(insertNodo(n,r.getHijoDer()));
            if (n.getLlave().compareTo(r.getLlave())==0)
                throw new ExceptionNodoB("El nodo se repite");
        }
        return r;
        
    }
    
    public void printFE(){
        printFE(raiz);
    }
    
    public void printFE(Nodo<E> r){
        if (r!=null){
            printFE(r.getHijoIzq());
            System.out.print(r.FE()+ " ");
            printFE(r.getHijoDer());
        }    
    }
        
}
    


public class ArbolDesdeLista {
    ///////////////////////////////
    //Completar
    
    public static ArbolB<Integer> convertirListaAVL(ArrayList<Integer> lista) throws ExceptionNodoB{
		lista.sort(new menorMayorNumeros());
		int raiz;
		if(lista.size()%2 ==0) {
    		raiz = (lista.size()/2) -1;
    	}else {
    		raiz = lista.size()/2;
    	}
		
		ArbolB<Integer> arbol = new ArbolB<>(new Nodo<Integer>(lista.get(raiz)));
		
		ArrayList<Integer> li = new ArrayList<>( lista.subList(0, raiz));
		ArrayList<Integer> ld =  new ArrayList<>(lista.subList(raiz+1, lista.size()));
		construccionRecursiva(ld, arbol);
		construccionRecursiva(li, arbol);
    	return arbol;
    }
    
    public static void construccionRecursiva(ArrayList<Integer> lado, ArbolB<Integer> arbol ) throws ExceptionNodoB {
    	if(lado.size() == 0) {}
    	else if(lado.size() == 1) {
    		arbol.insertNodo(new Nodo<Integer>(lado.get(0)));
    	}
    	else if(lado.size() == 2) {
    		arbol.insertNodo(new Nodo<Integer>(lado.get(0)));
    		arbol.insertNodo(new Nodo<Integer>(lado.get(1)));
    	}
    	else if(lado.size() == 3) {
    		arbol.insertNodo(new Nodo<Integer>(lado.get(1)));
    		arbol.insertNodo(new Nodo<Integer>(lado.get(0)));
    		arbol.insertNodo(new Nodo<Integer>(lado.get(2)));
    	}else {
    		int raiz;
    		if(lado.size()%2 ==0) {
        		raiz = (lado.size()/2) -1;
        	}else {
        		raiz = lado.size()/2;
        	}
    		arbol.insertNodo(new Nodo<Integer>(lado.get(raiz)));
    		ArrayList<Integer> li = new ArrayList<>( lado.subList(0, raiz));
    		ArrayList<Integer> ld =  new ArrayList<>(lado.subList(raiz+1, lado.size()));
    		construccionRecursiva(ld, arbol);
    		construccionRecursiva(li, arbol);
    	}
    }
    
    
    

    public static void main(String[] args) throws ExceptionNodoB {
    	ArrayList<Integer> lista=new ArrayList<Integer>();
    	lista.add(1);
    	lista.add(10);
    	lista.add(2);
    	lista.add(5);
    	lista.add(12);
    	lista.add(6);
    	ArbolB<Integer> arbol = convertirListaAVL(lista);
    	arbol.inorden();
    	System.out.println();
    	arbol.printFE();
//        Scanner in = new Scanner(System.in);
//        String line= in.nextLine();
//        String[] n=line.split(",");
//        ArrayList<Integer> lista=new ArrayList<Integer>();
//        for (String s:n)
//            lista.add(Integer.parseInt(s));
//        try {
//            ArbolB<Integer>arbol=convertirListaAVL(lista);
//            System.out.println(arbol.getRaiz());
//            arbol.inorden();
//            System.out.println();
//            arbol.printFE();
//        } catch (ExceptionNodoB e) {
//            // TODO Auto-generated catch block
//            System.out.println(e.getMessage());;
//        }
//        in.close();
//            
    }
}
class menorMayorNumeros implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1.intValue()-o2.intValue();
	}
	
}

