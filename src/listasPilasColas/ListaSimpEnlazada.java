package listasPilasColas;
import java.util.ArrayList;
import java.util.Scanner;

class NodoL<E>{
	private E Info;
	private NodoL<E> next;
	
	public E getInfo() {
		return Info;
	}
	public void setInfo(E info) {
		Info = info;
	}
	public NodoL<E> getNext() {
		return next;
	}
	public void setNext(NodoL<E> next) {
		this.next = next;
	}
	public NodoL(E info) {
		super();
		Info = info;
		next = null;
	}
	@Override
	public String toString() {
		return Info.toString();
	}
	
}

public class ListaSimpEnlazada<E extends Comparable<E>> {
	
	private NodoL<E> head;
	

	public NodoL<E> getHead() {
		return head;
	}


	public void setHead(NodoL<E> head) {
		this.head = head;
	}
	
	
	public ListaSimpEnlazada(NodoL<E> head) {
		super();
		this.head = head;
	}
	
	public ListaSimpEnlazada() {
		this.head=null;
	}


	public boolean isEmpty(){
		return head==null;
	}
	
	public int length(){
		int l=0;
		NodoL<E> temp=head;
		while(temp!=null){
			temp=temp.getNext();
			l++;
		}
		return l;
	}

	public void addFirst(E x){
		NodoL<E> newNodo=null;
		if (head!=null){
			newNodo=new NodoL<E>(head.getInfo());
			newNodo.setNext(head.getNext());
		} else{
			head=new NodoL<E>(x);		
		}
		head.setInfo(x);
		head.setNext(newNodo);
	}

	
		
	
	
	
	
	
	public int getIndex(E x) {
        int i = 0;
        NodoL<E> tmp = head;
        while 	(tmp != null && ((Comparable<E>) tmp.getInfo()).compareTo(x)!=0) {
            tmp = tmp.getNext();
            i++;
        }
        return ((tmp != null) ? i : -1);
    }
	
	public NodoL<E> getNodo(int i) {
        NodoL<E> tmp = head;
        int j=0;
        while 	(tmp != null && j<i) {
            tmp = tmp.getNext();
            j++;
        }
        return ((tmp != null) ? tmp : null);
    }
	
	public void printList(){
		NodoL<E> actual=head;
		while (actual!=null){
			System.out.print(actual.getInfo()+" ");
			actual=actual.getNext();
		}
		System.out.println();
	}
	
		
	public void insertNodo(E x, int pos) throws Exception{
		if (pos==0)
			addFirst(x);
		else{
			NodoL<E> n=new NodoL<E>(x);
			if (head==null)
				throw new Exception("La lista está vacía");
			NodoL<E> actual=head;
			int i=1;
			while (actual.getNext()!=null && i<pos){
				actual=actual.getNext();
				i++;
			}
			if (i==pos){
				n.setNext(actual.getNext());
				actual.setNext(n);
			}
			else
				throw new Exception("La posición no es válida");

		}
		
	}
	
		
	public boolean isSort(){
    	NodoL<E> tmp = head;
    	if (tmp!=null){
    		while (tmp.getNext()!= null && ((Comparable<E>) tmp.getInfo()).compareTo(tmp.getNext().getInfo())<0) {
	    		tmp=tmp.getNext();
    		}
    	}
    	if (tmp.getNext()==null)	
    		return true;
    	else
    		return false;
    }
	
	public boolean isSortR2(){
		return isSortN(head);
	}
	public boolean isSortN(NodoL<E> h){
		if (h.getNext()==null)
			return true;
		if (h.getNext().getInfo().compareTo(h.getInfo())>=0)
			return isSortN(h.getNext());
		else
			return false;
	}
	
	public boolean isSortA(NodoL<E> nActual){
		if(nActual== null) return false;
		else 
			if (nActual.getNext()==null) 
				return true;
			else{
				if ((nActual.getInfo()).
						compareTo(nActual.getNext().getInfo())>0)
					return false;
				else 
					return isSortA(nActual.getNext());
			}	
	}
	
