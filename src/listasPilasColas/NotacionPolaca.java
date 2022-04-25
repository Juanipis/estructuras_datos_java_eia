package listasPilasColas;

import java.util.Stack;

public class NotacionPolaca {

	public static String infijaaPosfija(String formula) {
		Stack<Character> pila = new Stack<>();
		StringBuilder result = new StringBuilder();
		String operadores = "^*/+-()";
		for(int i = 0; i < formula.length(); i++) {
			if(!operadores.contains(Character.toString(formula.charAt(i)))) {
				result.append(formula.charAt(i));
			}else {
				//Paso 2 ¿Parentecis derecho?
				if(formula.charAt(i) == ')') {
					do {
						result.append(pila.pop());
						if(!pila.empty() && pila.peek() == '(') {
							pila.pop();
						}
					} while (!pila.empty() && pila.peek() != '(');
					
					
				}
				else { //Pila no vacia
					if(pila.empty()) {
						pila.push(formula.charAt(i));
					}
					else {
						//Prioridad afuera mayor adentro
						if(prioridadAfueraPolaca(formula.charAt(i)) > prioridadAdentroPolaca(pila.peek())) {
							pila.add(formula.charAt(i));
						}
						//Prioridad afuera menor adentro
						else {
							result.append(pila.pop());
							while(!pila.empty() && prioridadAfueraPolaca(formula.charAt(i)) <= prioridadAdentroPolaca(pila.peek())) {
								result.append(pila.pop());
							}
							
						}
					}
					
					
				}
			}
		}
		while(!pila.empty()) {
			result.append(pila.pop());
		}
		
		return result.toString();
	}
	
	
	
	public static int prioridadAfueraPolaca(char r) {
		if(r == '^') {
			return 4;
		}else if(r == '*' || r == '/') {
			return 2;
		}else if(r == '+' || r == '-') {
			return 1;
		}else {
			return 5;
		}
	}
	
	public static int prioridadAdentroPolaca(char r) {
		if(r == '^') {
			return 3;
		}else if(r == '*' || r == '/') {
			return 2;
		}else if(r == '+' || r == '-') {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		String op = "a*(b+c-(d/e^f)-g)-h";
		System.out.println(infijaaPosfija(op));
	}
}
