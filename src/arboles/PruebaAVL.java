package arboles;

public class PruebaAVL {

	public static void main(String[] args) {
		
		NodoBinario<Integer> n1 = new NodoBinario<>(1);
		NodoBinario<Integer> n2 = new NodoBinario<>(2);
		NodoBinario<Integer> n3 = new NodoBinario<>(3);
		NodoBinario<Integer> n8 = new NodoBinario<>(8);
		NodoBinario<Integer> n12 = new NodoBinario<>(12);
		ArbolAVL<Integer> arbolAvl = new ArbolAVL<>(n8);
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
			arbolAvl.inorden();
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