	public boolean isSortR(){
		return isSortA(head);
	}
	
	public int getIndexMod(E x) {
    	if (isSort()){
    		int i = 0;
	        NodoL<E> tmp = head;
	        while (tmp != null && (((Comparable<E>) tmp.getInfo()).compareTo(x)<0)) {
	            tmp = tmp.getNext();
	            i++;
	        }
	        return ((tmp!=null && tmp.getInfo().compareTo(x)==0) ? i : -1);
    	}
    	else
    		return getIndex(x);
    }
	
	public int getIndex2(E x){
		if (!isSort()){
			return getIndex(x);
		}else{
			ArrayList<NodoL<E>> aux= new ArrayList<NodoL<E>>();
			NodoL<E> aux2=head;
			aux.add(aux2);
			while(aux2.getNext()!=null){
				aux2=aux2.getNext();
				aux.add(aux2);
			}
			int inicial=0;
			int fin=aux.size()-1;
			while(inicial<=fin){
				int medio=(inicial+fin)/2;
				E y=aux.get(medio).getInfo();
				if (aux.get(medio).getInfo().compareTo(x)==0)
					return medio;
				else if (aux.get(medio).getInfo().compareTo(x)>0)
					fin=medio-1;
				else
					inicial=medio+1;
			}
			return -1;
		}
	}
	
	
	public boolean change(int posi,int posj) {
		int l=length();
		if(posi>=0 && posi<l && posj>=0 && posj<l) {
			NodoL<E> nodoi=getNodo(posi);
			NodoL<E> nodoj=getNodo(posj);
			E temp=nodoi.getInfo();
			nodoi.setInfo(nodoj.getInfo());
			nodoj.setInfo(temp);
			return true;
		}
		return false;
		
	}
	
	public void sort() {
		if (head!=null) {
			int l=length();
			for (int i=0; i < l-1; i++) 				
				for (int j=0; j<l-1-i; j++) 
					if (getNodo(j+1).getInfo().compareTo(getNodo(j).getInfo())<0){ 
						E temp=getNodo(j).getInfo();
						getNodo(j).setInfo(getNodo(j+1).getInfo());
						getNodo(j+1).setInfo(temp);
					}
		}
			
	}
	
	public boolean deleteNodo(E x) {
        NodoL<E> tmp = head;
        NodoL<E> ant = null;
        while 	(tmp != null && ((Comparable<E>) tmp.getInfo()).compareTo(x)!=0) {
        	ant=tmp;
            tmp = tmp.getNext();
        }
        if (tmp!=null) {
        	if (ant==null)
        		head=head.getNext();
        	else {
        		ant.setNext(tmp.getNext());
        	}
        	return true;
        }
        return false;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String line= in.nextLine();
    	String[] n=line.split(",");
    	ListaSimpEnlazada<Integer> lista = new ListaSimpEnlazada<Integer>();
        for(int i=0;i<n.length;i++){
        	Integer number=Integer.parseInt(n[i]);
			try {
				lista.insertNodo(number, i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
        }
        lista.sort();
		/*NodoL<Integer> n1=new NodoL<Integer>(1);
		NodoL<Integer> n2=new NodoL<Integer>(2);
		NodoL<Integer> n3=new NodoL<Integer>(3);
		NodoL<Integer> n4=new NodoL<Integer>(4);
		//NodoL<Integer> n5=new NodoL<Integer>(5);
		//NodoL<Integer> n0=new NodoL<Integer>(0);
		n2.setNext(n4);
		n1.setNext(n2);
		n3.setNext(n1);*/
		
		/*lista.addFirst(5);
		lista.printList();
		try {
			lista.insertNodo(0, 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		lista.printList();*/
		//System.out.println(lista.getIndex(0));
		//System.out.println(lista.isSortR2());
		//lista.deleteNodo(0);
		lista.printList();
	}

}