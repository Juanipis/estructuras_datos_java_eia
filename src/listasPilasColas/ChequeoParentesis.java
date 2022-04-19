package listasPilasColas;

import java.util.Stack;

public class ChequeoParentesis {
	public static boolean parentesisCheck(String mensaje) {
		Stack<Character> pila = new Stack<>();
		boolean condicion = true;
		int index = 0;
		while(index < mensaje.length()) {
			if(mensaje.charAt(index) == '(') {
				pila.push(mensaje.charAt(index));
			}else if(mensaje.charAt(index) == ')') {
				if(pila.empty() == true) {
					condicion = false;
				}
				else {
					pila.pop();
				}
			}
		index++;
		}
		return (pila.empty() && condicion);
	}
	public static boolean parentesisCheckError(String mensaje) throws ParentesisMal {
		Stack<Character> pila = new Stack<>();
		Stack<Integer> pilaInt = new Stack<>();
		boolean condicion = true;
		int index = 0;
		while(index < mensaje.length() && condicion) {
			if(mensaje.charAt(index) == '(') {
				pila.push(mensaje.charAt(index));
				pilaInt.push(index);
			}else if(mensaje.charAt(index) == ')') {
				if(pila.empty() == true) {
					pilaInt.push(index);
					condicion = false;
				}
				else {
					pila.pop();
					pilaInt.pop();
				}
			}
		index++;
		}
		
		if(pila.empty() && condicion) {
			return true;
		}
		else{ //Caso de no cierra parentesis ¿En que posiciones
			if(pilaInt.size() == 1) { //¿Solo hay un indice?
				throw new ParentesisMal(pilaInt.pop()); 
			}else { //hay varios
				
				throw new ParentesisMal(pilaInt.toString()); 
			}
		}
		
	}
	
	public static void main(String[] args) {
		String mensaje = "()(((";
		try {
			System.out.println(parentesisCheckError(mensaje));
		} catch (ParentesisMal e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ParentesisMal extends Exception{
	public ParentesisMal(int index) { //Si solo es un parentesis
		super("Error en la posicion: " + index);
	}
	public ParentesisMal(String indexes) {
		super("Error en las posiciones: " + indexes);
	}
}
