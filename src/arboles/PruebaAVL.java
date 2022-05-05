package arboles;

public class PruebaAVL {

	public static void main(String[] args) {
		
		NodoB<Integer> n1 = new NodoB<>(1);
		NodoB<Integer> n2 = new NodoB<>(2);
		NodoB<Integer> n3 = new NodoB<>(3);
		NodoB<Integer> n8 = new NodoB<>(8);
		NodoB<Integer> n12 = new NodoB<>(12);
		AVL<Integer> arbolAvl = new AVL<>(n8);
		try {
			arbolAvl.insertNodo(n3);
			arbolAvl.insertNodo(n12);
			arbolAvl.insertNodo(n2);
			arbolAvl.insertNodo(n1);
//			arbolAvl.insertNodo(6);
//			arbolAvl.insertNodo(13);
//			arbolAvl.insertNodo(10);
//			arbolAvl.insertNodo(1);
//			arbolAvl.insertNodo(5);
//			arbolAvl.insertNodo(7);
//			arbolAvl.insertNodo(4);
//			arbolAvl.insertNodo(16);
			arbolAvl.preorden();
		} catch (ExeptionNodo e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			arbolAvl.insertNodo(8);
//			arbolAvl.insertNodo(12);
//			arbolAvl.insertNodo(2);
//			arbolAvl.insertNodo(9);
//			arbolAvl.insertNodo(6);
//			arbolAvl.insertNodo(13);
//			arbolAvl.insertNodo(10);
//			arbolAvl.insertNodo(1);
//			arbolAvl.insertNodo(5);
//			arbolAvl.insertNodo(7);
//			arbolAvl.insertNodo(4);
//			arbolAvl.insertNodo(16);
//		} catch (ExeptionNodo e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
